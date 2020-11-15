package Arma;

import Disparos.DisparoInfectado;

public class ArmaInfectado extends Arma{

	protected int alcance;
	
	public ArmaInfectado(int vel, int da�o,int al,String img) {
		velocidad=vel;
		this.da�o=da�o;
		alcance=al;
		spriteDisparo=img;
	}
	
	public DisparoInfectado crearDisparo(int x, int y) {
		DisparoInfectado disparo=new DisparoInfectado(x,y,velocidad,da�o,spriteDisparo,alcance);
		
		return disparo;
	}

}
