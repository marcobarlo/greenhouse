#include "func.h"



void array_to_string(byte array[], unsigned int len, char buffer[])
{
  for (unsigned int i = 0; i < len; i++)
  {
    byte nib1 = (array[i] >> 4) & 0x0F;
    byte nib2 = (array[i] >> 0) & 0x0F;
    buffer[i * 2 + 0] = nib1  < 0xA ? '0' + nib1  : 'A' + nib1  - 0xA;
    buffer[i * 2 + 1] = nib2  < 0xA ? '0' + nib2  : 'A' + nib2  - 0xA;
  }
  buffer[len * 2] = '\0';
}

void str2byte( char array [], byte array2[]){
  byte val1=0;
      byte val2=0;
      char letter1;
      char letter2;
      for (int i=0;i<6;i++){
        letter1=array[2*i];
        if(letter1 >= '0' && letter1 <= '9')
           val1 = letter1 - '0';
        else if(letter1 >= 'A' && letter1 <= 'F')
           val1 = letter1 - 'A' + 10;
        letter2=array[2*i+1];
        if(letter2 >= '0' && letter2 <= '9')
           val2 = letter2 - '0';
        else if(letter2 >= 'A' && letter2 <= 'F')
           val2 = letter2 - 'A' + 10;

        array2[i]=val1*16+val2;
        }
  }

long Convert_byte_to_long(byte array [], unsigned int start) {
  templong templ;
  for (int i = start; i < start + 4; i++) {
    //        ID_B[i - 6] = payload[i];
    templ.b[3 - i + start] = array[i];
  }
  return templ.l;
};

float Convert_byte_to_float(byte array[], unsigned int start) {
  tempfloat tempf;
  for (int i = start; i < start + 4; i++) {
    tempf.b[3 - i + start] = array[i];
  }
  return tempf.f;
};


void Convert_long_to_byte(byte array [], unsigned int start, long l) {
  array[start+3] = l & 0xFF;
  array[start+2] = (l >> 8)  & 0xFF;
  array[start+1] = (l >> 16) & 0xFF;
  array[start] = (l >> 24) & 0xFF;
};

void Convert_float_to_byte(byte array[],unsigned int start, float f){
  tempfloat tempf;
  tempf.f=f;
  array[start+3] = tempf.b[0];
  array[start+2] = tempf.b[1];
  array[start+1] = tempf.b[2];
  array[start] = tempf.b[3];
  };

  
void Load_to_payload_float2(byte array[],unsigned int start, float f){
  tempfloat tempf;
  tempf.f=f;
  array[start] = tempf.b[0];
  array[start+1] = tempf.b[1];
  array[start+2] = tempf.b[2];
  array[start+3] = tempf.b[3];
  };
