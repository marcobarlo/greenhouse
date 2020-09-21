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

#ifndef CONTROLLORE_DEBUG
#define CONTROLLORE_DEBUG  0
#endif

#define SIZE 3

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
    Sensore* sensori [3]; //i sensori sono istanziati nel seguente ordine Temperatura Umidita Irradianza
    Attuatore* attuatori [3];//gli attuatori sono nel seguente ordine serpentina innafiatoio Striscia led
    bool Start=false;
    bool Error[3];//gli errori degli attuatori sono nel seguente ordine serpentina innafiatoio Striscia led
    bool Observed;
    long ID;
    long Sezione;
    Controllore();
  public:
    static Controllore* GetInstance();
    void ModificaAmbiente(float array []);//i valori devono essere nel seguente ordine Temperatura Umidita Irradianza
    void SetSoglie(float array[]);//le soglie devono essere nel seguente ordine Temperatura Umidita Irradianza
    void Controllo();
    void SetUp(Ambiente *);
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
