#ifndef _SENSORE_H
#define _SENSORE_H

 class Sensore{
  public:
    Sensore(){};
    virtual float GetDato()=0;
    virtual void SetUp()=0;
  };

#endif
