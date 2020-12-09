package Disparos;

import Juego.Entidad;

public abstract class Disparo extends Entidad{

	protected int velocidad;
	protected int daño;
	protected int coordenadaX,coordenadaY;
	
	public Disparo(int x, int y,int vel, int daño,String img) {
		coordenadaX=x;
		coordenadaY=y;
		velocidad=vel;
		this.daño=daño;
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

	public int getDaño() {
		return daño;
	}
	
	public abstract void mover();
	
	public boolean esInfectado() {
		return false;
	}
}
