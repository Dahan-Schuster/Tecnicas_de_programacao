#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "Pessoa.hpp"

Pessoa::Pessoa() {
    nome = "";
    dia = 0;
    mes = 0;
    ano = 0;
    idade = -1;
}

Pessoa::Pessoa(const char* nomeP, int diaNa, int mesNa, int anoNa) {
    strcpy(nome, nomeP);
    dia = diaNa;
    mes = mesNa;
    ano = anoNa;

    idade = -1;
}

void Pessoa::calculaIdade(int diaAt, int mesAt, int anoAt) {
    idade = anoAt - ano;
    
    if (mes > mesAt || (mes == mesAt && dia > diaAt)) {
        idade = idade - 1;
    }
}

void Pessoa::imprimeIdade() {
    if (idade < 0) {
        printf("A idade de %s ainda não foi calculada\n", nome);
    } else {
        printf("%s tem, ou teria, %d anos\n", nome, idade);
    }
}

void Pessoa::calculaImprimeIdade(int diaAt, int mesAt, int anoAt) {
    calculaIdade(diaAt, mesAt, anoAt);
    imprimeIdade();
}

int Pessoa::getIdade() {
    return dia;
}
