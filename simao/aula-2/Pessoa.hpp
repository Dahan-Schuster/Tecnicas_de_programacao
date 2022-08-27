#ifndef PESSOA_H
#define PESSOA_H

class Pessoa {

    private:
        int dia;
        int mes;
        int ano;
        int idade;
        char nome[30];

    public:
        Pessoa ();
        Pessoa (const char* nomeP, int diaNa, int mesNa, int anoNa);
        
        void calculaIdade(int diaAt, int mesAt, int anoAt);
        void imprimeIdade();
        void calculaImprimeIdade(int diaAt, int mesAt, int anoAt);
        int  getIdade();
};

#endif
