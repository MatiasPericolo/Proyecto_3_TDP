package Infectados;

import javax.swing.JLabel;
import Arma.ArmaInfectado;

public class Beta extends Infectado{
	
	public Beta(JLabel label) {
		super(label);
		sprite="Sprites\\\\Personaje e Infectados\\\\InfectadoBeta.gif";
		velocidad=10;
		arma=new ArmaInfectado(velocidad*10, 5, 20, "Sprites\\Disparos\\DisparoBeta.gif");
		resistencia = 2;
		sonido = "Sonidos\\Beta.wav";
	}	
	
}
