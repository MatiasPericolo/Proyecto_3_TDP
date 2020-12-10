package Visitor;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Disparos.DisparoInfectado;
import Disparos.DisparoSanitario;
import Infectados.Infectado;
import Jugador.Personaje;
import Premios.Cuarentena;
import Premios.Premio;
import States.EstadoQuieto;

public class VisitorCuarentena extends Visitor{

	public VisitorCuarentena(Cuarentena e) {
		super(e);
	}
	
	public void visitarInfectado(Infectado infectado) {
		if(((Cuarentena)miEntidad).isActivado()) {
			infectado.setEstadoActual(new EstadoQuieto(infectado));
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File("Sonidos\\DontMove.wav")));
				clip.start();
			}
			catch(IOException | LineUnavailableException | UnsupportedAudioFileException e) {
				e.printStackTrace();
			}
		}
		if(((Cuarentena)miEntidad).getTermino()) {
			infectado.recuperarEstado();
		}
		
			
	}

	public void visitarPremio(Premio premio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPersonaje(Personaje personaje) {
		// TODO Auto-generated method stub
		
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
