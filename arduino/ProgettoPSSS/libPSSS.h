#ifndef _PROGETTOPSS_H
#define _PROGETTOPSS_H

//#include "Controllore.h"

#include <DHT.h>
#include <Ethernet.h>
#include <Arduino.h>

#include "PubSubClient.h"
#include "func.h"

#define CLIENT_TEMP "TEMP" //DA CAMBIARE ?? come faccio a fare la connessione al primo Client ID il mac??
#define DHTPIN 2
#define DHTTYPE DHT11   // DHT 11

#define LUXINPUT A0

#define YL_69_PIN A1
#define YL_69_VCC 6

//void array_to_string(byte array[], unsigned int len, char buffer[]);

class Controllore;
class Comunicazione;
class Ambiente;
class Sensore;
class Attuatore;


void callback(char* topic, byte* payload, unsigned int length);

class Ambiente{
  private:
    //Rifarlo in modo tale da avere due vettori invece si averli così
    float target[3];
    float soglie[3];
    float UmiditaTarget;
    float IrradianzaTarget;
    float TemperaturaTarget;
    float SogliaU;
    float SogliaI;
    float SogliaT;
  public:
    Ambiente(){};
    //riscrivere con modifica Ambiente che prende un vettore
    void ModificaAmbiente2(float array []);
    void ModificaAmbiente(float T, float U, float I);
//    void  SetUmiditaTarget(float);
//    void  SetIrradianzaTarget(float);
//    void  SetTemperaturaTarget(float);
    // riscrivere facendo prendere un vettore
    void SetSoglie(float T, float U, float I);
    void SetSoglie2(float array[]);
    //fare altre due funzioni che prendano in questo caso tutti i target e tutte le soglie
    int GetSoglie(float array[],int lung);//per farlo per bene servirebbero puntatori ma così evito di fare allocazione dinamica di cose piccole
    float GetSogliaU();
    float GetSogliaI();
    float GetSogliaT();
    int GetTarget(float array[],int lung);//per farlo correttamente ci vorrebbero i puntatori alternatuìiva è il mega accrocchio di fare il ritorno di qualcosa di locale
    float GetUmiditaTarget();
    float GetIrradianzaTarget();
    float GetTemperaturaTarget();

  };

 class Sensore{
  public:
    Sensore(){};
    virtual float GetDato(){};
    virtual void SetUp(){};
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
    virtual void SetAttuatore(float f){};
    virtual void SetUp(){};
  };

class Serpentina : public Attuatore{
  public:
    Serpentina(){};
    virtual void SetAttuatore(float f);
    virtual void SetUp();
  };

class Innaffiatoio : public Attuatore{
  public:
    Innaffiatoio(){};
    virtual void SetAttuatore(float f);
    virtual void SetUp();
  };
  
class StrisciaLed : public Attuatore {
  public:
    StrisciaLed(){};
    virtual void SetAttuatore(float f);
    virtual void SetUp();
  };







#endif
