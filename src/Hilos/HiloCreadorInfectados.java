package Hilos;

import Juego.Juego;

public class HiloCreadorInfectados extends Thread{
	
	private Juego juego;
	protected boolean run;
	private int cantInfectados;
	private int finOleada;
	
	public HiloCreadorInfectados(Juego juego, int cantidadInfectados) {
		cantInfectados=cantidadInfectados;
		finOleada=cantInfectados/2;
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
			if(finOleada==cantInfectados)
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
