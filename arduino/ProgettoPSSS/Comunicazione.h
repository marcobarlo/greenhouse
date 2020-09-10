#ifndef _COMUNICAZIONE_H
#define _COMUNICAZIONE_H

#include <stdio.h>
#include <Ethernet.h>
#include <Arduino.h>
#include <SPI.h>
#include "MemoryFree.h"
#include "libPSSS.h"


#include "Controllore.h"
#include "PubSubClient.h"

#define CLIENT_TEMP "TEMP" //DA CAMBIARE ?? come faccio a fare la connessione al primo Client ID il mac??
//Dovrei già averlo fatto il CLIENT ID ora è il mac 
void callback(char* topic, byte* payload, unsigned int length);

class Controllore;
class Comunicazione;
class Ambiente;
class Sensore;
class Attuatore;

class Comunicazione{
  private:
    static Comunicazione* Me;
    EthernetClient ethClient;
    PubSubClient mqttClient;
    Ambiente*  Target;
    Controllore* Controller;
    char * CLIENT_ID;
    char * Header;
  public:
    Comunicazione(){Me=this;};
    static Comunicazione* GetInstance();
    void SetUp(Ambiente *);
    void PublishTest();
    void PublishData(byte * payload);
    void PublishError(byte * payload);
    void _callback(char* topic, byte* payload, unsigned int length);
    void keepalive();
  };



#endif
