package Infectados;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Arma.ArmaInfectado;
import States.EstadoBerserk;

public class Alfa extends Infectado{

	public Alfa(JLabel label) {
		super(label);
		sprite="Sprites\\Personaje e Infectados\\InfectadoAlfa.gif";
		velocidad=10;
		arma=new ArmaInfectado(velocidad*10, 5, 20, "Sprites\\Disparos\\DisparoAlfa.png");
		resistencia = 1;
		sonido = "Sonidos\\Alfa.wav";
	}
	
	public void recibirCura(int cura) {
		int curaTotal=cura/resistencia;
		cargaViral -= curaTotal;
		if(cargaViral<=20 && (cargaViral+curaTotal)>20) {
			estadoActual=new EstadoBerserk(this);
			estadoGuardado=new EstadoBerserk(this);
			//sprite="Sprites\\Personaje e Infectados\\InfectadoAlfaBerserk.gif";
			//label.setIcon(new ImageIcon(sprite));
		}
		if(cargaViral <= 0) {
			destruir();
		}
	}
}
