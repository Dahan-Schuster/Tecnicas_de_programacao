#include "Universidade.hpp"
#include <string.h>

Universidade::Universidade() {
    const char* nomeUni = "";
    strcpy(nome, nomeUni);
}

Universidade::Universidade(const char* nomeUni) {
    strcpy(nome, nomeUni);
}

Universidade::~Universidade() {}

void Universidade::setNome(const char* nomeUni) {
    strcpy(nome, nomeUni);
}

const char* Universidade::getNome() {
    return nome;
}
