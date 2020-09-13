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

void Controllore :: SendAck(){
      Serial.println("E inviamoli questi dati");
    byte payload [4];
    Load_to_payload_long(payload,0,ID);
    Link->Publish("GH/Ack",payload,4);
  };


void Controllore :: SendDati(){
    Serial.println("E inviamoli questi dati");
    byte payload [16];
    float dati[3];
//    for(int i=0;i<3;i++){
//      dati[i]=sensori[i]->GetDato();
//      }
    dati[0]=-1;
    dati[1]=-1;
    dati[2]=-1;
    Load_to_payload_long(payload,0,ID);
    int j=0;
    for (int i=4;i<16;i=i+4){
      Serial.println("Di 4 in 4");
      Serial.println(i);
      Serial.println(i-4*(i/4));
      if (dati[j]<0){
        byte payload [8];
        Load_to_payload_long(payload,0,ID);
        Load_to_payload_long(payload,4,j+1);
        Link->PublishErrore(payload,8);
        }
      Load_to_payload_float(payload,i,dati[j]);
      j=j+1;
      }
    Serial.println("Faccio Publish dei Dati");
    for (int i=0;i<16;i++){
      Serial.println(payload[i]);
      }
    Link->PublishDati(payload,16);
  };

void  Controllore :: SetUp2(Ambiente * amb){
  ambiente=amb;
//  Serial.println("Start Setup Controllore");
//  Serial.println(freeMemory(), DEC);  // print how much RAM is available.
//  Vedere la cosa che sta scritta nel link di barr groupù
// C'è un modo in cui sono costretto a fare i new non a mano non credo 
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
//  Serial.println("End Setup Controllore");
  };


//Devo togliere non serve più e rinominare il Setup2 in Setup
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
  //convertire in allocazione dinamica?? Fatto
    Serial.println("Sono nel Get Instance del controllore");
  if (Controllore::MeStesso == NULL) {
        Serial.println("Alloco la prima volta");
        Controllore::MeStesso = new Controllore();
  }
  Serial.println("Faccio il return della istance del controllore");
  return Controllore::MeStesso;
};

//void Controllore::Controllo() {
//  //Riscrivere per errori sui sensori e attuatori come ci siamo messi d'accordo
//  //per i sensori DHT c'è la funzione per il fotoresistore se diventa circuito aperto stesso per igrometro?? 
//  Serial.println("Sono nella funzione di controllo");
//    Serial.println(freeMemory(), DEC);  // print how much RAM is available.
//  float target [3];
//  float soglie [3];
//  //TODO Riscrivere così che sia più facile usare il vettore e non farla manualmente
//  target[0] = ambiente->GetTemperaturaTarget();
//  target[1] = ambiente->GetUmiditaTarget();
//  target[2] = ambiente->GetIrradianzaTarget();
//  soglie[0] = ambiente->GetSogliaT();
//  soglie[1] = ambiente->GetSogliaU();
//  soglie[2] = ambiente->GetSogliaI();
//  float valore[3];
//  for (int i = 0; i < 3; i++) {
//    valore[i] = sensori[i]->GetDato();
//    if (abs(target[i] - valore[i]) > soglie[0]) {
//      if (Error[i] == false) {
//        Error[i] = false;
//        attuatori[i]->SetAttuatore();
//      }
//      else {
//        //Togliere sto puntatore e mettere un buffer statico
//        byte* bytes;
//        bytes = (byte *) i;
//        Link->PublishErrore(bytes);
//      }
//    }
//  }
//  if (Observed) {
//    //rivedere sto codice per la conversione e l'invio dei dati
//    union TEMP{
//      float f;
//      byte b[4];
//      }temp;
//    //Usare le union per convertire i float in byte arrays
//    byte payload [12];
//    for (int i=0;i<3;i++){
//      temp.f=valore[i];
//      for (int j=0;j<4;j++){
//        payload[j+4*i]=temp.b[j];
//        }
//      }
//    Link->PublishDati(payload,16);
//  }
//};


void Controllore::Controllo() {
  //Riscrivere per errori sui sensori e attuatori come ci siamo messi d'accordo
  //per i sensori DHT c'è la funzione per il fotoresistore se diventa circuito aperto stesso per igrometro?? 
  Serial.println("Sono nella funzione di controllo");
  Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  float target [3];
  float soglie [3];
  ambiente->GetTarget(target,3);
  ambiente->GetSoglie(soglie,3);
  float valore[3];
//  valore[0]=0.5;
//  valore[1]=0.8;
//  valore[2]=1;
  for (int i = 0; i < 3; i++) {
//    valore[i] = sensori[i]->GetDato();
    valore[i]=-10;
    if(valore[i]<0){
        byte payload [8];
        Load_to_payload_long(payload,0,ID);
        Load_to_payload_long(payload,4,i+1);
        Serial.println(i+1);
        Link->PublishErrore(payload,8);
      }else{
    if (abs(target[i] - valore[i]) > soglie[0]) {
      if (Error[i] == false) {
        Error[i] = true;
//        attuatori[i]->SetAttuatore(abs(target[i] - valore[i]));
      }
      else {
        byte payload [8];
        Load_to_payload_long(payload,0,ID);
        Load_to_payload_long(payload,4,(4+i));
        Load_to_payload_float(payload,8,abs(target[i] - valore[i]));
        Link->PublishErrore(payload,12);
      }
    }else{
      Error[i]=false;
      }
      }
  }
  
  if (Observed) {
    //rivedere sto codice per la conversione e l'invio dei dati
    //Usare le union per convertire i float in byte arrays
    //valore vettore già è pieno credo
    byte payload [16];
     Load_to_payload_long(payload,0,ID);
    for(int i=0;i<3;i++){
      Load_to_payload_float(payload,4+4*i,valore[i]);
      }
    Link->PublishDati(payload,16);
  }
};


ISR(TIMER1_COMPA_vect) {
  //Da rivedere completamente
  Controllore * contr;
  contr = Controllore :: GetInstance();
  contr->Controllo();
}
