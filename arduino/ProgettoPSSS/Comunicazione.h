#ifndef _COMUNICAZIONE_H
#define _COMUNICAZIONE_H

#include <stdio.h>
#include <Ethernet.h>
#include <Arduino.h>
#include <SPI.h>
#include "MemoryFree.h"
#include <SD.h>
#include "func.h"

#define TopicErrore "GH/Errore"
#define TopicDati "GH/Dati"
#define TopicAck  "GH/Ack"
#define TopicSetUp "GH/SetUp"

#ifndef COMUNICAZIONE_DEBUG
#define COMUNICAZIONE_DEBUG  0
#endif


#include "Controllore.h"
#include "PubSubClient.h"

#define NUM_S 3

void callback(char* topic, byte* payload, unsigned int length);



class Controllore;
class Comunicazione;

class Comunicazione{
  private:
    static Comunicazione* Me;
    EthernetClient ethClient;
    PubSubClient mqttClient;
    Controllore* Controller;
    char CLIENT_ID[13];//va visto dinamicamente se queste dimensioni vanno bene ed eventualmente metterle come define
    char Header[30];
    char mqttserver[9];
    byte mac_byte[6];
    bool CheckID(byte ID_B [4],byte payload []);
    Comunicazione(){Me=this;};
    void _callbackSetUp(byte * payload);
    void _callbackMod(byte * payload);
    void _callbackSTROBS();
    void _callbackSTPOBS();
    void Publish(char topic [], byte * payload, int lung);
  public:
    static Comunicazione* GetInstance();
    void SetUp();
    void PublishTest();
    void _callback(char* topic, byte* payload, unsigned int length);
    void PublishAck(long ID);
    void PublishDati(long ID,float array []);
    void PublishErroreSensore(long ID, long Errore);
    void PublishErroreAttuatore(long ID, long Errore,float delta);

    void keepalive();
    ~Comunicazione(){};
  };



#endif
