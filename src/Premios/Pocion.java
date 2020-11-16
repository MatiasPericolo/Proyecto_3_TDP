package Premios;

import Visitor.VisitorPocion;

public class Pocion extends ObjetoPrecioso{

	public Pocion(int x, int y) {
		super(x, y);
		efecto = "Pocion";
		sprite = "Sprites\\Premios\\Pocion.png";
		visitor = new VisitorPocion(this);
	}

}
