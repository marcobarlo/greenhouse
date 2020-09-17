#include "Ambiente.h"
#include "Controllore.h"
#include "Comunicazione.h"
#include <SPI.h>
#include "MemoryFree.h"
#include "Tim.h"
#include "limits.h"

#define CONTROL_DELAY 10000

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
  Com->SetUp();
  Serial.println("Fine Setup delle componenti");
}

void loop() {
  //Da rivedere se va usato invece l'interrupt per il calcolo del tempo
  if (millis()<previousMillis){
//    unsigned long DIFF=(ULONG_MAX-previousMillis);
    unsigned long MIL=(ULONG_MAX-previousMillis)+millis();
    if (MIL>CONTROL_DELAY){
      if(Contr->GetStart()){
        Contr->Controllo();
        }
      }
    }else  if (millis() - previousMillis > CONTROL_DELAY) {
    if(Contr->GetStart()){
      Contr->Controllo();//Adesso come faccio iniziare solo se ho il Setup?? mi sa che devo fare il fatto dell'interrupt
          Serial.println("CI SONO E CONTROLLO PURE");
    }
    Serial.println("CI SONO");
    previousMillis = millis();
  }
  Com->keepalive();
  // put your main code here, to run repeatedly:
}
