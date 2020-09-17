#include "SensoreTemperatura.h"

SensoreTemperatura::SensoreTemperatura(): dht(DHTPIN, DHTTYPE) {
};
//SensoreTemperatura::SensoreTemperatura() {
//};

void SensoreTemperatura  :: SetUp() {
  Serial.println(" Setup SensoreTemperatura");
//  DHT  dht2(DHTPIN, DHTTYPE);
//  dht=&dht2;
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
//  return 10;
};