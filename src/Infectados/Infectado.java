package Infectados;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;

import Arma.ArmaInfectado;
import Disparos.DisparoInfectado;
import Juego.Entidad;
import States.Estado;
import States.EstadoNormal;
import Visitor.Visitor;
import Visitor.VisitorInfectado;

public class Infectado extends Entidad{
	
	protected int cargaViral;
	protected int velocidad;
	protected Estado estadoActual;
	protected int coordenadaX;
	protected ArmaInfectado arma;
	protected int resistencia;
	protected String sonido;

	
	public Infectado(JLabel label) {
		visitor=new VisitorInfectado(this);
		cargaViral=100;
		coordenadaX=((int) (Math.random()*720))-32;
		estadoActual=new EstadoNormal(this);
		this.label=label;
		valiosa=true;
	}

	public DisparoInfectado disparar() {
		DisparoInfectado disparo=arma.crearDisparo(label.getX()+(label.getHeight()/2),label.getY());
		
		return disparo;
	}
	
	public void destruir() {
		label.setVisible(false);
	}

	public void recibir(Visitor visitor) {
		visitor.visitarInfectado(this);
	}
	
	public void recibirCura(int cura) {
		cargaViral -= cura/resistencia;
		if(cargaViral == 80) {
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File(sonido)));
				clip.start();
			}
			catch(IOException | LineUnavailableException | UnsupportedAudioFileException e) {
				e.printStackTrace();
			}
		}
		if(cargaViral <= 0) {
			destruir();
		}
	}
	
	public void mover() {
		estadoActual.mover();
	}

	public Estado getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(Estado estadoActual) {
		this.estadoActual = estadoActual;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
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
	
	public void setSonido(String sonido) {
		this.sonido = sonido;
	}
	
	public String getSonido() {
		return sonido;
	}
	
	public Estado recuperarEstado() {
		return new EstadoNormal(this);
	}
	
}
