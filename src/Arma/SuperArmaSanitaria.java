package Arma;

import Disparos.DisparoSanitario;

public class SuperArmaSanitaria extends Arma{
	
	public SuperArmaSanitaria(int vel, int da�o,String img) {
		velocidad=vel;
		this.da�o=da�o;
		spriteDisparo=img;
	}
	
	public DisparoSanitario crearDisparo(int x, int y) {
		DisparoSanitario disparo=new DisparoSanitario(x,y,velocidad,da�o*2,spriteDisparo);
		
		return disparo;
	}

}
