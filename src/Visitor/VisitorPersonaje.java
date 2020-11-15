package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;

public class VisitorPersonaje extends Visitor{

	public void visitarInfectado(Infectado infectado) {
		System.out.println("Personaje visita Infectado");
		
	}

	public void visitarPersonaje(Personaje personaje) {
		
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		System.out.println("Personaje visita un Disparo");
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		
	}

}
