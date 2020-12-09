package Arma;

import Disparos.DisparoSanitario;

public class ArmaSanitaria extends Arma{
	
	public ArmaSanitaria(int vel, int da�o,String img) {
		velocidad=vel;
		this.da�o=1000;
		spriteDisparo=img;
	}
	
	public DisparoSanitario crearDisparo(int x, int y) {
		DisparoSanitario disparo=new DisparoSanitario(x,y,velocidad,da�o,spriteDisparo);
		
		return disparo;
	}

}
