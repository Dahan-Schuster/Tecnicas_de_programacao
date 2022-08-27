#include "Principal.hpp"
#include <stdio.h>
#include <iostream>
using std::cout;
using std::cin;
using std::endl;

Principal::Principal() {
	int larg = 0, alt = 0, prof = 0;
	cout << "Informe larg, alt e prof da caixa 1, em cm: ";
	cin >> larg >> alt >> prof;
	cx1 = Caixa(larg, alt, prof);

	cout << "Informe larg, alt e prof da caixa 2, em cm: ";
	cin >> larg >> alt >> prof;
	cx2 = Caixa(larg, alt, prof);
}

Principal::~Principal() {}

void Principal::Iniciar() {
	cout << "Caixa 1 tem " << cx1.getAreaExterna() << "cm² e " << cx1.getVolume() << "cm³" << endl;
	cout << "Caixa 2 tem " << cx2.getAreaExterna() << "cm² e " << cx2.getVolume() << "cm³" << endl;
}

