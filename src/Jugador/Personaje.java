package Jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Entidad;

public class Personaje extends Entidad{

	protected JLabel labelPersonaje;
	protected int cargaViral;
	protected int velocidad;
	protected String sprite;
	protected String direccion;
	
	public Personaje(JLabel label) {
		labelPersonaje=label;
		cargaViral=0;
		velocidad=10;
		sprite="Sprites\\Personaje e Infectados\\personaje.gif";
		direccion = "Derecha";
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
	
	public void moverDerecha() {
		if(labelPersonaje.getX()<688) {
			labelPersonaje.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeDerecha.gif"));
			labelPersonaje.setBounds(labelPersonaje.getX()+getVelocidad(),labelPersonaje.getY(), 199, 150);
			direccion = "Derecha";
		}
	}
	
	public void moverIzquierda() {
		if((labelPersonaje.getX()>-32)) {
			labelPersonaje.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeIzquierda.gif"));
			labelPersonaje.setBounds(labelPersonaje.getX()-getVelocidad(),labelPersonaje.getY(), 199, 150);
			direccion = "Izquierda";
		}
	}
	
	public void quieto() {
		labelPersonaje.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeQuieto"+direccion+".gif"));		
	}

	public void disparar() {
		labelPersonaje.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeDisparando"+direccion+".gif"));			
	}
}
