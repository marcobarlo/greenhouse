#ifndef _TEMPERATURA_H
#define _TEMPERATURA_H

#include "Sensore.h"
#include <DHT.h>
#include "Config.h"
#include <SPI.h>

#define DHTPIN 2
#define DHTTYPE DHT11   // DHT 11


class SensoreTemperatura : public Sensore{
  private:
    float Temperatura;
	  DHT dht;
  public:
    SensoreTemperatura();
    virtual void  WhoAreYou(){Serial.println("Sono il sensore di Temperatura");};
    virtual float GetDato();
    virtual void SetUp();
  };


#endif
