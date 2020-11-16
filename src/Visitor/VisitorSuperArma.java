package Visitor;

import Arma.SuperArmaSanitaria;
import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;
import Premios.Cuarentena;
import Premios.Premio;
import Premios.SuperArma;
import States.EstadoQuieto;

public class VisitorSuperArma extends Visitor{

	public VisitorSuperArma(SuperArma e) {
		super(e);
	}
	
	public void visitarInfectado(Infectado infectado) {
			
	}

	public void visitarPremio(Premio premio) {
		// TODO Auto-generated method stub
		
	}

	public void visitarPersonaje(Personaje personaje) {
		if(((SuperArma)miEntidad).isActivado()) {
			personaje.setArmaGuardada(personaje.getArma());
			personaje.setArma(new SuperArmaSanitaria(10,10,"Sprites\\Disparos\\SuperDisparoPersonaje.png"));
		}
		if(((SuperArma)miEntidad).getTermino()) {
			personaje.setArma(personaje.getArmaGuardada());
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
