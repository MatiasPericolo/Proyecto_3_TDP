package States;

import Infectados.Infectado;

public class EstadoNormal extends Estado{

	public EstadoNormal(Infectado infectado) {
		super(infectado);
		prioridad=1;
	}
	
	public void mover() {
			if(miInfectado.getLabel().getY()<820)
				miInfectado.getLabel().setBounds(miInfectado.getLabel().getX(),miInfectado.getLabel().getY()+miInfectado.getVelocidad(), miInfectado.getLabel().getWidth(), miInfectado.getLabel().getHeight());
			else
				miInfectado.getLabel().setBounds(miInfectado.getLabel().getX(),0, miInfectado.getLabel().getWidth(), miInfectado.getLabel().getHeight());
	}
	
	public String toString() {
		return "Normal";
	}
}
