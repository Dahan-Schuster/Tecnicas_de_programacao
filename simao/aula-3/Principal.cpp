#include "Principal.hpp"
#include <stdio.h>

Principal::Principal():
    aluno1(),
    aluno2()
{

    utfpr = Universidade("UTFPR");
    ufpr  = Universidade("UFPR");

    aluno1.Inicializa("Dahan", 19, 12, 2000);
    aluno1.setUniversidade(&utfpr);
    aluno1.calculaIdade(27, 8, 2022);

    aluno2.Inicializa("Vihen", 30,  8, 1992);
    aluno2.setUniversidade(&ufpr);
    aluno2.calculaIdade(27, 8, 2022);
}

Principal::~Principal() {}

void Principal::Iniciar() {
    aluno1.imprimeDados();
    aluno2.imprimeDados();
}

