package Infectados;

import javax.swing.JLabel;

import Arma.ArmaInfectado;
import Disparos.DisparoInfectado;
import States.Estado;
import States.EstadoBerserk;
import States.EstadoNormal;

public class Alfa extends Infectado{
	
	protected Estado estadoActual;

	public Alfa(JLabel label) {
		super(label);
		sprite="Sprites\\Personaje e Infectados\\InfectadoAlfa.gif";
		velocidad=10;
		estadoActual=new EstadoNormal(this);
		arma=new ArmaInfectado(velocidad*10, 5, 20, "Sprites\\Disparos\\DisparoAlfa.png");
		resistencia = 1;
	}
	
	public void mover() {
		estadoActual.mover();
	}

	public Estado getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(Estado estadoActual) {
		this.estadoActual = estadoActual;
	}
	
}
