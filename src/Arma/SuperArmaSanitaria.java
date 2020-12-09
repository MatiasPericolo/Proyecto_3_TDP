package Arma;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Disparos.DisparoSanitario;

public class SuperArmaSanitaria extends Arma{
	
	public SuperArmaSanitaria(int vel, int daño,String img) {
		velocidad=vel;
		this.daño=daño;
		spriteDisparo=img;
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File("Sonidos\\HeavyMachineGun.wav")));
			clip.start();
		}
		catch(IOException | LineUnavailableException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
	public DisparoSanitario crearDisparo(int x, int y) {
		DisparoSanitario disparo=new DisparoSanitario(x,y,velocidad,daño*2,spriteDisparo);
		
		return disparo;
	}

}
