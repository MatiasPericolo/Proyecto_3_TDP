package Premios;

import Visitor.VisitorSuperArma;

public class SuperArma extends Temporal{

	public SuperArma(int x, int y, int t) {
		super(x, y, t);
		efecto="SuperArma";
		sprite="Sprites\\Premios\\SuperArma.png";
		visitor=new VisitorSuperArma(this);
	}

}
