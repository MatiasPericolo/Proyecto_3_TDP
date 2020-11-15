package Disparos;

import javax.swing.JLabel;

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

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	public abstract void mover();
	
	public boolean esInfectado() {
		return false;
	}
}
