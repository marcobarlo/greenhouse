#include "Tim.h"
#include "TimerInterrupt.h"
//
#define USE_TIMER_1     true
//#define USE_TIMER_2     true
//#define USE_TIMER_3     true
//#define USE_TIMER_4     true
//#define USE_TIMER_5     true


void TimerHandler1(void)
{
    Serial.println("ED HANDLIAMOLO STO TIMER");
    Serial.println(millis());
    Controllore * Contr;
    Contr=Controllore::GetInstance();
    Contr->Controllo();//Adesso come faccio iniziare solo se ho il Setup?? mi sa che devo fare il fatto dell'interrupt
}
//
//void SetUpTimer(){
//      ITimer1.init();
//      if (ITimer1.attachInterruptInterval(TIMER1_INTERVAL_MS, TimerHandler1))
//        Serial.println("Starting  ITimer1 OK, millis() = " + String(millis()));
//      else
//        Serial.println("Can't set ITimer1. Select another freq. or timer");
//  }

void Timer::SetUp(){
      ITimer1.init();
      if (ITimer1.attachInterruptInterval(TIMER1_INTERVAL_MS, TimerHandler1))
        Serial.println("Starting  ITimer1 OK, millis() = " + String(millis()));
      else
        Serial.println("Can't set ITimer1. Select another freq. or timer");
  }
