package Hilos;

import Juego.Juego;

public class HiloMoverInfectados extends Thread {

	private Juego juego;
	protected boolean run;
	
	public HiloMoverInfectados(Juego juego) {
		this.juego=juego;
		run=true;
	}
	
	public void detenerHilo() {
		run=false;
	}

	public void run() {
		while(run){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.mover();
		}
	}
	
}
