package Hilos;

import javax.swing.JLabel;

public class HiloControles extends Thread {
	
	protected int velocidad;
	protected JLabel pj;
	protected boolean run;
	
	public HiloControles(JLabel personaje) {
		velocidad = 0;;
		pj = personaje;
		run = true;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public void run() {
		while(run) {
			if(pj.getX()<689 && pj.getX() > -33)
				pj.setBounds(pj.getX()+velocidad,pj.getY(), 199, 150);
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
