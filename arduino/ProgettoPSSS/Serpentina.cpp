#include "Serpentina.h"
#include <DHT.h>
#include <string.h>

#define NUM_T 3
#define NUM_S 3

// A sto punto la sposto in una libreria a parte insieme e quella byte float e viceversa e quella byte long e viceversa???
//void array_to_string(byte array[], unsigned int len, char buffer[])
//{
//    for (unsigned int i = 0; i < len; i++)
//    {
//        byte nib1 = (array[i] >> 4) & 0x0F;
//        byte nib2 = (array[i] >> 0) & 0x0F;
//        buffer[i*2+0] = nib1  < 0xA ? '0' + nib1  : 'A' + nib1  - 0xA;
//        buffer[i*2+1] = nib2  < 0xA ? '0' + nib2  : 'A' + nib2  - 0xA;
//    }
//    buffer[len*2] = '\0';
//}



void Serpentina :: SetAttuatore(float f){};
void Serpentina :: SetUp(){};
