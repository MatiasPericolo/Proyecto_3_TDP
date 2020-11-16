package Premios;

import javax.swing.JLabel;

import Hilos.HiloPremioTemporal;

public class Temporal extends Premio {
	
	protected int tiempoActivo;
	protected HiloPremioTemporal hiloTemporal;
	
	public Temporal(int x,int y, int t) {
		super(x,y);
		tiempoActivo = t;
		temporal=true;
		hiloTemporal=new HiloPremioTemporal(this);
	}
	
	public void setTiempo(int t) {
		tiempoActivo = t;
	}
	
	public int getTiempo() {
		return tiempoActivo;
	}
	
	public void empezarHilo() {
		hiloTemporal.start();
	}
}
