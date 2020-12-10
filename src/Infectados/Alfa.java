package Infectados;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Arma.ArmaInfectado;
import States.Estado;
import States.EstadoBerserk;
import States.EstadoNormal;

public class Alfa extends Infectado{

	public Alfa(JLabel label) {
		super(label);
		sprite="Sprites\\Personaje e Infectados\\InfectadoAlfa.gif";
		velocidad=10;
		arma=new ArmaInfectado(velocidad*10, 5, 20, "Sprites\\Disparos\\DisparoAlfa.gif");
		resistencia = 1;
		sonido = "Sonidos\\Alfa.wav";
	}
	
	public void recibirCura(int cura) {
		super.recibirCura(cura);
		if(cargaViral<=20 && (cargaViral+(cura/resistencia))>20) {
			this.setEstadoActual(new EstadoBerserk(this));
			sprite="Sprites\\Personaje e Infectados\\InfectadoAlfaBerserk.gif";
			label.setIcon(new ImageIcon(sprite));
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File("Sonidos\\AlfaConvertido.wav")));
				clip.start();
			}
			catch(IOException | LineUnavailableException | UnsupportedAudioFileException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Estado recuperarEstado() {
		Estado state;
		if(cargaViral<=20)
			state=new EstadoBerserk(this);
		else
			state=new EstadoNormal(this);
		return state;
	}
}
