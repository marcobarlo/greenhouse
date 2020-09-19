#ifndef _TEMPERATURA_H
#define _TEMPERATURA_H

#include "Sensore.h"
#include <DHT.h>
#include "Config.h"
#include <SPI.h>


#ifndef TEMPERATURA_DEBUG
#define TEMPERATURA_DEBUG  0
#endif

class SensoreTemperatura : public Sensore{
  private:
	  DHT dht;
  public:
    SensoreTemperatura();
    virtual float GetDato();
    virtual void SetUp();
  };


#endif
