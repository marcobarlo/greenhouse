#ifndef _PROGETTOPSS_H
#define _PROGETTOPSS_H

#include <DHT.h>
#include <Ethernet.h>
#include <Arduino.h>

#include "PubSubClient.h"

#define CLIENT_ID "PRIMO"
#define DHTPIN 2
#define DHTTYPE DHT11   // DHT 11
#define LUXINPUT A0



void callback(char* topic, byte* payload, unsigned int length);

class Ambiente{
  private:
    float UmiditaTarget;
    float IrradianzaTarget;
    float TemperaturaTarget;
  public:
    Ambiente();
    void ModificaAmbiente(float U, float I, float T);
    float GetUmiditaTarget();
    float GetIrradianzaTarget();
    float GetTemperaturaTarget();

  };

 class Sensore{
  public:
    Sensore(){};
    virtual float GetDato();
    virtual void SetUp();
  };

class SensoreUmidita : public Sensore{
  private:
    float Umidita;
	
  public:
    SensoreUmidita(){};
    virtual float GetDato();
    virtual void SetUp();
  };

class SensoreIrradianza : public Sensore{
  private:
    float Irradianza;
  public:
    SensoreIrradianza();
    virtual float GetDato();
    virtual void SetUp();
  };
  
class SensoreTemperatura : public Sensore{
  private:
    float Temperatura;
	  DHT dht;
  public:
    SensoreTemperatura();
    virtual float GetDato();
    virtual void SetUp();
  };

class Attuatore {
  public:
    Attuatore(){};
    virtual void SetAttuatore();
    virtual void SetUp();
  };

class Serpentina : public Attuatore{
  public:
    Serpentina(){};
    virtual void SetAttuatore();
    virtual void SetUp();
  };

class Innaffiatoio : public Attuatore{
  public:
    Innaffiatoio(){};
    virtual void SetAttuatore();
    virtual void SetUp();
  };
  
class StrisciaLed : public Attuatore {
  public:
    StrisciaLed(){};
    virtual void SetAttuatore();
    virtual void SetUp();
  };

class Controllore{
  private:
    Ambiente * ambiente;
    Sensore sensori [2];
    Attuatore attuatori [2];
    bool Observed;
    long ID;
    long Sezione;
  public:
    Controllore(){};
    void SetID(long);
    void SetSezione(long);
    void SetObserved(bool);
    long GetID();
    long GetSezione();
  };

class Comunicazione{
  private:
    static Comunicazione* Me=NULL;
    EthernetClient ethClient;
    PubSubClient mqttClient;
    Ambiente*  Target;
    Controllore* Controller;
    char * Header;
  public:
    Comunicazione(){Me=this;};
    static Comunicazione* GetInstance();
    void SetUp(Ambiente *, Controllore *);
    void Publish();
    void _callback(char* topic, byte* payload, unsigned int length);
    void keepalive();
  };



#endif
