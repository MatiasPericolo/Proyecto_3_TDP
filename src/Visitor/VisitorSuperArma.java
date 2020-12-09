package Visitor;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Arma.ArmaSanitaria;
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
			personaje.setArma(new SuperArmaSanitaria(10,10,"Sprites\\Disparos\\SuperDisparoPersonaje.png"));
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File("Sonidos\\HeavyMachineGun.wav")));
				clip.start();
			}
			catch(IOException | LineUnavailableException | UnsupportedAudioFileException e) {
				e.printStackTrace();
			} 
		}
		if(((SuperArma)miEntidad).getTermino()) {
			personaje.setArma(new ArmaSanitaria(10,10,"Sprites\\Disparos\\DisparoPersonaje.png"));
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
