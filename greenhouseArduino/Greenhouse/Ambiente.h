#ifndef _AMBIENTE_H
#define _AMBIENTE_H

#include <SPI.h>

#define NUM_T 3 //Numero valori target
#define NUM_S 3 //Numero di sensori

#ifndef AMBIENTE_DEBUG
#define AMBIENTE_DEBUG  0
#endif

class Ambiente{
  private:
    float target[3]; // per convenzione i valori sono salvati in questo ordine Temperatura Umidita Irradianza sia per i target che per le soglie
    float soglie[3]; //le soglie come i target sono salvati in questo ordine Temperatura Umidita Irradianza
  public:
    Ambiente(){};
    void ModificaAmbiente(float array []);//I valori per le modifiche dei parametri devono essere forniti in questo ordine Temperatura Umidita Irradianza
    void SetSoglie(float array[]);//Le soglie devono essere fornite nell'ordine Temperatura Umidita Irradianza
    //Le soglie prelevate nell'ordine Temperatura Umidita Irradianza
    int GetSoglie(float array[],int lung);//per farlo per bene servirebbero puntatori ma così evito di fare allocazione dinamica di cose piccole
    //I valori target prelevati nell'ordine Temperatura Umidita Irradianza
    int GetTarget(float array[],int lung);//per farlo correttamente ci vorrebbero i puntatori alternatuìiva è il mega accrocchio di fare il ritorno di qualcosa di locale


  };

#endif
