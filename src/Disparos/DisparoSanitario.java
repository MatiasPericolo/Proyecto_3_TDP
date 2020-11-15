package Disparos;

public class DisparoSanitario extends Disparo{
	
	public DisparoSanitario(int x, int y,int vel, int daño,String img) {
		super(x,y,vel,daño,img);
	}
	
	public void mover() {
		label.setBounds(label.getX(),label.getY()-getVelocidad(),20,22);
	}

	public void destruir() {
		label.setVisible(false);
	}
	
}
