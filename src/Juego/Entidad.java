package Juego;

import javax.swing.JLabel;

public abstract class Entidad {

	protected JLabel label;
	
	public abstract void mover();
	
	public abstract boolean esInfectado();
	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel labelInfectado) {
		label = labelInfectado;
	}
}
