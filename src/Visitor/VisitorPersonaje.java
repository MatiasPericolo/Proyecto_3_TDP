package Visitor;

import java.util.Timer;
import java.util.TimerTask;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;
import Premios.Premio;
import Premios.Temporal;

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

	public void visitarPremio(Premio premio) {
		premio.setActivado(true);
		if(premio.isTemporal()){
			TimerTask tarea = new TimerTask() {
				int segundos = 0;
				public void run() {
					if(segundos == ((Temporal)premio).getTiempo()) {
						premio.setTermino(true);
						cancel();
					}
					else {
						segundos = segundos + 1000;
					}
				}
			};
			
			Timer tiempo = new Timer();
			tiempo.schedule(tarea, 0, 1000);
		}
		premio.getLabel().setVisible(false);
	}

}
