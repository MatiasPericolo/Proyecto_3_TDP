package States;

import Infectados.Infectado;

public class EstadoNormal extends Estado{

	public EstadoNormal(Infectado infectado) {
		super(infectado);
	}
	
	public void mover() {
			if(miInfectado.getLabel().getY()<820)
				miInfectado.getLabel().setBounds(miInfectado.getLabel().getX(),miInfectado.getLabel().getY()+miInfectado.getVelocidad(), 199, 150);
			else
				miInfectado.getLabel().setBounds(miInfectado.getLabel().getX(),0, 199, 150);
	}
}
