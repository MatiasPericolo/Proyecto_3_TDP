package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;

public class VisitorInfectado extends Visitor{

	public void visitarInfectado(Infectado infectado) {
		
	}

	public void visitarPersonaje(Personaje personaje) {
		System.out.println("Infectado visita Personaje");
		
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		System.out.println("Infectado visita un Disparo");
		
	}

}
