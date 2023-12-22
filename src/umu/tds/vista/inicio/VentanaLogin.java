package umu.tds.vista.inicio;

import javax.swing.*;
import umu.tds.Controlador;
import umu.tds.ControladorVentanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaLogin extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private JTextField textoUsuario;
	private JPasswordField textoContraseña;
	private JButton botonLogin;
	private JButton botonRegistro;
	private JButton botonGitHub;
	private JLabel labelRecuperarContraseña;

	public VentanaLogin() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 0, 100 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 35, 0, 0, 0, 30, 0, 0, 30, 0, 35, 0, 0, 0, 0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel labelTitulo = new JLabel("Inicia sesión en Spotifoo");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_labelTitulo = new GridBagConstraints();
		gbc_labelTitulo.gridwidth = 3;
		gbc_labelTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_labelTitulo.gridx = 0;
		gbc_labelTitulo.gridy = 0;
		add(labelTitulo, gbc_labelTitulo);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);

		botonGitHub = new JButton("  Continuar con GitHub");
		botonGitHub.setIcon(new ImageIcon(VentanaLogin.class.getResource("/umu/tds/vista/imagenes/github.png")));
		botonGitHub.setForeground(Color.WHITE);
		botonGitHub.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_botonGitHub = new GridBagConstraints();
		gbc_botonGitHub.fill = GridBagConstraints.VERTICAL;
		gbc_botonGitHub.insets = new Insets(0, 0, 5, 5);
		gbc_botonGitHub.gridx = 1;
		gbc_botonGitHub.gridy = 2;
		add(botonGitHub, gbc_botonGitHub);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 4;
		add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel labelUsuario = new JLabel("Correo electrónico o nombre de usuario");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.WEST;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 5;
		add(labelUsuario, gbc_labelUsuario);

		textoUsuario = new JTextField();
		textoUsuario.setToolTipText("");
		textoUsuario.setForeground(Color.WHITE);
		textoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoUsuario.setColumns(20);
		GridBagConstraints gbc_textoUsuario = new GridBagConstraints();
		gbc_textoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textoUsuario.fill = GridBagConstraints.BOTH;
		gbc_textoUsuario.gridx = 1;
		gbc_textoUsuario.gridy = 6;
		add(textoUsuario, gbc_textoUsuario);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 7;
		add(verticalStrut_2, gbc_verticalStrut_2);

		JLabel labelContraseña = new JLabel("Contraseña");
		labelContraseña.setForeground(Color.WHITE);
		labelContraseña.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.anchor = GridBagConstraints.WEST;
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.gridx = 1;
		gbc_labelContraseña.gridy = 8;
		add(labelContraseña, gbc_labelContraseña);

		textoContraseña = new JPasswordField();
		textoContraseña.setToolTipText("");
		textoContraseña.setForeground(Color.WHITE);
		textoContraseña.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoContraseña.setColumns(20);
		GridBagConstraints gbc_textoContraseña = new GridBagConstraints();
		gbc_textoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_textoContraseña.fill = GridBagConstraints.BOTH;
		gbc_textoContraseña.gridx = 1;
		gbc_textoContraseña.gridy = 9;
		add(textoContraseña, gbc_textoContraseña);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 10;
		add(verticalStrut_3, gbc_verticalStrut_3);

		botonLogin = new JButton("     Iniciar Sesión     ");
		botonLogin.setForeground(Color.WHITE);
		botonLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.fill = GridBagConstraints.VERTICAL;
		gbc_botonLogin.insets = new Insets(0, 0, 5, 5);
		gbc_botonLogin.gridx = 1;
		gbc_botonLogin.gridy = 11;
		add(botonLogin, gbc_botonLogin);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 12;
		add(verticalStrut_4, gbc_verticalStrut_4);

		labelRecuperarContraseña = new JLabel("¿Has olvidado tu contraseña?");
		labelRecuperarContraseña.setForeground(Color.WHITE);
		GridBagConstraints gbc_labelRecuperarContraseña = new GridBagConstraints();
		gbc_labelRecuperarContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelRecuperarContraseña.gridx = 1;
		gbc_labelRecuperarContraseña.gridy = 13;
		add(labelRecuperarContraseña, gbc_labelRecuperarContraseña);

		Component verticalStrut_5 = Box.createVerticalStrut(5);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 14;
		add(verticalStrut_5, gbc_verticalStrut_5);

		JPanel panelRegistrarse = new JPanel();
		panelRegistrarse.setOpaque(false);
		panelRegistrarse.setForeground(Color.WHITE);
		panelRegistrarse.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panelRegistrarse = new GridBagConstraints();
		gbc_panelRegistrarse.insets = new Insets(0, 0, 0, 5);
		gbc_panelRegistrarse.fill = GridBagConstraints.BOTH;
		gbc_panelRegistrarse.gridx = 1;
		gbc_panelRegistrarse.gridy = 15;
		add(panelRegistrarse, gbc_panelRegistrarse);
		GridBagLayout gbl_panelRegistrarse = new GridBagLayout();
		gbl_panelRegistrarse.columnWidths = new int[] { 91, 159, 0 };
		gbl_panelRegistrarse.rowHeights = new int[] { 30, 0 };
		gbl_panelRegistrarse.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelRegistrarse.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelRegistrarse.setLayout(gbl_panelRegistrarse);

		JLabel labelRegisto = new JLabel("¿No tienes cuenta?");
		labelRegisto.setForeground(new Color(204, 204, 204));
		GridBagConstraints gbc_labelRegisto = new GridBagConstraints();
		gbc_labelRegisto.anchor = GridBagConstraints.WEST;
		gbc_labelRegisto.insets = new Insets(0, 0, 0, 5);
		gbc_labelRegisto.gridx = 0;
		gbc_labelRegisto.gridy = 0;
		panelRegistrarse.add(labelRegisto, gbc_labelRegisto);

		botonRegistro = new JButton("Regístrate en Spotifoo");
		botonRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		botonRegistro.setForeground(Color.WHITE);
		botonRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_botonRegistro = new GridBagConstraints();
		gbc_botonRegistro.fill = GridBagConstraints.VERTICAL;
		gbc_botonRegistro.anchor = GridBagConstraints.WEST;
		gbc_botonRegistro.gridx = 1;
		gbc_botonRegistro.gridy = 0;
		panelRegistrarse.add(botonRegistro, gbc_botonRegistro);

		// Manejadores
		botonRegistro.addActionListener(this);
		botonLogin.addActionListener(this);
		botonGitHub.addActionListener(this);
		labelRecuperarContraseña.addMouseListener((MouseListener) this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonLogin) {

			String usuario = textoUsuario.getText();
			String contraseña = new String(textoContraseña.getPassword());
			Boolean login = Controlador.INSTANCIA.login(usuario, contraseña);

			if (!login) {
				JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.",
						"Problema en Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
			} else {
				ControladorVentanas.INSTANCIA.logInSatisfactorio();
			}
		}

		if (e.getSource() == botonRegistro) {
			textoUsuario.setText("");
			textoContraseña.setText("");
			PlantillaInicio.empezarRegistro();
		}

		if (e.getSource() == botonGitHub) {
			JOptionPane.showMessageDialog(null, "Funcionalidad no disponible. ", "Error", JOptionPane.WARNING_MESSAGE);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == labelRecuperarContraseña) {
			JOptionPane.showMessageDialog(null, "Mucha suerte recordándola !!!", "Mmmm",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}