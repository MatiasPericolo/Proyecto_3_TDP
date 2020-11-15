package Visitor;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;

public abstract class Visitor {

	public abstract void visitarInfectado(Infectado infectado);
	//public abstract void visitarPremio(Premio premio);
	public abstract void visitarPersonaje(Personaje personaje);
	public abstract void visitarDisparoInfectado(DisparoInfectado disparo);
	public abstract void visitarDisparoSanitario(DisparoSanitario disparo);
}
