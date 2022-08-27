#ifndef PESSOA_H
#define PESSOA_H


typedef struct pessoa {
    int dia;
    int mes;
    int ano;
    int idade;
} Pessoa;

int calculaIdade(Pessoa* pessoa, int dia, int mes, int ano);

Pessoa* criaPessoa(int dia, int mes, int ano);

#endif
