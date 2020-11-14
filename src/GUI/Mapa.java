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
		Mapa frame = new Mapa();
	}

	/**
	 * Create the frame.
	 */
	public Mapa() {
		
		juego=new Juego(this);
		nivelActual=new Nivel(3,juego);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 0, 810, 1000);
		getContentPane().setLayout(null);
		setResizable(false);
			
		JLabel labelPersonaje = new JLabel();
		labelPersonaje.setBounds(288, 810, 199, 150);
		personaje=new Personaje(labelPersonaje);
		labelPersonaje.setIcon(new ImageIcon(personaje.getSprite()));
		getContentPane().add(labelPersonaje);
		
		mapaImagen=new JLabel();
		mapaImagen.setIcon(new ImageIcon("Sprites\\Juego\\mapa_nivel_1.jpg"));
		mapaImagen.setBounds(0, 0, 800, 1000);
		getContentPane().add(mapaImagen);
		
		addKeyListener(new teclasListener());
		
		setVisible(true);
		
		nivelActual.iniciarJuego();
	}
	
	public JLabel crearLabelEnemigo() {
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
        		personaje.disparar();
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
