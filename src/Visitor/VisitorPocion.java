package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;
import Premios.Cuarentena;
import Premios.Pocion;
import Premios.Premio;
import States.EstadoQuieto;

public class VisitorPocion extends Visitor{

	public VisitorPocion(Pocion e) {
		super(e);
	}
	
	public void visitarInfectado(Infectado infectado) {	
		// TODO Auto-generated method stub
			
	}

	public void visitarPremio(Premio premio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPersonaje(Personaje personaje) {
		if(((Pocion)miEntidad).isActivado()) {
			personaje.recibirVirus(-20);
			((Pocion)miEntidad).setTermino(true);
		}
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
