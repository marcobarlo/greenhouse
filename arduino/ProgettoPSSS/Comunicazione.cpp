#include "Comunicazione.h"

#define DISPLACEMENT_BYTE_S 6
#define DISPLACEMENT_SEZ_S  10
#define DISPLACEMENT_TRG_S  14
#define DISPLACEMENT_SGL_S  26
#define DISPLACEMENT_TRG_M  4

File myFile;

Comunicazione* Comunicazione :: Me = NULL;
 
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
  Controller = Controllore::GetInstance();
  if(COMUNICAZIONE_DEBUG>0){
    Serial.println(F("Inizializzazione della SD card ..."));
    }
  pinMode(10, OUTPUT);
  digitalWrite(10, HIGH);
  if(!SD.begin(4)){
    if(COMUNICAZIONE_DEBUG>0){
    Serial.println(F("Inizializzazione Fallita"));
    }
  while(1);
  }
  if(COMUNICAZIONE_DEBUG>0){
  Serial.println(F("Initialization Effettuata"));
  }
  myFile=SD.open("conf5.txt");
  int length=12;
  char mac_char [length+1];
    if(myFile){
  int i=0;
  char inputchar;
  while(myFile.available()){
    if (i<13){
    inputchar=myFile.read();
    mac_char[i]=inputchar;
    i=i+1;
    mac_char[i]='\0';
    }else if(i>=13){
    inputchar=myFile.read();
    mqttserver[i-13]=inputchar;
    i=i+1;        
    mqttserver[i-13]='\0';
     }
    }
    myFile.close();
    if(COMUNICAZIONE_DEBUG>0){
    Serial.println(F("MAC:"));
    Serial.println(mac_char);
    Serial.println(F("IP Broker Mqtt:"));
    Serial.println(mqttserver);
    }
    str2byte(mac_char,mac_byte);
    }else{
      if(COMUNICAZIONE_DEBUG>0){
      Serial.println(F("Errore nell'apertura del file"));
    }
  }
  strcpy(CLIENT_ID, mac_char);
  Ethernet.begin(mac_byte);
  if(COMUNICAZIONE_DEBUG>0){
  Serial.println(F("IP ottenuto tramite DHCP:"));
  Serial.println(Ethernet.localIP());
  }
  mqttClient.setClient(ethClient);
  mqttClient.setServer( mqttserver, 1883); // or local broker
  mqttClient.setCallback(callback);
  mqttClient.connect(CLIENT_ID);
  mqttClient.subscribe(TopicSetUp);
};

void Comunicazione :: keepalive() {
  if (!mqttClient.loop()) {
    if(COMUNICAZIONE_DEBUG>0){
    Serial.println(F("Caduta la connessione"));
    }
    mqttClient.connect(CLIENT_ID);
    if (!Controller->GetStart()){
        mqttClient.subscribe(TopicSetUp);
      }
    else{
    char Topic[30];
    strcpy(Topic, Header);
    strcat(Topic, "+");
    mqttClient.subscribe(Topic); }
  };
};

void Comunicazione :: Publish(char topic [], byte * payload, int lung){
   if(COMUNICAZIONE_DEBUG>0){
    Serial.println("Invio del payload:");
   }
    if (mqttClient.connected()) {
    mqttClient.publish(topic, payload, lung);
  }
};


void Comunicazione :: PublishDati(long ID,float array []){
    int DIM=4+4*NUM_S;
    byte payload [DIM];
    Convert_long_to_byte(payload,0,ID);
    for(int i=0;i<NUM_S;i++){
      Convert_float_to_byte(payload,4+4*i,array[i]);
      }
   this->Publish(TopicDati,payload,DIM);
  };


void Comunicazione :: PublishErroreSensore(long ID, long Errore){
    byte payload [8];
    Convert_long_to_byte(payload,0,ID);
    Convert_long_to_byte(payload,4,Errore);
    this->Publish(TopicErrore,payload,8);
  };


void Comunicazione :: PublishErroreAttuatore(long ID, long Errore,float delta){
        byte payload [12];
        Convert_long_to_byte(payload,0,ID);
        Convert_long_to_byte(payload,4,Errore);
        Convert_float_to_byte(payload,8,delta);
        this->Publish(TopicErrore,payload,12);
};

void Comunicazione :: PublishAck(long ID){
  if(COMUNICAZIONE_DEBUG>0){
    Serial.println("Invio dell'ACK:");
    }
    byte payload [4];
    Convert_long_to_byte(payload,0,ID);
    this->Publish(TopicAck,payload,4);
  };


void Comunicazione::_callback(char* topic, byte* payload, unsigned int length) {
  if(COMUNICAZIONE_DEBUG>0){
  Serial.println("Sono nella Callback:");
  }
  char optionmod [30];
  char optionstr [30];
  char optionstp [30];
  if(COMUNICAZIONE_DEBUG>0){
  Serial.println(F("Topic per cui si è entrati nella callback"));
  Serial.println(topic);
  }
  if (strcmp(TopicSetUp, topic) == 0) {
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
    }
  }
  strcpy(optionmod, Header);
  strcat(optionmod, "Mod");
  strcpy(optionstr, Header);
  strcat(optionstr, "STROBS");
  strcpy(optionstp, Header);
  strcat(optionstp, "STPOBS");
  if (strcmp(optionmod, topic) == 0) {
    byte ID_B2 [4];
    long Temp = Controller->GetID();
    Convert_long_to_byte(ID_B2, 0, Temp);
    bool corretto = true;
    int j = 0;
    while (corretto && j < 4) {
      if (ID_B2[j] != payload[j]) {//Con la funzione viene già invertito quando messo in byte quindi non serve invertire qui
        corretto = false;
      }
      j = j + 1;
    }
    if (corretto) {
      this->_callbackMod(payload);
    }
  }else if (strcmp(optionstr, topic) == 0) {
    byte ID_B [4];
    long Temp = Controller->GetID();
    Convert_long_to_byte(ID_B, 0, Temp);
    bool corretto = true;
    int j = 0;
        while (corretto && j < 4) {
          if (ID_B[j] != payload[j]) {
            corretto = false;
          }
          j = j + 1;
        }
    if (corretto) {
      this->_callbackSTROBS();
    }
  }else if (strcmp(optionstp, topic) == 0) {
    //Primo byte conterrà i meno significativi
    byte ID_B [4];
    long Temp = Controller->GetID();
    Convert_long_to_byte(ID_B, 0, Temp);
    bool corretto = true;
    int j = 0;
        while (corretto && j < 4) {
          if (ID_B[j] != payload[j]) {
            corretto = false;
          }
          j = j + 1;
        }
    if (corretto) {
        this->_callbackSTPOBS();
    }
  }
}

void Comunicazione::_callbackSetUp(byte * payload){
      if(COMUNICAZIONE_DEBUG>0){
      Serial.println(F("SetUp"));
      }
      byte ID_B[4];
      byte Sezione_B[4];
      byte target_b [3][4];
      float target[3];
      byte soglie_b [3][4];
      float soglie [3];
      long ID = Convert_byte_to_long(payload, DISPLACEMENT_BYTE_S);
      Controller->SetID(ID);
      long sez = Convert_byte_to_long(payload, DISPLACEMENT_SEZ_S);
      Controller->SetSezione(sez);
      for (int i = 0; i < 3; i++) {
        target[i] = Convert_byte_to_float(payload, DISPLACEMENT_TRG_S + 4 * i);
        soglie[i] = Convert_byte_to_float(payload, DISPLACEMENT_SGL_S + 4 * i);
      }
      Controller->ModificaAmbiente(target);
      Controller->SetSoglie(soglie);
      Controller->SetStart();
      char sezione [10];
      ltoa(Controller->GetSezione(), sezione, 10);
      char Topic[30];
      strcpy(Header, "GH/");
      strcat(Header, sezione);
      strcat(Header, "/cmd/");
      strcpy(Topic, Header);
      strcat(Topic, "+");
      mqttClient.subscribe(Topic);
      //Convertire Topic in una costante
      mqttClient.unsubscribe(TopicSetUp);
      if(COMUNICAZIONE_DEBUG>0){
        Serial.println(F("Fine del SetUP"));
        }
  };
void Comunicazione::_callbackMod(byte * payload){
      float target[3];
      if(COMUNICAZIONE_DEBUG>0){
        Serial.println(F("Ricezione delle modifiche dei valori ambientali"));
        }
      for (int i = 0; i < 3; i++) {
        target[i] = Convert_byte_to_float(payload, DISPLACEMENT_TRG_M + 4 * i);
      }
      Controller->ModificaAmbiente(target);
      this->PublishAck(Controller->GetID());//FaccioFare direttamente al controllore
  };
void Comunicazione::_callbackSTROBS(){
      if(COMUNICAZIONE_DEBUG>0){
        Serial.println(F("Ricezione messaggio di osservazione"));
        }
      Controller->SetObserved(true);
      Controller->SendDati();
  };
void Comunicazione::_callbackSTPOBS(){
      if(COMUNICAZIONE_DEBUG>0){
        Serial.println(F("Ricevuto messaggio di fine osservazione"));
        }
      Controller->SetObserved(false);
  };

void Comunicazione::PublishTest() {
  mqttClient.publish("test/topic", String(i).c_str() );
  i = i + 1;
};

bool Comunicazione::CheckID(byte ID_B [4],byte payload []){
  bool corretto = true;
    int j = 0;
        while (corretto && j < 4) {
          if (ID_B[j] != payload[j]) {
            corretto = false;
          }
          j = j + 1;
        }
  return corretto;
  };
