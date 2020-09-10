#include "Comunicazione.h"


Comunicazione* Comunicazione :: Me;

byte mac[] = {
  0x0A, 0xCF, 0xB3, 0xC4, 0xD8, 0x32
};

byte ip[] = {10, 0, 0, 3};

const char* mqtt_server = "10.0.0.2";

byte gateway[] = {10, 0, 0, 1};  // gateway address

byte subnet[] = {255, 255, 255, 0};  //subnet mask

int i=0;

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
void Comunicazione :: SetUp(Ambiente * amb) {
  Serial.println("SetUp Comunicazione");
  Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  Target = amb;
  Controllore cntr;
  Controller = cntr.GetInstance();
  Ethernet.begin(mac, ip);//Testare con solo mac, speriamo funzioni
  Serial.println(Ethernet.localIP());
  mqttClient.setClient(ethClient);
  mqttClient.setServer( mqtt_server, 1883); // or local broker
  mqttClient.setCallback(callback);
  int lung = sizeof(mac)/sizeof(mac[0]);
  char char_mac[lung+1];
//  for (int i = 0; i < sizeof(mac); i++) {
////    strcat(char_mac, (char)mac[i]);
//  Serial.print((char)mac[i]);
//  char_mac[i] = (char)mac[i];
//  }
  array_to_string(mac,lung,char_mac);
//  char_mac[lung] = NULL;
  CLIENT_ID = char_mac;
  Serial.println("MAC");
  Serial.println(char_mac);
  Serial.println("Client ID");
  Serial.println(CLIENT_ID);
  //  mqttClient.setCallback([this] (char* topic, byte* payload, unsigned int length) { this->callback(topic, payload, length); });
  mqttClient.connect(CLIENT_ID);
  mqttClient.subscribe("GH/SetUp");
  mqttClient.publish("test/topic", "10, 0, 0, 3");
  Serial.println("Fine SetUp Comunicazione");
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
    mqttClient.publish("GH/Errore", payload);
  }
};


void Comunicazione::_callback(char* topic, byte* payload, unsigned int length) {
  //  char msgBuffer[20];
  // I am only using one ascii character as command, so do not need to take an entire word as payload
  // However, if you want to send full word commands, uncomment the next line and use for string comparison
  // payload[length]='\0';// terminate string with 0
  //String strPayload = String((char*)payload);  // convert to string
  // Serial.println(strPayload);
  Serial.println("Sono nella Callback");
  char * option;
  Serial.println(topic);
    Serial.println(freeMemory(), DEC);  // print how much RAM is available.
  Serial.print(strcmp("GH/SetUp", topic));
  if (strcmp("GH/SetUp", topic)==0) {
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
    while (corretto && j < 6) {
      Serial.println("Mac");
      Serial.println(mac[j]);
      Serial.println("Payload");
      Serial.println(payload[j]);
      if (mac[j] != payload[j]) {
        corretto = false;
      }
      Serial.println("Corretto e j");
      Serial.println(corretto);
      Serial.println(j);
      j = j + 1;
    }
    if (corretto) {
      Serial.println("Trovato il mac!!!");
      Serial.println(freeMemory(), DEC);  // print how much RAM is available.
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
      union templong{
        byte b [4] ;
        long l;
        }templ;
      for (int i = 6;i < 10; i++) {
//        ID_B[i - 6] = payload[i];
        templ.b[3-i + 6] = payload[i];
      }
      Controller->SetID(templ.l);
      Serial.println("ID:");
      Serial.println(templ.l,DEC);
      for (int i = 10;i < 14 ; i++) {
//        Sezione_B[i - 10] = payload[i];
        templ.b[3-i + 10] = payload[i];

      }
      Serial.println(freeMemory(), DEC);  // print how much RAM is available.

//      for (int i=0;i<4;i++){
//        Serial.println(templ.b[i]);
//        };
      
      Serial.println("Sezione:");
      Serial.println(templ.l);
      Controller->SetSezione(templ.l);
      
      union TEMPF {
        float f;
        byte b[4];
      } tempf;

      for (int i = 14; i < 18; i++) {
        tempf.b[3-i+14] = payload[i];
        Serial.println(payload[i]);
        Serial.println(tempf.b[3-i+14]);
      }
      Serial.println("Temperatura:");
      Serial.println(templ.l);
      Temperatura = tempf.f;
      for (int i = 18; i < 22; i++) {
        tempf.b[3-i+ 18] = payload[i];
      }
      Umidita = tempf.f;
      for (int i = 22; i < 26; i++) {
        tempf.b[3-i+22] = payload[i];
      }
      Irradianza = tempf.f;
      Target->ModificaAmbiente(Temperatura, Umidita, Irradianza);
      Serial.println("Temperatura:");
      Serial.println(Temperatura);
      Serial.println("Umidita:");
      Serial.println(Umidita);
      Serial.println("Irradianza:");
      Serial.println(Irradianza);
      
      for (int i = 26; i < 30; i++) {
        tempf.b[3-i+26] = payload[i];
      }
      SogliaT = tempf.f;
      for (int i = 30; i < 34; i++) {
        tempf.b[3-i+30] = payload[i];
      }
      SogliaU = tempf.f;
      for (int i = 34; i < 38; i++) {
        tempf.b[3-i+34] = payload[i];
      }
      SogliaI = tempf.f;
      Target->SetSoglie(SogliaT, SogliaU, SogliaI);
      Serial.println("SogliaT:");
      Serial.println(SogliaT);
      Serial.println("SogliaU");
      Serial.println(SogliaU);
      Serial.println("SogliaI");
      Serial.println(SogliaI);
      Serial.println("SEZIONE TEST FROM GET SEZIONE");
      Serial.println(Controller->GetSezione());
      //          this->ID=String((char *)ID_B);
      //          this->Sezione=String((char *)Sezione_B);
      //          String HeadofTopic="GH/";
            //Probabilmente devo aggiungere la Null termination Da rifare sto pezzo
        
//        templ.l=Controller->GetSezione();
//        int lung = sizeof(templ.b)/sizeof(templ.b[0]);
//        for (int i=0;i<lung;i++){
//          Serial.println(templ.b[i]);
//          }
//        Serial.println(lung);
//        char sezione[lung+1];
//        array_to_string(templ.b,lung,sezione);
        char sezione [10];
        ltoa(Controller->GetSezione(),sezione,10);
        for(int i=0;i<10;i++){
          Serial.println(sezione[i]);
          }
        Serial.println(sezione);
//        Header[0]="\0";
//        char* Topic;
//        strcat(Header, "GH/");
//        strcat(Header, sezione);
//        strcat(Header, "/cmd/");
//        strcpy(Topic, Header);
//        strcat(Topic, "+");
        //Un pò di porcate rivedere
        char Topic[30];
        char Buffer[30];
        strcpy(Buffer,"GH/");
        strcat(Buffer,sezione);
        strcat(Buffer, "/cmd/");
        strcpy(Topic, Buffer);
        strcat(Topic, "+");
        Header=Buffer;
//        Serial.println(Header);
      mqttClient.subscribe(Topic);
//        Serial.println(Topic);
      mqttClient.unsubscribe("GH/SetUp");
    }
  }
  strcpy(option, Header);
  strcat(option, "Mod");
  if (strcmp(option, topic)==0) {
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
  if (strcmp(option, topic)==0) {
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
  if (strcmp(option, topic)==0) {
    //Primo byte conterrà i meno significativi
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

void Comunicazione::PublishTest(){
    mqttClient.publish("test/topic",String(i).c_str() );
    i=i+1;
  };
