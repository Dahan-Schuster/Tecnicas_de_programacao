#pragma once

class PolReg {
	private:
		int numeroLados;
		int tamanhoLado;
	
	public:
		PolReg();
		PolReg(int n, int tam);
		~PolReg();

		int getNumeroLados();
		void setNumeroLados(int n);
		
		int getTamanhoLado();
		void setTamanhoLado(int tam);

		int getPerimetro();
		int getAnguloInterno();
		int getArea();
};