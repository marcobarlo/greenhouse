#include "SensoreUmidita.h"

void SensoreUmidita :: SetUp() {
  Serial.println(" Setup SensoreUmidita");
  pinMode(YL_69_VCC, OUTPUT);
  digitalWrite(YL_69_VCC, LOW);
};

float SensoreUmidita :: GetDato() {
  Serial.println(" GetDato SensoreUmidita");
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
