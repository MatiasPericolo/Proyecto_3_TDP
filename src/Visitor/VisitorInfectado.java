package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Juego.Entidad;
import Jugador.Personaje;

public class VisitorInfectado extends Visitor{

	public VisitorInfectado(Infectado e) {
		super(e);
	}

	public void visitarInfectado(Infectado infectado) {
		
	}

	public void visitarPersonaje(Personaje personaje) {
		Infectado aux = (Infectado) miEntidad;
		personaje.setDaño(100);
		System.out.println(personaje.getCargaViral());
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		Infectado aux = (Infectado) miEntidad;
		aux.setCargaViral(disparo.getDaño());
		disparo.destruir();
		System.out.println("Carga infectado:"+aux.getCargaViral());
	}

}
