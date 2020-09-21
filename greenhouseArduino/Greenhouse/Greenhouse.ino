#include "Ambiente.h"
#include "Controllore.h"
#include "Comunicazione.h"
#include <SPI.h>
#include "limits.h"

#define CONTROL_DELAY 60000

Controllore* Contr;
Comunicazione * Com;
Ambiente * Amb;
long previousMillis;

void setup() {
  Serial.begin(9600);
  while (!Serial) {};
  Serial.println("Start Setup delle componenti");
  Amb=new Ambiente();
  Contr=Controllore::GetInstance();
  Contr->SetUp(Amb);
  Com=Comunicazione::GetInstance();
  Com->SetUp();
  Serial.println("Fine Setup delle componenti");
}

void loop() {
  if (millis()<previousMillis){
    unsigned long MIL=(ULONG_MAX-previousMillis)+millis();
    if (MIL>CONTROL_DELAY){
      if(Contr->GetStart()){
        Contr->Controllo();
        }
      }
    }else  if (millis() - previousMillis > CONTROL_DELAY) {
    if(Contr->GetStart()){
      Contr->Controllo();
    }
    previousMillis = millis();
  }
  Com->keepalive();
  // put your main code here, to run repeatedly:
}
