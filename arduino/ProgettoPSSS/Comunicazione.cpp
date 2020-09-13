#include "Comunicazione.h"

#define DISPLACEMENT_BYTE_S 6
#define DISPLACEMENT_SEZ_S  10
#define DISPLACEMENT_TRG_S  14
#define DISPLACEMENT_SGL_S  26
#define DISPLACEMENT_TRG_M  4

Comunicazione* Comunicazione :: Me = NULL;

//TODO Inserire il codice per fare la lettura da SD e fare solo poi begin e ti pigli l'IP?? testare

byte mac[] = {
  0x0A, 0xCF, 0xB3, 0xC4, 0xD8, 0x32
};

byte ip[] = {10, 0, 0, 3};

const char* mqtt_server = "10.0.0.2";

byte gateway[] = {10, 0, 0, 1};  // gateway address

byte subnet[] = {255, 255, 255, 0};  //subnet mask

int i = 0;

void callback(char* topic, byte* payload, unsigned int length) {
  Comunicazione * link;
  link = Comunicazione::GetInstance();
  link->_callback(topic, payload, length);
};

static Comunicazione* Comunicazione::GetInstance() {
  if (Me == NULL) {
    Me = new Comunicazione();
  }
  return Me;

};
void Comunicazione :: SetUp(Ambiente * amb) {
  Target = amb;
  Controller = Controllore::GetInstance();
  Ethernet.begin(mac, ip);//Testare con solo mac, speriamo funzioni
  Serial.println(Ethernet.localIP());
  mqttClient.setClient(ethClient);
  mqttClient.setServer( mqtt_server, 1883); // or local broker
  mqttClient.setCallback(callback);
  int lung = sizeof(mac) / sizeof(mac[0]);
  char char_mac[lung + 1];
  array_to_string(mac, lung, char_mac);
  strcpy(CLIENT_ID, char_mac);
  mqttClient.connect(CLIENT_ID);
  mqttClient.subscribe("GH/SetUp");
  mqttClient.publish("test/topic", "10, 0, 0, 3");
};

void Comunicazione :: keepalive() {
  if (!mqttClient.loop()) {
    mqttClient.connect(CLIENT_ID);
  };
};

void Comunicazione :: PublishDati(byte * payload, int lung) {
  Serial.println("Sto inviando");
  if (mqttClient.connect(CLIENT_ID)) {
    //RISCRIVERE QUESTO TOPIC COME COSTANTI
    mqttClient.publish("GH/Dati", payload, lung);
  }
};

void Comunicazione :: Publish(char topic [], byte * payload, int lung){
    Serial.println("Sto inviando");
  if (mqttClient.connect(CLIENT_ID)) {
    mqttClient.publish(topic, payload, lung);
  }
  };


void Comunicazione :: PublishErrore(byte * payload,int lung) {
  if (mqttClient.connect(CLIENT_ID)) {
    //RISCRIVERE QUESTO TOPIC COME COSTANTI
    mqttClient.publish("GH/Errore", payload,lung);
  }
};


void Comunicazione::_callback(char* topic, byte* payload, unsigned int length) {
  Serial.println("Sono nella Callback");
  char option [30];
  Serial.println(topic);
  Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  if (strcmp("GH/SetUp", topic) == 0) {
    Serial.print("Message arrived [");
    Serial.print(topic);
    Serial.print("] ");//MQTT_BROKER
    bool corretto = true;
    int j = 0;
    while (corretto && j < 6) {
      if (mac[j] != payload[j]) {
        corretto = false;
      }
      j = j + 1;
    }
    if (corretto) {
      Serial.println("Trovato il mac!!!");
      Serial.println(freeMemory(), DEC);  // print how much RAM is available.
      // Convertire in vettori di vettori di 4 byte
      byte ID_B[4];
      byte Sezione_B[4];
      byte target_b [3][4];
      float target[3];
      byte soglie_b [3][4];
      float soglie [3];
      long ID = Convert_byte_to_long(payload, DISPLACEMENT_BYTE_S);
      Controller->SetID(ID);
      Serial.println("ID:");
      Serial.println(ID, DEC);
      long sez = Convert_byte_to_long(payload, DISPLACEMENT_SEZ_S);
      Serial.println("Sezione:");
      Serial.println(sez);
      Controller->SetSezione(sez);
      Serial.println("PRELEVIAMOLI STI CAZZO DI DATI");
      for (int i = 0; i < 3; i++) {
        Serial.println(i);
        target[i] = Convert_byte_to_float(payload, DISPLACEMENT_TRG_S + 4 * i);
        Serial.println(target[i]);
        soglie[i] = Convert_byte_to_float(payload, DISPLACEMENT_SGL_S + 4 * i);
        Serial.println(soglie[i]);
      }
      Target->ModificaAmbiente2(target);
      Target->SetSoglie2(soglie);
      Controller->SetStart();
      float targetf[3];
      float soglief[3];
      Target->GetTarget(targetf,3);
      Target->GetSoglie(soglief,3);
      Serial.println("Temperatura Umidita e Irradianza con le funzioni");
      Serial.println(targetf[0]);
      Serial.println(targetf[1]);
      Serial.println(targetf[2]);
      Serial.println("Le tre Soglie con funzione:");
      Serial.println(soglief[0]);
      Serial.println(soglief[1]);
      Serial.println(soglief[2]);
      Serial.println("SEZIONE TEST FROM GET SEZIONE");
      Serial.println(Controller->GetSezione());
      //Serve ?? o già lo ho?
      char sezione [10];
      ltoa(Controller->GetSezione(), sezione, 10);
      Serial.println("Dopo ltoa");
      Serial.println(sezione);
      char Topic[30];
      strcpy(Header, "GH/");
      strcat(Header, sezione);
      strcat(Header, "/cmd/");
      strcpy(Topic, Header);
      strcat(Topic, "+");
      Serial.println(Header);
      mqttClient.subscribe(Topic);
      Serial.println(Topic);
      //Convertire Topic in una costante
      mqttClient.unsubscribe("GH/SetUp");
    }
  }
  strcpy(option, Header);
  strcat(option, "Mod");
  Serial.print(strcmp(option, topic));
  if (strcmp(option, topic) == 0) {
    Serial.println("Sono in mod");
//    byte ID_B [4];
    byte ID_B2 [4];
    float target[3];
    long Temp = Controller->GetID();
//    ID_B[0] = Temp & 0xFF;
//    ID_B[1] = (Temp >> 8)  & 0xFF;
//    ID_B[2] = (Temp >> 16) & 0xFF;
//    ID_B[3] = (Temp >> 24) & 0xFF;
    Load_to_payload_long(ID_B2, 0, Temp);

    Serial.println(ID_B2[0]);
    Serial.println(ID_B2[1]);
    Serial.println(ID_B2[2]);
    Serial.println(ID_B2[3]);
    bool corretto = true;
    int j = 0;
    Serial.println("Prendo il payload");
    while (corretto && j < 4) {
      if (ID_B2[j] != payload[j]) {//Con la funzione viene già invertito quando messo in byte quindi non serve invertire qui
        corretto = false;
      }
      j = j + 1;
    }
    if (corretto) {
      Serial.print("Trovato ID");
      for (int i = 0; i < 3; i++) {
        target[i] = Convert_byte_to_float(payload, DISPLACEMENT_TRG_M + 4 * i);
      }
      Serial.println("Temperatura Umidita Irradianze funzione");
      Serial.println(target[0]);
      Serial.println(target[1]);
      Serial.println(target[2]);
//      Target->ModificaAmbiente(Tem, Um, Irr);
      Target->ModificaAmbiente2(target);
      Controller->SendAck();
    }
  }
  strcpy(option, Header);
  strcat(option, "STROBS");
  if (strcmp(option, topic) == 0) {
    byte ID_B [4];
    long Temp = Controller->GetID();
    Load_to_payload_long(ID_B, 0, Temp);
//    ID_B[0] = Temp & 0xFF;
//    ID_B[1] = (Temp >> 8)  & 0xFF;
//    ID_B[2] = (Temp >> 16) & 0xFF;
//    ID_B[3] = (Temp >> 24) & 0xFF;
    bool corretto = true;
    int j = 0;
        while (corretto && j < 4) {
          if (ID_B[j] != payload[j]) {
            corretto = false;
          }
          j = j + 1;
        }
//    while (corretto && j < 4) {
//      if (ID_B[3 - j] != payload[j]) {
//        corretto = false;
//      }
//      j = j + 1;
//    }
    if (corretto) {
      Serial.println("Mi sento osservato!");
      Controller->SetObserved(true);
      //Invio il messaggio di ritorno
      Controller->SendDati();
    }
  }
  strcpy(option, Header);
  strcat(option, "STPOBS");
  if (strcmp(option, topic) == 0) {
    //Primo byte conterrà i meno significativi
    byte ID_B [4];
    long Temp = Controller->GetID();
    Load_to_payload_long(ID_B, 0, Temp);
    bool corretto = true;
    int j = 0;
        while (corretto && j < 4) {
          if (ID_B[j] != payload[j]) {
            corretto = false;
          }
          j = j + 1;
        }
//    while (corretto && j < 4) {
//      if (ID_B[3 - j] != payload[j]) {
//        corretto = false;
//      }
//      Serial.println(ID_B[3 - j]);
//      Serial.println(payload[j]);
//      j = j + 1;
//    }
    if (corretto) {
      Serial.println("Non mi sento più osservato");
      Controller->SetObserved(false);
    }
  }
}

void Comunicazione::PublishTest() {
  mqttClient.publish("test/topic", String(i).c_str() );
  i = i + 1;
};
