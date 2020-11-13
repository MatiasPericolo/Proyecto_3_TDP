package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Infectados.Alfa;
import Infectados.Beta;
import Juego.Nivel;
import Jugador.Personaje;

public class Mapa extends JFrame {
	
	protected JLabel mapaImagen;
	
	protected Personaje personaje;
	protected Beta infectadoBeta;
	protected Alfa infectadoAlfa;
	
	protected Nivel nivelActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mapa frame = new Mapa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mapa() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 0, 810, 1000);
		getContentPane().setLayout(null);
		setResizable(false);
			
		JLabel labelPersonaje = new JLabel();
		labelPersonaje.setBounds(288, 810, 199, 150);
		personaje=new Personaje(labelPersonaje);
		labelPersonaje.setIcon(new ImageIcon(personaje.getSprite()));
		getContentPane().add(labelPersonaje);
		
		JLabel labelInfectadoBeta = new JLabel();
		infectadoBeta=new Beta(labelInfectadoBeta);
		labelInfectadoBeta.setBounds(infectadoBeta.getCoordenadaX(), 0, 199, 150);
		labelInfectadoBeta.setIcon(new ImageIcon(infectadoBeta.getSprite()));
		getContentPane().add(labelInfectadoBeta);
		
		JLabel labelInfectadoAlfa = new JLabel();
		infectadoAlfa=new Alfa(labelInfectadoAlfa);
		labelInfectadoAlfa.setBounds(infectadoAlfa.getCoordenadaX(), 0, 199, 150);
		labelInfectadoAlfa.setIcon(new ImageIcon(infectadoAlfa.getSprite()));
		getContentPane().add(labelInfectadoAlfa);
		
		mapaImagen=new JLabel();
		mapaImagen.setIcon(new ImageIcon("Sprites\\Juego\\mapa_nivel_1.jpg"));
		mapaImagen.setBounds(0, 0, 800, 1000);
		getContentPane().add(mapaImagen);
		
		addKeyListener(new teclasListener());
		
		setVisible(true);
		setVisible(false);
		
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
        	
        	if(arg0.getKeyCode() == KeyEvent.VK_J) {
        		infectadoBeta.mover();
        		infectadoAlfa.mover();
        	}
        	
        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub
        }

    }
}
