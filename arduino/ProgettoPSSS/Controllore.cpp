#include "Controllore.h"

Controllore * Controllore :: MeStesso=NULL;

Controllore :: Controllore(){
//  MeStesso = this;
//  Link = Comunicazione :: GetInstance();
};

void  Controllore :: SetID(long id) {
  ID = id;
};
void  Controllore :: SetObserved(bool obs) {
  Observed = obs;
};

void  Controllore :: ToggleObserved() {
  Observed = !Observed;
};

void  Controllore :: SetSezione(long sez) {
  Sezione = sez;
};

//void  Controllore :: SetSoglia(float sogl) {
//  Soglia = sogl;
//};

long  Controllore :: GetID() {
  return ID;
};

long  Controllore :: GetSezione() {
  return Sezione;
};

//float  Controllore :: GetSoglia() {
//  return Soglia;
//};

void  Controllore :: SetUp2(Ambiente * amb){
  ambiente=amb;
  Serial.println("Start Setup Controllore");
  Serial.println(freeMemory(), DEC);  // print how much RAM is available.
//  Questo pezzotto è sbagliato va trasformato in un polimorifsmo vero e proprio con allocazione dinaimica
//o la cosa che sta scritta nel link di barr group
//  SensoreTemperatura Temp;
//  sensori[0]=Temp;
//  SensoreUmidita Um;
//  sensori[1]=Um;
//  SensoreIrradianza Irr;
//  sensori[2]=Irr;
  for (int i=0;i<3;i++){
    sensori[i].SetUp();
    }
//  Serpentina Serp;
//  attuatori[0]=Serp;
//  Innaffiatoio Inn;
//  attuatori[1]=Inn;
//  StrisciaLed Str;
//  attuatori[2]=Str;
  for (int i=0;i<3;i++){
    attuatori[i].SetUp();
    } 
//Codice Sbagliato Timer 1 può contare solo fino a 10 secondi
//  cli();
//  TCCR1A = 0;// set entire TCCR1A register to 0
//  TCCR1B = 0;// same for TCCR1B
//  TCNT1  = 0;//initialize counter value to 0
//  TCCR1B |= (1 << WGM12);
//  TCCR1B |= (1 << CS11);
//  TIMSK1 |= (1 << OCIE1A);
//  OCR1A = 33333;
//
//  sei();
//      Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  Serial.println("End Setup Controllore");
  };

void  Controllore :: SetUp() {
  Serial.println("Start Setup Controllore");
  Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  Serial.println("Ho letto la memoria");
  SensoreTemperatura Temp;
  sensori[0]=Temp;
  SensoreUmidita Um;
  sensori[1]=Um;
  SensoreIrradianza Irr;
  sensori[2]=Irr;
  for (int i=0;i<3;i++){
    sensori[i].SetUp();
    }
  Serpentina Serp;
  attuatori[0]=Serp;
  Innaffiatoio Inn;
  attuatori[1]=Inn;
  StrisciaLed Str;
  attuatori[2]=Str;
  for (int i=0;i<3;i++){
    attuatori[i].SetUp();
    } 
//Codice Sbagliato Timer 1 può contare solo fino a 10 secondi
//  cli();
//  TCCR1A = 0;// set entire TCCR1A register to 0
//  TCCR1B = 0;// same for TCCR1B
//  TCNT1  = 0;//initialize counter value to 0
//  TCCR1B |= (1 << WGM12);
//  TCCR1B |= (1 << CS11);
//  TIMSK1 |= (1 << OCIE1A);
//  OCR1A = 33333;
//
//  sei();
//      Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  Serial.println("End Setup Controllore");

}

static Controllore* Controllore :: GetInstance() {
  //convertire in allocazione dinamica??
    Serial.println("Sono nel Get Instance del controllore");
  if (Controllore::MeStesso == NULL) {
        Serial.println("Alloco la prima volta");
    Controllore::MeStesso = new Controllore();
  }
  Serial.println("Faccio il return della istance del controllore");
  return Controllore::MeStesso;
};

void Controllore::Controllo() {
  Serial.println("Sono nella funzione di controllo");
    Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  float target [3];
  float soglie [3];
  //TODO Riscrivere così che sia più facile usare il vettore e non farla manualmente
  target[0] = ambiente->GetTemperaturaTarget();
  target[1] = ambiente->GetUmiditaTarget();
  target[2] = ambiente->GetIrradianzaTarget();
  soglie[0] = ambiente->GetSogliaT();
  soglie[1] = ambiente->GetSogliaU();
  soglie[2] = ambiente->GetSogliaI();
  float valore[3];
  for (int i = 0; i < 3; i++) {
    valore[i] = sensori[i].GetDato();
    if (abs(target[i] - valore[i]) > soglie[0]) {
      if (Error[i] == false) {
        //TODO Invertire i rami dell'if e dobbiamo accordarci su errori di sensori
        Error[i] = false;
        attuatori[i].SetAttuatore();
      }
      else {
        byte* bytes;
        bytes = (byte *) i;
        Link->PublishError(bytes);
      }
    }
  }
  if (Observed) {
    union TEMP{
      float f;
      byte b[4];
      }temp;
    //Usare le union per convertire i float in byte arrays
    byte payload [12];
    for (int i=0;i<3;i++){
      temp.f=valore[i];
      for (int j=0;j<4;j++){
        payload[j+4*i]=temp.b[j];
        }
      }
    Link->PublishData(payload);
  }
};

ISR(TIMER1_COMPA_vect) {
  //Non capisco perchè nell'interrupt mi da errore su getinstance
  Controllore * contr;
  contr = Controllore :: GetInstance();
  contr->Controllo();
}
