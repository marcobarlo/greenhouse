#include "SensoreIrradianza.h"

SensoreIrradianza::SensoreIrradianza() {};

void SensoreIrradianza  :: SetUp() {
  Serial.println(" Setup SensoreIrradianza");
  Irradianza = -1;
  //Da mettere la roba che sta nel setup del file per fare la caratterizzazioe del fotoresistore
};

float SensoreIrradianza  :: GetDato() {
  Serial.println(" GetDato SensoreIrradianza");
//  //TODO DA FARE CARATTERIZZARE PER BENE I VALORI ATTUALI CREDO DIANO PROBLEMI, I LUX SEMBRANO INCREDIBILMENTE ALTI
  float level = analogRead(LUXINPUT);
  //calculate analog voltage
  float voltage = 5 * level / 1024;
  //make sure the voltage isn't outside the acceptable range
  // Se è più basso lo considero un errore?? boh lo metto a -1 anche se non so se abbia molto senso
  if (voltage < 0) {
    voltage = 0;
    return -1;
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
  Serial.println(lux);
  return lux;
//return 20;
};
