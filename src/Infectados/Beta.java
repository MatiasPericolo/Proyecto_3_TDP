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
		resistencia = 2;
	}
	
	public void mover() {
		if(label.getY()<820)
			label.setBounds(label.getX(),label.getY()+getVelocidad(), label.getWidth(), label.getHeight());
		else
			label.setBounds(label.getX(),0, label.getWidth(), label.getHeight());
	}
	
	
}
