package Hilos;

import Juego.Juego;

public class HiloGeneral extends Thread{

	private Juego juego;
	protected boolean run;
	
	public HiloGeneral(Juego juego) {
		this.juego=juego;
		run=true;
	}
	
	public void detenerHilo() {
		run=false;
	}

	public void run() {
		juego.reproducirSonidoInfectados();
		while(run){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.hiloGeneral();
		}
	}
	
}
