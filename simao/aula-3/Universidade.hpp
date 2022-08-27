#pragma once

class Universidade {
    private:
        char nome[50];
    
    public:
        Universidade();
        Universidade(const char* nomeUni);
        ~Universidade();

        void setNome(const char* nomeUni);
        const char* getNome();
};
