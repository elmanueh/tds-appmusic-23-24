package umu.tds.vista.inicio;

import javax.swing.*;

import umu.tds.AppMusic;
import umu.tds.modelo.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanaLogin extends JPanel implements ActionListener {

	private JTextField textoUsuario;
	private JPasswordField textoContraseña;
	private JButton botonLogin;
	private JButton botonRegistro;

	public VentanaLogin() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 30, 0, 0, 30, 0, 35, 0, 0, 0, 0 };
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

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		add(horizontalStrut, gbc_horizontalStrut);

		JButton botonGitHub = new JButton("  Continuar con GitHub");
		botonGitHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "hay que implementar esta funcionalidad", "ALERTA",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botonGitHub.setIcon(new ImageIcon(VentanaLogin.class.getResource("/umu/tds/vista/imagenes/github-icon.png")));
		botonGitHub.setForeground(Color.WHITE);
		botonGitHub.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_botonGitHub = new GridBagConstraints();
		gbc_botonGitHub.fill = GridBagConstraints.VERTICAL;
		gbc_botonGitHub.insets = new Insets(0, 0, 5, 5);
		gbc_botonGitHub.gridx = 1;
		gbc_botonGitHub.gridy = 2;
		add(botonGitHub, gbc_botonGitHub);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 2;
		gbc_horizontalStrut_1.gridy = 2;
		add(horizontalStrut_1, gbc_horizontalStrut_1);

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

		JLabel labelRecuperarContraseña = new JLabel("¿Has olvidado tu contraseña?");
		labelRecuperarContraseña.setForeground(Color.WHITE);
		GridBagConstraints gbc_labelRecuperarContraseña = new GridBagConstraints();
		gbc_labelRecuperarContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelRecuperarContraseña.gridx = 1;
		gbc_labelRecuperarContraseña.gridy = 13;
		add(labelRecuperarContraseña, gbc_labelRecuperarContraseña);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 14;
		add(verticalStrut_5, gbc_verticalStrut_5);

		JPanel panelRegistrarse = new JPanel();
		panelRegistrarse.setForeground(Color.WHITE);
		panelRegistrarse.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panelRegistrarse = new GridBagConstraints();
		gbc_panelRegistrarse.insets = new Insets(0, 0, 0, 5);
		gbc_panelRegistrarse.fill = GridBagConstraints.BOTH;
		gbc_panelRegistrarse.gridx = 1;
		gbc_panelRegistrarse.gridy = 15;
		add(panelRegistrarse, gbc_panelRegistrarse);
		panelRegistrarse.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel labelRegisto = new JLabel("¿No tienes cuenta?");
		labelRegisto.setForeground(new Color(204, 204, 204));
		panelRegistrarse.add(labelRegisto);

		botonRegistro = new JButton("Regístrate en Spotifoo");
		botonRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		botonRegistro.setForeground(Color.WHITE);
		botonRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelRegistrarse.add(botonRegistro);

		// Manejadores
		botonRegistro.addActionListener(this);
		botonLogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonLogin) { // esto lo tiene que hacer en otro lado

			String usuario = textoUsuario.getText();
			String contraseña = new String(textoContraseña.getPassword());
			if (usuario.isEmpty() && contraseña.isEmpty()) {
				JOptionPane.showMessageDialog(null, "LOS 2 CAMPOS VACIOS", "ERROR AL INCIAR", JOptionPane.ERROR_MESSAGE);
			} else if (usuario.isEmpty()) {
				JOptionPane.showMessageDialog(null, "USUARIO VACIO", "ERROR AL INCIAR", JOptionPane.ERROR_MESSAGE);
			} else if (contraseña.isEmpty()){
				JOptionPane.showMessageDialog(null, "CONTRASEÑA VACIA", "ERROR AL INCIAR", JOptionPane.ERROR_MESSAGE);
			} else {
				Boolean login = Controlador.getUnicaInstancia().login(usuario, contraseña);
				
				if (login) {
					AppMusic.logInSatisfactorio();
				} else
					JOptionPane.showMessageDialog(null, "CONTRASEÑA, USUARIO O CORREO NO COINCIDE", "ERROR AL INCIAR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource() == botonRegistro) {
			PlantillaInicio.empezarRegistro();
		}

	}

}