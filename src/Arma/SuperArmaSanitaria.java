package Arma;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Disparos.DisparoSanitario;

public class SuperArmaSanitaria extends Arma{
	
	public SuperArmaSanitaria(int vel, int da�o,String img) {
		velocidad=vel;
		this.da�o=da�o;
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
		DisparoSanitario disparo=new DisparoSanitario(x,y,velocidad,da�o*2,spriteDisparo);
		
		return disparo;
	}

}
