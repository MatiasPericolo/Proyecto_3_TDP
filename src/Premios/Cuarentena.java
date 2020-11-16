package Premios;

import javax.swing.JLabel;

import Visitor.VisitorCuarentena;

public class Cuarentena extends Temporal {

	public Cuarentena(int x, int y, int t) {
		super(x, y, t);
		efecto="Cuarentena";
		sprite="Sprites\\Premios\\Cuarentena.png";
		visitor=new VisitorCuarentena(this);
	}

}
