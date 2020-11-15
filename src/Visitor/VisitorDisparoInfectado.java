package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Juego.Entidad;
import Jugador.Personaje;
import Premios.Premio;

public class VisitorDisparoInfectado extends Visitor {

	public VisitorDisparoInfectado(DisparoInfectado e) {
		super(e);
	}

	public void visitarInfectado(Infectado infectado) {
		
	}

	public void visitarPersonaje(Personaje personaje) {
		DisparoInfectado aux = (DisparoInfectado) miEntidad;
		personaje.recibirVirus(aux.getDaño());
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		
	}

	@Override
	public void visitarPremio(Premio premio) {
		
	}

}
