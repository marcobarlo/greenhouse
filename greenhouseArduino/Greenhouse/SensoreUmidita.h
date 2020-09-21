#ifndef _UMIDITA_H
#define _UMIDITA_H

#include "Sensore.h"
#include "Config.h"
#include <SPI.h>



#ifndef UMIDITA_DEBUG
#define UMIDITA_DEBUG  0
#endif

class SensoreUmidita : public Sensore{
  public:
    SensoreUmidita(){};
    virtual float GetDato();
    virtual void SetUp();
  };


#endif
