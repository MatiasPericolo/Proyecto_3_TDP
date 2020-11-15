package Disparos;

public class DisparoInfectado extends Disparo{

	protected int alcance;
	protected int recorrido;
	
	public DisparoInfectado(int x, int y,int vel, int da�o,String img,int al) {
		super(x,y,vel,da�o,img);
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
	
}
