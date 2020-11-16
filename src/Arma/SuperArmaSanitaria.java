package Arma;

import Disparos.DisparoSanitario;

public class SuperArmaSanitaria extends Arma{
	
	public SuperArmaSanitaria(int vel, int daño,String img) {
		velocidad=vel;
		this.daño=daño;
		spriteDisparo=img;
	}
	
	public DisparoSanitario crearDisparo(int x, int y) {
		DisparoSanitario disparo=new DisparoSanitario(x,y,velocidad,daño*2,spriteDisparo);
		
		return disparo;
	}

}
