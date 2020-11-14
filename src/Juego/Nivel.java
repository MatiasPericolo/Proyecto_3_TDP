package Juego;

import GUI.Mapa;
import Hilos.HiloCreadorInfectados;
import Hilos.HiloMoverInfectados;

public class Nivel {

	protected int cantidadInfectados;
	protected HiloCreadorInfectados hiloCreador;
	protected HiloMoverInfectados hiloMovimiento;
	protected Mapa gui;
	
	public Nivel(int cantInfectados,Mapa gui) {
		this.gui=gui;
		cantidadInfectados=cantInfectados;
		hiloCreador=new HiloCreadorInfectados(gui.getJuego(),cantidadInfectados);
		hiloMovimiento=new HiloMoverInfectados(gui.getJuego());
	}
	
	public void iniciarJuego() {
		
		hiloCreador.run();
		//hiloMovimiento.run();
	}
}
