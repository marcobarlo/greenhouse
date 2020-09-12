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
  Serial.println("Sono proprio osservato");
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

void Controllore :: SendDati(){
    byte payload [16];
    long Templ=ID;
    //Fare refactiìoring per renderla più pulita basata sul for
//    payload[0] = Templ & 0xFF;
//    payload[1] = (Templ >> 8)  & 0xFF;
//    payload[2] = (Templ >> 16) & 0xFF;
//    payload[3] = (Templ >> 24) & 0xFF;
//    union TEMPF{
//      byte b [4];
//      float f;
//      }tempf;
////    tempf.f=sensori[0]->GetDato();
//    tempf.f=8.5;
//    payload[4] = tempf.b[0];
//    payload[5] = tempf.b[1];
//    payload[6] = tempf.b[2];
//    payload[7] = tempf.b[3];
//        tempf.f=8.4;
////    tempf.f=sensori[1]->GetDato();
//    payload[8] = tempf.b[0];
//    payload[9] = tempf.b[1];
//    payload[10] = tempf.b[2];
//    payload[11] = tempf.b[3];
//        tempf.f=8.6;
////    tempf.f=sensori[2]->GetDato();
//    payload[12] = tempf.b[0];
//    payload[13] = tempf.b[1];
//    payload[14] = tempf.b[2];
//    payload[15] = tempf.b[3];
    payload[3] = Templ & 0xFF;
    payload[2] = (Templ >> 8)  & 0xFF;
    payload[1] = (Templ >> 16) & 0xFF;
    payload[0] = (Templ >> 24) & 0xFF;
    union TEMPF{
      byte b [4];
      float f;
      }tempf;
//    tempf.f=sensori[0]->GetDato();
    tempf.f=8.5;
    payload[7] = tempf.b[0];
    payload[6] = tempf.b[1];
    payload[5] = tempf.b[2];
    payload[4] = tempf.b[3];
        tempf.f=8.4;
//    tempf.f=sensori[1]->GetDato();
    payload[11] = tempf.b[0];
    payload[10] = tempf.b[1];
    payload[9] = tempf.b[2];
    payload[8] = tempf.b[3];
        tempf.f=8.6;
//    tempf.f=sensori[2]->GetDato();
    payload[15] = tempf.b[0];
    payload[14] = tempf.b[1];
    payload[13] = tempf.b[2];
    payload[12] = tempf.b[3];
    Serial.println("Faccio Publish dei Dati");
    for (int i=0;i<16;i++){
      Serial.println(payload[i]);
      }
    Link->PublishDati(payload,16);
  };

void  Controllore :: SetUp2(Ambiente * amb){
  ambiente=amb;
  Serial.println("Start Setup Controllore");
  Serial.println(freeMemory(), DEC);  // print how much RAM is available.
//  Vedere la cosa che sta scritta nel link di barr group
  Link=Comunicazione::GetInstance();
  sensori[0]=new SensoreTemperatura();
  sensori[1]=new SensoreUmidita();
  sensori[2]=new SensoreIrradianza();
  for (int i=0;i<3;i++){
    sensori[i]->SetUp();
    Error[i]=false;
    }
  attuatori[0]=new Serpentina();
  attuatori[1]=new Innaffiatoio();
  attuatori[2]=new StrisciaLed();
  for (int i=0;i<3;i++){
    attuatori[i]->SetUp();
    } 
    Observed=false;
    ID=0;
    Sezione=0;
    
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
  //Si deve rivedere questo codice per l'arduino uno o con l'acrocchio o rivedendolo come interfaccia e classi che le usano 
  //questo presenterebbe di dover scrivere il codice a manella o rivedere le allocazioni e altro per recuperare megabytes
  sensori[0]=new SensoreTemperatura();
  sensori[1]=new SensoreUmidita();
  sensori[2]=new SensoreIrradianza();
  for (int i=0;i<3;i++){
    sensori[i]->SetUp();
    }
  attuatori[0]=new Serpentina();
  attuatori[1]=new Innaffiatoio();
  attuatori[2]=new StrisciaLed();
  for (int i=0;i<3;i++){
    attuatori[i]->SetUp();
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
  //Riscrivere per errori sui sensori e attuatori come ci siamo messi d'accordo
  //per i sensori DHT c'è la funzione per il fotoresistore se diventa circuito aperto stesso per igrometro?? 
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
    valore[i] = sensori[i]->GetDato();
    if (abs(target[i] - valore[i]) > soglie[0]) {
      if (Error[i] == false) {
        Error[i] = false;
        attuatori[i]->SetAttuatore();
      }
      else {
        //Togliere sto puntatore e mettere un buffer statico
        byte* bytes;
        bytes = (byte *) i;
        Link->PublishErrore(bytes);
      }
    }
  }
  if (Observed) {
    //rivedere sto codice per la conversione e l'invio dei dati
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
    Link->PublishDati(payload,16);
  }
};

ISR(TIMER1_COMPA_vect) {
  //Non capisco perchè nell'interrupt mi da errore su getinstance
  Controllore * contr;
  contr = Controllore :: GetInstance();
  contr->Controllo();
}
