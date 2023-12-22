package umu.tds.vista.inicio;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

import umu.tds.Controlador;
import umu.tds.ControladorVentanas;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel WindowRegister;
	private JTextPane labelTitulo;
	private JLabel labelEmail;
	private JTextField textoEmail;
	private JButton botonSiguiente;
	private JPanel panelLogin;
	private JLabel labelLogin;
	private JButton botonLogin;
	private JPanel WindowRegister_1;
	private JProgressBar barraProgreso;
	private Component verticalStrut;
	private JLabel labelPaso;
	private Component horizontalStrut;
	private JButton botonAtras;
	private JLabel labelTitulo1;
	private Component horizontalStrut_1;
	private JLabel labelContraseña;
	private JPasswordField textoContraseña;
	private JTextArea labelContraseñaInfo;
	private JButton botonSiguiente1;
	private JPanel WindowRegister_2;
	private JProgressBar barraProgreso1;
	private Component verticalStrut_1;
	private JLabel labelPaso1;
	private JButton botonAtras1;
	private JLabel labelTitulo2;
	private Component horizontalStrut_2;
	private JLabel labelUsuario;
	private Component horizontalStrut_3;
	private JLabel labelUsuarioInfo;
	private JTextField textoUsuario;
	private Component verticalStrut_2;
	private JLabel labelFechaNacimiento;
	private JDateChooser fechaNacimiento;
	private JButton botonSiguiente2;
	private JPanel WindowRegister_3;
	private JProgressBar barraProgreso2;
	private JLabel labelPaso2;
	private JButton botonAtras2;
	private JLabel labelTitulo3;
	private JPanel panelNovedades;
	private JCheckBox checkBox_1;
	private JTextArea textoNovedades;
	private JPanel panelCompartirDatos;
	private JCheckBox checkBox_2;
	private JTextArea textoCompartirDatos;
	private JTextArea labelTerminos;
	private Component verticalStrut_3;
	private Component horizontalStrut_4;
	private JButton botonRegistrar;
	private Component horizontalStrut_5;
	private Component verticalStrut_4;
	private Component verticalStrut_5;
	private Component verticalStrut_6;
	private Component verticalStrut_7;
	private Component verticalStrut_8;
	private Component verticalStrut_9;
	private Component verticalStrut_10;
	private Component verticalStrut_11;

	private CardLayout cardLayout;
	private JCheckBox mostrarContraseña;

	public VentanaRegistro() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);

		WindowRegister = new JPanel();
		WindowRegister.setOpaque(false);
		WindowRegister.setForeground(Color.WHITE);
		add(WindowRegister, "WindowRegister");
		GridBagLayout gbl_WindowRegister = new GridBagLayout();
		gbl_WindowRegister.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_WindowRegister.rowHeights = new int[] { 92, 0, 0, 30, 0, 30, 0, 30 };
		WindowRegister.setLayout(gbl_WindowRegister);

		labelTitulo = new JTextPane();
		labelTitulo.setText("Regístrate para \nempezar a \nescuchar \ncontenido");
		labelTitulo.setOpaque(false);
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelTitulo.setEditable(false);
		GridBagConstraints gbc_labelTitulo = new GridBagConstraints();
		gbc_labelTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_labelTitulo.gridx = 0;
		gbc_labelTitulo.gridy = 0;
		WindowRegister.add(labelTitulo, gbc_labelTitulo);

		verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 1;
		WindowRegister.add(verticalStrut_4, gbc_verticalStrut_4);

		labelEmail = new JLabel("Dirección de correo electrónico");
		labelEmail.setForeground(Color.WHITE);
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.WEST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 0);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 2;
		WindowRegister.add(labelEmail, gbc_labelEmail);

		textoEmail = new JTextField();
		textoEmail.setToolTipText("");
		textoEmail.setForeground(Color.WHITE);
		textoEmail.setColumns(20);
		GridBagConstraints gbc_textoEmail = new GridBagConstraints();
		gbc_textoEmail.fill = GridBagConstraints.BOTH;
		gbc_textoEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textoEmail.gridx = 0;
		gbc_textoEmail.gridy = 3;
		WindowRegister.add(textoEmail, gbc_textoEmail);

		verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_5.gridx = 0;
		gbc_verticalStrut_5.gridy = 4;
		WindowRegister.add(verticalStrut_5, gbc_verticalStrut_5);

		botonSiguiente = new JButton("     Siguiente     ");
		botonSiguiente.setForeground(Color.WHITE);
		botonSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_botonSiguiente = new GridBagConstraints();
		gbc_botonSiguiente.fill = GridBagConstraints.VERTICAL;
		gbc_botonSiguiente.insets = new Insets(0, 0, 5, 0);
		gbc_botonSiguiente.gridx = 0;
		gbc_botonSiguiente.gridy = 5;
		WindowRegister.add(botonSiguiente, gbc_botonSiguiente);

		verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_6.gridx = 0;
		gbc_verticalStrut_6.gridy = 6;
		WindowRegister.add(verticalStrut_6, gbc_verticalStrut_6);

		panelLogin = new JPanel();
		panelLogin.setForeground(Color.WHITE);
		GridBagConstraints gbc_panelLogin = new GridBagConstraints();
		gbc_panelLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelLogin.gridx = 0;
		gbc_panelLogin.gridy = 7;
		WindowRegister.add(panelLogin, gbc_panelLogin);
		GridBagLayout gbl_panelLogin = new GridBagLayout();
		gbl_panelLogin.columnWidths = new int[] { 111, 129, 0 };
		gbl_panelLogin.rowHeights = new int[] { 30, 0 };
		gbl_panelLogin.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelLogin.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelLogin.setLayout(gbl_panelLogin);

		labelLogin = new JLabel("¿Ya tienes una cuenta?");
		labelLogin.setForeground(new Color(204, 204, 204));
		GridBagConstraints gbc_labelLogin = new GridBagConstraints();
		gbc_labelLogin.anchor = GridBagConstraints.WEST;
		gbc_labelLogin.insets = new Insets(0, 0, 0, 5);
		gbc_labelLogin.gridx = 0;
		gbc_labelLogin.gridy = 0;
		panelLogin.add(labelLogin, gbc_labelLogin);

		botonLogin = new JButton("Inicia sesión aquí");
		botonLogin.setForeground(Color.WHITE);
		botonLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.fill = GridBagConstraints.BOTH;
		gbc_botonLogin.gridx = 1;
		gbc_botonLogin.gridy = 0;
		panelLogin.add(botonLogin, gbc_botonLogin);
		botonLogin.addActionListener(this);

		WindowRegister_1 = new JPanel();
		WindowRegister_1.setOpaque(false);
		WindowRegister_1.setForeground(Color.WHITE);
		add(WindowRegister_1, "WindowRegister_1");
		GridBagLayout gbl_WindowRegister_1 = new GridBagLayout();
		gbl_WindowRegister_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_WindowRegister_1.columnWidths = new int[] { 0, 250, 0, 0 };
		gbl_WindowRegister_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_WindowRegister_1.rowHeights = new int[] { 0, 0, 0, 0, 20, 0, 30, 0, 0, 0, 30 };
		WindowRegister_1.setLayout(gbl_WindowRegister_1);

		barraProgreso = new JProgressBar();
		barraProgreso.setValue(33);
		GridBagConstraints gbc_barraProgreso = new GridBagConstraints();
		gbc_barraProgreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_barraProgreso.gridwidth = 4;
		gbc_barraProgreso.insets = new Insets(0, 0, 5, 0);
		gbc_barraProgreso.gridx = 0;
		gbc_barraProgreso.gridy = 0;
		WindowRegister_1.add(barraProgreso, gbc_barraProgreso);

		verticalStrut = Box.createVerticalStrut(5);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 1;
		WindowRegister_1.add(verticalStrut, gbc_verticalStrut);

		botonAtras = new JButton("");
		botonAtras.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/umu/tds/vista/imagenes/arrow.png")));
		botonAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonAtras.setContentAreaFilled(false);
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.gridheight = 2;
		gbc_botonAtras.insets = new Insets(0, 0, 5, 5);
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 2;
		WindowRegister_1.add(botonAtras, gbc_botonAtras);

		labelPaso = new JLabel("Paso 1 de 3");
		labelPaso.setForeground(new Color(204, 204, 204));
		labelPaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_labelPaso = new GridBagConstraints();
		gbc_labelPaso.anchor = GridBagConstraints.WEST;
		gbc_labelPaso.insets = new Insets(0, 0, 5, 5);
		gbc_labelPaso.gridx = 1;
		gbc_labelPaso.gridy = 2;
		WindowRegister_1.add(labelPaso, gbc_labelPaso);

		horizontalStrut = Box.createHorizontalStrut(50);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 3;
		gbc_horizontalStrut.gridy = 2;
		WindowRegister_1.add(horizontalStrut, gbc_horizontalStrut);

		labelTitulo1 = new JLabel("Crea una contraseña");
		labelTitulo1.setForeground(Color.WHITE);
		labelTitulo1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_labelTitulo1 = new GridBagConstraints();
		gbc_labelTitulo1.anchor = GridBagConstraints.WEST;
		gbc_labelTitulo1.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitulo1.gridx = 1;
		gbc_labelTitulo1.gridy = 3;
		WindowRegister_1.add(labelTitulo1, gbc_labelTitulo1);

		horizontalStrut_1 = Box.createHorizontalStrut(50);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 5;
		WindowRegister_1.add(horizontalStrut_1, gbc_horizontalStrut_1);

		labelContraseña = new JLabel("Contraseña");
		labelContraseña.setForeground(Color.WHITE);
		labelContraseña.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.anchor = GridBagConstraints.WEST;
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.gridx = 1;
		gbc_labelContraseña.gridy = 5;
		WindowRegister_1.add(labelContraseña, gbc_labelContraseña);

		textoContraseña = new JPasswordField();
		GridBagConstraints gbc_textoContraseña = new GridBagConstraints();
		gbc_textoContraseña.fill = GridBagConstraints.BOTH;
		gbc_textoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_textoContraseña.gridx = 1;
		gbc_textoContraseña.gridy = 6;
		WindowRegister_1.add(textoContraseña, gbc_textoContraseña);
		
		mostrarContraseña = new JCheckBox("Mostrar Contraseña");
        
		GridBagConstraints gbc_mostrarContraseña = new GridBagConstraints();
		gbc_mostrarContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_mostrarContraseña.gridx = 1;
		gbc_mostrarContraseña.gridy = 7;
		WindowRegister_1.add(mostrarContraseña, gbc_mostrarContraseña);

		labelContraseñaInfo = new JTextArea(
				"La contraseña debe tener al menos 8 caracteres. \r\nTe recomendamos que incluyas como mínimo \r\n1 número y 1 carácter especial.");
		labelContraseñaInfo.setDisabledTextColor(Color.LIGHT_GRAY);
		labelContraseñaInfo.setEnabled(false);
		labelContraseñaInfo.setOpaque(false);
		labelContraseñaInfo.setForeground(new Color(204, 204, 204));
		labelContraseñaInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelContraseñaInfo.setEditable(false);
		GridBagConstraints gbc_labelContraseñaInfo = new GridBagConstraints();
		gbc_labelContraseñaInfo.fill = GridBagConstraints.BOTH;
		gbc_labelContraseñaInfo.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseñaInfo.gridx = 1;
		gbc_labelContraseñaInfo.gridy = 8;
		WindowRegister_1.add(labelContraseñaInfo, gbc_labelContraseñaInfo);

		verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 1;
		gbc_verticalStrut_7.gridy = 9;
		WindowRegister_1.add(verticalStrut_7, gbc_verticalStrut_7);

		botonSiguiente1 = new JButton("     Siguiente     ");
		botonSiguiente1.setForeground(Color.WHITE);
		botonSiguiente1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_botonSiguiente1 = new GridBagConstraints();
		gbc_botonSiguiente1.fill = GridBagConstraints.VERTICAL;
		gbc_botonSiguiente1.insets = new Insets(0, 0, 0, 5);
		gbc_botonSiguiente1.gridx = 1;
		gbc_botonSiguiente1.gridy = 10;
		WindowRegister_1.add(botonSiguiente1, gbc_botonSiguiente1);

		WindowRegister_2 = new JPanel();
		WindowRegister_2.setOpaque(false);
		WindowRegister_2.setForeground(Color.WHITE);
		add(WindowRegister_2, "name_99315507830600");
		GridBagLayout gbl_WindowRegister_2 = new GridBagLayout();
		gbl_WindowRegister_2.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_WindowRegister_2.columnWidths = new int[] { 50, 250, 50 };
		gbl_WindowRegister_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		gbl_WindowRegister_2.rowHeights = new int[] { 0, -66, 0, 0, 0, 0, 0, 30, 0, 0, 30, 0, 30 };
		WindowRegister_2.setLayout(gbl_WindowRegister_2);

		barraProgreso1 = new JProgressBar();
		barraProgreso1.setValue(66);
		GridBagConstraints gbc_barraProgreso1 = new GridBagConstraints();
		gbc_barraProgreso1.fill = GridBagConstraints.HORIZONTAL;
		gbc_barraProgreso1.gridwidth = 3;
		gbc_barraProgreso1.insets = new Insets(0, 0, 5, 0);
		gbc_barraProgreso1.gridx = 0;
		gbc_barraProgreso1.gridy = 0;
		WindowRegister_2.add(barraProgreso1, gbc_barraProgreso1);

		verticalStrut_1 = Box.createVerticalStrut(5);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 1;
		WindowRegister_2.add(verticalStrut_1, gbc_verticalStrut_1);

		botonAtras1 = new JButton("");
		botonAtras1.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/umu/tds/vista/imagenes/arrow.png")));
		botonAtras1.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonAtras1.setContentAreaFilled(false);
		GridBagConstraints gbc_botonAtras1 = new GridBagConstraints();
		gbc_botonAtras1.gridheight = 2;
		gbc_botonAtras1.insets = new Insets(0, 0, 5, 5);
		gbc_botonAtras1.gridx = 0;
		gbc_botonAtras1.gridy = 2;
		WindowRegister_2.add(botonAtras1, gbc_botonAtras1);

		labelPaso1 = new JLabel("Paso 2 de 3");
		labelPaso1.setForeground(new Color(204, 204, 204));
		labelPaso1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_labelPaso1 = new GridBagConstraints();
		gbc_labelPaso1.anchor = GridBagConstraints.WEST;
		gbc_labelPaso1.insets = new Insets(0, 0, 5, 5);
		gbc_labelPaso1.gridx = 1;
		gbc_labelPaso1.gridy = 2;
		WindowRegister_2.add(labelPaso1, gbc_labelPaso1);

		labelTitulo2 = new JLabel("Háblanos de ti");
		labelTitulo2.setForeground(Color.WHITE);
		labelTitulo2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_labelTitulo2 = new GridBagConstraints();
		gbc_labelTitulo2.anchor = GridBagConstraints.WEST;
		gbc_labelTitulo2.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitulo2.gridx = 1;
		gbc_labelTitulo2.gridy = 3;
		WindowRegister_2.add(labelTitulo2, gbc_labelTitulo2);

		verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 1;
		gbc_verticalStrut_8.gridy = 4;
		WindowRegister_2.add(verticalStrut_8, gbc_verticalStrut_8);

		horizontalStrut_2 = Box.createHorizontalStrut(50);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 5;
		WindowRegister_2.add(horizontalStrut_2, gbc_horizontalStrut_2);

		labelUsuario = new JLabel("Nombre");
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.WEST;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 5;
		WindowRegister_2.add(labelUsuario, gbc_labelUsuario);

		horizontalStrut_3 = Box.createHorizontalStrut(50);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 5;
		WindowRegister_2.add(horizontalStrut_3, gbc_horizontalStrut_3);

		labelUsuarioInfo = new JLabel("Este nombre aparecerá en tu perfil");
		labelUsuarioInfo.setForeground(new Color(204, 204, 204));
		GridBagConstraints gbc_labelUsuarioInfo = new GridBagConstraints();
		gbc_labelUsuarioInfo.anchor = GridBagConstraints.WEST;
		gbc_labelUsuarioInfo.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuarioInfo.gridx = 1;
		gbc_labelUsuarioInfo.gridy = 6;
		WindowRegister_2.add(labelUsuarioInfo, gbc_labelUsuarioInfo);

		textoUsuario = new JTextField();
		textoUsuario.setForeground(Color.WHITE);
		textoUsuario.setColumns(10);
		GridBagConstraints gbc_textoUsuario = new GridBagConstraints();
		gbc_textoUsuario.fill = GridBagConstraints.BOTH;
		gbc_textoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textoUsuario.gridx = 1;
		gbc_textoUsuario.gridy = 7;
		WindowRegister_2.add(textoUsuario, gbc_textoUsuario);

		verticalStrut_2 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 8;
		WindowRegister_2.add(verticalStrut_2, gbc_verticalStrut_2);

		labelFechaNacimiento = new JLabel("Fecha de nacimiento");
		labelFechaNacimiento.setForeground(Color.WHITE);
		labelFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelFechaNacimiento = new GridBagConstraints();
		gbc_labelFechaNacimiento.anchor = GridBagConstraints.WEST;
		gbc_labelFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_labelFechaNacimiento.gridx = 1;
		gbc_labelFechaNacimiento.gridy = 9;
		WindowRegister_2.add(labelFechaNacimiento, gbc_labelFechaNacimiento);

		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setForeground(Color.WHITE);
		fechaNacimiento.setDateFormatString("dd / MM / yyyy");
		GridBagConstraints gbc_fechaNacimiento = new GridBagConstraints();
		gbc_fechaNacimiento.fill = GridBagConstraints.BOTH;
		gbc_fechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_fechaNacimiento.gridx = 1;
		gbc_fechaNacimiento.gridy = 10;
		WindowRegister_2.add(fechaNacimiento, gbc_fechaNacimiento);

		verticalStrut_9 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_9 = new GridBagConstraints();
		gbc_verticalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_9.gridx = 1;
		gbc_verticalStrut_9.gridy = 11;
		WindowRegister_2.add(verticalStrut_9, gbc_verticalStrut_9);

		botonSiguiente2 = new JButton("     Siguiente     ");
		botonSiguiente2.setForeground(Color.WHITE);
		botonSiguiente2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_botonSiguiente2 = new GridBagConstraints();
		gbc_botonSiguiente2.fill = GridBagConstraints.VERTICAL;
		gbc_botonSiguiente2.insets = new Insets(0, 0, 0, 5);
		gbc_botonSiguiente2.gridx = 1;
		gbc_botonSiguiente2.gridy = 12;
		WindowRegister_2.add(botonSiguiente2, gbc_botonSiguiente2);

		WindowRegister_3 = new JPanel();
		WindowRegister_3.setOpaque(false);
		WindowRegister_3.setForeground(Color.WHITE);
		add(WindowRegister_3, "name_99315527483000");
		GridBagLayout gbl_WindowRegister_3 = new GridBagLayout();
		gbl_WindowRegister_3.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_WindowRegister_3.columnWidths = new int[] { 50, 250, 50 };
		gbl_WindowRegister_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_WindowRegister_3.rowHeights = new int[] { 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 35 };
		WindowRegister_3.setLayout(gbl_WindowRegister_3);

		barraProgreso2 = new JProgressBar();
		barraProgreso2.setValue(100);
		GridBagConstraints gbc_barraProgreso2 = new GridBagConstraints();
		gbc_barraProgreso2.fill = GridBagConstraints.HORIZONTAL;
		gbc_barraProgreso2.gridwidth = 3;
		gbc_barraProgreso2.insets = new Insets(0, 0, 5, 0);
		gbc_barraProgreso2.gridx = 0;
		gbc_barraProgreso2.gridy = 0;
		WindowRegister_3.add(barraProgreso2, gbc_barraProgreso2);

		botonAtras2 = new JButton("");
		botonAtras2.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/umu/tds/vista/imagenes/arrow.png")));
		botonAtras2.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonAtras2.setContentAreaFilled(false);
		GridBagConstraints gbc_botonAtras2 = new GridBagConstraints();
		gbc_botonAtras2.gridheight = 2;
		gbc_botonAtras2.insets = new Insets(0, 0, 5, 5);
		gbc_botonAtras2.gridx = 0;
		gbc_botonAtras2.gridy = 2;
		WindowRegister_3.add(botonAtras2, gbc_botonAtras2);

		labelPaso2 = new JLabel("Paso 3 de 3");
		labelPaso2.setForeground(new Color(204, 204, 204));
		labelPaso2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_labelPaso2 = new GridBagConstraints();
		gbc_labelPaso2.anchor = GridBagConstraints.WEST;
		gbc_labelPaso2.insets = new Insets(0, 0, 5, 5);
		gbc_labelPaso2.gridx = 1;
		gbc_labelPaso2.gridy = 2;
		WindowRegister_3.add(labelPaso2, gbc_labelPaso2);

		labelTitulo3 = new JLabel("Términos y Condiciones");
		labelTitulo3.setForeground(Color.WHITE);
		labelTitulo3.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_labelTitulo3 = new GridBagConstraints();
		gbc_labelTitulo3.anchor = GridBagConstraints.WEST;
		gbc_labelTitulo3.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitulo3.gridx = 1;
		gbc_labelTitulo3.gridy = 3;
		WindowRegister_3.add(labelTitulo3, gbc_labelTitulo3);

		verticalStrut_10 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_10 = new GridBagConstraints();
		gbc_verticalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_10.gridx = 1;
		gbc_verticalStrut_10.gridy = 4;
		WindowRegister_3.add(verticalStrut_10, gbc_verticalStrut_10);

		panelNovedades = new JPanel();
		panelNovedades.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panelNovedades = new GridBagConstraints();
		gbc_panelNovedades.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelNovedades.insets = new Insets(0, 0, 5, 5);
		gbc_panelNovedades.gridx = 1;
		gbc_panelNovedades.gridy = 5;
		WindowRegister_3.add(panelNovedades, gbc_panelNovedades);
		GridBagLayout gbl_panelNovedades = new GridBagLayout();
		gbl_panelNovedades.columnWidths = new int[] { 21, 205, 0 };
		gbl_panelNovedades.rowHeights = new int[] { 32, 0 };
		gbl_panelNovedades.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelNovedades.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelNovedades.setLayout(gbl_panelNovedades);

		checkBox_1 = new JCheckBox("");
		checkBox_1.setOpaque(false);
		checkBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
		gbc_checkBox_1.anchor = GridBagConstraints.NORTH;
		gbc_checkBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_1.gridx = 0;
		gbc_checkBox_1.gridy = 0;
		panelNovedades.add(checkBox_1, gbc_checkBox_1);

		textoNovedades = new JTextArea("Quiero que me enviéis novedades y ofertas\r\nde Spotifoo.");
		textoNovedades.setDisabledTextColor(Color.WHITE);
		textoNovedades.setEnabled(false);
		textoNovedades.setOpaque(false);
		textoNovedades.setForeground(new Color(255, 255, 255));
		textoNovedades.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoNovedades.setEditable(false);
		GridBagConstraints gbc_textoNovedades = new GridBagConstraints();
		gbc_textoNovedades.anchor = GridBagConstraints.NORTHWEST;
		gbc_textoNovedades.gridx = 1;
		gbc_textoNovedades.gridy = 0;
		panelNovedades.add(textoNovedades, gbc_textoNovedades);

		panelCompartirDatos = new JPanel();
		panelCompartirDatos.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panelCompartirDatos = new GridBagConstraints();
		gbc_panelCompartirDatos.fill = GridBagConstraints.BOTH;
		gbc_panelCompartirDatos.insets = new Insets(0, 0, 5, 5);
		gbc_panelCompartirDatos.gridx = 1;
		gbc_panelCompartirDatos.gridy = 6;
		WindowRegister_3.add(panelCompartirDatos, gbc_panelCompartirDatos);
		GridBagLayout gbl_panelCompartirDatos = new GridBagLayout();
		gbl_panelCompartirDatos.columnWidths = new int[] { 21, 234, 0 };
		gbl_panelCompartirDatos.rowHeights = new int[] { 88, 0 };
		gbl_panelCompartirDatos.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelCompartirDatos.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelCompartirDatos.setLayout(gbl_panelCompartirDatos);

		checkBox_2 = new JCheckBox("");
		checkBox_2.setOpaque(false);
		GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
		gbc_checkBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox_2.anchor = GridBagConstraints.NORTH;
		gbc_checkBox_2.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_2.gridx = 0;
		gbc_checkBox_2.gridy = 0;
		panelCompartirDatos.add(checkBox_2, gbc_checkBox_2);

		textoCompartirDatos = new JTextArea(
				"Compartir mis datos de registro con los\r\nproveedores de contenidos de Spotifoo\r\npara fines de marketing. Ten en cuenta\r\nque tus datos pueden ser transferidos a\r\nun país de fuera del EEE, tal y como se\r\nrecoge en nuestra Política de Privacidad.");
		textoCompartirDatos.setDisabledTextColor(Color.WHITE);
		textoCompartirDatos.setEnabled(false);
		textoCompartirDatos.setOpaque(false);
		textoCompartirDatos.setForeground(new Color(255, 255, 255));
		textoCompartirDatos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoCompartirDatos.setEditable(false);
		GridBagConstraints gbc_textoCompartirDatos = new GridBagConstraints();
		gbc_textoCompartirDatos.anchor = GridBagConstraints.NORTHWEST;
		gbc_textoCompartirDatos.gridx = 1;
		gbc_textoCompartirDatos.gridy = 0;
		panelCompartirDatos.add(textoCompartirDatos, gbc_textoCompartirDatos);

		verticalStrut_11 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_11 = new GridBagConstraints();
		gbc_verticalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_11.gridx = 1;
		gbc_verticalStrut_11.gridy = 7;
		WindowRegister_3.add(verticalStrut_11, gbc_verticalStrut_11);

		labelTerminos = new JTextArea(
				"Al hacer clic en Registrarte, aceptas los\r\nTérminos y condiciones de uso de Spotifoo.");
		labelTerminos.setDisabledTextColor(Color.WHITE);
		labelTerminos.setEnabled(false);
		labelTerminos.setOpaque(false);
		labelTerminos.setForeground(Color.WHITE);
		labelTerminos.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTerminos.setEditable(false);
		GridBagConstraints gbc_labelTerminos = new GridBagConstraints();
		gbc_labelTerminos.fill = GridBagConstraints.BOTH;
		gbc_labelTerminos.insets = new Insets(0, 0, 5, 5);
		gbc_labelTerminos.gridx = 1;
		gbc_labelTerminos.gridy = 8;
		WindowRegister_3.add(labelTerminos, gbc_labelTerminos);

		verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 9;
		WindowRegister_3.add(verticalStrut_3, gbc_verticalStrut_3);

		horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 10;
		WindowRegister_3.add(horizontalStrut_4, gbc_horizontalStrut_4);

		botonRegistrar = new JButton("     Regístrate     ");
		botonRegistrar.setForeground(Color.WHITE);
		botonRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_botonRegistrar = new GridBagConstraints();
		gbc_botonRegistrar.fill = GridBagConstraints.VERTICAL;
		gbc_botonRegistrar.insets = new Insets(0, 0, 0, 5);
		gbc_botonRegistrar.gridx = 1;
		gbc_botonRegistrar.gridy = 10;
		WindowRegister_3.add(botonRegistrar, gbc_botonRegistrar);

		horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.gridx = 2;
		gbc_horizontalStrut_5.gridy = 10;
		WindowRegister_3.add(horizontalStrut_5, gbc_horizontalStrut_5);

		// Manejadores
		botonSiguiente.addActionListener(this);
		botonAtras.addActionListener(this);
		botonSiguiente1.addActionListener(this);
		botonAtras1.addActionListener(this);
		botonSiguiente2.addActionListener(this);
		botonAtras2.addActionListener(this);
		botonRegistrar.addActionListener(this);
		mostrarContraseña.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonSiguiente) {
			String email = textoEmail.getText().trim();
			if (email.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Correo Electrónico es obligatorio.",
						"Problema en Correo Electrónico", JOptionPane.ERROR_MESSAGE);
			} else if (Controlador.INSTANCIA.existeUsuario(email)) {
				JOptionPane.showMessageDialog(null, "Esta dirección ya esta vinculada a otra cuenta.",
						"Dirección en uso", JOptionPane.WARNING_MESSAGE);
			} else {
				cardLayout.next(VentanaRegistro.this);
			}
		}

		if (e.getSource() == botonLogin) {
			textoUsuario.setText("");
			textoContraseña.setText("");
			textoEmail.setText("");
			fechaNacimiento.setDate(null);
			PlantillaInicio.salirRegistro();
		}

		if (e.getSource() == botonAtras) {
			cardLayout.previous(VentanaRegistro.this);
		}

		if (e.getSource() == botonSiguiente1) {
			String contraseña = new String(textoContraseña.getPassword()).trim();
			if (contraseña.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Contraseña es obligatorio.", "Problema en Contraseña",
						JOptionPane.ERROR_MESSAGE);
			} else {
				cardLayout.next(VentanaRegistro.this);
			}
		}

		if (e.getSource() == botonAtras1) {
			cardLayout.previous(VentanaRegistro.this);
		}

		if (e.getSource() == botonSiguiente2) {
			String nombre = textoUsuario.getText().trim();
			Date fecha = fechaNacimiento.getDate();

			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Nombre es obligatorio.", "Problema en Nombre",
						JOptionPane.ERROR_MESSAGE);
			} else if (Controlador.INSTANCIA.existeUsuario(nombre)) {
				JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe.", "Nombre usuario en uso",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (fecha == null) {
					JOptionPane.showMessageDialog(null, "El campo Fecha Nacimiento es obligatorio.",
							"Problema en Fecha Nacimiento", JOptionPane.ERROR_MESSAGE);
				} else {
					cardLayout.next(VentanaRegistro.this);
				}
			}
		}

		if (e.getSource() == botonAtras2) {
			cardLayout.previous(VentanaRegistro.this);
		}

		if (e.getSource() == botonRegistrar) {
			String usuario = textoUsuario.getText().trim();
			String contraseña = new String(textoContraseña.getPassword()).trim();
			String correo = textoEmail.getText().trim();
			Date fecha = fechaNacimiento.getDate();

			Controlador.INSTANCIA.registrarUsuario(usuario, correo, fecha, contraseña);
			JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.", "Registro satisfactorio",
					JOptionPane.INFORMATION_MESSAGE);
			ControladorVentanas.INSTANCIA.logInSatisfactorio();
		}
		
		if (e.getSource() == mostrarContraseña) {
			textoContraseña.setEchoChar(mostrarContraseña.isSelected() ? '\0' : '*');
		}

	}

}