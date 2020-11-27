package Juego;

import Hilos.HiloCreadorInfectados;
import Hilos.HiloGeneral;
import Hilos.HiloSonidoInfectados;

public class Nivel {

	protected int cantidadInfectados;
	protected HiloCreadorInfectados hiloCreador;
	protected HiloGeneral hiloGeneral;
	protected HiloSonidoInfectados hiloSonido;
	protected Juego juego;
	
	public Nivel(int cantInfectados,Juego juego) {
		this.juego=juego;
		cantidadInfectados=cantInfectados;
		hiloCreador=new HiloCreadorInfectados(juego,cantidadInfectados);
		hiloGeneral=new HiloGeneral(juego);
		//hiloSonido=new HiloSonidoInfectados(juego);
	}
	
	public void iniciarJuego() {
		
		hiloCreador.start();
		hiloGeneral.start();
		//hiloSonido.start();
	}

	public void cortarHilos() {
		hiloCreador.detenerHilo();
		hiloGeneral.detenerHilo();
		//hiloSonido.detenerHilo();
	}
}
