package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Juego.Entidad;
import Jugador.Personaje;

public class VisitorDisparoSanitario extends Visitor {

	public VisitorDisparoSanitario(DisparoSanitario e) {
		super(e);
	}

	public void visitarInfectado(Infectado infectado) {
		DisparoSanitario aux = (DisparoSanitario) miEntidad;
		infectado.setCargaViral(aux.getDaño());
		miEntidad.destruir();
		System.out.println("Carga infectado:"+infectado.getCargaViral());
	}

	public void visitarPersonaje(Personaje personaje) {
		
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		
	}

}
