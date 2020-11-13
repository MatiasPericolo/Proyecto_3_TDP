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

import Jugador.Personaje;

public class Mapa extends JFrame {
	
	protected JLabel mapaImagen;
	
	protected Personaje personaje;

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
            
        	JLabel labelPersonaje=personaje.getLabelPersonaje();
        	System.out.println(labelPersonaje.getX());
        	
        	if((arg0.getKeyCode() == KeyEvent.VK_D) && (labelPersonaje.getX()<688)) {
        		labelPersonaje.setBounds(labelPersonaje.getX()+personaje.getVelocidad(),labelPersonaje.getY(), 199, 150);
        	}
        	
        	if((arg0.getKeyCode() == KeyEvent.VK_A)  && (labelPersonaje.getX()>-32)) {
        		labelPersonaje.setBounds(labelPersonaje.getX()-personaje.getVelocidad(),labelPersonaje.getY(), 199, 150);
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
