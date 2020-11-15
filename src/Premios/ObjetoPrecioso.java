package Premios;

import javax.swing.JLabel;

public class ObjetoPrecioso extends Premio {
	
	public ObjetoPrecioso(int v, JLabel l) {
		velocidad = v;
		label = l;
		efectos = new String[] {"Pocion"};
		sprites = new String[] {"Sprite\\Premios\\pocion.png"};
	}
	
}
