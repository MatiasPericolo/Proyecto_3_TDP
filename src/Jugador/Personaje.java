package Jugador;

import javax.swing.JLabel;

import Juego.Entidad;

public class Personaje extends Entidad{

	protected JLabel labelPersonaje;
	protected int cargaViral;
	protected int velocidad;
	protected String sprite;
	
	public Personaje(JLabel label) {
		labelPersonaje=label;
		cargaViral=0;
		velocidad=10;
		sprite="Sprites\\Personaje e Infectados\\personaje.gif";
	}

	public JLabel getLabelPersonaje() {
		return labelPersonaje;
	}

	public void setLabelPersonaje(JLabel labelPersonaje) {
		this.labelPersonaje = labelPersonaje;
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
	
}
