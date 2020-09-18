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
  if(AMBIENTE_DEBUG>0){
  Serial.println("Modifica Ambiente valori:");
  }
  UmiditaTarget = U;
  IrradianzaTarget = I;
  TemperaturaTarget = T;
};

void  Ambiente :: ModificaAmbiente2(float array []) {
    if(AMBIENTE_DEBUG>0){
    Serial.println("Modifica Ambiente2 valori:");
    }
  for(int i=0;i<NUM_T;i++){
    target[i]=array[i];
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
  if(AMBIENTE_DEBUG>0){
  Serial.println(F("Prelevo le soglie"));
  }
  if(lung<(sizeof(soglie)/sizeof(soglie[0]))){
    if(AMBIENTE_DEBUG>0){
      Serial.println(F("Vettore per il prelievo soglie troppo piccolo"));
    }
        return -1;
    }
    for (int i=0;i<(sizeof(soglie)/sizeof(soglie[0]));i++){
      array[i]=soglie[i];
      }
    return 0;
  };//per farlo per bene servirebbero puntatori ma così evito di fare allocazione dinamica di cose piccole


int Ambiente :: GetTarget(float array[],int lung){
  if(AMBIENTE_DEBUG>0){
        Serial.println(F("Prelievo dei valori Target"));
      }
  if(lung<(sizeof(target)/sizeof(target[0]))){
    if(AMBIENTE_DEBUG>0){
      Serial.println(F("Vettore per il prelievo dei target troppo piccolo"));
    }
    return -1;
    }
    for (int i=0;i<(sizeof(target)/sizeof(target[0]));i++){
      array[i]=target[i];
      }
    return 0;
  };//per farlo per bene servirebbero puntatori ma così evito di fare allocazione dinamica di cose piccole
  
void Ambiente :: SetSoglie(float T, float U, float I) {
  SogliaT = T;
  SogliaU = U;
  SogliaI = I;
};

//Devo mettere un controllo sulla lunghezza come per la lettura??
void Ambiente :: SetSoglie2(float array[]) {
  if(AMBIENTE_DEBUG>0){
  Serial.println(F("Modifica Soglie 2 valori"));
  }
  for(int i=0;i<NUM_S;i++){
    soglie[i]=array[i];
    }
};
