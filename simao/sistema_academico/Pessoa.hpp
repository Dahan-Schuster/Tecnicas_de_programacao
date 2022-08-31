#pragma once
	
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
        void Inicializa (const char* nomeP, int diaNa, int mesNa, int anoNa);

        void calculaIdade(int diaAt, int mesAt, int anoAt);
        int  getIdade();
        void imprimeDados();
};

