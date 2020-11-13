package Infectados;

import javax.swing.JLabel;

import Juego.Entidad;

public class Infectado extends Entidad{
	
	protected JLabel labelInfectado;
	protected int cargaViral;
	protected int velocidad;
	protected String sprite;
	protected int coordenadaX;
	
	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public Infectado(JLabel label) {
		cargaViral=100;
		coordenadaX=((int) (Math.random()*720))-32;
		labelInfectado=label;
	}
	
	public JLabel getLabelInfectado() {
		return labelInfectado;
	}

	public void setLabelInfectado(JLabel labelInfectado) {
		this.labelInfectado = labelInfectado;
	}

	public int getCargaViral() {
		return cargaViral;
	}

	public void setCargaViral(int cargaViral) {
		this.cargaViral = cargaViral;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}

	public void mover() {
		
	}
	
}
