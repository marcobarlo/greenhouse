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

void Controllore :: SendDati(){
    if(CONTROLLORE_DEBUG>0){
    Serial.println(F("Invio dei dati"));
    }
    float dati[SIZE];
    for(int i=0;i<SIZE;i++){
      dati[i]=sensori[i]->GetDato();
      if (dati [i]<0){
        Link->PublishErroreSensore(ID,i);
        }
      }
    Link->PublishDati(ID,dati);
  };

void  Controllore :: SetUp(Ambiente * amb){
  if(CONTROLLORE_DEBUG>0){
    Serial.println(F("SetUp Controllore"));
    }
  ambiente=amb;
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
    if(CONTROLLORE_DEBUG>0){
    Serial.println(F("Fine setup Controllore"));
    }
  };


////Devo togliere non serve più e rinominare il Setup2 in Setup
//void  Controllore :: SetUp() {
//  //Si deve rivedere questo codice per l'arduino uno o con l'acrocchio o rivedendolo come interfaccia e classi che le usano 
//  //questo presenterebbe di dover scrivere il codice a manella o rivedere le allocazioni e altro per recuperare megabytes
//  sensori[0]=new SensoreTemperatura();
//  sensori[1]=new SensoreUmidita();
//  sensori[2]=new SensoreIrradianza();
//  for (int i=0;i<3;i++){
//    sensori[i]->SetUp();
//    }
//  attuatori[0]=new Serpentina();
//  attuatori[1]=new Innaffiatoio();
//  attuatori[2]=new StrisciaLed();
//  for (int i=0;i<3;i++){
//    attuatori[i]->SetUp();
//    } 
//}

static Controllore* Controllore :: GetInstance() {
  if (Controllore::MeStesso == NULL) {
        Controllore::MeStesso = new Controllore();
  }
  return Controllore::MeStesso;
};

void Controllore::Controllo() {
  if(CONTROLLORE_DEBUG>0){
  Serial.println(F("Sono nella funzione di controllo"));
  }
  float target [SIZE];
  float soglie [3];
  ambiente->GetTarget(target,SIZE);
  ambiente->GetSoglie(soglie,SIZE);
  float valore[SIZE];
  for (int i = 0; i < SIZE; i++) {
    valore[i] = sensori[i]->GetDato();
    if(valore[i]<0){
      Link->PublishErroreSensore(ID,i+1);
      }else{
    if (abs(target[i] - valore[i]) > soglie[i]) {
      if (Error[i] == false) {
        Error[i] = true;
//        attuatori[i]->SetAttuatore(abs(target[i] - valore[i]));
      }else {
          Link->PublishErroreAttuatore(ID,i+4,abs(target[i] - valore[i]));
      }
    }else{
      Error[i]=false;
      }
      }
  }
  if (Observed) {
    Link->PublishDati(ID,valore);
  }
  if(CONTROLLORE_DEBUG>0){
  Serial.println(F("Finito il controllo"));
  }
};


void Controllore::ModificaAmbiente(float array []){
  ambiente->ModificaAmbiente(array);
  };

void Controllore::SetSoglie(float array[]){
  ambiente->SetSoglie(array);
  };
