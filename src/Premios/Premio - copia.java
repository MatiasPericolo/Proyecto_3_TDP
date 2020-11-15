package Premios;

import Juego.Entidad;
import Visitor.Visitor;

public class Premio extends Entidad {

	protected int velocidad;
	protected int coordenadaX;
	protected int coordenadaY;
	protected String sprite;
	protected String [] efectos;
	protected String efecto;
	
	@Override
	public void mover() {
		if(label.getY()<820)
			label.setBounds(label.getX(),label.getY()+velocidad, 199, 150);
		else
			label.setBounds(label.getX(),0, 199, 150);
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
	
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public void setSprite(String s) {
		sprite = s;
	}
	
	public String getSprite() {
		return sprite;
	}
	
	public void setEfecto(int e) {
		efecto = efectos[e];
	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibir(Visitor visitor) {
		
	}
	
}
