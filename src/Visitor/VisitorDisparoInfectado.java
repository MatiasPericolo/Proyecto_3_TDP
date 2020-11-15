package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;

public class VisitorDisparoInfectado extends Visitor {

	public void visitarInfectado(Infectado infectado) {
		
	}

	public void visitarPersonaje(Personaje personaje) {
		System.out.println("Disparo alcanza al personaje");
		
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		
	}

}
