package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JFrame ventanaElegirNivel;
	private JPanel panelElegirNivel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1200, 770);
		getContentPane().setLayout(null);
		
		JButton botonJugar = new JButton("Elegir Nivel");
		oyenteElegirNivel oyenteBotonElegirNivel=new oyenteElegirNivel();
		botonJugar.addActionListener(oyenteBotonElegirNivel);
		botonJugar.setBounds(535, 353, 287, 94);
		getContentPane().add(botonJugar);
		
		JButton botonSalir = new JButton("Salir");
		oyenteSalir oyenteBotonSalir=new oyenteSalir();
		botonSalir.addActionListener(oyenteBotonSalir);
		botonSalir.setBounds(535, 540, 287, 94);
		getContentPane().add(botonSalir);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 1200, 770);
	}
	
	class oyenteElegirNivel implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			JButton btnNivelUno;
			JButton btnNivelDos;
			JLabel fondo;
			
			//Creo la ventana para elegir Nivel
			ventanaElegirNivel=new JFrame("Elegir Nivel");
			ventanaElegirNivel.setBounds(700, 250, 400, 300);
			ventanaElegirNivel.setVisible(true);
			
			//Creo el panel para elegir Nivel
			panelElegirNivel=new JPanel();
			panelElegirNivel.setBorder(new EmptyBorder(5, 5, 5, 5));
			ventanaElegirNivel.setContentPane(panelElegirNivel);
			panelElegirNivel.setLayout(null);
			
			//Creo el boton Nivel uno y lo agrego
			btnNivelUno=new JButton("Nivel 1");
			oyenteDificultadFacil oyenteFacil=new oyenteDificultadFacil();
			btnNivelUno.addActionListener(oyenteFacil);
			btnNivelUno.setBounds(115, 40, 168, 70);
			panelElegirNivel.add(btnNivelUno);
			
			//Creo el boton Nivel dos y lo agrego
			btnNivelDos=new JButton("Nivel 2");
			oyenteDificultadDificil oyenteDificil=new oyenteDificultadDificil();
			btnNivelDos.addActionListener(oyenteDificil);
			btnNivelDos.setBounds(115, 160, 168, 70);
			panelElegirNivel.add(btnNivelDos);
			
			//Creo el fondo
			fondo=new JLabel(new ImageIcon("Sprites\\\\fondo.jpg"));
			panelElegirNivel.add(fondo);
			fondo.setBounds(0,0,400,300);
			fondo.setVisible(true);
			
		}
	}
	
	class oyenteDificultadFacil implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ventanaElegirNivel.setVisible(false);
			setVisible(false);
			Mapa frame = new Mapa(10);
		}
	}
	
	class oyenteDificultadDificil implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ventanaElegirNivel.setVisible(false);
			setVisible(false);
			Mapa frame = new Mapa(20);
		}
	}
	
	class oyenteSalir implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
