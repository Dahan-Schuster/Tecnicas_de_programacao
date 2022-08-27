#include <stdlib.h>
#include "pessoa.h"

int calculaIdade(Pessoa* pessoa, int dia, int mes, int ano) {
    if (pessoa == NULL) {
        return -1;
    }

    if (dia < 0 || mes < 0 || ano < 0) {
        return -2;
    }

    pessoa->idade = ano - pessoa->ano;
    
    if (pessoa->mes > mes || (pessoa->mes == mes && pessoa->dia > dia)) {
        pessoa->idade = pessoa->idade - 1;
    }
}

Pessoa* criaPessoa(int dia, int mes, int ano) {
    Pessoa* novaPessoa = (Pessoa*)malloc(sizeof(Pessoa));
    novaPessoa->dia = dia;
    novaPessoa->mes = mes;
    novaPessoa->ano = ano;

    novaPessoa->idade = -1;

    return novaPessoa;
}

