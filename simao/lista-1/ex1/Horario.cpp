#include "Horario.hpp"
#include <iostream>
using std::cout;
using std::endl;

Horario::Horario() {
	hora = 0;
	minuto = 0;
}

Horario::Horario(int h, int min) {
	setHora(h);
	setMinuto(min);
}

Horario::~Horario() {}

int Horario::getHora() {
	return hora;
}

void Horario::setHora(int h) {
	if (h > 24 || h < 0) {
		cout << "Valor para atributo hora inválido, precisa estar entre 0 e 24 (inclusive)." << endl;
		return;
	}

	hora = h;
}

int Horario::getMinuto() {
	return minuto;
}

void Horario::setMinuto(int min) {
	if (min > 59 || min < 0) {
		cout << "Valor para atributo minuto inválido, precisa estar entre 0 e 60 (exclusive)." << endl;
		return;
	}

	minuto = min;
}

Horario Horario::calculaIntervalo(Horario h2) {
	int intervaloMinuto = 0;
	int intervaloHora = 0;

	if (hora >= h2.getHora()) {
		intervaloHora = hora - h2.getHora();
		if (minuto >= h2.getMinuto()) {
			intervaloMinuto = minuto - h2.getMinuto();
		} else {
			intervaloHora--;
			intervaloMinuto = 60 - minuto - h2.getMinuto();
		}
	} else {
		intervaloHora = h2.getHora() - hora; 
		if (h2.getMinuto() >= minuto) {
			intervaloMinuto = h2.getMinuto() - minuto;
		} else {
			intervaloHora--;
			intervaloMinuto = 60 - minuto - h2.getMinuto();
		}
	}
	
	return Horario(intervaloHora, intervaloMinuto);
}

void Horario::imprimeHorario() {
	cout << hora << ":" << minuto;
}