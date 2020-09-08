//set I/O pins
//pin 3 will connect to the base of the NPN transistor and trigger the LED on/off
#include <SPI.h>

int LED = 3;

int PINFOTO =A0;

//digital pins 9, 10, 11 are PWM enabled, so they will be used to sink the current for the Red, Green, and Blue LEDs in the RGB LED
int red = 9;
int green = 10;
int blue = 11;

//define the RGB values for each color of the rainbow: red, orange, yellow, green, blue, violet
float rainbowArrayRGB[][6] = {{255,255,255,0,0,139},{0,127,255,255,0,0},{0,0,0,0,255,255}};


//array to indicate which PWM line to set the values to
int colorsArray[] = {red, green, blue};

int brightness = 0;

//track which mode LED is in
bool toggle;
int i=0;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  while (!Serial) {};
  pinMode(red, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(blue, OUTPUT);
  pinMode(LED, OUTPUT);
  pinMode(PINFOTO, INPUT);
  Serial.println( sizeof(rainbowArrayRGB[0])/sizeof(rainbowArrayRGB[0][1]));
  Serial.println( sizeof(rainbowArrayRGB)/sizeof(rainbowArrayRGB[0]));
    digitalWrite(LED, HIGH);
}

void loop() {
  // put your main code here, to run repeatedly:
  rainbowStrobe();
//  RGB_color(0, 0, 0); // Red
   float level = analogRead(PINFOTO);
    float voltage = 5*level/1024;//Lo riporto nel range della tensione massima
    float r1=10000*(5/voltage-1);
    Serial.println("Lettura:");
    Serial.println(i);
    i=i+1;
    Serial.println(voltage);
    Serial.println(r1);
    
}
void rainbowStrobe(){
//    for(int i = 0; i < sizeof(rainbowArrayRGB[0])/sizeof(rainbowArrayRGB[0][1]); i++){
//    for(int j = 0; j < sizeof(rainbowArrayRGB)/sizeof(rainbowArrayRGB[0]); j++){
//      analogWrite(colorsArray[j], 255-brightness*(rainbowArrayRGB[j][i]/(rainbowArrayRGB[0][i]+rainbowArrayRGB[1][i]+rainbowArrayRGB[2][i])));
//    }
//    delay(1000);
//  } 
//    for(int j = 0; j < sizeof(rainbowArrayRGB)/sizeof(rainbowArrayRGB[0]); j++){
//      analogWrite(colorsArray[j], 255-brightness*(rainbowArrayRGB[j][1]/(rainbowArrayRGB[0][1]+rainbowArrayRGB[1][1]+rainbowArrayRGB[2][1])));
//    }
    for(int j = 0; j < sizeof(rainbowArrayRGB)/sizeof(rainbowArrayRGB[0]); j++){
      analogWrite(colorsArray[j], 255-brightness);
    }
    delay(1000);
}

void RGB_color(int red_light_value, int green_light_value, int blue_light_value)
 {
  analogWrite(red, red_light_value);
  analogWrite(green, green_light_value);
  analogWrite(blue, blue_light_value);
}
