package Juego;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.IIOException;
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
import Premios.Pocion;
import Premios.Premio;
import Premios.SuperArma;

public class Juego {

	protected List<Entidad> listaEntidades;
	protected List<Premio> listaPremios;
	protected Mapa gui;
	protected int cooldownDisparoInfectados;
	protected int cooldownDisparoPersonaje;
	protected int cooldownOleadaInfectados;
	protected int cantidadInfectados;
	protected int finOleada;
	protected boolean generarInfectado;
	protected Clip clip;
	protected TimerTask tarea;
	
	public Juego(Mapa gui,int dificultad) {
		this.gui=gui;
		cantidadInfectados=dificultad;
		finOleada=cantidadInfectados/2;
		generarInfectado=true;
		listaEntidades=new LinkedList<Entidad>();
		listaPremios=new LinkedList<Premio>();
		cooldownDisparoInfectados=0;
		cooldownDisparoPersonaje=0;
		cooldownOleadaInfectados=0;
		iniciarMusicaNivel(dificultad/10);
	}
	
	public void agregarPersonaje(Personaje personaje) {
		listaEntidades.add(personaje);
	}
	
	public void hiloGeneral() {
		mover();
		activarPremios();
		comprobarPermiso();
		controlDeOleadas();
		checkearColision();
	}
	
	public void controlDeOleadas() {
		boolean esperar=false;;
		
		if(finOleada==cantidadInfectados)
			if(cooldownOleadaInfectados<100) {
				esperar=true;
				cooldownOleadaInfectados++;
			}
		
		if(!esperar) {
			if(generarInfectado) {
				cantidadInfectados--;
				generarEnemigoAleatorio();
			}
			
			if(cantidadInfectados==0) {
				generarInfectado=false;
				if(checkearJuegoTerminado())
					finalizar(true);
			}
		}
		
			
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
		checkearPremiosActivos(listaEntidades.get(listaEntidades.size()-1));
    }

    public void checkearPremiosActivos(Entidad infectado){

        if(!listaPremios.isEmpty()) 
            for(int i=0;i<listaPremios.size();i++) {
                listaPremios.get(i).setActivado(true);
                infectado.recibir(listaPremios.get(i).getVisitor());
                listaPremios.get(i).setActivado(false);
            }

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
					if(i==0)
						finalizar(false);
				} else if(!listaEntidades.get(j).getLabel().isVisible()) {
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
	
	public void reproducirSonidoInfectados() {
		
			tarea = new TimerTask() {
				String sonido;
				Clip clip;
				public void run() {
					try {
						int random = (int) Math.floor(Math.random()*listaEntidades.size());
						if(listaEntidades.get(random).getTipo()=="Infectado") {
							sonido = ((Infectado)listaEntidades.get(random)).getSonido();
							clip = AudioSystem.getClip();
							clip.open(AudioSystem.getAudioInputStream(new File(sonido)));
							clip.start();
						}
						
					}
					catch(LineUnavailableException | IOException | UnsupportedAudioFileException e) {
						e.printStackTrace();
					}
				}
			};
			Timer temporizador = new Timer();
			temporizador.schedule(tarea, 0, 3000);
		
	}
	
	public void iniciarMusicaNivel(int nivel) {
		System.out.println(nivel);
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File("Sonidos\\MusicaNivel-" + nivel + ".wav")));
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		
	}
	
	public void comprobarPermiso() {
		
		if(((Personaje)listaEntidades.get(0)).isPermisoParaDisparar()==false)
			if(cooldownDisparoPersonaje==4) {
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
	
	public void finalizar(boolean victoria) {
		clip.stop();
		tarea.cancel();
		gui.terminar(victoria);
	}
}
