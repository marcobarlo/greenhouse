#ifndef _ATTUATORE_H
#define _ATTUATORE_H

class Attuatore {
  public:
    Attuatore(){};
    virtual void SetAttuatore(float f)=0;
    virtual void SetUp()=0;
  };


#endif
