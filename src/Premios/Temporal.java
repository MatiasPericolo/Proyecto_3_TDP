package Premios;

import javax.swing.JLabel;

public class Temporal extends Premio {
	
	
	protected int tiempoActivo;
	
	public Temporal(int v, int t, JLabel l) {
		tipo = "Temporal";
		velocidad = v;
		tiempoActivo = t;
		label = l;
		efectos = new String[]{"Cuarentena", "SuperArma"};
	}
	
	public void setTiempo(int t) {
		tiempoActivo = t;
	}
	
	public int getTiempo() {
		return tiempoActivo;
	}
	
}
