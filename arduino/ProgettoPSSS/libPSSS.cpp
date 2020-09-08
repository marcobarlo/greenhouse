#include "libPSSS.h"
#include <DHT.h>
#include <string.h>


byte mac[] = {
  0x0A, 0xCF, 0xB3, 0xC4, 0xD8, 0x32
};

byte ip[] = {10, 0, 0, 3}; 

const char* mqtt_server = "10.0.0.2";

byte gateway[] = {10, 0, 0, 1};  // gateway address

byte subnet[] = {255, 255, 255, 0};  //subnet mask

void callback(char* topic, byte* payload, unsigned int length){
  Comunicazione * link;
  link=Comunicazione::GetInstance();
  link->_callback(topic,payload,length);
  };

void  Controllore :: SetID(long id){
    ID=id;
  };
void  Controllore :: SetObserved(bool obs){
  Observed=obs;
  };

void  Controllore :: SetSezione(long sez){
    Sezione=sez;
  };
long  Controllore :: GetID(){
    return ID;
  };
long  Controllore :: GetSezione(){
    return Sezione;
  };


SensoreTemperatura::SensoreTemperatura():dht(DHTPIN,DHTTYPE){
  };
  
void SensoreTemperatura  :: SetUp(){
  Temperatura=-1;
	 dht.begin();
  };

float SensoreTemperatura  :: GetDato(){
  
	float chk = dht.readTemperature(DHTPIN);
	return chk;
  };

SensoreIrradianza::SensoreIrradianza(){};

void SensoreIrradianza  :: SetUp(){
   Irradianza=-1;
  };

float SensoreIrradianza  :: GetDato(){
 //DA FARE CARATTERIZZARE PER BENE 
 float level = analogRead(LUXINPUT);
 //calculate analog voltage
 float voltage = 5*level/1024;
 //make sure the voltage isn't outside the acceptable range
 if(voltage < 0){
   voltage = 0;
 }
 if(voltage > 5){
   voltage = 5;
 }
 //initialize a lux value
 float lux = 0;
 //based on the voltage, select the equation that will best convert it to a lux value
 if(voltage <= 0.534){
   lux = 1286.47506604*pow(voltage,2) + 178.51342186*voltage - 1.70982528;   
 }
 else if(voltage <= 2.9){
   lux = 197.90983722*exp(1.62826391*voltage);
 }
 else if(voltage <= 4.1){
   lux = -3785.88415527*pow(voltage,6) + 85678.15521655*pow(voltage,5) - 604387.00259741*pow(voltage,4) + 1410432.63046882*pow(voltage,3) + 1529553.55029751*pow(voltage,2) - 11122170.790418*voltage + 12440209.3288285;
 }
 else{
   lux = 23.9858393*exp(2.28356737*voltage);
 }
 //ensure the lux value isn't less than 0
 if(lux < 0 ){
   lux = 0;
 }
 return lux;
};

static Comunicazione* Comunicazione::GetInstance(){
    if (Me==NULL){
      Comunicazione Link;
      Me=&Link;
      }
      return Me;
  };
void Comunicazione :: SetUp(Ambiente * amb, Controllore * cntr){
  Target=amb;
  Controller=cntr;
  Ethernet.begin(mac, ip);//Testare con solo mac, speriamo funzioni
  mqttClient.setClient(ethClient);
  mqttClient.setServer( mqtt_server, 1883); // or local broker
  mqttClient.setCallback(callback);
//  mqttClient.setCallback([this] (char* topic, byte* payload, unsigned int length) { this->callback(topic, payload, length); });
  mqttClient.connect(CLIENT_ID);
  mqttClient.subscribe("GH/SetUp");
  };

void Comunicazione::keepalive(){
  mqttClient.loop();
  };

void Comunicazione::_callback(char* topic, byte* payload, unsigned int length) {
  //  char msgBuffer[20];
  // I am only using one ascii character as command, so do not need to take an entire word as payload
  // However, if you want to send full word commands, uncomment the next line and use for string comparison
  // payload[length]='\0';// terminate string with 0
  //String strPayload = String((char*)payload);  // convert to string
    // Serial.println(strPayload); 
  char * option;
  if(strcmp("GH/SetUp",topic)){
     Serial.print("Message arrived [");
     Serial.print(topic);
     Serial.print("] ");//MQTT_BROKER
     //Controllo MAC in BYTE?
//     for (int i = 0; i < 12; i++) {
//      msgBuffer[i]=(char)payload[i];
//      Serial.print((char)payload[i]);
//     }
     byte ID_B[4];
     byte Sezione_B[4];
     bool corretto=true;
     int j=0;
     while (corretto && j<12){
        if (mac[j]!=payload[j]){
            corretto=false;
          }
          j=j+1;
      }
     if (corretto){
        for (int i=12;i++;i<16){
          ID_B[i-12]=payload[i];
          }
        for (int i=16;i++;i<20){
          Sezione_B[i-16]=payload[i];
          }
//          this->ID=String((char *)ID_B);
//          this->Sezione=String((char *)Sezione_B);
          Controller->SetID((long)ID_B);
          Controller->SetSezione((long)Sezione_B);
//          String HeadofTopic="GH/";
          char* Topic;
          strcat(Header,"GH/");
          strcat(Header,(char)(Controller->GetSezione()));
          strcat(Header,"/cmd/");
          strcpy(Topic,Header);
          strcat(Topic,"+");
          mqttClient.subscribe((const char *)Topic);
          Serial.println(Topic);
          mqttClient.unsubscribe("GH/SetUp");
      }
       
    }
    strcpy(option,Header);
    strcat(option,"Mod");
    if (strcmp(option,topic)){
      
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
