#include <stdlib.h>
#include <string.h>
#include <iostream>
using std::cout;
using std::endl;

#include "Pessoa.hpp"

Pessoa::Pessoa() {
   Inicializa("", 0, 0, 0); 
}

Pessoa::Pessoa(const char* nomeP, int diaNa, int mesNa, int anoNa) {
   Inicializa(nomeP, diaNa, mesNa, anoNa); 
}

void Pessoa::Inicializa(const char* nomeP, int diaNa, int mesNa, int anoNa) {
    strcpy(nome, nomeP);
    dia = diaNa;
    mes = mesNa;
    ano = anoNa;
    idade = -1;
    pUniversidade = NULL;
}


void Pessoa::imprimeDados() {
    cout << "Aluno: " << nome << ", " << idade << " anos";
    if (pUniversidade != NULL) {
        cout << " - " << pUniversidade->getNome();
    }

    cout << endl;
}

void Pessoa::setUniversidade(Universidade* uni) {
    pUniversidade = uni;
}

void Pessoa::calculaIdade(int diaAt, int mesAt, int anoAt) {
    idade = anoAt - ano;
    
    if (mes > mesAt || (mes == mesAt && dia > diaAt)) {
        idade = idade - 1;
    }
}

int Pessoa::getIdade() {
    return idade;
}
