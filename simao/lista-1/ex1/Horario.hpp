#pragma once

class Horario {
	private:
		int hora;
		int minuto;
	
	public:
		Horario();
		Horario(int h, int min);
		~Horario();

		int getHora();
		void setHora(int h);
		
		int getMinuto();
		void setMinuto(int min);

		Horario calculaIntervalo(Horario h2);
		void imprimeHorario();
};