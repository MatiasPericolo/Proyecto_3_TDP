package Premios;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Visitor.VisitorCuarentena;

public class Cuarentena extends Temporal {

	public Cuarentena(int x, int y, int t) {
		super(x, y, t);
		efecto="Cuarentena";
		sprite="Sprites\\Premios\\Cuarentena.png";
		visitor=new VisitorCuarentena(this);
		
	}

}
