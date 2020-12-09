package Disparos;

import Juego.Entidad;

public abstract class Disparo extends Entidad{

	protected int velocidad;
	protected int da�o;
	protected int coordenadaX,coordenadaY;
	
	public Disparo(int x, int y,int vel, int da�o,String img) {
		coordenadaX=x;
		coordenadaY=y;
		velocidad=vel;
		this.da�o=da�o;
		sprite=img;
		valiosa=false;
	}
	
	public int getCoordenadaX() {
		return coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getDa�o() {
		return da�o;
	}
	
	public abstract void mover();
	
	public boolean esInfectado() {
		return false;
	}
}
