package Juego;

import GUI.Mapa;
import Hilos.HiloCreadorInfectados;
import Hilos.HiloMoverInfectados;

public class Nivel {

	protected int cantidadInfectados;
	protected HiloCreadorInfectados hiloCreador;
	protected HiloMoverInfectados hiloMovimiento;
	protected Juego juego;
	
	public Nivel(int cantInfectados,Juego juego) {
		this.juego=juego;
		cantidadInfectados=cantInfectados;
		hiloCreador=new HiloCreadorInfectados(juego,cantidadInfectados);
		hiloMovimiento=new HiloMoverInfectados(juego);
	}
	
	public void iniciarJuego() {
		
		hiloCreador.start();
		hiloMovimiento.start();
	}
}
