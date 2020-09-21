#include "Ambiente.h"

void  Ambiente :: ModificaAmbiente(float array []) {
    if(AMBIENTE_DEBUG>0){
    Serial.println("Modifica Ambiente2 valori:");
    }
  for(int i=0;i<NUM_T;i++){
    target[i]=array[i];
    }
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
  };


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
  };
  
void Ambiente :: SetSoglie(float array[]) {
  if(AMBIENTE_DEBUG>0){
  Serial.println(F("Modifica Soglie valori"));
  }
  for(int i=0;i<NUM_S;i++){
    soglie[i]=array[i];
    }
};
