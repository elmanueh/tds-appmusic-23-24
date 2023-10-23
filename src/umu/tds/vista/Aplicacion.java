package umu.tds.vista;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Aplicacion {

	private JFrame frame;
	private JTextField textUser;
	private JLabel lblAppMusic;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel lblRecoveryPassword;
	private JPanel jlblRegister;
	private JLabel lblRegister;
	private JButton btnRegister;
	private JPanel WindowRegister;
	private JLabel lblAppMusic_1;
	private JLabel lblUser_1;
	private JTextField textField;
	private JButton btnLogin_1;
	private JPanel jlblRegister_1;
	private JLabel lblRegister_1;
	private JButton btnRegister_1;
	private JPanel WindowRegister_1;
	private JLabel lblUser_2;
	private JButton btnLogin_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JPanel WindowRegister_2;
	private JLabel lblUser_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnLogin_3;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_10;
	private JTextField textField_1;
	private JLabel lblNewLabel_11;
	private JPanel WindowRegister_3;
	private JLabel lblUser_4;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JButton btnLogin_4;
	private JButton btnNewButton_2;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JLabel lblNewLabel_14;
	private JDateChooser dateChooser;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
					Aplicacion window = new Aplicacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aplicacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(30, 30, 30));
		frame.setBackground(new Color(30, 30, 30));
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 563, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel WindowLogin = new JPanel();
		WindowLogin.setOpaque(false);
		WindowLogin.setForeground(new Color(255, 255, 255));
		WindowLogin.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(WindowLogin, "WindowLogin");
		GridBagLayout gbl_WindowLogin = new GridBagLayout();
		gbl_WindowLogin.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowLogin.rowHeights = new int[]{0, 30, 0, 30, 0, 0, 0, 0, 30, 0, 30, 0, 0};
		gbl_WindowLogin.columnWidths = new int[]{20, 0, 0};
		gbl_WindowLogin.columnWeights = new double[]{0.0, 0.0, 0.0};
		WindowLogin.setLayout(gbl_WindowLogin);
		
		lblAppMusic = new JLabel("Inicia sesión en AppMusic");
		lblAppMusic.setForeground(new Color(255, 255, 255));
		lblAppMusic.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GridBagConstraints gbc_lblAppMusic = new GridBagConstraints();
		gbc_lblAppMusic.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAppMusic.gridwidth = 3;
		gbc_lblAppMusic.insets = new Insets(0, 0, 5, 0);
		gbc_lblAppMusic.gridx = 0;
		gbc_lblAppMusic.gridy = 0;
		WindowLogin.add(lblAppMusic, gbc_lblAppMusic);
		
		btnNewButton_3 = new JButton("  Continuar con GitHub");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setIcon(new ImageIcon(Aplicacion.class.getResource("/umu/tds/vista/imagenes/github-icon.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(WindowLogin, "En mantenimiento.");
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 2;
		WindowLogin.add(btnNewButton_3, gbc_btnNewButton_3);
		
		lblUser = new JLabel("Correo electrónico o nombre de usuario");
		lblUser.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 4;
		WindowLogin.add(lblUser, gbc_lblUser);
		
		textUser = new JTextField();
		textUser.setForeground(new Color(255, 255, 255));
		textUser.setToolTipText("");
		GridBagConstraints gbc_textUser = new GridBagConstraints();
		gbc_textUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUser.insets = new Insets(0, 0, 5, 5);
		gbc_textUser.gridx = 1;
		gbc_textUser.gridy = 5;
		WindowLogin.add(textUser, gbc_textUser);
		textUser.setColumns(20);
		
		lblPassword = new JLabel("Contraseñaaa");
		lblPassword.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 6;
		WindowLogin.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setColumns(20);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 7;
		WindowLogin.add(passwordField, gbc_passwordField);
		
		btnLogin = new JButton("Iniciar Sesión");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMain main = new VentanaMain();
				main.setVisible(true);
				frame.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 9;
		WindowLogin.add(btnLogin, gbc_btnLogin);
		
		lblRecoveryPassword = new JLabel("¿Has olvidado tu contraseña?");
		lblRecoveryPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(WindowLogin, "Pues acuerdate crack");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRecoveryPassword.setForeground(new Color(68, 110, 158));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRecoveryPassword.setForeground(new Color(255, 255, 255));
			}
		});
		lblRecoveryPassword.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblRecoveryPassword = new GridBagConstraints();
		gbc_lblRecoveryPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblRecoveryPassword.gridx = 1;
		gbc_lblRecoveryPassword.gridy = 11;
		WindowLogin.add(lblRecoveryPassword, gbc_lblRecoveryPassword);
		
		jlblRegister = new JPanel();
		jlblRegister.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_jlblRegister = new GridBagConstraints();
		gbc_jlblRegister.insets = new Insets(0, 0, 0, 5);
		gbc_jlblRegister.fill = GridBagConstraints.BOTH;
		gbc_jlblRegister.gridx = 1;
		gbc_jlblRegister.gridy = 12;
		WindowLogin.add(jlblRegister, gbc_jlblRegister);
		
		lblRegister = new JLabel("¿No tienes cuenta?");
		lblRegister.setForeground(new Color(255, 255, 255));
		jlblRegister.add(lblRegister);
		
		btnRegister = new JButton("Regístrate en AppMusic");
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "WindowRegister");
			}
		});
		jlblRegister.add(btnRegister);
		
		WindowRegister = new JPanel();
		WindowRegister.setForeground(new Color(255, 255, 255));
		WindowRegister.setOpaque(false);
		frame.getContentPane().add(WindowRegister, "WindowRegister");
		GridBagLayout gbl_WindowRegister = new GridBagLayout();
		gbl_WindowRegister.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowRegister.rowHeights = new int[]{0, 30, 0, 0, 30, 0, 30, 0};
		WindowRegister.setLayout(gbl_WindowRegister);
		
		lblAppMusic_1 = new JLabel("Regístrate para empezar a escuchar contenido");
		lblAppMusic_1.setForeground(new Color(255, 255, 255));
		lblAppMusic_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblAppMusic_1 = new GridBagConstraints();
		gbc_lblAppMusic_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAppMusic_1.gridwidth = 3;
		gbc_lblAppMusic_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblAppMusic_1.gridx = 0;
		gbc_lblAppMusic_1.gridy = 0;
		WindowRegister.add(lblAppMusic_1, gbc_lblAppMusic_1);
		
		lblUser_1 = new JLabel("Dirección de correo electrónico");
		lblUser_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblUser_1 = new GridBagConstraints();
		gbc_lblUser_1.anchor = GridBagConstraints.WEST;
		gbc_lblUser_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser_1.gridx = 1;
		gbc_lblUser_1.gridy = 2;
		WindowRegister.add(lblUser_1, gbc_lblUser_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setToolTipText("");
		textField.setColumns(20);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		WindowRegister.add(textField, gbc_textField);
		
		btnLogin_1 = new JButton("Siguiente");
		btnLogin_1.setForeground(new Color(255, 255, 255));
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "WindowRegister_1");
			}
		});
		GridBagConstraints gbc_btnLogin_1 = new GridBagConstraints();
		gbc_btnLogin_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin_1.gridx = 1;
		gbc_btnLogin_1.gridy = 5;
		WindowRegister.add(btnLogin_1, gbc_btnLogin_1);
		
		jlblRegister_1 = new JPanel();
		jlblRegister_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_jlblRegister_1 = new GridBagConstraints();
		gbc_jlblRegister_1.fill = GridBagConstraints.BOTH;
		gbc_jlblRegister_1.insets = new Insets(0, 0, 0, 5);
		gbc_jlblRegister_1.gridx = 1;
		gbc_jlblRegister_1.gridy = 7;
		WindowRegister.add(jlblRegister_1, gbc_jlblRegister_1);
		
		lblRegister_1 = new JLabel("¿Ya tienes una cuenta?");
		lblRegister_1.setForeground(new Color(255, 255, 255));
		jlblRegister_1.add(lblRegister_1);
		
		btnRegister_1 = new JButton("Inicia sesión aquí");
		btnRegister_1.setForeground(new Color(255, 255, 255));
		btnRegister_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "WindowLogin");
			}
		});
		jlblRegister_1.add(btnRegister_1);
		
		WindowRegister_1 = new JPanel();
		WindowRegister_1.setForeground(new Color(255, 255, 255));
		WindowRegister_1.setOpaque(false);
		frame.getContentPane().add(WindowRegister_1, "WindowRegister_1");
		GridBagLayout gbl_WindowRegister_1 = new GridBagLayout();
		gbl_WindowRegister_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowRegister_1.rowHeights = new int[]{0, 0, 30, 0, 0, 0, 0, 0, 30, 0, 30, 0};
		gbl_WindowRegister_1.columnWeights = new double[]{0.0};
		WindowRegister_1.setLayout(gbl_WindowRegister_1);
		
		lblUser_2 = new JLabel("Paso 1 de 3");
		GridBagConstraints gbc_lblUser_2 = new GridBagConstraints();
		gbc_lblUser_2.anchor = GridBagConstraints.WEST;
		gbc_lblUser_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser_2.gridx = 0;
		gbc_lblUser_2.gridy = 0;
		WindowRegister_1.add(lblUser_2, gbc_lblUser_2);
		
		lblNewLabel = new JLabel("Crea una contraseña");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		WindowRegister_1.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Contraseña");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		WindowRegister_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.gridx = 0;
		gbc_passwordField_1.gridy = 4;
		WindowRegister_1.add(passwordField_1, gbc_passwordField_1);
		
		lblNewLabel_2 = new JLabel("La contraseña debe tener al menos 8 caracteres.");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		WindowRegister_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Te recomendamos que incluyas como mínimo");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		WindowRegister_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("1 número y 1 carácter especial.");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 7;
		WindowRegister_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		btnLogin_2 = new JButton("Siguiente");
		btnLogin_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "WindowRegister_2");
			}
		});
		GridBagConstraints gbc_btnLogin_2 = new GridBagConstraints();
		gbc_btnLogin_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin_2.gridx = 0;
		gbc_btnLogin_2.gridy = 9;
		WindowRegister_1.add(btnLogin_2, gbc_btnLogin_2);
		
		btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "WindowRegister");
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 11;
		WindowRegister_1.add(btnNewButton, gbc_btnNewButton);
		
		WindowRegister_2 = new JPanel();
		WindowRegister_2.setForeground(new Color(255, 255, 255));
		WindowRegister_2.setOpaque(false);
		frame.getContentPane().add(WindowRegister_2, "WindowRegister_2");
		GridBagLayout gbl_WindowRegister_2 = new GridBagLayout();
		gbl_WindowRegister_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowRegister_2.rowHeights = new int[]{0, 0, 30, 0, 0, 0, 30, 0, 0, 30, 0, 0, 0, 0, 30, 0, 30, 0};
		gbl_WindowRegister_2.columnWeights = new double[]{0.0};
		gbl_WindowRegister_2.columnWidths = new int[]{0};
		WindowRegister_2.setLayout(gbl_WindowRegister_2);
		
		lblUser_3 = new JLabel("Paso 2 de 3");
		GridBagConstraints gbc_lblUser_3 = new GridBagConstraints();
		gbc_lblUser_3.anchor = GridBagConstraints.WEST;
		gbc_lblUser_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser_3.gridx = 0;
		gbc_lblUser_3.gridy = 0;
		WindowRegister_2.add(lblUser_3, gbc_lblUser_3);
		
		lblNewLabel_5 = new JLabel("Háblanos de ti");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 1;
		WindowRegister_2.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 3;
		WindowRegister_2.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		lblNewLabel_10 = new JLabel("Este nombre aparecerá en tu perfil");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 4;
		WindowRegister_2.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 5;
		WindowRegister_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Fecha de nacimiento");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 7;
		WindowRegister_2.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 0;
		gbc_dateChooser.gridy = 8;
		WindowRegister_2.add(dateChooser, gbc_dateChooser);
		
		btnLogin_3 = new JButton("Siguiente");
		btnLogin_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "WindowRegister_3");

			}
		});
		GridBagConstraints gbc_btnLogin_3 = new GridBagConstraints();
		gbc_btnLogin_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin_3.gridx = 0;
		gbc_btnLogin_3.gridy = 10;
		WindowRegister_2.add(btnLogin_3, gbc_btnLogin_3);
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "WindowRegister_1");

			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 11;
		WindowRegister_2.add(btnNewButton_1, gbc_btnNewButton_1);
		
		WindowRegister_3 = new JPanel();
		WindowRegister_3.setForeground(new Color(255, 255, 255));
		WindowRegister_3.setOpaque(false);
		frame.getContentPane().add(WindowRegister_3, "WindowRegister_3");
		GridBagLayout gbl_WindowRegister_3 = new GridBagLayout();
		gbl_WindowRegister_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowRegister_3.rowHeights = new int[]{0, 0, 30, 0, 0, 30, 0, 0, 0, 0, 0, 30, 0};
		WindowRegister_3.setLayout(gbl_WindowRegister_3);
		
		lblUser_4 = new JLabel("Paso 3 de 3");
		GridBagConstraints gbc_lblUser_4 = new GridBagConstraints();
		gbc_lblUser_4.anchor = GridBagConstraints.WEST;
		gbc_lblUser_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser_4.gridx = 0;
		gbc_lblUser_4.gridy = 0;
		WindowRegister_3.add(lblUser_4, gbc_lblUser_4);
		
		lblNewLabel_13 = new JLabel("Términos y Condiciones");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 1;
		WindowRegister_3.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		chckbxNewCheckBox = new JCheckBox("Quiero que me enviéis novedades y ofertas de Spotify");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 3;
		WindowRegister_3.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Compartir mis datos de registro con los proveedores de contenido...");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 6));
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_1.gridx = 0;
		gbc_chckbxNewCheckBox_1.gridy = 4;
		WindowRegister_3.add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);
		
		lblNewLabel_15 = new JLabel("Al hacer clic en Registrarte, aceptas los Términos y condiciones de uso de Spotify.");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_15.gridx = 0;
		gbc_lblNewLabel_15.gridy = 6;
		WindowRegister_3.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Para obtener más información acerca de cómo Spotify \r\n");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_16.gridx = 0;
		gbc_lblNewLabel_16.gridy = 7;
		WindowRegister_3.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("\r\nrecopila, utiliza, comparte y protege tus datos personales, \r\n");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_17.gridx = 0;
		gbc_lblNewLabel_17.gridy = 8;
		WindowRegister_3.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		lblNewLabel_14 = new JLabel("\r\nconsulta la Política de privacidad de Spotify.");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 9;
		WindowRegister_3.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		btnLogin_4 = new JButton("Regístrate");
		GridBagConstraints gbc_btnLogin_4 = new GridBagConstraints();
		gbc_btnLogin_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin_4.gridx = 0;
		gbc_btnLogin_4.gridy = 10;
		WindowRegister_3.add(btnLogin_4, gbc_btnLogin_4);
		
		btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "WindowRegister_2");
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 12;
		WindowRegister_3.add(btnNewButton_2, gbc_btnNewButton_2);
		GridBagConstraints gbc_panelFormulario = new GridBagConstraints();
	}

}
