#ifndef _PROGETTOPSS_H
#define _PROGETTOPSS_H

#include <DHT.h>
#include <Ethernet.h>
#include <Arduino.h>

#include "PubSubClient.h"

#define CLIENT_TEMP "TEMP" //DA CAMBIARE ?? come faccio a fare la connessione al primo Client ID il mac??
#define DHTPIN 2
#define DHTTYPE DHT11   // DHT 11

#define LUXINPUT A0

#define YL_69_PIN A1
#define YL_69_VCC 6



void callback(char* topic, byte* payload, unsigned int length);

class Controllore;
class Comunicazione;

class Ambiente{
  private:
    float UmiditaTarget;
    float IrradianzaTarget;
    float TemperaturaTarget;
  public:
    Ambiente();
    void ModificaAmbiente(float U, float I, float T);//Implementata
//    void  SetUmiditaTarget(float);
//    void  SetIrradianzaTarget(float);
//    void  SetTemperaturaTarget(float);
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
    void PublishData(byte * payload, char * CLIENT_ID);
    void PublishError(byte * payload, char * CLIENT_ID);
    void _callback(char* topic, byte* payload, unsigned int length);
    void keepalive();
  };


class Controllore{
  private:
    static Controllore* MeStesso=NULL;
    Comunicazione * Link;
    Ambiente * ambiente;
    Sensore sensori [3];
    Attuatore attuatori [3];
    bool Error[3];
    float Soglia;
    bool Observed;
    long ID;
    long Sezione;
  public:
    Controllore(){MeStesso=this;Link=Comunicazione :: GetInstance();};
    static Controllore* GetInstance();
    void Controllo();
    void SetUp();
    void SetID(long);
    void SetSezione(long);
    void SetObserved(bool);
    void SetSoglia(float);
    long GetID();
    long GetSezione();
    float GetSoglia();
    void ToggleObserved();
  };




#endif
