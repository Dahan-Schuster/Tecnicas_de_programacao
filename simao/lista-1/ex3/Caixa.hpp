#pragma once

class Caixa {
	private:
		int largura;
		int altura;
		int profundidade;
	
	public:
		Caixa();
		Caixa(int l, int a, int p);
		~Caixa();

		int getLargura();
		void setLargura(int l);
		
		int getAltura();
		void setAltura(int a);
		
		int getProfundidade();
		void setProfundidade(int p);

		int getAreaExterna();
		int getVolume();
};