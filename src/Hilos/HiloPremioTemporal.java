package Hilos;

import Premios.Temporal;

public class HiloPremioTemporal extends Thread{
		protected boolean run;
		protected int duracion;
		protected Temporal miObjeto;
		
		public HiloPremioTemporal(Temporal temp) {
			run=true;
			miObjeto=temp;
			duracion=temp.getTiempo();	
		}
		
		public void run() {
			while(run){
				try {
					Thread.sleep(duracion);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				run=false;
				miObjeto.setTermino(true);
			}
		}

	
}
