#include "Comunicazione.h"

#define DISPLACEMENT_BYTE_S 6
#define DISPLACEMENT_SEZ_S  10
#define DISPLACEMENT_TRG_S  14
#define DISPLACEMENT_SGL_S  26
#define DISPLACEMENT_TRG_M  4

File myFile;

Comunicazione* Comunicazione :: Me = NULL;

//TODO Inserire il codice per fare la lettura da SD e fare solo poi begin e ti pigli l'IP?? testare

//byte mac[] = {
//  0x0A, 0xCF, 0xB3, 0xC4, 0xD8, 0x32
//};

byte ip[] = {10, 0, 0, 3};

const char* mqtt_server = "10.0.0.2";

byte gateway[] = {10, 0, 0, 1};  // gateway address

byte subnet[] = {255, 255, 255, 0};  //subnet mask

 byte mac_byte[6];
 
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
void Comunicazione :: SetUp() {
//  Target = amb;
  Controller = Controllore::GetInstance();
    Serial.println("Initializing the SD card ...");
  pinMode(10, OUTPUT);
  digitalWrite(10, HIGH);
  if(!SD.begin(4)){
    Serial.println("Initialization Failed");
  while(1);
  }
  Serial.println("Initialization Done");
  myFile=SD.open("conf.txt");
    Serial.println(myFile.size());
  int length=myFile.size();
  char mac_char [length+1];
    if(myFile){
//  Serial.println(myFile.size());
//  int length=myFile.size();
//  char mac_char [length+1];
  int i=0;
  char inputchar;
  while(myFile.available()){
    Serial.println(i);
    inputchar=myFile.read();
    Serial.print(inputchar);
    mac_char[i]=inputchar;
    i=i+1;
    mac_char[i]='\0';
    }
    Serial.println();
    myFile.close();
//      mac_char[length+1]='\0';
    Serial.println("Lunghezza mac_char");
    Serial.println(sizeof(mac_char));
      Serial.println("Printo il mac_char");
      Serial.println(mac_char);
     for(int i=0;i<length;i++){
      Serial.println(mac_char[i]);
      }
      str2byte(mac_char,mac_byte);
    }else{
      Serial.println("Errore nell'apertura del file");
      }
  strcpy(CLIENT_ID, mac_char);
  Serial.println("CLIENT ID");
  Serial.println(CLIENT_ID);
  Ethernet.begin(mac_byte);
//  Ethernet.begin(mac, ip);//Testare con solo mac, speriamo funzioni
  Serial.println(Ethernet.localIP());
  mqttClient.setClient(ethClient);
  mqttClient.setServer( mqtt_server, 1883); // or local broker
  mqttClient.setCallback(callback);
//  int lung = sizeof(mac_byte) / sizeof(mac_byte[0]);
//  
//  char char_mac[lung + 1];
//  array_to_string(mac_byte, lung, char_mac);
//  char_mac[lung+1]='\0';
  mqttClient.connect(CLIENT_ID);
  mqttClient.subscribe("GH/SetUp");
  mqttClient.publish("test/topic", "10, 0, 0, 3");
//  TimerSetup();
};

void Comunicazione :: keepalive() {
  if (!mqttClient.loop()) {
    Serial.println("Caduta la connessione");
    mqttClient.connect(CLIENT_ID);
    char Topic[30];
    strcpy(Topic, Header);
    strcat(Topic, "+");
    Serial.println(Header);
    mqttClient.subscribe(Topic);
    
  };
};

//void Comunicazione :: PublishDati(byte * payload, int lung) {
//  Serial.println("Sto inviando");
//    if (mqttClient.connected()) {
////  if (mqttClient.connect(CLIENT_ID)) {
//    Serial.println(CLIENT_ID);
//    //RISCRIVERE QUESTO TOPIC COME COSTANTI
//    if(!mqttClient.publish("GH/Dati", payload, lung)){
//      Serial.println("MA CHE MISERIACCIA LADRA");
//      };
//  }
//};

void Comunicazione :: Publish(char topic [], byte * payload, int lung){
    Serial.println("Sto inviando");
        if (mqttClient.connected()) {
//  if (mqttClient.connect(CLIENT_ID)) {
    Serial.println(CLIENT_ID);
    mqttClient.publish(topic, payload, lung);
  }
  };


//void Comunicazione :: PublishErrore(byte * payload,int lung) {
//  Serial.println("Sto pubblicando un errore a:");
//  Serial.println(millis());
//      if (mqttClient.connected()) {
////  if (mqttClient.connect(CLIENT_ID)) {
//    Serial.println(CLIENT_ID);
//    //RISCRIVERE QUESTO TOPIC COME COSTANTI
//    mqttClient.publish("GH/Errore", payload,lung);
//  }
//};

void Comunicazione :: PublishDati(long ID,float array []){
    int DIM=4+4*NUM_S;
    byte payload [DIM];
    Load_to_payload_long(payload,0,ID);
    for(int i=0;i<NUM_S;i++){
      Load_to_payload_float(payload,4+4*i,array[i]);
      }
   this->Publish(TopicDati,payload,DIM);
  };


void Comunicazione :: PublishErroreSensore(long ID, long Errore){
    byte payload [8];
    Load_to_payload_long(payload,0,ID);
    Load_to_payload_long(payload,4,Errore);
    this->Publish(TopicErrore,payload,8);
  };


void Comunicazione :: PublishErroreAttuatore(long ID, long Errore,float delta){
        byte payload [12];
        Load_to_payload_long(payload,0,ID);
        Load_to_payload_long(payload,4,Errore);
        Load_to_payload_float(payload,8,delta);
        this->Publish(TopicErrore,payload,12);
  };

void Comunicazione :: PublishAck(long ID){
    Serial.println("E inviamoli questo ACK");
    byte payload [4];
    Load_to_payload_long(payload,0,ID);
    this->Publish(TopicAck,payload,4);
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
      if (mac_byte[j] != payload[j]) {
        corretto = false;
      }
      j = j + 1;
    }
    if (corretto) {
        this->_callbackSetUp(payload);
//      Serial.println("Trovato il mac!!!");
//      Serial.println(freeMemory(), DEC);  // print how much RAM is available.
//      // Convertire in vettori di vettori di 4 byte
//      byte ID_B[4];
//      byte Sezione_B[4];
//      byte target_b [3][4];
//      float target[3];
//      byte soglie_b [3][4];
//      float soglie [3];
//      long ID = Convert_byte_to_long(payload, DISPLACEMENT_BYTE_S);
//      Controller->SetID(ID);
//      Serial.println("ID:");
//      Serial.println(ID, DEC);
//      long sez = Convert_byte_to_long(payload, DISPLACEMENT_SEZ_S);
//      Serial.println("Sezione:");
//      Serial.println(sez);
//      Controller->SetSezione(sez);
//      Serial.println("PRELEVIAMOLI STI CAZZO DI DATI");
//      for (int i = 0; i < 3; i++) {
//        Serial.println(i);
//        target[i] = Convert_byte_to_float(payload, DISPLACEMENT_TRG_S + 4 * i);
//        Serial.println(target[i]);
//        soglie[i] = Convert_byte_to_float(payload, DISPLACEMENT_SGL_S + 4 * i);
//        Serial.println(soglie[i]);
//      }
//      Controller->ModificaAmbiente(target);
//      Controller->SetSoglie(soglie);
//      Controller->SetStart();
//      float targetf[3];
//      float soglief[3];
////      Target->GetTarget(targetf,3);
////      Target->GetSoglie(soglief,3);
////      Serial.println("Temperatura Umidita e Irradianza con le funzioni");
////      Serial.println(targetf[0]);
////      Serial.println(targetf[1]);
////      Serial.println(targetf[2]);
////      Serial.println("Le tre Soglie con funzione:");
////      Serial.println(soglief[0]);
////      Serial.println(soglief[1]);
////      Serial.println(soglief[2]);
////      Serial.println("SEZIONE TEST FROM GET SEZIONE");
//      Serial.println(Controller->GetSezione());
//      //Serve ?? o già lo ho?
//      char sezione [10];
//      ltoa(Controller->GetSezione(), sezione, 10);
//      Serial.println("Dopo ltoa");
//      Serial.println(sezione);
//      char Topic[30];
//      strcpy(Header, "GH/");
//      strcat(Header, sezione);
//      strcat(Header, "/cmd/");
//      strcpy(Topic, Header);
//      strcat(Topic, "+");
//      Serial.println(Header);
//      mqttClient.subscribe(Topic);
//      Serial.println(Topic);
//      Serial.println("STAMPO IL CLIENT ID NELLA CALLBACK SETUP");
//      Serial.println(CLIENT_ID);
//      Timer t;
//      t.SetUp();
//      //Convertire Topic in una costante
//      mqttClient.unsubscribe("GH/SetUp");
    }
  }
  strcpy(option, Header);
  strcat(option, "Mod");
  Serial.print(strcmp(option, topic));
  if (strcmp(option, topic) == 0) {
    Serial.println("Sono in mod");
//    byte ID_B [4];
    byte ID_B2 [4];
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
      this->_callbackMod(payload);
//      Serial.print("Trovato ID");
//      for (int i = 0; i < 3; i++) {
//        target[i] = Convert_byte_to_float(payload, DISPLACEMENT_TRG_M + 4 * i);
//      }
//      Serial.println("Temperatura Umidita Irradianze funzione");
//      Serial.println(target[0]);
//      Serial.println(target[1]);
//      Serial.println(target[2]);
////      Target->ModificaAmbiente(Tem, Um, Irr);
//      Contoller->ModificaAmbiente(target);
//      Controller->SendAck();//FaccioFare direttamente al controllore
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
      this->_callbackSTROBS();
//      Serial.println("Mi sento osservato!");
//      Controller->SetObserved(true);
//      //Invio il messaggio di ritorno
//      Controller->SendDati();
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
//      Serial.println("Non mi sento più osservato");
//      Controller->SetObserved(false);
        this->_callbackSTPOBS();
    }
  }
}

void Comunicazione::_callbackSetUp(byte * payload){
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
      Controller->ModificaAmbiente(target);
      Controller->SetSoglie(soglie);
      Controller->SetStart();
      float targetf[3];
      float soglief[3];
//      Target->GetTarget(targetf,3);
//      Target->GetSoglie(soglief,3);
//      Serial.println("Temperatura Umidita e Irradianza con le funzioni");
//      Serial.println(targetf[0]);
//      Serial.println(targetf[1]);
//      Serial.println(targetf[2]);
//      Serial.println("Le tre Soglie con funzione:");
//      Serial.println(soglief[0]);
//      Serial.println(soglief[1]);
//      Serial.println(soglief[2]);
//      Serial.println("SEZIONE TEST FROM GET SEZIONE");
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
      Serial.println("STAMPO IL CLIENT ID NELLA CALLBACK SETUP");
      Serial.println(CLIENT_ID);
//      Timer t;
//      t.SetUp();
      //Convertire Topic in una costante
      mqttClient.unsubscribe("GH/SetUp");
  };
void Comunicazione::_callbackMod(byte * payload){
      float target[3];

        Serial.print("Trovato ID");
      for (int i = 0; i < 3; i++) {
        target[i] = Convert_byte_to_float(payload, DISPLACEMENT_TRG_M + 4 * i);
      }
      Serial.println("Temperatura Umidita Irradianze funzione");
      Serial.println(target[0]);
      Serial.println(target[1]);
      Serial.println(target[2]);
//      Target->ModificaAmbiente(Tem, Um, Irr);
      Controller->ModificaAmbiente(target);
      this->PublishAck(Controller->GetID());//FaccioFare direttamente al controllore
  };
void Comunicazione::_callbackSTROBS(){
        Serial.println("Mi sento osservato!");
      Controller->SetObserved(true);
      //Invio il messaggio di ritorno
//      Controller->SendDati();
  };
void Comunicazione::_callbackSTPOBS(){
          Serial.println("Non mi sento più osservato");
      Controller->SetObserved(false);
  };

void Comunicazione::PublishTest() {
  mqttClient.publish("test/topic", String(i).c_str() );
  i = i + 1;
};
