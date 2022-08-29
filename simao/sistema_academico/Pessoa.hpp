#pragma once

#include "Universidade.hpp"

class Pessoa {
    private:
        int dia;
        int mes;
        int ano;
        int idade;
        char nome[30];
        Universidade* pUniversidade;

    public:
        Pessoa ();
        Pessoa (const char* nomeP, int diaNa, int mesNa, int anoNa);
        void Inicializa (const char* nomeP, int diaNa, int mesNa, int anoNa);

        void calculaIdade(int diaAt, int mesAt, int anoAt);
        int  getIdade();
        void setUniversidade(Universidade* uni);
        void imprimeDados();
};

