package Arma;

import Disparos.DisparoInfectado;

public class ArmaInfectado extends Arma{

	protected int alcance;
	
	public ArmaInfectado(int vel, int daño,int al,String img) {
		velocidad=vel;
		this.daño=daño;
		alcance=al;
		spriteDisparo=img;
	}
	
	public DisparoInfectado crearDisparo(int x, int y) {
		DisparoInfectado disparo=new DisparoInfectado(x,y,velocidad,daño,spriteDisparo,alcance);
		
		return disparo;
	}

}
