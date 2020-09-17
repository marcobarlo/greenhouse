#ifndef _AMBIENTE_H
#define _AMBIENTE_H

#include <SPI.h>

class Ambiente{
  private:
    //Rifarlo in modo tale da avere due vettori invece si averli così
    float target[3];
    float soglie[3];
    float UmiditaTarget;
    float IrradianzaTarget;
    float TemperaturaTarget;
    float SogliaU;
    float SogliaI;
    float SogliaT;
  public:
    Ambiente(){};
    //riscrivere con modifica Ambiente che prende un vettore
    void ModificaAmbiente2(float array []);
    void ModificaAmbiente(float T, float U, float I);
//    void  SetUmiditaTarget(float);
//    void  SetIrradianzaTarget(float);
//    void  SetTemperaturaTarget(float);
    // riscrivere facendo prendere un vettore
    void SetSoglie(float T, float U, float I);
    void SetSoglie2(float array[]);
    //fare altre due funzioni che prendano in questo caso tutti i target e tutte le soglie
    int GetSoglie(float array[],int lung);//per farlo per bene servirebbero puntatori ma così evito di fare allocazione dinamica di cose piccole
    float GetSogliaU();
    float GetSogliaI();
    float GetSogliaT();
    int GetTarget(float array[],int lung);//per farlo correttamente ci vorrebbero i puntatori alternatuìiva è il mega accrocchio di fare il ritorno di qualcosa di locale
    float GetUmiditaTarget();
    float GetIrradianzaTarget();
    float GetTemperaturaTarget();

  };

#endif
