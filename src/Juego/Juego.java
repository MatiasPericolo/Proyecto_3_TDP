package Juego;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparos.Disparo;
import GUI.Mapa;
import Infectados.Alfa;
import Infectados.Beta;
import Infectados.Infectado;
import Jugador.Personaje;
import Premios.Cuarentena;
import Premios.ObjetoPrecioso;
import Premios.Pocion;
import Premios.Premio;
import Premios.SuperArma;
import Premios.Temporal;

public class Juego {

	protected List<Entidad> listaEntidades;
	protected List<Premio> listaPremios;
	protected Mapa gui;
	protected int cooldownDisparoInfectados;
	protected int cooldownDisparoPersonaje;
	
	public Juego(Mapa gui) {
		this.gui=gui;
		listaEntidades=new LinkedList<Entidad>();
		listaPremios=new LinkedList<Premio>();
		cooldownDisparoInfectados=0;
		cooldownDisparoPersonaje=0;
	}
	
	public void agregarPersonaje(Personaje personaje) {
		listaEntidades.add(personaje);
	}
	
	public void hiloGeneral() {
		mover();
		checkearColision();
		activarPremios();
		comprobarPermiso();
	}
	
	public void generarEnemigoAleatorio() {
		Infectado infectadoAux;
		int random = (int) Math.floor(Math.random()*2);
		if(random == 0) {
			infectadoAux =new Alfa(gui.crearLabel());
		} else {
			infectadoAux =new Beta(gui.crearLabel());
		}
		ImageIcon icon = new ImageIcon(infectadoAux.getSprite());
		infectadoAux.getLabel().setBounds(infectadoAux.getCoordenadaX(), 0, icon.getIconWidth(), icon.getIconHeight());
		infectadoAux.getLabel().setIcon(icon);
		gui.getContentPane().add(infectadoAux.getLabel(),0);
		listaEntidades.add(infectadoAux);
	}
	
	public void crearPremio(int x, int y) {
		Premio premio;
		int random = (int) Math.floor(Math.random()*3);
		if(random == 0) {
			premio=new Cuarentena(x,y,3000);
		} else if(random == 1) {
			premio=new SuperArma(x,y,3000);
		}else {
			premio=new Pocion(x,y);
		}
		
		premio.setLabel(gui.crearLabel());
		premio.getLabel().setBounds(premio.getCoordenadaX(),premio.getCoordenadaY(),50,50);
		premio.getLabel().setIcon(new ImageIcon(premio.getSprite()));
		gui.getContentPane().add(premio.getLabel(),0);
		listaEntidades.add(premio);
		listaPremios.add(premio);
		
	}

	
	public void generarDisparo(Disparo disparo) {
		disparo.setLabel(gui.crearLabel());
		disparo.getLabel().setBounds(disparo.getCoordenadaX(),disparo.getCoordenadaY(),20,22);
		disparo.getLabel().setIcon(new ImageIcon(disparo.getSprite()));
		gui.getContentPane().add(disparo.getLabel(),0);
		listaEntidades.add(disparo);
	}
	
	public boolean colisionan(JLabel label1,JLabel label2) {
		
		if(label1.getBounds().intersects(label2.getBounds()) && label1!=null && label2!=null) {
			return true;
		}else
			return false;
		
	}
	
	public void checkearColision() {
		for(int i=0;i<listaEntidades.size();i++) {
			for(int j=i;j<listaEntidades.size();j++) {
				if(colisionan(listaEntidades.get(i).getLabel(),listaEntidades.get(j).getLabel()) && listaEntidades.get(i).getLabel()!=listaEntidades.get(j).getLabel())
					listaEntidades.get(j).recibir(listaEntidades.get(i).getVisitor());
				
				if(!listaEntidades.get(i).getLabel().isVisible()) {
					if(listaEntidades.get(i).getTipo() == "Infectado") {
						crearPremio(listaEntidades.get(i).getLabel().getX(),listaEntidades.get(i).getLabel().getY());
					}						
					listaEntidades.remove(i);
				}
				if(!listaEntidades.get(j).getLabel().isVisible()) {
					if(listaEntidades.get(j).getTipo() == "Infectado") {
						crearPremio(listaEntidades.get(j).getLabel().getX(),listaEntidades.get(j).getLabel().getY());
					}
					listaEntidades.remove(j);
				}
			}
		}
	}
	
	public void activarPremios() {
		
		
		if(!listaPremios.isEmpty()) {
			for(int i=0;i<listaPremios.size();i++) {
				for(int j=0;j<listaEntidades.size();j++) {
					listaEntidades.get(j).recibir(listaPremios.get(i).getVisitor());
				}
				listaPremios.get(i).setActivado(false);
			}
			for(int i=0;i<listaPremios.size();i++) {
				if(listaPremios.get(i).getTermino()) {
					for(int j=0;j<listaEntidades.size();j++) {
						listaEntidades.get(j).recibir(listaPremios.get(i).getVisitor());
					}
					listaPremios.remove(i);
					i--;
				}
			}
		}
	}
	
	public void mover() {
		for(int i=0;i<listaEntidades.size();i++) {
			listaEntidades.get(i).mover();
			if(listaEntidades.get(i).getTipo()=="Infectado")
				if(cooldownDisparoInfectados==10) {
					generarDisparo(((Infectado)listaEntidades.get(i)).disparar());
					cooldownDisparoInfectados=0;
				}else
					cooldownDisparoInfectados++;
		}
		
	}
	
	public void reproducirSonido(Clip clip) {
		String sonido;
		int random = (int) Math.floor(Math.random()*listaEntidades.size());
		try {
			if(listaEntidades.get(random).getTipo()=="Infectado") {
				sonido = ((Infectado)listaEntidades.get(random)).getSonido();
				clip.open(AudioSystem.getAudioInputStream(new File(sonido)));
				clip.start();
			}
		}
		catch(LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
	public void comprobarPermiso() {
		
		if(((Personaje)listaEntidades.get(0)).isPermisoParaDisparar()==false)
			if(cooldownDisparoPersonaje==10) {
				cooldownDisparoPersonaje=0;
				((Personaje)listaEntidades.get(0)).setPermisoParaDisparar(true);
			}else
				cooldownDisparoPersonaje++;
	}
	
	public boolean checkearJuegoTerminado() {
		boolean termino=true;
		for(int i=0;i<listaEntidades.size() && termino;i++) {
			if(listaEntidades.get(i).getTipo()=="Infectado")
				termino=false;
		}
		
		return termino;
		
	}
	
	public void finalizar() {
		gui.terminar();
	}
}
