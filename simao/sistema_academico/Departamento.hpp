#pragma once

class Universidade;

class Departamento {
	private:
		int id;
		char* nome[30];
		Universidade* pUniversidade;

	public:
		Deparmento(int _id, const char* _nome);
		Deparmento();
		~Departamento();
        void setUniversidade(Universidade* uni);
        Universidade* getUniversidade();
}