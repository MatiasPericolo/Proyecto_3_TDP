package Juego;

import Hilos.HiloGeneral;
import Hilos.HiloSonidoInfectados;

public class Nivel {

	protected HiloGeneral hiloGeneral;
	protected HiloSonidoInfectados hiloSonido;
	protected Juego juego;
	
	public Nivel(Juego juego) {
		this.juego=juego;
		hiloGeneral=new HiloGeneral(juego);
		//hiloSonido=new HiloSonidoInfectados(juego);
	}
	
	public void iniciarJuego() {
		
		hiloGeneral.start();
		//hiloSonido.start();
	}

	public void cortarHilos() {
		//hiloCreador.detenerHilo();
		hiloGeneral.detenerHilo();
		//hiloSonido.detenerHilo();
	}
}
