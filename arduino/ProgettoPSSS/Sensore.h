#ifndef _SENSORE_H
#define _SENSORE_H

 class Sensore{
  public:
    Sensore(){};
    virtual void  WhoAreYou(){};
    virtual float GetDato(){};
    virtual void SetUp(){};
  };

#endif
