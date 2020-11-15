package Disparos;

import javax.swing.JLabel;

public abstract class Disparo {

	protected int velocidad;
	protected int daño;
	protected JLabel label;
	protected String sprite;
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

	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
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

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	public abstract void mover();
	
}
