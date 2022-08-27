#include "Caixa.hpp"
#include <iostream>
using std::cout;
using std::endl;

Caixa::Caixa() {
	largura = 0;
	altura = 0;
	profundidade = 0;
}

Caixa::Caixa(int l, int a, int p) {
	setLargura(l);
	setAltura(a);
	setProfundidade(p);
}

Caixa::~Caixa() {}

int Caixa::getLargura() {
	return largura;
}

void Caixa::setLargura(int l) {
	if (l < 0) {
		cout << "Valor para atributo largura inválido, precisa maior que 0." << endl;
		return;
	}

	largura = l;
}

int Caixa::getAltura() {
	return altura;
}

void Caixa::setAltura(int a) {
	if (a < 0) {
		cout << "Valor para atributo altura inválido, precisa maior que 0." << endl;
		return;
	}

	altura = a;
}

int Caixa::getProfundidade() {
	return profundidade;
}

void Caixa::setProfundidade(int p) {
	if (p < 0) {
		cout << "Valor para atributo profundidade inválido, precisa maior que 0." << endl;
		return;
	}

	profundidade = p;
}

int Caixa::getAreaExterna(){
	return 2*(largura*altura + largura*profundidade + altura*profundidade);
}

int Caixa::getVolume(){
	return largura*altura*profundidade;
}
