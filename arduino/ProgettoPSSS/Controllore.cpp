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

void Controllore :: SendDati(){
    Serial.println(freeMemory(), DEC);  // print how much RAM is available.
    Serial.println("E inviamoli questi dati");
    float dati[SIZE];
    for(int i=0;i<SIZE;i++){
      sensori[i]->WhoAreYou();
      dati[i]=sensori[i]->GetDato();
      if (dati [i]<0){
        Link->PublishErroreSensore(ID,i);
        }
      }
    Link->PublishDati(ID,dati);
  };

void  Controllore :: SetUp2(Ambiente * amb){
  ambiente=amb;
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
  Serial.println("End Setup Controllore");
}

static Controllore* Controllore :: GetInstance() {
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
  float target [SIZE];
  float soglie [3];
  ambiente->GetTarget(target,SIZE);
  ambiente->GetSoglie(soglie,SIZE);
  Serial.println(F("Prese sia Target che Soglie"));
  float valore[SIZE];
  for (int i = 0; i < SIZE; i++) {
    valore[i] = sensori[i]->GetDato();
    Serial.println(i);
    Serial.println(valore[i]);
    if(valore[i]<0){
      Link->PublishErroreSensore(ID,i+1);
      }else{
    if (abs(target[i] - valore[i]) > soglie[0]) {
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
  Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  if (Observed) {
    Link->PublishDati(ID,valore);
  }
  Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  Serial.println(F("Finito sto cazzo di controllo"));
};


void Controllore::ModificaAmbiente(float array []){
  ambiente->ModificaAmbiente2(array);
  };

void Controllore::SetSoglie(float array[]){
  ambiente->SetSoglie2(array);
  };
