package Juego;

import javax.swing.JLabel;

public abstract class Entidad {

	protected JLabel label;
	protected String sprite;
	
	public abstract void mover();
	
	public abstract boolean esInfectado();
	
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
}
