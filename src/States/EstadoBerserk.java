package States;

import Infectados.Infectado;

public class EstadoBerserk extends Estado{

	public EstadoBerserk(Infectado infectado) {
		super(infectado);
	}
	
	public void mover() {
			if(miInfectado.getLabel().getY()<820)
				miInfectado.getLabel().setBounds(miInfectado.getLabel().getX(),miInfectado.getLabel().getY()+(miInfectado.getVelocidad()*2), 199, 150);
			else
				miInfectado.getLabel().setBounds(miInfectado.getLabel().getX(),0, 199, 150);
	}
	
}
