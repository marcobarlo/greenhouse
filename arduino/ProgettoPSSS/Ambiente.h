#ifndef _AMBIENTE_H
#define _AMBIENTE_H

#include <SPI.h>

#ifndef AMBIENTE_DEBUG
#define AMBIENTE_DEBUG  0
#endif

class Ambiente{
  private:
    //Rifarlo in modo tale da avere due vettori invece si averli così
    float target[3];
    float soglie[3];
    float UmiditaTarget;//Rimuovere questi valori??
    float IrradianzaTarget;
    float TemperaturaTarget;
    float SogliaU;
    float SogliaI;
    float SogliaT;
  public:
    Ambiente(){};
    //riscrivere con modifica Ambiente che prende un vettore
    void ModificaAmbiente2(float array []);//Riportare solo a ModficaAmbiente
    void ModificaAmbiente(float T, float U, float I);
    void SetSoglie(float T, float U, float I);
    void SetSoglie2(float array[]);//Riportare solo ad un Set 
    //fare altre due funzioni che prendano in questo caso tutti i target e tutte le soglie
    int GetSoglie(float array[],int lung);//per farlo per bene servirebbero puntatori ma così evito di fare allocazione dinamica di cose piccole
    float GetSogliaU();//Rimuovere? c'è quello con l'array
    float GetSogliaI();
    float GetSogliaT();
    int GetTarget(float array[],int lung);//per farlo correttamente ci vorrebbero i puntatori alternatuìiva è il mega accrocchio di fare il ritorno di qualcosa di locale
    float GetUmiditaTarget();///rimuovere c'è quello con l'array
    float GetIrradianzaTarget();
    float GetTemperaturaTarget();

  };

#endif
