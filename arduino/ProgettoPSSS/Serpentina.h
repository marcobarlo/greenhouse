#ifndef _PROGETTOPSS_H
#define _PROGETTOPSS_H

//#include "Controllore.h"

#include <DHT.h>
#include <Ethernet.h>
#include <Arduino.h>

#include "Attuatore.h"
#include "PubSubClient.h"
#include "func.h"

//#define CLIENT_TEMP "TEMP" //DA CAMBIARE ?? come faccio a fare la connessione al primo Client ID il mac??
//#define DHTPIN 2
//#define DHTTYPE DHT11   // DHT 11
//
//#define LUXINPUT A0
//
//#define YL_69_PIN A1
//#define YL_69_VCC 6

//void array_to_string(byte array[], unsigned int len, char buffer[]);

class Controllore;
class Comunicazione;
class Ambiente;
class Sensore;
class Attuatore;


void callback(char* topic, byte* payload, unsigned int length);




class Serpentina : public Attuatore{
  public:
    Serpentina(){};
    virtual void SetAttuatore(float f);
    virtual void SetUp();
  };



#endif
