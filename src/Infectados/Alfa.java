package Infectados;

import javax.swing.JLabel;

import Arma.ArmaInfectado;
import Disparos.DisparoInfectado;
import States.Estado;
import States.EstadoBerserk;
import States.EstadoNormal;

public class Alfa extends Infectado{

	public Alfa(JLabel label) {
		super(label);
		sprite="Sprites\\Personaje e Infectados\\InfectadoAlfa.gif";
		velocidad=10;
		arma=new ArmaInfectado(velocidad*10, 5, 20, "Sprites\\Disparos\\DisparoAlfa.png");
		resistencia = 1;
	}
	
	
	
}
