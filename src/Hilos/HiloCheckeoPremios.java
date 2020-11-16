package Hilos;

import Juego.Juego;

public class HiloCheckeoPremios extends Thread{

	private Juego juego;
	protected boolean run;
	
	public HiloCheckeoPremios(Juego juego) {
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
			juego.activarPremios();
		}
	}
	
}
