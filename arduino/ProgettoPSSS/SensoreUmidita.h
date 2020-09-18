#ifndef     def _UMIDITA_H
#define _UMIDITA_H

#include "Sensore.h"
#include "Config.h"
#include <SPI.h>


#define YL_69_PIN A1
#define YL_69_VCC 6

#ifndef UMIDITA_DEBUG
#define UMIDITA_DEBUG  0
#endif

class SensoreUmidita : public Sensore{
  private:
    float Umidita;
	
  public:
    SensoreUmidita(){};
    virtual void  WhoAreYou(){Serial.println("Sono il sensore di Umidita");};
    virtual float GetDato();
    virtual void SetUp();
  };


#endif
