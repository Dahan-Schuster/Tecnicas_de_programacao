#include <stdlib.h>
#include <stdio.h>
#include "pessoa.h"

#define ANO_ATUAL 2022

int main(int argc, char* argv[]) {
    Pessoa* newton = criaPessoa(4, 1, 1643);
    Pessoa* einstein = criaPessoa(14, 3, 1879);
   
    char* p;

    int dia = strtol(argv[1], &p, 10);
    int mes = strtol(argv[2], &p, 10);
    int ano = strtol(argv[3], &p, 10);
    
    calculaIdade(newton, dia, mes, ano);
    calculaIdade(einstein, dia, mes, ano);
    
    printf("A idade de Newton é %d \n", newton->idade);
    printf("A idade de Einstein é %d \n", einstein->idade);

    return 0;
}
