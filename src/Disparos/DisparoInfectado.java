package Disparos;

import Visitor.Visitor;
import Visitor.VisitorDisparoInfectado;

public class DisparoInfectado extends Disparo{

	protected int alcance;
	protected int recorrido;
	
	public DisparoInfectado(int x, int y,int vel, int daño,String img,int al) {
		super(x,y,vel,daño,img);
		visitor=new VisitorDisparoInfectado(this);
		tipo="DisparoInfectado";
		alcance=al;
		recorrido=0;
	}
	
	public void mover() {
		if(recorrido<alcance) {
			label.setBounds(label.getX(),label.getY()+getVelocidad(),20,22);
			recorrido++;
		}else
			this.destruir();
	}

	public void destruir() {
		label.setVisible(false);
	}
	
	public void recibir(Visitor visitor) {
		visitor.visitarDisparoInfectado(this);
	}
}
