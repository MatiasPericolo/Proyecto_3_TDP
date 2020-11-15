package Disparos;

import javax.swing.JLabel;

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
	}
	
	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}
	
	public abstract void mover();
	
	public boolean esInfectado() {
		return false;
	}
}
