package Hilos;

import javax.swing.JLabel;

import Jugador.Personaje;

public class HiloControles extends Thread {
	
	protected int velocidad;
	protected JLabel Labelpj;
	protected Personaje pj;
	protected boolean run;
	protected int cooldown;
	
	public HiloControles(Personaje personaje) {
		velocidad = 0;
		cooldown=0;
		pj = personaje;
		Labelpj = personaje.getLabel();
		run = true;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public void run() {
		while(run) {
			if(Labelpj.getX()<689 && Labelpj.getX() > -33)
				Labelpj.setBounds(Labelpj.getX()+velocidad,Labelpj.getY(), Labelpj.getWidth(), Labelpj.getHeight());
			if(pj.isPermisoParaDisparar()==false)
				if(cooldown==10) {
					cooldown=0;
					pj.setPermisoParaDisparar(true);
				}else
					cooldown++;
					
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
