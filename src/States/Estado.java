package States;

import Infectados.Infectado;

public class Estado {

	protected Infectado miInfectado;
	protected int prioridad;
	
	public Estado(Infectado infectado) {
		miInfectado=infectado;
	}
	
	public void mover() {
		
	}
	
	public String toString() {
		return null;
	}

	public int getPrioridad() {
		return prioridad;
	}
	
	public boolean esPrioridadQue(Estado estado) {
		return (prioridad>estado.getPrioridad());
	}
}
