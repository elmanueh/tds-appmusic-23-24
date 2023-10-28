package umu.tds.vista.inicio;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

import umu.tds.AppMusic;
import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.Usuario;
import umu.tds.vista.main.PlantillaMain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaRegistro extends JPanel {
	private JPanel WindowRegister;
	private JTextPane txtpnDasdas;
	private JLabel lblUser;
	private JTextField textField;
	private JButton btnLogin;
	private JPanel jlblRegister;
	private JLabel lblRegister;
	private JButton btnRegister;
	private JPanel WindowRegister_1;
	private JProgressBar progressBar;
	private Component verticalStrut;
	private JLabel lblUser_1;
	private Component horizontalStrut;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private Component horizontalStrut_1;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JTextArea txtrLaContraseaDebe;
	private JButton btnLogin_1;
	private JPanel WindowRegister_2;
	private JProgressBar progressBar_1;
	private Component verticalStrut_1;
	private JLabel lblUser_2;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private Component horizontalStrut_2;
	private JLabel lblNewLabel_3;
	private Component horizontalStrut_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_1;
	private Component verticalStrut_2;
	private JLabel lblNewLabel_5;
	private JDateChooser dateChooser;
	private JButton btnLogin_2;
	private JPanel WindowRegister_3;
	private JProgressBar progressBar_2;
	private JLabel lblUser_3;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_6;
	private JPanel panel;
	private JCheckBox chckbxNewCheckBox;
	private JTextArea txtrQuieroQueMe;
	private JPanel panel_1;
	private JCheckBox chckbxNewCheckBox_1;
	private JTextArea txtrCompartirMisDatos;
	private JTextArea textArea;
	private Component verticalStrut_3;
	private Component horizontalStrut_4;
	private JButton btnLogin_3;
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

	public VentanaRegistro() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);

		WindowRegister = new JPanel();
		WindowRegister.setOpaque(false);
		WindowRegister.setForeground(Color.WHITE);
		add(WindowRegister, "WindowRegister");
		GridBagLayout gbl_WindowRegister = new GridBagLayout();
		gbl_WindowRegister.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_WindowRegister.rowHeights = new int[] { 92, 0, 0, 30, 0, 35, 0, 0 };
		WindowRegister.setLayout(gbl_WindowRegister);

		txtpnDasdas = new JTextPane();
		txtpnDasdas.setText("Regístrate para \nempezar a \nescuchar \ncontenido");
		txtpnDasdas.setOpaque(false);
		txtpnDasdas.setForeground(Color.WHITE);
		txtpnDasdas.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtpnDasdas.setEditable(false);
		GridBagConstraints gbc_txtpnDasdas = new GridBagConstraints();
		gbc_txtpnDasdas.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnDasdas.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnDasdas.gridx = 0;
		gbc_txtpnDasdas.gridy = 0;
		WindowRegister.add(txtpnDasdas, gbc_txtpnDasdas);

		verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 1;
		WindowRegister.add(verticalStrut_4, gbc_verticalStrut_4);

		lblUser = new JLabel("Dirección de correo electrónico");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser.gridx = 0;
		gbc_lblUser.gridy = 2;
		WindowRegister.add(lblUser, gbc_lblUser);

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setForeground(Color.WHITE);
		textField.setColumns(20);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		WindowRegister.add(textField, gbc_textField);

		verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_5.gridx = 0;
		gbc_verticalStrut_5.gridy = 4;
		WindowRegister.add(verticalStrut_5, gbc_verticalStrut_5);

		btnLogin = new JButton("     Siguiente     ");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(VentanaRegistro.this);
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 5;
		WindowRegister.add(btnLogin, gbc_btnLogin);

		verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_6.gridx = 0;
		gbc_verticalStrut_6.gridy = 6;
		WindowRegister.add(verticalStrut_6, gbc_verticalStrut_6);

		jlblRegister = new JPanel();
		jlblRegister.setForeground(Color.WHITE);
		GridBagConstraints gbc_jlblRegister = new GridBagConstraints();
		gbc_jlblRegister.fill = GridBagConstraints.BOTH;
		gbc_jlblRegister.gridx = 0;
		gbc_jlblRegister.gridy = 7;
		WindowRegister.add(jlblRegister, gbc_jlblRegister);

		lblRegister = new JLabel("¿Ya tienes una cuenta?");
		lblRegister.setForeground(new Color(204, 204, 204));
		jlblRegister.add(lblRegister);

		btnRegister = new JButton("Inicia sesión aquí");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlantillaInicio.salirRegistro();
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		jlblRegister.add(btnRegister);

		WindowRegister_1 = new JPanel();
		WindowRegister_1.setOpaque(false);
		WindowRegister_1.setForeground(Color.WHITE);
		add(WindowRegister_1, "WindowRegister_1");
		GridBagLayout gbl_WindowRegister_1 = new GridBagLayout();
		gbl_WindowRegister_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_WindowRegister_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 30, 0, 0, 35 };
		WindowRegister_1.setLayout(gbl_WindowRegister_1);

		progressBar = new JProgressBar();
		progressBar.setValue(33);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridwidth = 3;
		gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 0;
		WindowRegister_1.add(progressBar, gbc_progressBar);

		verticalStrut = Box.createVerticalStrut(5);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 1;
		WindowRegister_1.add(verticalStrut, gbc_verticalStrut);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.previous(VentanaRegistro.this);
			}
		});
		btnNewButton.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/umu/tds/vista/imagenes/arrow.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setContentAreaFilled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		WindowRegister_1.add(btnNewButton, gbc_btnNewButton);

		lblUser_1 = new JLabel("Paso 1 de 3");
		lblUser_1.setForeground(new Color(204, 204, 204));
		lblUser_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUser_1 = new GridBagConstraints();
		gbc_lblUser_1.anchor = GridBagConstraints.WEST;
		gbc_lblUser_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser_1.gridx = 1;
		gbc_lblUser_1.gridy = 2;
		WindowRegister_1.add(lblUser_1, gbc_lblUser_1);

		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 2;
		WindowRegister_1.add(horizontalStrut, gbc_horizontalStrut);

		lblNewLabel = new JLabel("Crea una contraseña");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		WindowRegister_1.add(lblNewLabel, gbc_lblNewLabel);

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 5;
		WindowRegister_1.add(horizontalStrut_1, gbc_horizontalStrut_1);

		lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		WindowRegister_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 6;
		WindowRegister_1.add(passwordField, gbc_passwordField);

		txtrLaContraseaDebe = new JTextArea(
				"La contraseña debe tener al menos 8 caracteres. Te\nrecomendamos que incluyas como mínimo\n1 número y 1 carácter especial.");
		txtrLaContraseaDebe.setOpaque(false);
		txtrLaContraseaDebe.setForeground(new Color(204, 204, 204));
		txtrLaContraseaDebe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrLaContraseaDebe.setEditable(false);
		GridBagConstraints gbc_txtrLaContraseaDebe = new GridBagConstraints();
		gbc_txtrLaContraseaDebe.fill = GridBagConstraints.BOTH;
		gbc_txtrLaContraseaDebe.insets = new Insets(0, 0, 5, 5);
		gbc_txtrLaContraseaDebe.gridx = 1;
		gbc_txtrLaContraseaDebe.gridy = 7;
		WindowRegister_1.add(txtrLaContraseaDebe, gbc_txtrLaContraseaDebe);

		verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 1;
		gbc_verticalStrut_7.gridy = 8;
		WindowRegister_1.add(verticalStrut_7, gbc_verticalStrut_7);

		btnLogin_1 = new JButton("     Siguiente     ");
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(VentanaRegistro.this);
			}
		});
		btnLogin_1.setForeground(Color.WHITE);
		btnLogin_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnLogin_1 = new GridBagConstraints();
		gbc_btnLogin_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin_1.gridx = 1;
		gbc_btnLogin_1.gridy = 9;
		WindowRegister_1.add(btnLogin_1, gbc_btnLogin_1);

		WindowRegister_2 = new JPanel();
		WindowRegister_2.setOpaque(false);
		WindowRegister_2.setForeground(Color.WHITE);
		add(WindowRegister_2, "name_99315507830600");
		GridBagLayout gbl_WindowRegister_2 = new GridBagLayout();
		gbl_WindowRegister_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		gbl_WindowRegister_2.rowHeights = new int[] { 0, -66, 0, 0, 0, 0, 0, 30, 0, 0, 30, 0, 35 };
		WindowRegister_2.setLayout(gbl_WindowRegister_2);

		progressBar_1 = new JProgressBar();
		progressBar_1.setValue(66);
		GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
		gbc_progressBar_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar_1.gridwidth = 3;
		gbc_progressBar_1.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar_1.gridx = 0;
		gbc_progressBar_1.gridy = 0;
		WindowRegister_2.add(progressBar_1, gbc_progressBar_1);

		verticalStrut_1 = Box.createVerticalStrut(5);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 1;
		WindowRegister_2.add(verticalStrut_1, gbc_verticalStrut_1);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.previous(VentanaRegistro.this);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/umu/tds/vista/imagenes/arrow.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setContentAreaFilled(false);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		WindowRegister_2.add(btnNewButton_1, gbc_btnNewButton_1);

		lblUser_2 = new JLabel("Paso 2 de 3");
		lblUser_2.setForeground(new Color(204, 204, 204));
		lblUser_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUser_2 = new GridBagConstraints();
		gbc_lblUser_2.anchor = GridBagConstraints.WEST;
		gbc_lblUser_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser_2.gridx = 1;
		gbc_lblUser_2.gridy = 2;
		WindowRegister_2.add(lblUser_2, gbc_lblUser_2);

		lblNewLabel_2 = new JLabel("Háblanos de ti");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		WindowRegister_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

		verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 1;
		gbc_verticalStrut_8.gridy = 4;
		WindowRegister_2.add(verticalStrut_8, gbc_verticalStrut_8);

		horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 5;
		WindowRegister_2.add(horizontalStrut_2, gbc_horizontalStrut_2);

		lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		WindowRegister_2.add(lblNewLabel_3, gbc_lblNewLabel_3);

		horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 5;
		WindowRegister_2.add(horizontalStrut_3, gbc_horizontalStrut_3);

		lblNewLabel_4 = new JLabel("Este nombre aparecerá en tu perfil");
		lblNewLabel_4.setForeground(new Color(204, 204, 204));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		WindowRegister_2.add(lblNewLabel_4, gbc_lblNewLabel_4);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 7;
		WindowRegister_2.add(textField_1, gbc_textField_1);

		verticalStrut_2 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 8;
		WindowRegister_2.add(verticalStrut_2, gbc_verticalStrut_2);

		lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 9;
		WindowRegister_2.add(lblNewLabel_5, gbc_lblNewLabel_5);

		dateChooser = new JDateChooser();
		dateChooser.setForeground(Color.WHITE);
		dateChooser.setDateFormatString("dd / MM / yyyy");
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 10;
		WindowRegister_2.add(dateChooser, gbc_dateChooser);

		verticalStrut_9 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_9 = new GridBagConstraints();
		gbc_verticalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_9.gridx = 1;
		gbc_verticalStrut_9.gridy = 11;
		WindowRegister_2.add(verticalStrut_9, gbc_verticalStrut_9);

		btnLogin_2 = new JButton("     Siguiente     ");
		btnLogin_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(VentanaRegistro.this);
			}
		});
		btnLogin_2.setForeground(Color.WHITE);
		btnLogin_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnLogin_2 = new GridBagConstraints();
		gbc_btnLogin_2.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin_2.gridx = 1;
		gbc_btnLogin_2.gridy = 12;
		WindowRegister_2.add(btnLogin_2, gbc_btnLogin_2);

		WindowRegister_3 = new JPanel();
		WindowRegister_3.setOpaque(false);
		WindowRegister_3.setForeground(Color.WHITE);
		add(WindowRegister_3, "name_99315527483000");
		GridBagLayout gbl_WindowRegister_3 = new GridBagLayout();
		gbl_WindowRegister_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_WindowRegister_3.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 35 };
		WindowRegister_3.setLayout(gbl_WindowRegister_3);

		progressBar_2 = new JProgressBar();
		progressBar_2.setValue(100);
		GridBagConstraints gbc_progressBar_2 = new GridBagConstraints();
		gbc_progressBar_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar_2.gridwidth = 3;
		gbc_progressBar_2.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar_2.gridx = 0;
		gbc_progressBar_2.gridy = 0;
		WindowRegister_3.add(progressBar_2, gbc_progressBar_2);

		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.previous(VentanaRegistro.this);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/umu/tds/vista/imagenes/arrow.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setContentAreaFilled(false);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridheight = 2;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 1;
		WindowRegister_3.add(btnNewButton_2, gbc_btnNewButton_2);

		lblUser_3 = new JLabel("Paso 3 de 3");
		lblUser_3.setForeground(new Color(204, 204, 204));
		lblUser_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUser_3 = new GridBagConstraints();
		gbc_lblUser_3.anchor = GridBagConstraints.WEST;
		gbc_lblUser_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser_3.gridx = 1;
		gbc_lblUser_3.gridy = 1;
		WindowRegister_3.add(lblUser_3, gbc_lblUser_3);

		lblNewLabel_6 = new JLabel("Términos y Condiciones");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 2;
		WindowRegister_3.add(lblNewLabel_6, gbc_lblNewLabel_6);

		verticalStrut_10 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_10 = new GridBagConstraints();
		gbc_verticalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_10.gridx = 1;
		gbc_verticalStrut_10.gridy = 3;
		WindowRegister_3.add(verticalStrut_10, gbc_verticalStrut_10);

		panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		WindowRegister_3.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 21, 205, 0 };
		gbl_panel.rowHeights = new int[] { 32, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.NORTH;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 0;
		panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		txtrQuieroQueMe = new JTextArea("Quiero que me enviéis novedades y ofertas\r\nde Spotify.");
		txtrQuieroQueMe.setOpaque(false);
		txtrQuieroQueMe.setForeground(Color.WHITE);
		txtrQuieroQueMe.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrQuieroQueMe.setEditable(false);
		GridBagConstraints gbc_txtrQuieroQueMe = new GridBagConstraints();
		gbc_txtrQuieroQueMe.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtrQuieroQueMe.gridx = 1;
		gbc_txtrQuieroQueMe.gridy = 0;
		panel.add(txtrQuieroQueMe, gbc_txtrQuieroQueMe);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 5;
		WindowRegister_3.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 21, 234, 0 };
		gbl_panel_1.rowHeights = new int[] { 88, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setOpaque(false);
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxNewCheckBox_1.anchor = GridBagConstraints.NORTH;
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_1.gridx = 0;
		gbc_chckbxNewCheckBox_1.gridy = 0;
		panel_1.add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);

		txtrCompartirMisDatos = new JTextArea(
				"Compartir mis datos de registro con los\nproveedores de contenidos de AppMusic para\nfines de marketing. Ten en cuenta que tus\ndatos pueden ser transferidos a un país de\nfuera del EEE, tal y como se recoge en nuestra\nPolítica de Privacidad.");
		txtrCompartirMisDatos.setOpaque(false);
		txtrCompartirMisDatos.setForeground(Color.WHITE);
		txtrCompartirMisDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrCompartirMisDatos.setEditable(false);
		GridBagConstraints gbc_txtrCompartirMisDatos = new GridBagConstraints();
		gbc_txtrCompartirMisDatos.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtrCompartirMisDatos.gridx = 1;
		gbc_txtrCompartirMisDatos.gridy = 0;
		panel_1.add(txtrCompartirMisDatos, gbc_txtrCompartirMisDatos);

		verticalStrut_11 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_11 = new GridBagConstraints();
		gbc_verticalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_11.gridx = 1;
		gbc_verticalStrut_11.gridy = 6;
		WindowRegister_3.add(verticalStrut_11, gbc_verticalStrut_11);

		textArea = new JTextArea(
				"Al hacer clic en Registrarte, aceptas los Términos y\ncondiciones de uso de AppMusic.");
		textArea.setOpaque(false);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 11));
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 7;
		WindowRegister_3.add(textArea, gbc_textArea);

		verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 8;
		WindowRegister_3.add(verticalStrut_3, gbc_verticalStrut_3);

		horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 9;
		WindowRegister_3.add(horizontalStrut_4, gbc_horizontalStrut_4);

		btnLogin_3 = new JButton("     Regístrate     ");
		btnLogin_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty() || new String(passwordField.getPassword()).isEmpty()
						|| textField_1.getText().isEmpty() || dateChooser.getDate().equals(null))
					System.out.println("NO SE HA PODIDO REGISTRA");
				else {
					Controlador.getUnicaInstancia().registrarUsuario(textField_1.getText(), textField.getText(),
							dateChooser.getDate(), new String(passwordField.getPassword()));
					System.out.println("SI HA PODIDO");

					// AQUI SE TIENE QUE LLAMAR A ALGUNA FUNCION QUE ESCONDA LA VENTANA LOGIN Y
					// PONGA ALGO JOptionPane que algun texto

					System.out.println("nombre \t email \t contraseña" + "\n");
					for (Usuario u : Controlador.getUnicaInstancia().getUsuarios()) {
						String n = String.format("%1$-30s", u.getNombre());
						String e1 = String.format("%1$-30s", u.getEmail());
						String c = String.format("%1$-30s", u.getContraseña());
						Boolean p = u.isPremium();

						System.out.println(n + " " + e1 + " " + c + " " + p + "\n");
						for (PlayList pl : u.getListaPlayList())
							System.out.println(pl.getNombre());
						for (Cancion ca : u.getListaCancionesRecientes())
							System.out.println(ca.getTitulo());
					}

					PlantillaMain.main(null);
					AppMusic.ocultarPlantillaLogin();
				}

			}

		});
		btnLogin_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnLogin_3 = new GridBagConstraints();
		gbc_btnLogin_3.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin_3.gridx = 1;
		gbc_btnLogin_3.gridy = 9;
		WindowRegister_3.add(btnLogin_3, gbc_btnLogin_3);

		horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.gridx = 2;
		gbc_horizontalStrut_5.gridy = 9;
		WindowRegister_3.add(horizontalStrut_5, gbc_horizontalStrut_5);
	}
}