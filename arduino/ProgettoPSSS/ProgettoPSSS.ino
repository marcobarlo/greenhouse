#include "libPSSS.h"
#include "Controllore.h"
#include "Comunicazione.h"
#include <SPI.h>
#include "MemoryFree.h"

#define CONTROL_DELAY 60000

//
//Comunicazione Com;
//Controllore Contr;
Controllore* Contr;
Comunicazione * Com;
Ambiente Amb;
long previousMillis;


void setup() {
  // put your setup code here, to run once:
  //    cli();
  //  TCCR1A = 0;// set entire TCCR1A register to 0
  //  TCCR1B = 0;// same for TCCR1B
  //  TCNT1  = 0;//initialize counter value to 0
  //  OCR1A = 33333;
  //  TCCR1B |= (1 << WGM12);
  //  TCCR1B |= (1 << CS11);
  //  TIMSK1 |= (1 << OCIE1A);
  Serial.begin(9600);
  while (!Serial) {};
  Serial.println("Start Setup delle componenti");
  Contr=Controllore::GetInstance();
  Contr->SetUp2(&Amb);
  Com=Comunicazione::GetInstance();
  Com->SetUp(&Amb);
  Serial.println("Fine Setup delle componenti");
}

void loop() {
  if (millis() - previousMillis > CONTROL_DELAY) {
//    Contr.Controllo();//Adesso come faccio iniziare solo se ho il Setup?? mi sa che devo fare il fatto dell'interrupt
//    Com.PublishTest();
    Serial.println("CI SONO");
    previousMillis = millis();
  }
  Com->keepalive();
  // put your main code here, to run repeatedly:
}
