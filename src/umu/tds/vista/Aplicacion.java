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
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;

public class Aplicacion {

	JFrame frmAppmusic;
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
	private JPanel WindowRegister_2;
	private JLabel lblUser_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnLogin_3;
	private JLabel lblNewLabel_10;
	private JTextField textField_1;
	private JLabel lblNewLabel_11;
	private JPanel WindowRegister_3;
	private JLabel lblUser_4;
	private JLabel lblNewLabel_13;
	private JButton btnLogin_4;
	private JDateChooser dateChooser;
	private JButton btnNewButton_3;
	private JTextPane txtpnDasdas;
	private JProgressBar progressBar;
	private Component verticalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut_1;
	private JButton btnNewButton_4;
	private Component horizontalStrut_2;
	private JTextArea txtrLaContraseaDebe;
	private JProgressBar progressBar_1;
	private Component horizontalStrut;
	private Component horizontalStrut_3;
	private JButton btnNewButton;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private JProgressBar progressBar_2;
	private Component horizontalStrut_4;
	private Component horizontalStrut_5;
	private JButton btnNewButton_1;
	private JPanel panel;
	private JCheckBox chckbxNewCheckBox_2;
	private JTextArea txtrQuieroQueMe;
	private JPanel panel_1;
	private JCheckBox chckbxNewCheckBox;
	private JTextArea txtrCompartirMisDatos;
	private JTextArea textArea_2;
	private Component verticalStrut_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
					Aplicacion window = new Aplicacion();
					window.frmAppmusic.setVisible(true);
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
		frmAppmusic = new JFrame();
		frmAppmusic.setTitle("AppMusic");
		frmAppmusic.setIconImage(Toolkit.getDefaultToolkit().getImage(Aplicacion.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		frmAppmusic.getContentPane().setBackground(new Color(30, 30, 30));
		frmAppmusic.setBackground(new Color(30, 30, 30));
		frmAppmusic.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 19));
		frmAppmusic.getContentPane().setForeground(new Color(255, 255, 255));
		frmAppmusic.setForeground(new Color(255, 255, 255));
		frmAppmusic.setBounds(100, 100, 563, 551);
		frmAppmusic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppmusic.getContentPane().setLayout(new CardLayout(0, 0));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventanaSize = frmAppmusic.getSize();
		frmAppmusic.setLocation((pantalla.width - ventanaSize.width) / 2, (pantalla.height - ventanaSize.height) / 2);
		
		JPanel WindowLogin = new JPanel();
		WindowLogin.setOpaque(false);
		WindowLogin.setForeground(new Color(255, 255, 255));
		WindowLogin.setBackground(new Color(255, 255, 255));
		frmAppmusic.getContentPane().add(WindowLogin, "WindowLogin");
		GridBagLayout gbl_WindowLogin = new GridBagLayout();
		gbl_WindowLogin.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowLogin.rowHeights = new int[]{0, 30, 40, 30, 0, 30, 10, 0, 30, 30, 33, 30, 0, 10, 40};
		gbl_WindowLogin.columnWidths = new int[]{53, 0, 0};
		gbl_WindowLogin.columnWeights = new double[]{0.0, 0.0, 0.0};
		WindowLogin.setLayout(gbl_WindowLogin);
		
		lblAppMusic = new JLabel("Inicia sesión en AppMusic");
		lblAppMusic.setForeground(new Color(255, 255, 255));
		lblAppMusic.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblAppMusic = new GridBagConstraints();
		gbc_lblAppMusic.gridwidth = 3;
		gbc_lblAppMusic.insets = new Insets(0, 0, 5, 0);
		gbc_lblAppMusic.gridx = 0;
		gbc_lblAppMusic.gridy = 0;
		WindowLogin.add(lblAppMusic, gbc_lblAppMusic);
		
		btnNewButton_3 = new JButton("  Continuar con GitHub");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setIcon(new ImageIcon(Aplicacion.class.getResource("/umu/tds/vista/imagenes/github-icon.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(WindowLogin, "En mantenimiento.");
			}
		});
		
		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 2;
		WindowLogin.add(verticalStrut, gbc_verticalStrut);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 2;
		WindowLogin.add(btnNewButton_3, gbc_btnNewButton_3);
		
		lblUser = new JLabel("Correo electrónico o nombre de usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 4;
		WindowLogin.add(lblUser, gbc_lblUser);
		
		textUser = new JTextField();
		textUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textUser.setForeground(new Color(255, 255, 255));
		textUser.setToolTipText("");
		GridBagConstraints gbc_textUser = new GridBagConstraints();
		gbc_textUser.fill = GridBagConstraints.BOTH;
		gbc_textUser.insets = new Insets(0, 0, 5, 5);
		gbc_textUser.gridx = 1;
		gbc_textUser.gridy = 5;
		WindowLogin.add(textUser, gbc_textUser);
		textUser.setColumns(20);
		
		lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 7;
		WindowLogin.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordField.setToolTipText("");
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setColumns(20);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 8;
		WindowLogin.add(passwordField, gbc_passwordField);
		
		btnLogin = new JButton("     Iniciar Sesión     ");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMain main = new VentanaMain();
				main.setVisible(true);
				frmAppmusic.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 10;
		WindowLogin.add(btnLogin, gbc_btnLogin);
		
		lblRecoveryPassword = new JLabel("¿Has olvidado tu contraseña?");
		lblRecoveryPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(WindowLogin, "Las constraseñas no deben olvidarse, haz memoria.");
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
		gbc_lblRecoveryPassword.gridy = 12;
		WindowLogin.add(lblRecoveryPassword, gbc_lblRecoveryPassword);
		
		jlblRegister = new JPanel();
		jlblRegister.setBackground(Color.DARK_GRAY);
		jlblRegister.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_jlblRegister = new GridBagConstraints();
		gbc_jlblRegister.anchor = GridBagConstraints.NORTH;
		gbc_jlblRegister.insets = new Insets(0, 0, 0, 5);
		gbc_jlblRegister.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblRegister.gridx = 1;
		gbc_jlblRegister.gridy = 14;
		WindowLogin.add(jlblRegister, gbc_jlblRegister);
		
		btnRegister = new JButton("Regístrate en AppMusic");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frmAppmusic.getContentPane().getLayout();
				card.show(frmAppmusic.getContentPane(), "WindowRegister");
			}
		});
		jlblRegister.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblRegister = new JLabel("¿No tienes cuenta?");
		lblRegister.setForeground(new Color(204, 204, 204));
		jlblRegister.add(lblRegister);
		jlblRegister.add(btnRegister);
		
		WindowRegister = new JPanel();
		WindowRegister.setForeground(new Color(255, 255, 255));
		WindowRegister.setOpaque(false);
		frmAppmusic.getContentPane().add(WindowRegister, "WindowRegister");
		GridBagLayout gbl_WindowRegister = new GridBagLayout();
		gbl_WindowRegister.columnWeights = new double[]{0.0};
		gbl_WindowRegister.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowRegister.rowHeights = new int[]{0, 30, 0, 30, 15, 33, 30, 0};
		WindowRegister.setLayout(gbl_WindowRegister);
		
		txtpnDasdas = new JTextPane();
		txtpnDasdas.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtpnDasdas.setForeground(new Color(255, 255, 255));
		txtpnDasdas.setOpaque(false);
		txtpnDasdas.setEditable(false);
		txtpnDasdas.setText("Regístrate para \nempezar a \nescuchar \ncontenido");
		GridBagConstraints gbc_txtpnDasdas = new GridBagConstraints();
		gbc_txtpnDasdas.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnDasdas.fill = GridBagConstraints.BOTH;
		gbc_txtpnDasdas.gridx = 0;
		gbc_txtpnDasdas.gridy = 0;
		WindowRegister.add(txtpnDasdas, gbc_txtpnDasdas);
		
		lblUser_1 = new JLabel("Dirección de correo electrónico");
		lblUser_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblUser_1 = new GridBagConstraints();
		gbc_lblUser_1.anchor = GridBagConstraints.WEST;
		gbc_lblUser_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser_1.gridx = 0;
		gbc_lblUser_1.gridy = 2;
		WindowRegister.add(lblUser_1, gbc_lblUser_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setToolTipText("");
		textField.setColumns(20);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		WindowRegister.add(textField, gbc_textField);
		
		btnLogin_1 = new JButton("     Siguiente     ");
		btnLogin_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin_1.setForeground(new Color(255, 255, 255));
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frmAppmusic.getContentPane().getLayout();
				card.show(frmAppmusic.getContentPane(), "WindowRegister_1");
			}
		});
		GridBagConstraints gbc_btnLogin_1 = new GridBagConstraints();
		gbc_btnLogin_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin_1.gridx = 0;
		gbc_btnLogin_1.gridy = 5;
		WindowRegister.add(btnLogin_1, gbc_btnLogin_1);
		
		jlblRegister_1 = new JPanel();
		jlblRegister_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_jlblRegister_1 = new GridBagConstraints();
		gbc_jlblRegister_1.fill = GridBagConstraints.BOTH;
		gbc_jlblRegister_1.gridx = 0;
		gbc_jlblRegister_1.gridy = 7;
		WindowRegister.add(jlblRegister_1, gbc_jlblRegister_1);
		
		lblRegister_1 = new JLabel("¿Ya tienes una cuenta?");
		lblRegister_1.setForeground(new Color(204, 204, 204));
		jlblRegister_1.add(lblRegister_1);
		
		btnRegister_1 = new JButton("Inicia sesión aquí");
		btnRegister_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegister_1.setForeground(new Color(255, 255, 255));
		btnRegister_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frmAppmusic.getContentPane().getLayout();
				card.show(frmAppmusic.getContentPane(), "WindowLogin");
			}
		});
		jlblRegister_1.add(btnRegister_1);
		
		WindowRegister_1 = new JPanel();
		WindowRegister_1.setForeground(new Color(255, 255, 255));
		WindowRegister_1.setOpaque(false);
		frmAppmusic.getContentPane().add(WindowRegister_1, "WindowRegister_1");
		GridBagLayout gbl_WindowRegister_1 = new GridBagLayout();
		gbl_WindowRegister_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowRegister_1.rowHeights = new int[]{0, 0, 0, 0, 30, 0, 30, 0, 30, 33, 30, 0};
		gbl_WindowRegister_1.columnWeights = new double[]{0.0, 0.0, 0.0};
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
		
		verticalStrut_1 = Box.createVerticalStrut(5);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 1;
		WindowRegister_1.add(verticalStrut_1, gbc_verticalStrut_1);
		
		lblUser_2 = new JLabel("Paso 1 de 3");
		lblUser_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUser_2.setForeground(new Color(204, 204, 204));
		GridBagConstraints gbc_lblUser_2 = new GridBagConstraints();
		gbc_lblUser_2.anchor = GridBagConstraints.WEST;
		gbc_lblUser_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser_2.gridx = 1;
		gbc_lblUser_2.gridy = 2;
		WindowRegister_1.add(lblUser_2, gbc_lblUser_2);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 2;
		gbc_horizontalStrut_1.gridy = 2;
		WindowRegister_1.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(Aplicacion.class.getResource("/umu/tds/vista/imagenes/arrow.png")));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frmAppmusic.getContentPane().getLayout();
				card.show(frmAppmusic.getContentPane(), "WindowRegister");
			}
		});
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridheight = 2;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 2;
		WindowRegister_1.add(btnNewButton_4, gbc_btnNewButton_4);
		
		lblNewLabel = new JLabel("Crea una contraseña");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		WindowRegister_1.add(lblNewLabel, gbc_lblNewLabel);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 5;
		WindowRegister_1.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		WindowRegister_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_1.fill = GridBagConstraints.BOTH;
		gbc_passwordField_1.gridx = 1;
		gbc_passwordField_1.gridy = 6;
		WindowRegister_1.add(passwordField_1, gbc_passwordField_1);
		
		txtrLaContraseaDebe = new JTextArea("La contraseña debe tener al menos 8 caracteres. Te\nrecomendamos que incluyas como mínimo\n1 número y 1 carácter especial.");
		txtrLaContraseaDebe.setOpaque(false);
		txtrLaContraseaDebe.setForeground(new Color(204, 204, 204));
		txtrLaContraseaDebe.setEditable(false);
		txtrLaContraseaDebe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_txtrLaContraseaDebe = new GridBagConstraints();
		gbc_txtrLaContraseaDebe.insets = new Insets(0, 0, 5, 5);
		gbc_txtrLaContraseaDebe.fill = GridBagConstraints.BOTH;
		gbc_txtrLaContraseaDebe.gridx = 1;
		gbc_txtrLaContraseaDebe.gridy = 7;
		WindowRegister_1.add(txtrLaContraseaDebe, gbc_txtrLaContraseaDebe);
		
		btnLogin_2 = new JButton("     Siguiente     ");
		btnLogin_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin_2.setForeground(new Color(255, 255, 255));
		btnLogin_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frmAppmusic.getContentPane().getLayout();
				card.show(frmAppmusic.getContentPane(), "WindowRegister_2");
			}
		});
		GridBagConstraints gbc_btnLogin_2 = new GridBagConstraints();
		gbc_btnLogin_2.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin_2.gridx = 1;
		gbc_btnLogin_2.gridy = 9;
		WindowRegister_1.add(btnLogin_2, gbc_btnLogin_2);
		
		WindowRegister_2 = new JPanel();
		WindowRegister_2.setForeground(new Color(255, 255, 255));
		WindowRegister_2.setOpaque(false);
		frmAppmusic.getContentPane().add(WindowRegister_2, "WindowRegister_2");
		GridBagLayout gbl_WindowRegister_2 = new GridBagLayout();
		gbl_WindowRegister_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowRegister_2.rowHeights = new int[]{0, 0, 0, 0, 30, 0, 0, 30, 0, 0, 0, 30, 33, 0};
		gbl_WindowRegister_2.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_WindowRegister_2.columnWidths = new int[]{0, 0, 0};
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
		
		verticalStrut_2 = Box.createVerticalStrut(5);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 1;
		WindowRegister_2.add(verticalStrut_2, gbc_verticalStrut_2);
		
		lblUser_3 = new JLabel("Paso 2 de 3");
		lblUser_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUser_3.setForeground(new Color(204, 204, 204));
		GridBagConstraints gbc_lblUser_3 = new GridBagConstraints();
		gbc_lblUser_3.anchor = GridBagConstraints.WEST;
		gbc_lblUser_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser_3.gridx = 1;
		gbc_lblUser_3.gridy = 2;
		WindowRegister_2.add(lblUser_3, gbc_lblUser_3);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Aplicacion.class.getResource("/umu/tds/vista/imagenes/arrow.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frmAppmusic.getContentPane().getLayout();
				card.show(frmAppmusic.getContentPane(), "WindowRegister_1");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setContentAreaFilled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		WindowRegister_2.add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel_5 = new JLabel("Háblanos de ti");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 3;
		WindowRegister_2.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 5;
		WindowRegister_2.add(horizontalStrut, gbc_horizontalStrut);
		
		lblNewLabel_6 = new JLabel("Nombre");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 5;
		WindowRegister_2.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 5;
		WindowRegister_2.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		lblNewLabel_10 = new JLabel("Este nombre aparecerá en tu perfil");
		lblNewLabel_10.setForeground(new Color(204, 204, 204));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 6;
		WindowRegister_2.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 7;
		WindowRegister_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		verticalStrut_3 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 8;
		WindowRegister_2.add(verticalStrut_3, gbc_verticalStrut_3);
		
		lblNewLabel_11 = new JLabel("Fecha de nacimiento");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 9;
		WindowRegister_2.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(255, 255, 255));
		dateChooser.setDateFormatString("dd / MM / yyyy");
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 10;
		WindowRegister_2.add(dateChooser, gbc_dateChooser);
		
		btnLogin_3 = new JButton("     Siguiente     ");
		btnLogin_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin_3.setForeground(new Color(255, 255, 255));
		btnLogin_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frmAppmusic.getContentPane().getLayout();
				card.show(frmAppmusic.getContentPane(), "WindowRegister_3");

			}
		});
		GridBagConstraints gbc_btnLogin_3 = new GridBagConstraints();
		gbc_btnLogin_3.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin_3.gridx = 1;
		gbc_btnLogin_3.gridy = 12;
		WindowRegister_2.add(btnLogin_3, gbc_btnLogin_3);
		
		WindowRegister_3 = new JPanel();
		WindowRegister_3.setForeground(new Color(255, 255, 255));
		WindowRegister_3.setOpaque(false);
		frmAppmusic.getContentPane().add(WindowRegister_3, "WindowRegister_3");
		GridBagLayout gbl_WindowRegister_3 = new GridBagLayout();
		gbl_WindowRegister_3.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_WindowRegister_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_WindowRegister_3.rowHeights = new int[]{0, 0, 0, 30, 0, 0, 15, 0, 0, 33, 30, 0};
		WindowRegister_3.setLayout(gbl_WindowRegister_3);
		
		progressBar_2 = new JProgressBar();
		progressBar_2.setValue(100);
		GridBagConstraints gbc_progressBar_2 = new GridBagConstraints();
		gbc_progressBar_2.gridwidth = 3;
		gbc_progressBar_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar_2.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_2.gridx = 0;
		gbc_progressBar_2.gridy = 0;
		WindowRegister_3.add(progressBar_2, gbc_progressBar_2);
		
		lblUser_4 = new JLabel("Paso 3 de 3");
		lblUser_4.setForeground(new Color(204, 204, 204));
		lblUser_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUser_4 = new GridBagConstraints();
		gbc_lblUser_4.anchor = GridBagConstraints.WEST;
		gbc_lblUser_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser_4.gridx = 1;
		gbc_lblUser_4.gridy = 1;
		WindowRegister_3.add(lblUser_4, gbc_lblUser_4);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Aplicacion.class.getResource("/umu/tds/vista/imagenes/arrow.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) frmAppmusic.getContentPane().getLayout();
				card.show(frmAppmusic.getContentPane(), "WindowRegister_2");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setContentAreaFilled(false);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		WindowRegister_3.add(btnNewButton_1, gbc_btnNewButton_1);
		
		lblNewLabel_13 = new JLabel("Términos y Condiciones");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 1;
		gbc_lblNewLabel_13.gridy = 2;
		WindowRegister_3.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		WindowRegister_3.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{21, 205, 0};
		gbl_panel.rowHeights = new int[]{32, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setOpaque(false);
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_chckbxNewCheckBox_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2.anchor = GridBagConstraints.NORTH;
		gbc_chckbxNewCheckBox_2.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_2.gridx = 0;
		gbc_chckbxNewCheckBox_2.gridy = 0;
		panel.add(chckbxNewCheckBox_2, gbc_chckbxNewCheckBox_2);
		
		txtrQuieroQueMe = new JTextArea("Quiero que me enviéis novedades y ofertas\r\nde Spotify.");
		txtrQuieroQueMe.setForeground(new Color(255, 255, 255));
		txtrQuieroQueMe.setEditable(false);
		txtrQuieroQueMe.setOpaque(false);
		txtrQuieroQueMe.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_txtrQuieroQueMe = new GridBagConstraints();
		gbc_txtrQuieroQueMe.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtrQuieroQueMe.gridx = 1;
		gbc_txtrQuieroQueMe.gridy = 0;
		panel.add(txtrQuieroQueMe, gbc_txtrQuieroQueMe);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 5;
		WindowRegister_3.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{21, 234, 0};
		gbl_panel_1.rowHeights = new int[]{88, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setOpaque(false);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.NORTH;
		gbc_chckbxNewCheckBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 0;
		panel_1.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		txtrCompartirMisDatos = new JTextArea("Compartir mis datos de registro con los\nproveedores de contenidos de AppMusic para\nfines de marketing. Ten en cuenta que tus\ndatos pueden ser transferidos a un país de\nfuera del EEE, tal y como se recoge en nuestra\nPolítica de Privacidad.");
		txtrCompartirMisDatos.setForeground(new Color(255, 255, 255));
		txtrCompartirMisDatos.setEditable(false);
		txtrCompartirMisDatos.setOpaque(false);
		txtrCompartirMisDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_txtrCompartirMisDatos = new GridBagConstraints();
		gbc_txtrCompartirMisDatos.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtrCompartirMisDatos.gridx = 1;
		gbc_txtrCompartirMisDatos.gridy = 0;
		panel_1.add(txtrCompartirMisDatos, gbc_txtrCompartirMisDatos);
		
		textArea_2 = new JTextArea("Al hacer clic en Registrarte, aceptas los Términos y\ncondiciones de uso de AppMusic.");
		textArea_2.setForeground(new Color(255, 255, 255));
		textArea_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textArea_2.setOpaque(false);
		textArea_2.setEditable(false);
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 1;
		gbc_textArea_2.gridy = 7;
		WindowRegister_3.add(textArea_2, gbc_textArea_2);
		
		verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 8;
		WindowRegister_3.add(verticalStrut_4, gbc_verticalStrut_4);
		
		horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 9;
		WindowRegister_3.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		btnLogin_4 = new JButton("     Regístrate     ");
		btnLogin_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMain main = new VentanaMain();
				main.setVisible(true);
				frmAppmusic.setVisible(false);
			}
		});
		btnLogin_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnLogin_4 = new GridBagConstraints();
		gbc_btnLogin_4.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin_4.gridx = 1;
		gbc_btnLogin_4.gridy = 9;
		WindowRegister_3.add(btnLogin_4, gbc_btnLogin_4);
		
		horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_5.gridx = 2;
		gbc_horizontalStrut_5.gridy = 9;
		WindowRegister_3.add(horizontalStrut_5, gbc_horizontalStrut_5);
		GridBagConstraints gbc_panelFormulario = new GridBagConstraints();
	}

}
