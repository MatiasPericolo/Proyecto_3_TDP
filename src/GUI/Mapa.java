package GUI;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Juego.Juego;
import Juego.Nivel;
import Jugador.Personaje;

public class Mapa extends JFrame {
	
	protected JLabel mapaImagen;
	
	protected Personaje personaje;
	
	protected Nivel nivelActual;
	
	protected Juego juego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Mapa frame = new Mapa(1);
	}

	/**
	 * Create the frame.
	 */
	public Mapa(int nivel) {
		
		juego=new Juego(this);
		nivelActual=new Nivel(nivel,juego);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 0, 810, 1000);
		getContentPane().setLayout(null);
		setResizable(false);
			
		JLabel labelPersonaje = new JLabel();
		personaje=new Personaje(labelPersonaje);
		ImageIcon iconPJ = new ImageIcon(personaje.getSprite());
		labelPersonaje.setBounds(288, 810, iconPJ.getIconWidth(), iconPJ.getIconHeight());
		labelPersonaje.setIcon(iconPJ);
		getContentPane().add(labelPersonaje);
		juego.agregarPersonaje(personaje);
		
		mapaImagen=new JLabel();
		if(nivel==10)
			mapaImagen.setIcon(new ImageIcon("Sprites\\Juego\\mapa_nivel_1.jpg"));
		else
			mapaImagen.setIcon(new ImageIcon("Sprites\\Juego\\mapa_nivel_2.jpg"));
		mapaImagen.setBounds(0, 0, 800, 1000);
		getContentPane().add(mapaImagen);
		
		addKeyListener(new teclasListener());
		
		setVisible(true);
		
		nivelActual.iniciarJuego();
	}
	
	public JLabel crearLabel() {
		JLabel labelAux = new JLabel();
		return labelAux;
	}
	
	public Juego getJuego() {
		return juego;
	}
	
	class teclasListener implements KeyListener{

        @Override
        public void keyPressed(KeyEvent arg0) {
            
        	
        	if(arg0.getKeyCode() == KeyEvent.VK_D) {
        		personaje.moverDerecha();
        	}
        	
        	if(arg0.getKeyCode() == KeyEvent.VK_A) {
        		personaje.moverIzquierda();
        	}
        	
        	if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {
        		juego.generarDisparo(personaje.disparar());
        	}
        	
        }

        @Override
        public void keyReleased(KeyEvent arg0) {
        	personaje.quieto();

        }

        @Override
        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub
        }

    }
}
