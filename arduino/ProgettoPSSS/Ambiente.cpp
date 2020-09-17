#include "Ambiente.h"

#define NUM_T 3
#define NUM_S 3


float Ambiente  :: GetUmiditaTarget() {
  return UmiditaTarget;
};

float Ambiente  :: GetIrradianzaTarget() {
  return IrradianzaTarget;
};

float Ambiente  :: GetTemperaturaTarget() {
  return TemperaturaTarget;
};

void  Ambiente :: ModificaAmbiente(float T, float U, float I) {
  Serial.println("Modifica Ambiente valori:");
  UmiditaTarget = U;
  IrradianzaTarget = I;
  TemperaturaTarget = T;
  Serial.println(TemperaturaTarget);
  Serial.println(UmiditaTarget);
  Serial.println(IrradianzaTarget);
};

void  Ambiente :: ModificaAmbiente2(float array []) {
  Serial.println("Modifica Ambiente 2 valori:");
  for(int i=0;i<NUM_T;i++){
    target[i]=array[i];
    Serial.println(array[i]);
    Serial.println(target[i]);
    }
};

float Ambiente :: GetSogliaU() {
  return SogliaU;
};

float Ambiente :: GetSogliaI() {
  return SogliaI;
};

float Ambiente :: GetSogliaT() {
  return SogliaT;
};

int Ambiente :: GetSoglie(float array[],int lung){
  Serial.println("Me le getto proprio ste soglie");
  Serial.println(lung);
  Serial.println((sizeof(soglie)/sizeof(soglie[0])));
  if(lung<(sizeof(soglie)/sizeof(soglie[0]))){
        Serial.println("No no Troppo piccolo S");
            Serial.println(sizeof(array));
    Serial.println(sizeof(soglie));
    return -1;
    }
    Serial.println("Valore Soglie");
    for (int i=0;i<(sizeof(soglie)/sizeof(soglie[0]));i++){
      array[i]=soglie[i];
      Serial.println(F("Iterazione"));
      Serial.println(i);
      Serial.println(soglie[i]);
      Serial.println(array[i]);
      }
    return 0;
  };//per farlo per bene servirebbero puntatori ma così evito di fare allocazione dinamica di cose piccole


int Ambiente :: GetTarget(float array[],int lung){
  Serial.println(sizeof(array));
  if(lung<(sizeof(target)/sizeof(target[0]))){
    Serial.println("No no Troppo piccolo F");
    Serial.println(sizeof(array));
    Serial.println(sizeof(target));
    return -1;
    }
    Serial.println("Valori Target");
    for (int i=0;i<(sizeof(target)/sizeof(target[0]));i++){
      array[i]=target[i];
      }
    return 0;
  };//per farlo per bene servirebbero puntatori ma così evito di fare allocazione dinamica di cose piccole
  
void Ambiente :: SetSoglie(float T, float U, float I) {
  SogliaT = T;
  SogliaU = U;
  SogliaI = I;
  Serial.println("Stampa delle soglie in ambiente");
  Serial.println(SogliaT);
  Serial.println(SogliaU);
  Serial.println(SogliaI);

};

//Devo mettere un controllo sulla lunghezza come per la lettura??
void Ambiente :: SetSoglie2(float array[]) {
  Serial.println("Modifica Soglie 2 valori:");
  for(int i=0;i<NUM_S;i++){
    soglie[i]=array[i];
    }
};
