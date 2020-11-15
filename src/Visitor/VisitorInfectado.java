package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Juego.Entidad;
import Jugador.Personaje;
import Premios.Premio;

public class VisitorInfectado extends Visitor{

	public VisitorInfectado(Infectado e) {
		super(e);
	}

	public void visitarInfectado(Infectado infectado) {
		
	}

	public void visitarPersonaje(Personaje personaje) {
		Infectado aux = (Infectado) miEntidad;
		personaje.recibirVirus(100);
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		Infectado aux = (Infectado) miEntidad;
		aux.recibirCura(disparo.getDaño());
		disparo.destruir();
	}

	@Override
	public void visitarPremio(Premio premio) {
		
	}

}
