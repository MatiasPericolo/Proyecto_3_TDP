package Hilos;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import Juego.Juego;

public class HiloSonidoInfectados extends Thread {

	private Juego juego;
	protected boolean run;
	
	public HiloSonidoInfectados(Juego juego) {
		this.juego=juego;
		run=true;
	}
	
	public void detenerHilo() {
		run=false;
	}

	public void run() {
		Clip clip;
		while(run){
			try {
				clip = AudioSystem.getClip();
				juego.reproducirSonido(clip);
				Thread.sleep(3000);
				clip.close();
			} catch (InterruptedException | LineUnavailableException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
