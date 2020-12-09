package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;
import Premios.Cuarentena;
import Premios.Premio;
import States.EstadoQuieto;

public class VisitorCuarentena extends Visitor{

	public VisitorCuarentena(Cuarentena e) {
		super(e);
	}
	
	public void visitarInfectado(Infectado infectado) {
		if(((Cuarentena)miEntidad).isActivado()) {
			infectado.setEstadoActual(new EstadoQuieto(infectado));
		}
		if(((Cuarentena)miEntidad).getTermino()) {
			infectado.setEstadoActual(infectado.recuperarEstado());
		}
		
			
	}

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
