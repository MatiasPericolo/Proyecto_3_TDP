package Arma;

import Disparos.DisparoSanitario;

public class ArmaSanitaria extends Arma{
	
	public ArmaSanitaria(int vel, int daño,String img) {
		velocidad=vel;
		this.daño=1000;
		spriteDisparo=img;
	}
	
	public DisparoSanitario crearDisparo(int x, int y) {
		DisparoSanitario disparo=new DisparoSanitario(x,y,velocidad,daño,spriteDisparo);
		
		return disparo;
	}

}
