package States;

import Infectados.Infectado;

public class EstadoBerserk extends Estado{

	public EstadoBerserk(Infectado infectado) {
		super(infectado);
	}
	
	public void mover() {
			if(miInfectado.getLabelInfectado().getY()<820)
				miInfectado.getLabelInfectado().setBounds(miInfectado.getLabelInfectado().getX(),miInfectado.getLabelInfectado().getY()+(miInfectado.getVelocidad()*2), 199, 150);
			else
				miInfectado.getLabelInfectado().setBounds(miInfectado.getLabelInfectado().getX(),0, 199, 150);
	}
	
}
