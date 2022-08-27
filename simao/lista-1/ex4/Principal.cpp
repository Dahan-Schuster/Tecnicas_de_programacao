#include "Principal.hpp"
#include <stdio.h>
#include <iostream>
using std::cout;
using std::cin;
using std::endl;

Principal::Principal() {
	int numLados = 0, tamLado = 0;
	cout << "Informe o número de lados do polígono e o tamanho de cada lado em cm: ";
	cin >> numLados >> tamLado;
	pol = PolReg(numLados, tamLado);
}

Principal::~Principal() {}

void Principal::Iniciar() {
	cout << "Este polígono tem " << pol.getPerimetro() << "cm de perímetro e "
		 << pol.getAnguloInterno() << "° de ângulo interno" << endl;
}

