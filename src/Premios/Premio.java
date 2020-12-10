package Premios;

import Juego.Entidad;
import Visitor.Visitor;

public class Premio extends Entidad {

	protected int coordenadaX;
	protected int coordenadaY;
	protected String efecto;
	protected boolean activado;
	protected boolean termino;
	protected boolean temporal;
	
	public boolean isTemporal() {
		return temporal;
	}

	public void setTemporal(boolean temporal) {
		this.temporal = temporal;
	}

	public Premio(int x, int y) {
		coordenadaX=x;
		coordenadaY=y;
		activado=false;
		termino=false;
		valiosa=false;
	}
	
	public boolean getTermino() {
		return termino;
	}

	public void setTermino(boolean termino) {
		this.termino = termino;
	}

	public boolean isActivado() {
		return activado;
	}

	public void setActivado(boolean activado) {
		this.activado = activado;
	}

	public void mover() {
		if(label.getY()<820)
			label.setBounds(label.getX(),label.getY()+30, 199, 150);
		else
			destruir();
	}
	
	public void setCoordenadaX(int x) {
		coordenadaX = x;
	}
	
	public int getCoordenadaX() {
		return coordenadaX;
	}
	
	public void setCoordenadaY(int y) {
		coordenadaY = y;
	}
	
	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void destruir() {
		termino=true;
		label.setVisible(false);
	}

	public void recibir(Visitor visitor) {
		visitor.visitarPremio(this);
	}

	public String getEfecto() {
		return efecto;
	}

	public void setEfecto(String efecto) {
		this.efecto = efecto;
	}
	
	
}
