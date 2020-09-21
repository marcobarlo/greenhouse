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

long Convert_byte_to_long(byte array [], unsigned int start);// i parametri sono il vettore di byte contente il valore ed il punto da cui partire per convertire in long

float Convert_byte_to_float(byte array[], unsigned int start);// i parametri sono il vettore di byte contente il valore ed il punto da cui partire per convertire in float


void Convert_long_to_byte(byte array [],unsigned int start,long l);// i parametri sono il vettore di byte in cui convertire il valore, il punto da cui partire ad inserire il valore convertito ed il valore da convertire

void Convert_float_to_byte(byte array[], unsigned int start,float f);// i parametri sono il vettore di byte in cui convertire il valore, il punto da cui partire ad inserire il valore convertito ed il valore da convertire


#endif
