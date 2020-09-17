#ifndef _COMUNICAZIONE_H
#define _COMUNICAZIONE_H

#include <stdio.h>
#include <Ethernet.h>
#include <Arduino.h>
#include <SPI.h>
#include "MemoryFree.h"
//#include "TimerInterrupt.h"
#include "Tim.h"
#include <SD.h>

#define TopicErrore "GH/Errore"
#define TopicDati "GH/Dati"
#define TopicAck  "GH/Ack"



#include "Controllore.h"
//#include "PubSubClient.h"
//
//#define CLIENT_TEMP "TEMP" //DA CAMBIARE ?? come faccio a fare la connessione al primo Client ID il mac??
//Dovrei già averlo fatto il CLIENT ID ora è il mac 
#define NUM_S 3

void callback(char* topic, byte* payload, unsigned int length);



class Controllore;
class Comunicazione;
//class Ambiente;
//class Sensore;
//class Attuatore;

class Comunicazione{
  private:
    static Comunicazione* Me;
    EthernetClient ethClient;
    PubSubClient mqttClient;
//    Ambiente*  Target;
    Controllore* Controller;
    //vedere se trasformare da allocazione dinamica a instanziazione statica di buffer
    char CLIENT_ID[13];//va visto dinamicamente se queste dimensioni vanno bene ed eventualmente metterle come define
    char Header[30];
    Comunicazione(){Me=this;};
    void _callbackSetUp(byte * payload);
    void _callbackMod(byte * payload);
    void _callbackSTROBS();
    void _callbackSTPOBS();
    void Publish(char topic [], byte * payload, int lung);
  public:
//    Comunicazione(){Me=this;};
    static Comunicazione* GetInstance();
    void SetUp();
    void PublishTest();
//    void PublishDati(byte * payload, int lung);
//    void PublishErrore(byte * payload,int lung);
    void _callback(char* topic, byte* payload, unsigned int length);
    void PublishAck(long ID);
    void PublishDati(long ID,float array []);
    void PublishErroreSensore(long ID, long Errore);
    void PublishErroreAttuatore(long ID, long Errore,float delta);

    void keepalive();
    ~Comunicazione(){};
  };



#endif
