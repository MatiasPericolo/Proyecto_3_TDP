package Infectados;

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
	protected Estado estadoActual,estadoGuardado;
	protected int coordenadaX;
	protected ArmaInfectado arma;
	protected int resistencia;
	protected String sonido;

	
	public Infectado(JLabel label) {
		tipo="Infectado";
		visitor=new VisitorInfectado(this);
		cargaViral=100;
		coordenadaX=((int) (Math.random()*720))-32;
		estadoActual=new EstadoNormal(this);
		this.label=label;
		estadoGuardado=new EstadoNormal(this);
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
	
	public Estado getEstadoGuardado() {
		return estadoGuardado;
	}

	public void setEstadoGuardado(Estado estadoGuardado) {
		this.estadoGuardado = estadoGuardado;
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
}
