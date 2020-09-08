#include <SPI.h>                                   // For networking
#include <WiFiEsp.h>
#include <PubSubClient.h>
#include <WiFiEspClient.h>
#include <WiFiEspUdp.h>


#define CLIENT_ID "TEST"
#define PUBLISH_DELAY 3000
// Update these with values suitable for your network.

char ssid[] = "FASTWEB-B500CF";
char pass[]  = "FT4GZF9Y23";
const char* mqtt_server = "10.0.0.2";
long previousMillis;


byte gateway[] = {10, 0, 0, 1};  // gateway address
//byte gateway[]={169,254,247,187};
byte subnet[] = {255, 255, 255, 0};  //subnet mask

int status = WL_IDLE_STATUS; // the Wifi radio's status

int i=0;

WiFiEspClient espClient;

PubSubClient client;

void callback(char* topic, byte* payload, unsigned int length) {
Serial.print("Message arrived [");
Serial.print(topic);

Serial.print("] ");
for (int i=0;i<length;i++) {
char receivedChar = (char)payload[i];
Serial.print(receivedChar);
if (receivedChar == '0')
Serial.println("Off");
if (receivedChar == '1')
Serial.println("On");

}
Serial.println();
}


void setup() 
{
Serial.begin(9600 );     // communication with the host computer
Serial3.begin(9600);
while (!Serial)   { ; }
while (!Serial3)   { ; }
// initialize ESP module
WiFi.init(&Serial3);

// check for the presence of the shield
if (WiFi.status() == WL_NO_SHIELD) {
Serial.println("WiFi shield not present");
// don't continue
while (true);
}

while ( status != WL_CONNECTED) {
Serial.print("Attempting to connect to WPA SSID: ");
Serial.println(ssid);
// Connect to WPA/WPA2 network
status = WiFi.begin(ssid, pass);
}
Serial.println("You're connected to the network");

//connect to MQTT server
  client.setClient(espClient);
  client.setServer( mqtt_server, 1883); // or local broker
  client.setCallback(callback);
  previousMillis = millis();
  Serial.println("TEST FIRST PUBLISH");
  client.publish("test/topic", "10, 0, 0, 3");
}



void loop() {
// put your main code here, to run repeatedly:
if (!client.connected()) {
reconnect();
}
  if (millis() - previousMillis > PUBLISH_DELAY) {
    sendData();
    previousMillis = millis();
  }
}

void sendData() {
  if (client.connect(CLIENT_ID)) {
    client.publish("test/topic",String(i).c_str() );
    i=i+1;
  }
}


void reconnect() {
// Loop until we're reconnected
while (!client.connected()) {
Serial.print("Attempting MQTT connection...");
// Attempt to connect, just a name to identify the client
if (client.connect("NANO","xxxxxx","xxxxxxxxxxx")) {
Serial.println("connected");
// Once connected, publish an announcement...
// client.publish("outpic","Hello World");
// ... and resubscribe
client.subscribe("intopic",0);

} else {
  Serial.print("failed, rc=");
  Serial.print(client.state());
  Serial.println(" try again in 5 seconds");
  // Wait 5 seconds before retrying
  delay(5000);
}
}
}
