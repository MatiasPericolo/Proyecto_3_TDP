package Juego;

import javax.swing.JLabel;
import Disparos.Disparo;
import Disparos.DisparoDull;
import Visitor.Visitor;

public abstract class Entidad {

	protected JLabel label;
	protected String sprite;
	protected Visitor visitor;
	protected boolean valiosa;
	
	public boolean isValiosa() {
		return valiosa;
	}
	
	public abstract void mover();
	public abstract void destruir();
	
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
	
	public int generarPremio() {
		return 0;
	}
	
	public Disparo disparar() {
		return new DisparoDull(0,0,0,0,"0");
	}
}
