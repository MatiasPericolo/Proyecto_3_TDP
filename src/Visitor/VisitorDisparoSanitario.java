package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;
import Premios.Premio;

public class VisitorDisparoSanitario extends Visitor {

	public VisitorDisparoSanitario(DisparoSanitario e) {
		super(e);
	}

	public void visitarInfectado(Infectado infectado) {
		DisparoSanitario aux = (DisparoSanitario) miEntidad;
		infectado.recibirCura(aux.getDaño());
		miEntidad.destruir();
	}

	public void visitarPersonaje(Personaje personaje) {
		
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		
	}

	@Override
	public void visitarPremio(Premio premio) {
		
	}

}
