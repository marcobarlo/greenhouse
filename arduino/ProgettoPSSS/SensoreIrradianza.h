#ifndef _IRRADIANZA_H
#define _IRRADIANZA_H

#include "Sensore.h"
#include "Config.h"
#include <SPI.h>


#ifndef IRRADIANZA_DEBUG
#define IRRADIANZA_DEBUG  0
#endif

class SensoreIrradianza : public Sensore{
  public:
    SensoreIrradianza();
    virtual float GetDato();
    virtual void SetUp();
  };

#endif
