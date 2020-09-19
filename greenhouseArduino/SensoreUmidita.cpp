#include "SensoreUmidita.h"

void SensoreUmidita :: SetUp() {
  if(UMIDITA_DEBUG>0){
  Serial.println(" Setup SensoreUmidita");
  }
  pinMode(YL_69_VCC, OUTPUT);
  digitalWrite(YL_69_VCC, LOW);
};

float SensoreUmidita :: GetDato() {
  float Umidita;
  if(UMIDITA_DEBUG>0){
  Serial.println(" Prelievo dato SensoreUmidita");
  }
  digitalWrite(YL_69_VCC, HIGH);
  delay(500);
  int value = analogRead(YL_69_PIN);
  digitalWrite(YL_69_VCC, LOW);
  Umidita = 1023 - value;
  Serial.println(value);
  if(value ==0){
    return -1;
    }
//  return Umidita;
  return (Umidita/1023)*100;
};
