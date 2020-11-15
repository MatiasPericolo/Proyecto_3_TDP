package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Juego.Entidad;
import Jugador.Personaje;

public class VisitorPersonaje extends Visitor{
	

	public VisitorPersonaje(Personaje e) {
		super(e);
	}

	public void visitarInfectado(Infectado infectado) {
		/*
		Infectado aux = (Infectado) miEntidad;
		personaje.setDaño(100);
		System.out.println(personaje.getCargaViral());
		*/
		Personaje aux = (Personaje) miEntidad;
		
	}

	public void visitarPersonaje(Personaje personaje) {
		
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		
	}

}
