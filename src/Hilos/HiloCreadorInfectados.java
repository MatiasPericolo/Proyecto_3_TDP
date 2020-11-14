package Hilos;

import Juego.Juego;

public class HiloCreadorInfectados extends Thread{
	
	private Juego juego;
	protected boolean run;
	private int cantInfectados;
	
	public HiloCreadorInfectados(Juego juego, int cantidadInfectados) {
		cantInfectados=cantidadInfectados;
		this.juego=juego;
		run=true;
	}
	
	public void detenerHilo() {
		run=false;
	}

	public void run() {
		while(run){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cantInfectados--;
			juego.generarEnemigoAleatorio();
			
			if(cantInfectados==0)
				run=false;
		}
	}
}
