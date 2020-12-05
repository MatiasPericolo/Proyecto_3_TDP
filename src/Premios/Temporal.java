package Premios;

public class Temporal extends Premio {
	
	protected int tiempoActivo;
	
	public Temporal(int x,int y, int t) {
		super(x,y);
		tiempoActivo = t;
		temporal=true;
	}
	
	public void setTiempo(int t) {
		tiempoActivo = t;
	}
	
	public int getTiempo() {
		return tiempoActivo;
	}
	
}
