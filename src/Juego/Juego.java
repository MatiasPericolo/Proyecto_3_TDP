package Juego;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import GUI.Mapa;
import Infectados.Alfa;
import Infectados.Beta;
import Infectados.Infectado;

public class Juego {

	protected List<Infectado> listaInfectados;
	protected Mapa gui;
	
	public Juego(Mapa gui) {
		this.gui=gui;
		listaInfectados=new LinkedList<Infectado>();
	}
	
	public void generarEnemigoAleatorio() {
		Infectado infectadoAux;
		int random = (int) Math.floor(Math.random()*2);
		System.out.println(random);
		if(random == 0) {
			infectadoAux =new Alfa(gui.crearLabelEnemigo());
		} else {
			infectadoAux =new Beta(gui.crearLabelEnemigo());
		}
		infectadoAux.getLabelInfectado().setBounds(infectadoAux.getCoordenadaX(), 0, 199, 150);
		infectadoAux.getLabelInfectado().setIcon(new ImageIcon(infectadoAux.getSprite()));
		gui.getContentPane().add(infectadoAux.getLabelInfectado(),0);
		listaInfectados.add(infectadoAux);
		
		
	}
	
	public void mover() {
		for(int i=0;i<listaInfectados.size();i++) {
			listaInfectados.get(i).mover();
		}
	}
	
}
