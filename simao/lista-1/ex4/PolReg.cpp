#include "PolReg.hpp"
#include <iostream>
using std::cout;
using std::endl;

PolReg::PolReg() {
	numeroLados = 0;
	tamanhoLado = 0;
}

PolReg::PolReg(int n, int tam) {
	setNumeroLados(n);
	setTamanhoLado(tam);
}

PolReg::~PolReg() {}

int PolReg::getNumeroLados() {
	return numeroLados;
}

void PolReg::setNumeroLados(int n) {
	if (n < 0) {
		cout << "Valor para atributo numeroLados inválido, precisa maior que 0." << endl;
		return;
	}

	numeroLados = n;
}

int PolReg::getTamanhoLado() {
	return tamanhoLado;
}

void PolReg::setTamanhoLado(int tam) {
	if (tam < 0) {
		cout << "Valor para atributo tamanhoLado inválido, precisa maior que 0." << endl;
		return;
	}

	tamanhoLado = tam;
}

int PolReg::getPerimetro() {
	return numeroLados * tamanhoLado;
}

int PolReg::getAnguloInterno() {
	return (numeroLados - 2) * 180;
}

int PolReg::getArea(){
	return 0; // não é possível calcular a área de um polígono regular
}
