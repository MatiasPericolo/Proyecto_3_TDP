package Arma;

import Disparos.Disparo;

public abstract class Arma {
	
	protected int velocidad;
	protected int da�o;
	protected String spriteDisparo;

	public abstract Disparo crearDisparo(int x, int y);
	
}
