package Juego;

import GUI.Mapa;
import Hilos.HiloCheckeoColisiones;
import Hilos.HiloCheckeoPremios;
import Hilos.HiloCreadorInfectados;
import Hilos.HiloMoverInfectados;

public class Nivel {

	protected int cantidadInfectados;
	protected HiloCreadorInfectados hiloCreador;
	protected HiloMoverInfectados hiloMovimiento;
	protected HiloCheckeoColisiones hiloColisiones;
	protected HiloCheckeoPremios hiloPremios;
	protected Juego juego;
	
	public Nivel(int cantInfectados,Juego juego) {
		this.juego=juego;
		cantidadInfectados=cantInfectados;
		hiloCreador=new HiloCreadorInfectados(juego,cantidadInfectados);
		hiloMovimiento=new HiloMoverInfectados(juego);
		hiloColisiones=new HiloCheckeoColisiones(juego);
		hiloPremios=new HiloCheckeoPremios(juego) ;
	}
	
	public void iniciarJuego() {
		
		hiloCreador.start();
		hiloMovimiento.start();
		hiloColisiones.start();
		hiloPremios.start();
	}
}
