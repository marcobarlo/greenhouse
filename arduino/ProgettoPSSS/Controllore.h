#ifndef _CONTROLLORE_H
#define _CONTROLLORE_H

#include <Arduino.h>
#include "libPSSS.h"
#include "Comunicazione.h"

#define DHTPIN 2
#define DHTTYPE DHT11   // DHT 11

#define LUXINPUT A0

#define YL_69_PIN A1
#define YL_69_VCC 6

class Controllore;
class Comunicazione;
class Ambiente;
class Sensore;
class Attuatore;

class Controllore{
  private:
    static Controllore* MeStesso;
    Comunicazione * Link;
    Ambiente * ambiente;
    Sensore sensori [3];
    Attuatore attuatori [3];
    bool Error[3];
    bool Observed;
    long ID;
    long Sezione;
  public:
    Controllore();
    static Controllore* GetInstance();
    void Controllo();
    void SetUp();
    void SetID(long);
    void SetSezione(long);
    void SetObserved(bool);
//    void SetSoglia(float);
    long GetID();
    long GetSezione();
//    float GetSoglia();
    void ToggleObserved();
  };


#endif 
