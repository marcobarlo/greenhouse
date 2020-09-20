#include "Tim.h"

#include "Controllore.h"
//#include "TimerInterrupt.h"
//
//#define USE_TIMER_1     true
//#define USE_TIMER_2     false
//#define USE_TIMER_3     false
//#define USE_TIMER_4     false
//#define USE_TIMER_5     false
//
//#define TIMER1_INTERVAL_MS    10000
//
//#include "TimerInterrupt.h"

volatile int seconds = 0;

//void TimerHandler1(void)
//{
//    Serial.println("ED HANDLIAMOLO STO TIMER");
//    Serial.println(millis());
//    Controllore * Contr;
//    Contr=Controllore::GetInstance();
//    Contr->Controllo();//Adesso come faccio iniziare solo se ho il Setup?? mi sa che devo fare il fatto dell'interrupt
//}
//
//void SetUpTimer(){
//      ITimer1.init();
//      if (ITimer1.attachInterruptInterval(TIMER1_INTERVAL_MS, TimerHandler1))
//        Serial.println("Starting  ITimer1 OK, millis() = " + String(millis()));
//      else
//        Serial.println("Can't set ITimer1. Select another freq. or timer");
//  }
//
//void Timer::SetUp(){
//      ITimer1.init();
//      if (ITimer1.attachInterruptInterval(TIMER1_INTERVAL_MS, TimerHandler1))
//        Serial.println("Starting  ITimer1 OK, millis() = " + String(millis()));
//      else
//        Serial.println("Can't set ITimer1. Select another freq. or timer");
//  }
void TimerSetup(){
  int frequency = 1; // in hz
  cli();//stop interrupts
  TCCR1A = B00000000;//Register A all 0's since we're not toggling any pins  TCCR1B = 0;// same for TCCR1B
      // TCCR1B clock prescalers
    // 0 0 1 clkI/O /1 (No prescaling)
    // 0 1 0 clkI/O /8 (From prescaler)
    // 0 1 1 clkI/O /64 (From prescaler)
    // 1 0 0 clkI/O /256 (From prescaler)
    // 1 0 1 clkI/O /1024 (From prescaler)
  TCCR1B = B00001100;//bit 3 set for CTC mode, will call interrupt on counter match, bit 2 set to divide clock by 256, so 16MHz/256=62.5KHz
  TIMSK1 = B00000010;//bit 1 set to call the interrupt on an OCR1A match
  TCNT1  = 0;//initialize counter value to 0
  // set compare match register for 1hz increments
  OCR1A  = (unsigned long)((62500UL / frequency) - 1UL);//our clock runs at 62.5kHz, which is 1/62.5kHz = 16us
//  OCR1A = 65536;// = (16*10^6) / (1*1024) - 1 (must be <65536)
  // turn on CTC mode
//  TCCR1B |= (1 << WGM12);
//  // Set CS10 and CS12 bits for 1024 prescaler
//  TCCR1B |= (1 << CS12) | (1 << CS10);  
//  // enable timer compare interrupt
//  TIMSK1 |= (1 << OCIE1A);
  sei();
  };

ISR(TIMER1_COMPA_vect){//timer1 interrupt 1Hz toggles pin 13 (LED)
//generates pulse wave of frequency 1Hz/2 = 0.5kHz (takes two cycles for full wave- toggle high then toggle low)
    seconds++;
  if(seconds >= 60){ //set to however many seconds you want
    Serial.println(millis());           // This code is what happens
    Serial.println(F("E CONTROLLIAMOLA STA PIANTINA"));
    seconds = 0;                        // after 'x' seconds
    Controllore * contr;
    contr=Controllore::GetInstance();
    contr->Controllo();
//    digitalWrite(13, !digitalRead(13)); //
}
}
