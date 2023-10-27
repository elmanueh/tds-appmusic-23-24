package umu.tds.vista;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaLogin extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

    public VentanaLogin() {
    	GridBagLayout gridBagLayout = new GridBagLayout();
    	gridBagLayout.rowHeights = new int[]{0, 0, 40, 0, 0, 0, 30, 0, 0, 30, 0, 35, 0, 0, 0, 0};
    	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
    	setLayout(gridBagLayout);
    	
    	JLabel lblIniciaSesinEn = new JLabel("Inicia sesión en Spotifoo");
    	lblIniciaSesinEn.setForeground(Color.WHITE);
    	lblIniciaSesinEn.setFont(new Font("Tahoma", Font.BOLD, 30));
    	GridBagConstraints gbc_lblIniciaSesinEn = new GridBagConstraints();
    	gbc_lblIniciaSesinEn.gridwidth = 3;
    	gbc_lblIniciaSesinEn.insets = new Insets(0, 0, 5, 0);
    	gbc_lblIniciaSesinEn.gridx = 0;
    	gbc_lblIniciaSesinEn.gridy = 0;
    	add(lblIniciaSesinEn, gbc_lblIniciaSesinEn);
    	
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
    	
    	JButton btnNewButton_3 = new JButton("  Continuar con GitHub");
    	btnNewButton_3.setIcon(new ImageIcon(VentanaLogin.class.getResource("/umu/tds/vista/imagenes/github-icon.png")));
    	btnNewButton_3.setForeground(Color.WHITE);
    	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
    	GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
    	gbc_btnNewButton_3.fill = GridBagConstraints.VERTICAL;
    	gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
    	gbc_btnNewButton_3.gridx = 1;
    	gbc_btnNewButton_3.gridy = 2;
    	add(btnNewButton_3, gbc_btnNewButton_3);
    	
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
    	
    	JLabel lblUser = new JLabel("Correo electrónico o nombre de usuario");
    	lblUser.setHorizontalAlignment(SwingConstants.CENTER);
    	lblUser.setForeground(Color.WHITE);
    	lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
    	GridBagConstraints gbc_lblUser = new GridBagConstraints();
    	gbc_lblUser.anchor = GridBagConstraints.WEST;
    	gbc_lblUser.insets = new Insets(0, 0, 5, 5);
    	gbc_lblUser.gridx = 1;
    	gbc_lblUser.gridy = 5;
    	add(lblUser, gbc_lblUser);
    	
    	textField = new JTextField();
    	textField.setToolTipText("");
    	textField.setForeground(Color.WHITE);
    	textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
    	textField.setColumns(20);
    	GridBagConstraints gbc_textField = new GridBagConstraints();
    	gbc_textField.insets = new Insets(0, 0, 5, 5);
    	gbc_textField.fill = GridBagConstraints.BOTH;
    	gbc_textField.gridx = 1;
    	gbc_textField.gridy = 6;
    	add(textField, gbc_textField);
    	
    	Component verticalStrut_2 = Box.createVerticalStrut(20);
    	GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
    	gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
    	gbc_verticalStrut_2.gridx = 1;
    	gbc_verticalStrut_2.gridy = 7;
    	add(verticalStrut_2, gbc_verticalStrut_2);
    	
    	JLabel lblPassword = new JLabel("Contraseña");
    	lblPassword.setForeground(Color.WHITE);
    	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
    	GridBagConstraints gbc_lblPassword = new GridBagConstraints();
    	gbc_lblPassword.anchor = GridBagConstraints.WEST;
    	gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
    	gbc_lblPassword.gridx = 1;
    	gbc_lblPassword.gridy = 8;
    	add(lblPassword, gbc_lblPassword);
    	
    	passwordField = new JPasswordField();
    	passwordField.setToolTipText("");
    	passwordField.setForeground(Color.WHITE);
    	passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
    	passwordField.setColumns(20);
    	GridBagConstraints gbc_passwordField = new GridBagConstraints();
    	gbc_passwordField.insets = new Insets(0, 0, 5, 5);
    	gbc_passwordField.fill = GridBagConstraints.BOTH;
    	gbc_passwordField.gridx = 1;
    	gbc_passwordField.gridy = 9;
    	add(passwordField, gbc_passwordField);
    	
    	Component verticalStrut_3 = Box.createVerticalStrut(20);
    	GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
    	gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
    	gbc_verticalStrut_3.gridx = 1;
    	gbc_verticalStrut_3.gridy = 10;
    	add(verticalStrut_3, gbc_verticalStrut_3);
    	
    	JButton btnLogin = new JButton("     Iniciar Sesión     ");
    	btnLogin.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			ControladorInicio.sendLogin(textField.getText(), new String(passwordField.getPassword()));
    		}
    	});
    	btnLogin.setForeground(Color.WHITE);
    	btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
    	GridBagConstraints gbc_btnLogin = new GridBagConstraints();
    	gbc_btnLogin.fill = GridBagConstraints.VERTICAL;
    	gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
    	gbc_btnLogin.gridx = 1;
    	gbc_btnLogin.gridy = 11;
    	add(btnLogin, gbc_btnLogin);
    	
    	Component verticalStrut_4 = Box.createVerticalStrut(20);
    	GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
    	gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
    	gbc_verticalStrut_4.gridx = 1;
    	gbc_verticalStrut_4.gridy = 12;
    	add(verticalStrut_4, gbc_verticalStrut_4);
    	
    	JLabel lblRecoveryPassword = new JLabel("¿Has olvidado tu contraseña?");
    	lblRecoveryPassword.setForeground(Color.WHITE);
    	GridBagConstraints gbc_lblRecoveryPassword = new GridBagConstraints();
    	gbc_lblRecoveryPassword.insets = new Insets(0, 0, 5, 5);
    	gbc_lblRecoveryPassword.gridx = 1;
    	gbc_lblRecoveryPassword.gridy = 13;
    	add(lblRecoveryPassword, gbc_lblRecoveryPassword);
    	
    	Component verticalStrut_5 = Box.createVerticalStrut(20);
    	GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
    	gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
    	gbc_verticalStrut_5.gridx = 1;
    	gbc_verticalStrut_5.gridy = 14;
    	add(verticalStrut_5, gbc_verticalStrut_5);
    	
    	JPanel jlblRegister = new JPanel();
    	jlblRegister.setForeground(Color.WHITE);
    	jlblRegister.setBackground(Color.DARK_GRAY);
    	GridBagConstraints gbc_jlblRegister = new GridBagConstraints();
    	gbc_jlblRegister.insets = new Insets(0, 0, 0, 5);
    	gbc_jlblRegister.fill = GridBagConstraints.BOTH;
    	gbc_jlblRegister.gridx = 1;
    	gbc_jlblRegister.gridy = 15;
    	add(jlblRegister, gbc_jlblRegister);
    	jlblRegister.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    	
    	JLabel lblRegister = new JLabel("¿No tienes cuenta?");
    	lblRegister.setForeground(new Color(204, 204, 204));
    	jlblRegister.add(lblRegister);
    	
    	JButton btnRegister = new JButton("Regístrate en Spotifoo");
    	btnRegister.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			ControladorInicio.startRegister();
    		}
    	});
    	btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
    	btnRegister.setForeground(Color.WHITE);
    	btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
    	jlblRegister.add(btnRegister);
    }
}