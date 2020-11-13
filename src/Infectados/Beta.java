package Infectados;

import javax.swing.JLabel;

public class Beta extends Infectado{

	public Beta(JLabel label) {
		super(label);
		sprite="Sprites\\\\Personaje e Infectados\\\\InfectadoBeta.gif";
		velocidad=10;
	}
	
	public void mover() {
		if(labelInfectado.getY()<820)
			labelInfectado.setBounds(labelInfectado.getX(),labelInfectado.getY()+getVelocidad(), 199, 150);
		else
			labelInfectado.setBounds(labelInfectado.getX(),0, 199, 150);
	}
}
