package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Juego.Entidad;
import Jugador.Personaje;
import Premios.Premio;

public class VisitorPersonaje extends Visitor{
	

	public VisitorPersonaje(Personaje e) {
		super(e);
	}

	public void visitarInfectado(Infectado infectado) {
		Personaje aux = (Personaje) miEntidad;
		aux.recibirVirus(100);
				
	}

	public void visitarPersonaje(Personaje personaje) {
		
	}

	public void visitarDisparoInfectado(DisparoInfectado disparo) {
		
	}

	public void visitarDisparoSanitario(DisparoSanitario disparo) {
		
	}

	@Override
	public void visitarPremio(Premio premio) {
		// TODO Auto-generated method stub
		
	}

}
