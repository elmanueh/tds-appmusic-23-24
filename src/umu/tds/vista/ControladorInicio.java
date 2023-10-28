package umu.tds.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.usuario.Usuario;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;

public class ControladorInicio extends JFrame {

	private static CardLayout cl_panelCardLayout;
	private static JPanel panelCardLayout;

	public static void sendLogin(String usuario, String contraseña) {
		// aqui se comprueba que los datos coincidan en la base de datos
		boolean login = false;
		boolean contraseñaInvalida = false;
		if (Controlador.getUnicaInstancia().existeUsuario(usuario)) {
			for (Usuario u : Controlador.getUnicaInstancia().getUsuarios()) {
				if (u.getEmail().equals(usuario) || u.getNombre().equals(contraseña)) {
					if (u.getContraseña().equals(contraseña)) {
						System.out.println("SI ES LOGIN"); 
						login =true;
					}
					else {
						System.out.println("CONTRAEÑA NO VALIDA");
						contraseñaInvalida = true;
					}
				}
			}
		}
		if (contraseñaInvalida) {
			
		}
		else if (!login)
			System.out.println("NO EXISTE NOMBRE DE USUARIO O EMAIL");
		else {
			VentanaMain app = new VentanaMain();
			app.setVisible(true);
		}
	}

	public static void sendRegister(String email, String contraseña, String nombre, Date fechaNacimiento) {
		// aqui se registrara y ara cosas
		
		if (email.isEmpty() || contraseña.isEmpty() || nombre.isEmpty() || fechaNacimiento.equals(null))
			System.out.println("NO SE HA PODIDO REGISTRA");
		else {
			Controlador.getUnicaInstancia().registrarUsuario(nombre, email, null, contraseña);
			System.out.println("SI HA PODIDO");
			
			//AQUI SE TIENE QUE LLAMAR A ALGUNA FUNCION QUE ESCONDA LA VENTANA LOGIN Y PONGA ALGO JOptionPane que algun texto
			
			System.out.println("nombre \t email \t contraseña"+ "\n");
			for (Usuario u : Controlador.getUnicaInstancia().getUsuarios()) {
				String n = String.format("%1$-30s", u.getNombre());
				String e = String.format("%1$-30s", u.getEmail());
				String c = String.format("%1$-30s", u.getContraseña());
				System.out.println(n + " " + e + " " + c + " " + "\n");
			}
			VentanaMain app = new VentanaMain();
			app.setVisible(true);
			
		}
		

	}

	public static void startRegister() {
		cl_panelCardLayout.show(panelCardLayout, "ventanaRegistro");
	}

	public static void exitRegister() {
		cl_panelCardLayout.show(panelCardLayout, "ventanaLogin");
	}

	public static void loginGitHub(String usuario, String contraseña) {
		// LO QUE PONE EN LA GUIA ES OBSOLETO
	}

	/**
	 * Create the application.
	 */
	public ControladorInicio() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ControladorInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		getContentPane().setLayout(new BorderLayout(0, 0));

		setTitle("Spotifoo");
		setSize(550, 600);
		setMinimumSize(getSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		VentanaLogin ventanaLogin = new VentanaLogin();
		VentanaRegistro ventanaRegistro = new VentanaRegistro();

		cl_panelCardLayout = new CardLayout();
		panelCardLayout = new JPanel(cl_panelCardLayout);

		panelCardLayout.add(ventanaLogin, "ventanaLogin");
		panelCardLayout.add(ventanaRegistro, "ventanaRegistro");
		getContentPane().add(panelCardLayout);

		cl_panelCardLayout.show(panelCardLayout, "ventanaLogin");

		JPanel cabezera = new JPanel();
		cabezera.setBackground(new Color(40, 40, 40));
		getContentPane().add(cabezera, BorderLayout.NORTH);
		cabezera.setLayout(new BorderLayout(0, 0));

		JPanel pIzquierda = new JPanel();
		pIzquierda.setOpaque(false);
		cabezera.add(pIzquierda, BorderLayout.WEST);

		Component horizontalStrut = Box.createHorizontalStrut(10);
		pIzquierda.add(horizontalStrut);

		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(ControladorInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		icono.setHorizontalAlignment(SwingConstants.LEFT);
		icono.setForeground(Color.WHITE);
		pIzquierda.add(icono);

		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		pIzquierda.add(horizontalStrut_1);

		JLabel titulo = new JLabel("Spotifoo");
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		pIzquierda.add(titulo);

		Component verticalStrut = Box.createVerticalStrut(90);
		pIzquierda.add(verticalStrut);

		JPanel pDerecha = new JPanel();
		pDerecha.setOpaque(false);
		cabezera.add(pDerecha, BorderLayout.EAST);

		JTextArea txtrTrabajoRealizadoPor = new JTextArea(
				"\nTrabajo realizado por:\r\n     - Julian Francisco Gomez Diaz\r\n     - Manuel Bernabe Rodriguez");
		txtrTrabajoRealizadoPor.setOpaque(false);
		txtrTrabajoRealizadoPor.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtrTrabajoRealizadoPor.setEditable(false);
		pDerecha.add(txtrTrabajoRealizadoPor);

	}

}
