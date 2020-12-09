package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.VentanaPrincipal.oyenteDificultadFacil;
import Juego.Juego;
import Juego.Nivel;
import Jugador.Personaje;

public class Mapa extends JFrame {
	
	protected JLabel mapaImagen;
	
	protected Personaje personaje;
	
	protected Nivel nivelActual;
	
	protected Juego juego;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mapa frame = new Mapa(6);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Mapa(int dificultad) {
		
		juego=new Juego(this,dificultad);
		nivelActual=new Nivel(juego);
		
		
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
		if(dificultad==10) {
			mapaImagen.setIcon(new ImageIcon("Sprites\\Juego\\mapa_nivel_1.jpg"));
		}
		else {
			mapaImagen.setIcon(new ImageIcon("Sprites\\Juego\\mapa_nivel_2.jpg"));
			
		}
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
	
	public void terminar(boolean gano) {
		
			nivelActual.cortarHilos();
			setVisible(false);
			JFrame frame = new JFrame();
			JLabel fondo=new JLabel();
			ImageIcon imagen;
			if(gano)
				imagen=new ImageIcon("Sprites\\Juego\\victoria.jpg");
			else
				imagen=new ImageIcon("Sprites\\Juego\\derrota.jpg");
			frame.setBounds(0,0,imagen.getIconWidth(),imagen.getIconHeight());
			fondo.setBounds(0,0,imagen.getIconWidth(),imagen.getIconHeight() );
			fondo.setIcon(imagen);
			frame.add(fondo);
			JButton cerrar=new JButton("Cerrar");
			cerrar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);				
				}
			});
			cerrar.setBounds(275, 250, 100, 20);
			fondo.add(cerrar);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        		if(personaje.isPermisoParaDisparar())
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
