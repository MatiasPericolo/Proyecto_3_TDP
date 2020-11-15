package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;

public class VisitorDisparoSanitario extends Visitor {

	public void visitarInfectado(Infectado infectado) {
		System.out.println("Disparo alcanza un Infectado");
		
	}

	public void visitarPersonaje(Personaje personaje) {
		
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		
	}

}
