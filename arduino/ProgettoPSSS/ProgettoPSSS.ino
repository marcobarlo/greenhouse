#include "libPSSS.h"
#include "Controllore.h"
#include "Comunicazione.h"
#include <SPI.h>
#include "MemoryFree.h"

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
  Contr->SetUp2(Amb);
  Com=Comunicazione::GetInstance();
  Com->SetUp(Amb);
  Serial.println("Fine Setup delle componenti");
}

void loop() {
  //Da rivedere se va usato invece l'interrupt per il calcolo del tempo
  if (millis() - previousMillis > CONTROL_DELAY) {
    Contr->Controllo();//Adesso come faccio iniziare solo se ho il Setup?? mi sa che devo fare il fatto dell'interrupt
    Serial.println("CI SONO");
    previousMillis = millis();
  }
  Com->keepalive();
  // put your main code here, to run repeatedly:
}