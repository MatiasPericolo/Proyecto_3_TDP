package Juego;

import Hilos.HiloGeneral;

public class Nivel {

	protected HiloGeneral hiloGeneral;
	protected Juego juego;
	
	public Nivel(Juego juego) {
		this.juego=juego;
		hiloGeneral=new HiloGeneral(juego);
	}
	
	public void iniciarJuego() {
		
		hiloGeneral.start();
	}

	public void cortarHilos() {
		//hiloCreador.detenerHilo();
		hiloGeneral.detenerHilo();
		//hiloSonido.detenerHilo();
	}
}
