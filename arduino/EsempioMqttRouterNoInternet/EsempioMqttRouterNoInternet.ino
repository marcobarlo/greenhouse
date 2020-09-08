#include <SPI.h>
#include <Ethernet.h>
#include "PubSubClient.h"
#include "DHT.h" //DHT.h library

#define CLIENT_ID "TEST"
#define PUBLISH_DELAY 3000



byte mac[] = {
  0x0A, 0xCF, 0xB3, 0xC4, 0xD8, 0x32
};
//byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED};   //physical mac address
//IPAddress ip(192,168,1,224);
//byte ip[] = {192, 168, 1, 1};   // static ip of Arduino
//byte ip[] = {192, 168, 1, 224};   // static ip of Arduino
//10.0.0.3
byte ip[] = {10, 0, 0, 3}; 

//const char* mqtt_server = "169.254.247.187";
//const char* mqtt_server = "192.168.1.135";
const char* mqtt_server = "10.0.0.2";
//byte gateway[] = {192, 168, 1, 254};  // gateway address
byte gateway[] = {10, 0, 0, 1};  // gateway address
//byte gateway[]={169,254,247,187};
byte subnet[] = {255, 255, 255, 0};  //subnet mask

int i=0;

EthernetClient ethClient;
PubSubClient mqttClient;
long previousMillis;

void setup() {
  // put your setup code here, to run once:
      Ethernet.begin(mac, ip);
//  Ethernet.begin(mac, ip, gateway, subnet);  //start Ethernet
   Serial.begin(9600);
  while (!Serial) {};
  Serial.println(F("MQTT Arduino Demo"));
  Serial.println();
  Serial.println(F("Ethernet configured manually"));
  Serial.print("IP address: ");
  Serial.println(Ethernet.localIP());
  Serial.println();
  mqttClient.setClient(ethClient);
  mqttClient.setServer( mqtt_server, 1883); // or local broker
  mqttClient.setCallback(callback);
  previousMillis = millis();
  Serial.println("TEST FIRST PUBLISH");
  mqttClient.publish("test/topic", "10, 0, 0, 3");
}

void loop() {
  // put your main code here, to run repeatedly:
  if (millis() - previousMillis > PUBLISH_DELAY) {
    sendData();
    previousMillis = millis();
  }
   Serial.println(mqttClient.state());
  mqttClient.loop();
}

void sendData() {
  if (mqttClient.connect(CLIENT_ID)) {
    mqttClient.publish("test/topic",String(i).c_str() );
    i=i+1;
  }
}

void callback(char* topic, byte* payload, unsigned int length) {
  char msgBuffer[20];
  // I am only using one ascii character as command, so do not need to take an entire word as payload
  // However, if you want to send full word commands, uncomment the next line and use for string comparison
  // payload[length]='\0';// terminate string with 0
//String strPayload = String((char*)payload);  // convert to string
  // Serial.println(strPayload); 
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");//MQTT_BROKER
  for (int i = 0; i < length; i++) {
    Serial.print((char)payload[i]);
  }
  Serial.println();
  Serial.println(payload[0]);

  // Examine only the first character of the message
  if (payload[0] == 49)             // Message "1" in ASCII (turn output ON)
  {
  } else if (payload[0] == 48)      // Message "0" in ASCII (turn output OFF)
  {
  } else if (payload[0] == 50)
  {
    mqttClient.publish("test/topic", "BOH");// publish IP nr
  } else {
    Serial.println("Unknown value");
    mqttClient.publish("test/topic", "Non dovrebbe essere possibile");
  }

}
