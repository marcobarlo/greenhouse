#ifndef _CONTROLLORE_H
#define _CONTROLLORE_H

#include <Arduino.h>
#include <SPI.h>
//#include "libPSSS.h"
#include "Ambiente.h"
#include "SensoreUmidita.h"
#include "SensoreTemperatura.h"
#include "SensoreIrradianza.h"
#include "Serpentina.h"
#include "StrisciaLed.h"
#include "Innaffiatoio.h"
#include "Comunicazione.h"
#include "MemoryFree.h"


#define SIZE 3

//#define DHTPIN 2
//#define DHTTYPE DHT11   // DHT 11

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
    Sensore* sensori [3];
    Attuatore* attuatori [3];
    bool Start=false;
    bool Error[3];
    bool Observed;
    long ID;
    long Sezione;
    Controllore();
  public:
    static Controllore* GetInstance();
    void ModificaAmbiente(float array []);
    void SetSoglie(float array[]);
    void Controllo();
    void SetUp();
    void SetUp2(Ambiente *);
    void SetID(long);
    void SetSezione(long);
    void SetObserved(bool);
    long GetID();
    long GetSezione();
    void SendDati();
    void SendAck();
    bool GetStart(){return Start;}
    void SetStart(){Start=true;}
    void ToggleObserved();
    ~Controllore(){};
  };


#endif 
