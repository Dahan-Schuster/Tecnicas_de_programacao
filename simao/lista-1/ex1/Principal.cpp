#include "Principal.hpp"
#include <stdio.h>
#include <iostream>
using std::cout;
using std::cin;
using std::endl;

Principal::Principal() {
	int hora = 0, min = 0;
	cout << "Informe o primeiro horario: ";
	cin >> hora >> min;
	h1 = Horario(hora, min);

	cout << "Informe o segundo horario: ";
	cin >> hora >> min;
	h2 = Horario(hora, min);
}

Principal::~Principal() {}

void Principal::Iniciar() {
    Horario intervalo = h1.calculaIntervalo(h2);
	cout << "Intervalo de ";
	intervalo.imprimeHorario();
	cout  << endl;

	double valor = 0.0;
	if (intervalo.getHora() < 3) {
		valor = 4.5;
	} else if (intervalo.getHora() > 12) {
		valor = 33.0;
	} else {
		valor = intervalo.getHora() * (60 / 15) * 0.75;
		if (intervalo.getMinuto() > 0) {
			valor = valor + (intervalo.getMinuto() / 15) * 0.75;
		}
	}

	cout << "Valor: R$ " << valor << endl;
}

