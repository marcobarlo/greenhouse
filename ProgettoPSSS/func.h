#ifndef _FUNC_H
#define _FUNC_H

#include <stdio.h>
//#include <Ethernet.h>
//#include "Controllore.h"
#include <Arduino.h>
#include <SPI.h>


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


void Convert_long_to_byte(byte array [],unsigned int start,long l);

void Convert_float_to_byte(byte array[], unsigned int start,float f);

void Load_to_payload_float2(byte array[], unsigned int start,float f);


#endif
