package Juego;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparos.Disparo;
import GUI.Mapa;
import Infectados.Alfa;
import Infectados.Beta;
import Infectados.Infectado;

public class Juego {

	protected List<Infectado> listaInfectados;
	protected List<Disparo> listaDisparos;
	protected List<Entidad> listaEntidades;
	protected Mapa gui;
	protected int cooldown;
	
	public Juego(Mapa gui) {
		this.gui=gui;
		listaInfectados=new LinkedList<Infectado>();
		listaDisparos=new LinkedList<Disparo>();
		listaEntidades=new LinkedList<Entidad>();
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
		infectadoAux.getLabel().setBounds(infectadoAux.getCoordenadaX(), 0, 199, 150);
		infectadoAux.getLabel().setIcon(new ImageIcon(infectadoAux.getSprite()));
		gui.getContentPane().add(infectadoAux.getLabel(),0);
		//listaInfectados.add(infectadoAux);
		listaEntidades.add(infectadoAux);
		
		
	}
	
	public void generarDisparo(Disparo disparo) {
		disparo.setLabel(gui.crearLabel());
		disparo.getLabel().setBounds(disparo.getCoordenadaX(),disparo.getCoordenadaY(),20,22);
		disparo.getLabel().setIcon(new ImageIcon(disparo.getSprite()));
		gui.getContentPane().add(disparo.getLabel(),0);
		//listaDisparos.add(disparo);
		listaEntidades.add(disparo);
	}
	
	public boolean colisionan(JLabel label1,JLabel label2) {
		
		if(label1.getBounds().intersects(label2.getBounds())) {
			return true;
		}else
			return false;
		
	}
	
	public void checkearColision() {
		for(int i=0;i<listaEntidades.size();i++) {
			for(int j=i;j<listaEntidades.size();j++) {
				if(colisionan(listaEntidades.get(i).getLabel(),listaEntidades.get(j).getLabel()))
					i=2;
			}
		}
	}
	
	public void mover() {
		for(int i=0;i<listaEntidades.size();i++) {
			listaEntidades.get(i).mover();
			if(listaEntidades.get(i).esInfectado())
				if(cooldown==10) {
					generarDisparo(((Infectado)listaEntidades.get(i)).disparar());
					cooldown=0;
				}else
					cooldown++;
		}
		
	}
	
}
