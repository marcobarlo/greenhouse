#ifndef _PROGETTOPSS_H
#define _PROGETTOPSS_H


#include <DHT.h>
#include <Ethernet.h>
#include <Arduino.h>

#include "Attuatore.h"

#include "func.h"





class Serpentina : public Attuatore{
  public:
    Serpentina(){};
    virtual void SetAttuatore(float f);
    virtual void SetUp();
  };



#endif
