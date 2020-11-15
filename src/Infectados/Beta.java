package Infectados;

import javax.swing.JLabel;

import Arma.ArmaInfectado;
import Disparos.DisparoInfectado;

public class Beta extends Infectado{

	public Beta(JLabel label) {
		super(label);
		sprite="Sprites\\\\Personaje e Infectados\\\\InfectadoBeta.gif";
		velocidad=10;
		arma=new ArmaInfectado(velocidad*10, 5, 20, "Sprites\\Disparos\\DisparoBeta.png");
	}
	
	public void mover() {
		if(labelInfectado.getY()<820)
			labelInfectado.setBounds(labelInfectado.getX(),labelInfectado.getY()+getVelocidad(), 199, 150);
		else
			labelInfectado.setBounds(labelInfectado.getX(),0, 199, 150);
	}
	
	
}
