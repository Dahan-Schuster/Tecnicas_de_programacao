#include <stdlib.h>
#include <stdio.h>
#include "Pessoa.hpp"

#define ANO_ATUAL 2022

int main(int argc, char* argv[]) {
    Pessoa newton   ("Newton", 4, 1, 1643);
    Pessoa einstein ("Einstein", 14, 3, 1879);
   
    char* p;

    int dia = strtol(argv[1], &p, 10);
    int mes = strtol(argv[2], &p, 10);
    int ano = strtol(argv[3], &p, 10);
    
    newton.calculaImprimeIdade(dia, mes, ano);
    einstein.calculaImprimeIdade(dia, mes, ano);

    return 0;
}
