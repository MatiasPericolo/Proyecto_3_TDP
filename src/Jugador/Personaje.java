package Jugador;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Arma.Arma;
import Arma.ArmaSanitaria;
import Disparos.DisparoSanitario;
import Juego.Entidad;
import Visitor.Visitor;
import Visitor.VisitorPersonaje;

public class Personaje extends Entidad{

	protected int cargaViral;
	protected int velocidad;
	protected String sprite;
	protected String direccion;
	protected boolean quieto;
	protected Arma arma;
	protected boolean permisoParaDisparar;

	public Personaje(JLabel label) {
		visitor=new VisitorPersonaje(this);
		this.label=label;
		cargaViral=0;
		velocidad=10;
		sprite="Sprites\\Personaje e Infectados\\personaje.gif";
		direccion = "Derecha";
		quieto = true;
		arma=new ArmaSanitaria(10,10,"Sprites\\Disparos\\DisparoPersonaje.png");
		permisoParaDisparar=true;
		valiosa=false;
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
			ImageIcon icon = new ImageIcon("Sprites\\Personaje e Infectados\\personajeDerecha.gif");
			label.setIcon(icon);
			label.setBounds(label.getX()+velocidad,label.getY(),  label.getWidth(), label.getHeight());
			direccion = "Derecha";
		}
	}
	
	public void moverIzquierda() {
		if(label.getX()>-32) {
			ImageIcon icon = new ImageIcon("Sprites\\Personaje e Infectados\\personajeIzquierda.gif");
			label.setIcon(icon);
			label.setBounds(label.getX()-velocidad,label.getY(),  label.getWidth(), label.getHeight());
			direccion = "Izquierda";
		}
	}
	
	public void quieto() {
		quieto = true;
		ImageIcon icon = new ImageIcon("Sprites\\Personaje e Infectados\\personajeQuieto"+direccion+".gif");
		label.setIcon(icon);
		label.setBounds(label.getX(), label.getY(), icon.getIconWidth(), icon.getIconHeight());	
	}

	public DisparoSanitario disparar() {
			permisoParaDisparar=false;
			quieto();
			ImageIcon icon = new ImageIcon("Sprites\\Personaje e Infectados\\personajeDisparando"+direccion+".gif");	
			label.setIcon(icon);
			label.setBounds(label.getX(), label.getY(), icon.getIconWidth(), icon.getIconHeight());	
			DisparoSanitario disparo=(DisparoSanitario)arma.crearDisparo(label.getX()+(label.getWidth()/2),label.getY());
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File("Sonidos\\DisparoSanitario.wav")));
				clip.start();
			}
			catch(IOException | LineUnavailableException | UnsupportedAudioFileException e) {
				e.printStackTrace();
			}
			
			
		return disparo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isQuieto() {
		return quieto;
	}

	public void setQuieto(boolean quieto) {
		this.quieto = quieto;
	}

	public boolean isPermisoParaDisparar() {
		return permisoParaDisparar;
	}

	public void setPermisoParaDisparar(boolean permisoParaDisparar) {
		this.permisoParaDisparar = permisoParaDisparar;
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
		label.setVisible(false);
	}
	
	public void setArma(Arma arma) {
		this.arma=arma;
	}
	
	public Arma getArma() {
		return arma;
	}
	
	
}
