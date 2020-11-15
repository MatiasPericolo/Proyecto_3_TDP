package Juego;

import javax.swing.JLabel;

import Visitor.Visitor;

public abstract class Entidad {

	protected JLabel label;
	protected String sprite;
	protected String tipo;
	protected Visitor visitor;
	
	public abstract void mover();
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel labelInfectado) {
		label = labelInfectado;
	}
	
	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public abstract void recibir(Visitor visitor);
}
