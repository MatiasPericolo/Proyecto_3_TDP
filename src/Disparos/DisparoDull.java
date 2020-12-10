package Disparos;

import Visitor.Visitor;
import Visitor.VisitorDisparoInfectado;

public class DisparoDull extends Disparo{

	public DisparoDull(int x, int y,int vel, int daño,String img) {
		super(x,y,vel,0,img);
		
	}
	
	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibir(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
