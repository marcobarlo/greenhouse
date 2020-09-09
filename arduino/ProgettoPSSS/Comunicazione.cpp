#include "Comunicazione.h"

Comunicazione* Comunicazione :: Me;

byte mac[] = {
  0x0A, 0xCF, 0xB3, 0xC4, 0xD8, 0x32
};

byte ip[] = {10, 0, 0, 3};

const char* mqtt_server = "10.0.0.2";

byte gateway[] = {10, 0, 0, 1};  // gateway address

byte subnet[] = {255, 255, 255, 0};  //subnet mask



void callback(char* topic, byte* payload, unsigned int length) {
  Comunicazione * link;
  link = Comunicazione::GetInstance();
  link->_callback(topic, payload, length);
};

static Comunicazione* Comunicazione::GetInstance() {
  if (Me == NULL) {
    Comunicazione Link;
    Me = &Link;
  }
  return Me;
};
void Comunicazione :: SetUp(Ambiente * amb, Controllore * cntr) {
  Target = amb;
  Controller = cntr;
  Ethernet.begin(mac, ip);//Testare con solo mac, speriamo funzioni
  mqttClient.setClient(ethClient);
  mqttClient.setServer( mqtt_server, 1883); // or local broker
  mqttClient.setCallback(callback);
  char * char_mac;
  for (int i = 0; i < sizeof(mac); i++) {
    strcat(char_mac, (char)mac[i]);
  }
  CLIENT_ID = char_mac;
  //  mqttClient.setCallback([this] (char* topic, byte* payload, unsigned int length) { this->callback(topic, payload, length); });
  mqttClient.connect(CLIENT_ID);
  mqttClient.subscribe("GH/SetUp");
};

void Comunicazione :: keepalive() {
  mqttClient.loop();
};

void Comunicazione :: PublishData(byte * payload) {
  //      char * Topic;
  //      strcpy(Topic, Header);
  //      strcat(Topic, "Dati");
  if (mqttClient.connect(CLIENT_ID)) {
    mqttClient.publish("GH/Dati", payload);
  }
};

void Comunicazione :: PublishError(byte * payload) {
  //
  //    char * Topic;
  //      strcpy(Topic, Header);
  //      strcat(Topic, "Error");
  if (mqttClient.connect(CLIENT_ID)) {
    mqttClient.publish("GH/Error", payload);
  }
};


void Comunicazione::_callback(char* topic, byte* payload, unsigned int length) {
  //  char msgBuffer[20];
  // I am only using one ascii character as command, so do not need to take an entire word as payload
  // However, if you want to send full word commands, uncomment the next line and use for string comparison
  // payload[length]='\0';// terminate string with 0
  //String strPayload = String((char*)payload);  // convert to string
  // Serial.println(strPayload);
  char * option;
  if (strcmp("GH/SetUp", topic)) {
    Serial.print("Message arrived [");
    Serial.print(topic);
    Serial.print("] ");//MQTT_BROKER
    //Controllo MAC in BYTE?
    //     for (int i = 0; i < 12; i++) {
    //      msgBuffer[i]=(char)payload[i];
    //      Serial.print((char)payload[i]);
    //     }
    //Mantenere il tutto salvato come invece di passare a Long??
    bool corretto = true;
    int j = 0;
    while (corretto && j < 12) {
      if (mac[j] != payload[j]) {
        corretto = false;
      }
      j = j + 1;
    }
    if (corretto) {
      byte ID_B[4];
      byte Sezione_B[4];
      byte Temperatura_B[4];
      byte Umidita_B[4];
      byte Irradianza_B[4];
      float Temperatura;
      float Umidita;
      float Irradianza;
      byte SogliaT_B[4];
      byte SogliaU_B[4];
      byte SogliaI_B[4];
      float SogliaT;
      float SogliaU;
      float SogliaI;
      for (int i = 12; i++; i < 16) {
        ID_B[i - 12] = payload[i];
      }
      for (int i = 16; i++; i < 20) {
        Sezione_B[i - 16] = payload[i];
      }
      Controller->SetID((long)ID_B);
      Controller->SetSezione((long)Sezione_B);
      union TEMP {
        float f;
        byte b[4];
      } temp;

      for (int i = 16; i++; i < 20) {
        temp.b[i - 16] = payload[i];
      }
      Temperatura = temp.f;
      for (int i = 20; i++; i < 24) {
        temp.b[i - 20] = payload[i];
      }
      Umidita = temp.f;
      for (int i = 24; i++; i < 28) {
        temp.b[i - 24] = payload[i];
      }
      Irradianza = temp.f;
      Target->ModificaAmbiente(Temperatura, Umidita, Irradianza);
      
      for (int i = 16; i++; i < 20) {
        temp.b[i - 16] = payload[i];
      }
      SogliaT = temp.f;
      for (int i = 20; i++; i < 24) {
        temp.b[i - 20] = payload[i];
      }
      SogliaU = temp.f;
      for (int i = 24; i++; i < 28) {
        temp.b[i - 24] = payload[i];
      }
      SogliaI = temp.f;
      Target->SetSoglie(SogliaT, SogliaU, SogliaI);
      
      //          this->ID=String((char *)ID_B);
      //          this->Sezione=String((char *)Sezione_B);
      //          String HeadofTopic="GH/";
      char* Topic;
      strcat(Header, "GH/");
      strcat(Header, (char)(Controller->GetSezione()));
      strcat(Header, "/cmd/");
      strcpy(Topic, Header);
      strcat(Topic, "+");
      mqttClient.subscribe((const char *)Topic);
      Serial.println(Topic);
      mqttClient.unsubscribe("GH/SetUp");
      sei();
    }
  }
  strcpy(option, Header);
  strcat(option, "Mod");
  if (strcmp(option, topic)) {
    byte ID_B [4];
    //Cambiare da modifica ambiente a 3 set ed un solo dato??
    //    byte Um_B[4];
    long Um = 0;
    //    byte Irr_B[4];
    float Irr = 0;
    //    byte Tem_B[4];
    float Tem = 0;
    long Temp = Controller->GetID();
    ID_B[0] = Temp & 0xFF;
    ID_B[1] = (Temp >> 8)  & 0xFF;
    ID_B[2] = (Temp >> 16) & 0xFF;
    ID_B[3] = (Temp >> 24) & 0xFF;
    //      Temp=Controller->GetSezione();
    //      Sezione_B[0]=Temp & 0xFF;
    //      Sezione_B[1]=(Temp >> 8)  & 0xFF;
    //      Sezione_B[2]=(Temp >> 16) & 0xFF;
    //      Sezione_B[3]=(Temp >> 24) & 0xFF;
    bool corretto = true;
    int j = 0;
    while (corretto && j < 12) {
      if (ID_B[j] != payload[j]) {
        corretto = false;
      }
      j = j + 1;
    }
    if (corretto) {
      union TEMP {
        float f;
        byte b[4];
      } temp;
      for (int i = 4; i < 8; i++) {
        //        Um_B[i - 4] = payload[i];
        temp.b[i - 4] = payload[i]; //Qui invece deve inviare come big endian
        //        Um=(Um<<8) | payload[i];
      }
      Tem = temp.f;
      for (int i = 4; i < 8; i++) {
        //        Irr_B[i - 4] = payload[i];
        temp.b[i - 4] = payload[i]; //Qui invece deve inviare come big endian
        //        Irr=(Irr<<8) | payload[i];
      }
      Um = temp.f;
      for (int i = 4; i < 8; i++) {
        //        Tem_B[i - 4] = payload[i];
        temp.b[i - 4] = payload[i]; //Qui invece deve inviare come big endian
        //        Tem=(Tem<<8) | payload[i];
      }
      Irr = temp.f;
      Target->ModificaAmbiente(Tem, Um, Irr);
    }
  }
  //  strcpy(option, Header);
  //  strcat(option, "Rec");
  //  if (strcmp(option, topic)) {
  //    byte ID_B [4];
  //    long Temp = Controller->GetID();
  //    ID_B[0] = Temp & 0xFF;
  //    ID_B[1] = (Temp >> 8)  & 0xFF;
  //    ID_B[2] = (Temp >> 16) & 0xFF;
  //    ID_B[3] = (Temp >> 24) & 0xFF;
  //    bool corretto = true;
  //    int j = 0;
  //    while (corretto && j < 12) {
  //      if (ID_B[j] != payload[j]) {
  //        corretto = false;
  //      }
  //      j = j + 1;
  //    }
  //    if (corretto) {
  //        Controller->ToggleObserved();
  //      }
  //  }
  strcpy(option, Header);
  strcat(option, "STROBS");
  if (strcmp(option, topic)) {
    byte ID_B [4];
    long Temp = Controller->GetID();
    ID_B[0] = Temp & 0xFF;
    ID_B[1] = (Temp >> 8)  & 0xFF;
    ID_B[2] = (Temp >> 16) & 0xFF;
    ID_B[3] = (Temp >> 24) & 0xFF;
    bool corretto = true;
    int j = 0;
    while (corretto && j < 12) {
      if (ID_B[j] != payload[j]) {
        corretto = false;
      }
      j = j + 1;
    }
    if (corretto) {
      Controller->SetObserved(true);
    }
  }
  strcpy(option, Header);
  strcat(option, "STPOBS");
  if (strcmp(option, topic)) {
    byte ID_B [4];
    long Temp = Controller->GetID();
    ID_B[0] = Temp & 0xFF;
    ID_B[1] = (Temp >> 8)  & 0xFF;
    ID_B[2] = (Temp >> 16) & 0xFF;
    ID_B[3] = (Temp >> 24) & 0xFF;
    bool corretto = true;
    int j = 0;
    while (corretto && j < 12) {
      if (ID_B[j] != payload[j]) {
        corretto = false;
      }
      j = j + 1;
    }
    if (corretto) {
      Controller->SetObserved(false);
    }
  }
  //
  //  for (int i = 0; i < length; i++) {
  //    Serial.print((char)payload[i]);
  //  }
  //  Serial.println();
  //  Serial.println(payload[0]);
  //
  //  // Examine only the first character of the message
  //  if (payload[0] == 49)             // Message "1" in ASCII (turn output ON)
  //  {
  //  } else if (payload[0] == 48)      // Message "0" in ASCII (turn output OFF)
  //  {
  //  } else if (payload[0] == 50)
  //  {
  //    mqttClient.publish("test/topic", "BOH");// publish IP nr
  //  } else {
  //    Serial.println("Unknown value");
  //    mqttClient.publish("test/topic", "Non dovrebbe essere possibile");
  //  }
}
