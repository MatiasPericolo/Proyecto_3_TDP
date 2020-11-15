package Juego;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import Disparos.Disparo;
import GUI.Mapa;
import Infectados.Alfa;
import Infectados.Beta;
import Infectados.Infectado;

public class Juego {

	protected List<Infectado> listaInfectados;
	protected List<Disparo> listaDisparos;
	protected Mapa gui;
	protected int cooldown;
	
	public Juego(Mapa gui) {
		this.gui=gui;
		listaInfectados=new LinkedList<Infectado>();
		listaDisparos=new LinkedList<Disparo>();
		cooldown=0;
	}
	
	public void generarEnemigoAleatorio() {
		Infectado infectadoAux;
		int random = (int) Math.floor(Math.random()*2);
		if(random == 0) {
			infectadoAux =new Alfa(gui.crearLabel());
		} else {
			infectadoAux =new Beta(gui.crearLabel());
		}
		infectadoAux.getLabelInfectado().setBounds(infectadoAux.getCoordenadaX(), 0, 199, 150);
		infectadoAux.getLabelInfectado().setIcon(new ImageIcon(infectadoAux.getSprite()));
		gui.getContentPane().add(infectadoAux.getLabelInfectado(),0);
		listaInfectados.add(infectadoAux);
		
		
	}
	
	public void generarDisparo(Disparo disparo) {
		disparo.setLabel(gui.crearLabel());
		disparo.getLabel().setBounds(disparo.getCoordenadaX(),disparo.getCoordenadaY(),20,22);
		disparo.getLabel().setIcon(new ImageIcon(disparo.getSprite()));
		gui.getContentPane().add(disparo.getLabel(),0);
		listaDisparos.add(disparo);
	}
	
	public void mover() {
		for(int i=0;i<listaInfectados.size();i++) {
			listaInfectados.get(i).mover();
			if(cooldown==10) {
				generarDisparo(listaInfectados.get(i).disparar());
				cooldown=0;
			}else
				cooldown++;
		}
		for(int i=0;i<listaDisparos.size();i++) {
			listaDisparos.get(i).mover();
		}
	}
	
}
