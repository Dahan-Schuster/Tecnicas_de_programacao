#ifndef PRINCIPAL_H
#define PRINCIPAL_H

#include "Universidade.hpp"
#include "Pessoa.hpp"

class Principal {
    private:
        Universidade utfpr;
        Pessoa aluno1;

        Universidade ufpr;
        Pessoa aluno2;
    
    public:
        Principal();
        ~Principal();
        void Iniciar();
};

#endif
