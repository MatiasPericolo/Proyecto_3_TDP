package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Juego.Entidad;
import Jugador.Personaje;

public class VisitorDisparoInfectado extends Visitor {

	public VisitorDisparoInfectado(DisparoInfectado e) {
		super(e);
	}

	public void visitarInfectado(Infectado infectado) {
		
	}

	public void visitarPersonaje(Personaje personaje) {
		System.out.println("Disparo/Personaje");
		DisparoInfectado aux = (DisparoInfectado) miEntidad;
		personaje.setDaño(aux.getDaño());
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		
	}

}
