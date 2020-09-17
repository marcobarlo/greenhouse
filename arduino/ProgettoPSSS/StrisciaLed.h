#ifndef _STRISCIALED_H
#define _STRISCIALED_H

#include "Attuatore.h"

class StrisciaLed : public Attuatore {
  public:
    StrisciaLed(){};
    virtual void SetAttuatore(float f);
    virtual void SetUp();
  };



#endif 
