#ifndef _IRRADIANZA_H
#define _IRRADIANZA_H

#include "Sensore.h"
#include "Config.h"
#include <SPI.h>

#define LUXINPUT A0


class SensoreIrradianza : public Sensore{
  private:
    float Irradianza;
  public:
    SensoreIrradianza();
    virtual void  WhoAreYou(){Serial.println("Sono il sensore di Irradianza");};
    virtual float GetDato();
    virtual void SetUp();
  };

#endif
