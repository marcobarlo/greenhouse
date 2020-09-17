#ifndef _INNAFFIATOIO_H
#define _INNAFFIATOIO_H

#include "Attuatore.h"
#include "Config.h"

class Innaffiatoio : public Attuatore{
  public:
    Innaffiatoio(){};
    virtual void SetAttuatore(float f);
    virtual void SetUp();
  };

#endif
