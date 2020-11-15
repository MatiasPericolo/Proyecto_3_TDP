package Infectados;

import javax.swing.JLabel;

import Arma.ArmaInfectado;
import Disparos.Disparo;
import Disparos.DisparoInfectado;
import Juego.Entidad;

public class Infectado extends Entidad{
	
	protected int cargaViral;
	protected int velocidad;
	protected int coordenadaX;
	protected ArmaInfectado arma;
	
	public Infectado(JLabel label) {
		tipo="Infectado";
		cargaViral=100;
		coordenadaX=((int) (Math.random()*720))-32;
		this.label=label;
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

	public DisparoInfectado disparar() {
		DisparoInfectado disparo=arma.crearDisparo(label.getX()+(label.getHeight()/2),label.getY());
		
		return disparo;
	}
	
	public void mover() {
		
	}

	public boolean esInfectado() {
		return true;
	}

	
}
