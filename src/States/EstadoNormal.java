package States;

import Infectados.Infectado;

public class EstadoNormal extends Estado{

	public EstadoNormal(Infectado infectado) {
		super(infectado);
	}
	
	public void mover() {
			if(miInfectado.getLabelInfectado().getY()<820)
				miInfectado.getLabelInfectado().setBounds(miInfectado.getLabelInfectado().getX(),miInfectado.getLabelInfectado().getY()+miInfectado.getVelocidad(), 199, 150);
			else
				miInfectado.getLabelInfectado().setBounds(miInfectado.getLabelInfectado().getX(),0, 199, 150);
	}
}
