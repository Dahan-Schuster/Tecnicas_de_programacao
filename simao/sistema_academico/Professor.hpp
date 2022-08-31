#pragma once

#include "Pessoa.hpp"
#include "Universidade.hpp"

class Professor: public Pessoa {
	private:
        Universidade* pUniversidade;
        Departamento* pDepartamento;

	public:
		Professor();
        Professor(const char* nomeP, int diaNa, int mesNa, int anoNa);
		~Professor();
        void setUniversidade(Universidade* uni);
		Universidade* getUniversidade();
        void setDepartamento(Departamento* dep);
		Departamento* getDepartamento();
}