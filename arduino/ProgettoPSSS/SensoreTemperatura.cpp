#include "SensoreTemperatura.h"

SensoreTemperatura::SensoreTemperatura(): dht(DHTPIN, DHTTYPE) {
};


void SensoreTemperatura  :: SetUp() {
  if(TEMPERATURA_DEBUG>0){
  Serial.println(F("Setup SensoreTemperatura"));
  }
  Temperatura = -1;
  dht.begin();
};

float SensoreTemperatura  :: GetDato() {
  if(TEMPERATURA_DEBUG>0){
  Serial.println(F("GetDato SensoreTemperatura"));
  }
  float chk = dht.readTemperature();
  if (isnan(chk)){
    chk=-1;
    }
  return chk;
};
