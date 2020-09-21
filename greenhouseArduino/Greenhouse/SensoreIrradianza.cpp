#include "SensoreIrradianza.h"

SensoreIrradianza::SensoreIrradianza() {};

void SensoreIrradianza  :: SetUp() {
  if(IRRADIANZA_DEBUG>0){
  Serial.println(F("Setup SensoreIrradianza"));
  }
};

float SensoreIrradianza  :: GetDato() {
  if(IRRADIANZA_DEBUG>0){
  Serial.println(F("Prelievo Dato SensoreIrradianza"));
  }
  float level = analogRead(IRRINPUT);
  float voltage = 5 * level / 1024;

  if (voltage < 0) {
    voltage = 0;
  }
  if (voltage > 5) {
    voltage = 5;
  }
  float irr = 0;

  if (voltage <= 0.534) {
    irr = 1286.47506604 * pow(voltage, 2) + 178.51342186 * voltage - 1.70982528;
  }
  else if (voltage <= 2.9) {
    irr = 197.90983722 * exp(1.62826391 * voltage);
  }
  else if (voltage <= 4.1) {
    irr = -3785.88415527 * pow(voltage, 6) + 85678.15521655 * pow(voltage, 5) - 604387.00259741 * pow(voltage, 4) + 1410432.63046882 * pow(voltage, 3) + 1529553.55029751 * pow(voltage, 2) - 11122170.790418 * voltage + 12440209.3288285;
  }
  else {
    irr = 23.9858393 * exp(2.28356737 * voltage);
  }

  if (irr < 0 ) {
    irr = 0;
    return -1;
  }
  if(IRRADIANZA_DEBUG>0){
    Serial.println(irr);
    }
  return irr;
};
