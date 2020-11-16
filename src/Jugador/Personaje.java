package Jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Arma.Arma;
import Arma.ArmaSanitaria;
import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Hilos.HiloControles;
import Juego.Entidad;
import Visitor.Visitor;
import Visitor.VisitorPersonaje;

public class Personaje extends Entidad{

	protected int cargaViral;
	protected int velocidad;
	protected String sprite;
	protected String direccion;
	protected HiloControles control;
	protected boolean quieto;
	protected Arma arma,armaGuardada;
	
	public Arma getArmaGuardada() {
		return armaGuardada;
	}

	public void setArmaGuardada(Arma armaGuardada) {
		this.armaGuardada = armaGuardada;
	}

	public Personaje(JLabel label) {
		visitor=new VisitorPersonaje(this);
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
				label.setBounds(label.getX()+velocidad,label.getY(),  label.getWidth(), label.getHeight());
				quieto = false;
			}
			ImageIcon icon = new ImageIcon("Sprites\\Personaje e Infectados\\personajeDerecha.gif");
			label.setIcon(icon);
			label.setBounds(label.getX(), label.getY(), icon.getIconWidth(), icon.getIconHeight());
			control.setVelocidad(velocidad);
			direccion = "Derecha";
		} else {
			quieto();
		}
	}
	
	public void moverIzquierda() {
		if((label.getX()>-32)) {
			if(quieto){
				label.setBounds(label.getX()-velocidad,label.getY(),  label.getWidth(), label.getHeight());
				quieto = false;
			}
			ImageIcon icon = new ImageIcon("Sprites\\Personaje e Infectados\\personajeIzquierda.gif");
			label.setIcon(icon);
			label.setBounds(label.getX(), label.getY(), icon.getIconWidth(), icon.getIconHeight());
			control.setVelocidad(-velocidad);
			direccion = "Izquierda";
		} else {
			quieto();
		}
	}
	
	public void quieto() {
		quieto = true;
		control.setVelocidad(0);
		ImageIcon icon = new ImageIcon("Sprites\\Personaje e Infectados\\personajeQuieto"+direccion+".gif");
		label.setIcon(icon);
		label.setBounds(label.getX(), label.getY(), icon.getIconWidth(), icon.getIconHeight());	
	}

	public DisparoSanitario disparar() {
		quieto();
		ImageIcon icon = new ImageIcon("Sprites\\Personaje e Infectados\\personajeDisparando"+direccion+".gif");	
		label.setIcon(icon);
		label.setBounds(label.getX(), label.getY(), icon.getIconWidth(), icon.getIconHeight());	
		DisparoSanitario disparo=(DisparoSanitario)arma.crearDisparo(label.getX()+(label.getWidth()/2),label.getY());
		
		return disparo;
	}

	public void mover() {
		
	}
	
	public void recibirVirus(int daño) {
		cargaViral +=daño;	
	}

	public void recibir(Visitor visitor) {
		visitor.visitarPersonaje(this);
	}
	
	public void destruir() {
		
	}
	
	public void setArma(Arma arma) {
		this.arma=arma;
	}
	
	public Arma getArma() {
		return arma;
	}
}
