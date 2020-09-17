#include "SensoreTemperatura.h"

SensoreTemperatura::SensoreTemperatura(): dht(DHTPIN, DHTTYPE) {
};


void SensoreTemperatura  :: SetUp() {
  Serial.println(" Setup SensoreTemperatura");
  Temperatura = -1;
  dht.begin();
};

float SensoreTemperatura  :: GetDato() {
  
  Serial.println(" GetDato SensoreTemperatura");
  float chk = dht.readTemperature();
  Serial.println(chk);
  if (isnan(chk)){
    chk=-1;
    }
  return chk;
};
