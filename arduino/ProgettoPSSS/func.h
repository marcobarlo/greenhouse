#ifndef _FUNC_H
#define _FUNC_H

#include <stdio.h>
//#include <Ethernet.h>
//#include "Controllore.h"
#include <Arduino.h>
#include <SPI.h>

//#define USE_TIMER_1     true
//#define USE_TIMER_2     false
//#define USE_TIMER_3     false
//#define USE_TIMER_4     false
//#define USE_TIMER_5     false
//
//#define TIMER1_INTERVAL_MS    10000
//
//void TimerHandler1(void);
//
//class Test{
//  public:
//  Test(){};
//  void SetUp();
//  
//  };

union templong {
  byte b [4] ;
  long l;
};
union tempfloat {
  float f;
  byte b[4];
};

void array_to_string(byte array[], unsigned int len, char buffer[]);

void str2byte( char array [], byte array2[]);

long Convert_byte_to_long(byte array [], unsigned int start);

float Convert_byte_to_float(byte array[], unsigned int start);


void Load_to_payload_long(byte array [],unsigned int start,long l);

void Load_to_payload_float(byte array[], unsigned int start,float f);

void Load_to_payload_float2(byte array[], unsigned int start,float f);


#endif
