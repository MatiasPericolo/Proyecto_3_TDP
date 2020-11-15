package Jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Arma.ArmaSanitaria;
import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Hilos.HiloControles;
import Juego.Entidad;

public class Personaje extends Entidad{

	protected int cargaViral;
	protected int velocidad;
	protected String sprite;
	protected String direccion;
	protected HiloControles control;
	protected boolean quieto;
	protected ArmaSanitaria arma;
	
	public Personaje(JLabel label) {
		tipo="Personaje";
		this.label=label;
		control = new HiloControles(label);
		control.start();
		cargaViral=0;
		velocidad=10;
		sprite="Sprites\\Personaje e Infectados\\personaje.gif";
		direccion = "Derecha";
		quieto = true;
		arma=new ArmaSanitaria(10,10,"Sprites\\Disparos\\DisparoPersonaje.png");
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
		if(label.getX()<688) {
			if(quieto){
				label.setBounds(label.getX()+velocidad,label.getY(), 199, 150);
				quieto = false;
			}
			label.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeDerecha.gif"));
			control.setVelocidad(velocidad);
			direccion = "Derecha";
		} else {
			quieto();
		}
	}
	
	public void moverIzquierda() {
		if((label.getX()>-32)) {
			if(quieto){
				label.setBounds(label.getX()-velocidad,label.getY(), 199, 150);
				quieto = false;
			}
			label.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeIzquierda.gif"));
			control.setVelocidad(-velocidad);
			direccion = "Izquierda";
		} else {
			quieto();
		}
	}
	
	public void quieto() {
		quieto = true;
		control.setVelocidad(0);
		label.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeQuieto"+direccion+".gif"));		
	}

	public DisparoSanitario disparar() {
		quieto();
		label.setIcon(new ImageIcon("Sprites\\Personaje e Infectados\\personajeDisparando"+direccion+".gif"));	
		DisparoSanitario disparo=arma.crearDisparo(label.getX()+(label.getHeight()/2),label.getY());
		
		return disparo;
	}

	public void mover() {
		// TODO Auto-generated method stub
		
	}

	public boolean esInfectado() {
		return false;
	}
}
