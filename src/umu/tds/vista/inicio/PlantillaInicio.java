package umu.tds.vista.inicio;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;

/**
 * Clase PlantillaInicio
 */
public class PlantillaInicio extends JFrame {

	/**
	 * ATRIBUTOS
	 */
	private static final long serialVersionUID = 1L;
	
	private static CardLayout cardLayout;
	private static JPanel panelCardLayout;

	/**
	 * Metodo que inicializa PlantillaMain
	 */
	private void inicializar() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PlantillaInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		getContentPane().setLayout(new BorderLayout(0, 0));

		setTitle("Spotifoo");
		setSize(550, 600);
		setMinimumSize(getSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	/**
	 * Metodo que cambia al panel de Registro
	 */
	public static void empezarRegistro() {
		cardLayout.next(panelCardLayout);
	}

	/**
	 * Metodo que cambia al panel de Login
	 */
	public static void salirRegistro() {
		cardLayout.previous(panelCardLayout);
	}

	/**
	 * Constructor de la clase PlantillaInicio
	 */
	public PlantillaInicio() {
		inicializar();

		VentanaLogin ventanaLogin = new VentanaLogin();
		VentanaRegistro ventanaRegistro = new VentanaRegistro();

		cardLayout = new CardLayout();
		panelCardLayout = new JPanel(cardLayout);

		panelCardLayout.add(ventanaLogin, "ventanaLogin");
		panelCardLayout.add(ventanaRegistro, "ventanaRegistro");
		getContentPane().add(panelCardLayout);

		cardLayout.show(panelCardLayout, "ventanaLogin");

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
		icono.setIcon(new ImageIcon(PlantillaInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));
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
		txtrTrabajoRealizadoPor.setDisabledTextColor(Color.LIGHT_GRAY);
		txtrTrabajoRealizadoPor.setEnabled(false);
		txtrTrabajoRealizadoPor.setOpaque(false);
		txtrTrabajoRealizadoPor.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtrTrabajoRealizadoPor.setEditable(false);
		pDerecha.add(txtrTrabajoRealizadoPor);

	}
}
