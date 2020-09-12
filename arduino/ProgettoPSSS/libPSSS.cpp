#include "libPSSS.h"
#include <DHT.h>
#include <string.h>


void array_to_string(byte array[], unsigned int len, char buffer[])
{
    for (unsigned int i = 0; i < len; i++)
    {
        byte nib1 = (array[i] >> 4) & 0x0F;
        byte nib2 = (array[i] >> 0) & 0x0F;
        buffer[i*2+0] = nib1  < 0xA ? '0' + nib1  : 'A' + nib1  - 0xA;
        buffer[i*2+1] = nib2  < 0xA ? '0' + nib2  : 'A' + nib2  - 0xA;
    }
    buffer[len*2] = '\0';
}

float Ambiente  :: GetUmiditaTarget() {
  return UmiditaTarget;
};

float Ambiente  :: GetIrradianzaTarget() {
  return IrradianzaTarget;
};

float Ambiente  :: GetTemperaturaTarget() {
  return TemperaturaTarget;
};

void  Ambiente :: ModificaAmbiente(float T, float U, float I) {
  Serial.println("Modifica Ambiente valori:");
  UmiditaTarget = U;
  IrradianzaTarget = I;
  TemperaturaTarget = T;
  Serial.println(TemperaturaTarget);
  Serial.println(UmiditaTarget);
  Serial.println(IrradianzaTarget);
};

float Ambiente :: GetSogliaU() {
  return SogliaU;
};

float Ambiente :: GetSogliaI() {
  return SogliaI;
};

float Ambiente :: GetSogliaT() {
  return SogliaT;
};

void Ambiente :: SetSoglie(float T, float U, float I) {
  SogliaT = T;
  SogliaU = U;
  SogliaI = I;
  Serial.println("Stampa delle soglie in ambiente");
  Serial.println(SogliaT);
  Serial.println(SogliaU);
  Serial.println(SogliaI);

};




void SensoreUmidita :: SetUp() {
  Serial.println(" Setup SensoreUmidita");
  pinMode(YL_69_VCC, OUTPUT);
  digitalWrite(YL_69_VCC, LOW);
};

float SensoreUmidita :: GetDato() {
  Serial.println(" GetDato SensoreUmidita");
  digitalWrite(YL_69_VCC, HIGH);
  delay(500);
  int value = analogRead(YL_69_PIN);
  digitalWrite(YL_69_VCC, LOW);
  Umidita = 1023 - value;
  return Umidita;
};



SensoreTemperatura::SensoreTemperatura(): dht(DHTPIN, DHTTYPE) {
};

void SensoreTemperatura  :: SetUp() {
  Serial.println(" Setup SensoreTemperatura");
  Temperatura = -1;
  dht.begin();
};

float SensoreTemperatura  :: GetDato() {
  
  Serial.println(" GetDato SensoreTemperatura");
  float chk = dht.readTemperature(DHTPIN);
  return chk;
};

SensoreIrradianza::SensoreIrradianza() {};

void SensoreIrradianza  :: SetUp() {
  Serial.println(" Setup SensoreIrradianza");
  Irradianza = -1;
  //Da mettere la roba che sta nel setup del file per fare la caratterizzazioe del fotoresistore
};

float SensoreIrradianza  :: GetDato() {
  Serial.println(" GetDato SensoreIrradianza");
  //TODO DA FARE CARATTERIZZARE PER BENE I VALORI ATTUALI CREDO DIANO PROBLEMI, I LUX SEMBRANO INCREDIBILMENTE ALTI
  float level = analogRead(LUXINPUT);
  //calculate analog voltage
  float voltage = 5 * level / 1024;
  //make sure the voltage isn't outside the acceptable range
  if (voltage < 0) {
    voltage = 0;
  }
  if (voltage > 5) {
    voltage = 5;
  }
  //initialize a lux value
  float lux = 0;
  //based on the voltage, select the equation that will best convert it to a lux value
  if (voltage <= 0.534) {
    lux = 1286.47506604 * pow(voltage, 2) + 178.51342186 * voltage - 1.70982528;
  }
  else if (voltage <= 2.9) {
    lux = 197.90983722 * exp(1.62826391 * voltage);
  }
  else if (voltage <= 4.1) {
    lux = -3785.88415527 * pow(voltage, 6) + 85678.15521655 * pow(voltage, 5) - 604387.00259741 * pow(voltage, 4) + 1410432.63046882 * pow(voltage, 3) + 1529553.55029751 * pow(voltage, 2) - 11122170.790418 * voltage + 12440209.3288285;
  }
  else {
    lux = 23.9858393 * exp(2.28356737 * voltage);
  }
  //ensure the lux value isn't less than 0
  if (lux < 0 ) {
    lux = 0;
  }
  return lux;
};
