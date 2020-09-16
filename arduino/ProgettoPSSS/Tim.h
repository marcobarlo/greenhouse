#ifndef _TIM_H
#define _TIM_H


//#include "TimerInterrupt.h"
#include "Controllore.h"

#define USE_TIMER_1     true
//#define USE_TIMER_2     false
//#define USE_TIMER_3     false
//#define USE_TIMER_4     false
//#define USE_TIMER_5     false

#define TIMER1_INTERVAL_MS    10000

void TimerHandler1(void);

class Timer{
  public:
  Test(){};
  void SetUp();
  
  };

#endif
