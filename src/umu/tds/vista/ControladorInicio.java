package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ControladorInicio extends JFrame {

	private static CardLayout cl_panelCardLayout;
	private static JPanel panelCardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
					ControladorInicio window = new ControladorInicio();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static void sendLogin(String usuario, String contraseña) {
		// aqui se comprueba que los datos coincidan
		
		// cardLayout.show(cardPanel, "ventanaRegistro");
				VentanaMain app = new VentanaMain();
				app.setVisible(true);
				// setVisible(false);
	}
	
	public static void sendRegister(String email, String contraseña, String nombre, Date fechaNacimiento) {
		// aqui se registrara y ara cosas
		
		VentanaMain app = new VentanaMain();
		app.setVisible(true);
		
	}

	public static void startRegister() {
		cl_panelCardLayout.show(panelCardLayout, "ventanaRegistro");
	}
	
	public static void exitRegister() {
		cl_panelCardLayout.show(panelCardLayout, "ventanaLogin");
	}

	/**
	 * Create the application.
	 */
	public ControladorInicio() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ControladorInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		getContentPane().setLayout(new BorderLayout(0, 0));
		VentanaLogin ventanaLogin = new VentanaLogin();
		VentanaRegistro ventanaRegistro = new VentanaRegistro();

		cl_panelCardLayout = new CardLayout();
		panelCardLayout = new JPanel(cl_panelCardLayout);

		panelCardLayout.add(ventanaLogin, "ventanaLogin");
		panelCardLayout.add(ventanaRegistro, "ventanaRegistro");
		getContentPane().add(panelCardLayout);

		cl_panelCardLayout.show(panelCardLayout, "ventanaLogin");

		JPanel cabezera = new JPanel();
		cabezera.setBackground(Color.BLACK);
		getContentPane().add(cabezera, BorderLayout.NORTH);
		cabezera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(ControladorInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		icono.setHorizontalAlignment(SwingConstants.LEFT);
		icono.setForeground(Color.WHITE);
		cabezera.add(icono);

		JLabel titulo = new JLabel("Spotifoo");
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		cabezera.add(titulo);

		setTitle("Spotifoo");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
