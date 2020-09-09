#ifndef _COMUNICAZIONE_H
#define _COMUNICAZIONE_H

#include <Ethernet.h>
#include <Arduino.h>

#include "Controllore.h"
#include "PubSubClient.h"

#define CLIENT_TEMP "TEMP" //DA CAMBIARE ?? come faccio a fare la connessione al primo Client ID il mac??

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
    void SetUp(Ambiente *, Controllore *);
    void PublishData(byte * payload);
    void PublishError(byte * payload);
    void _callback(char* topic, byte* payload, unsigned int length);
    void keepalive();
  };



#endif
