package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

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
			
			Mapa frame = new Mapa();
			frame.setVisible(true);
			setVisible(false);
			
		}
	}
	
	class oyenteSalir implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
