package States;

import Infectados.Infectado;

public class EstadoQuieto extends Estado{

	public EstadoQuieto(Infectado infectado) {
		super(infectado);
	}

	public void mover() {
		
	}
	
	public String toString() {
		return "Quieto";
	}
}
