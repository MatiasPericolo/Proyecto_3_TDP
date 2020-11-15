package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Juego.Entidad;
import Jugador.Personaje;
import Premios.Premio;

public class VisitorPremio extends Visitor {

	public VisitorPremio(Premio e) {
		super(e);
	}

	@Override
	public void visitarInfectado(Infectado infectado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitarPremio(Premio premio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitarPersonaje(Personaje personaje) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		// TODO Auto-generated method stub

	}

}
