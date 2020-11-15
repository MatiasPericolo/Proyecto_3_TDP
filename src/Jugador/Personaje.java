package Jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Arma.ArmaSanitaria;
import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Hilos.HiloControles;
import Juego.Entidad;

public class Personaje extends Entidad{

	protected JLabel labelPersonaje;
	protected int cargaViral;
	protected int velocidad;
	protected String sprite;
	protected String direccion;
	protected HiloControles control;
	protected boolean quieto;
	protected ArmaSanitaria arma;
	
	public Personaje(JLabel label) {
		labelPersonaje=label;
		control = new HiloControles(label);
		control.start();
		cargaViral=0;
		velocidad=10;
		sprite="Sprites\\Personaje e Infectados\\personaje.gif";
		direccion = "Derecha";
		quieto = true;
		arma=new ArmaSanitaria(10,10,"Sprites\\Disparos\\DisparoPersonaje.png");
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
			if(quieto){
				labelPersonaje.setBounds(labelPersonaje.getX()+velocidad,labelPersonaje.getY(), 199, 150);
				quieto = false;
			}
			labelPersonaje.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeDerecha.gif"));
			control.setVelocidad(velocidad);
			direccion = "Derecha";
		} else {
			quieto();
		}
	}
	
	public void moverIzquierda() {
		if((labelPersonaje.getX()>-32)) {
			if(quieto){
				labelPersonaje.setBounds(labelPersonaje.getX()-velocidad,labelPersonaje.getY(), 199, 150);
				quieto = false;
			}
			labelPersonaje.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeIzquierda.gif"));
			control.setVelocidad(-velocidad);
			direccion = "Izquierda";
		} else {
			quieto();
		}
	}
	
	public void quieto() {
		quieto = true;
		control.setVelocidad(0);
		labelPersonaje.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeQuieto"+direccion+".gif"));		
	}

	public DisparoSanitario disparar() {
		quieto();
		labelPersonaje.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeDisparando"+direccion+".gif"));	
		DisparoSanitario disparo=arma.crearDisparo(labelPersonaje.getX()+(labelPersonaje.getHeight()/2),labelPersonaje.getY());
		
		return disparo;
	}
}
