package umu.tds.vista.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.descuento.Descuento;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaPremium implements ActionListener {

	private JFrame frame;
	private JTextField codigo;
	private JButton botonPremium;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPremium window = new VentanaPremium();
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
	public VentanaPremium() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel_Normal = new JPanel();
		frame.getContentPane().add(panel_Normal, "panel_Normal");
		GridBagLayout gbl_panel_Normal = new GridBagLayout();
		panel_Normal.setLayout(gbl_panel_Normal);

		Component verticalStrut = Box.createVerticalStrut(60);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 8;
		gbc_verticalStrut.gridy = 1;
		panel_Normal.add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel = new JLabel("Suscribete a Spotifoo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 2;
		panel_Normal.add(lblNewLabel, gbc_lblNewLabel);

		Component verticalStrut_1 = Box.createVerticalStrut(40);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 8;
		gbc_verticalStrut_1.gridy = 3;
		panel_Normal.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel_1 = new JLabel("Introduzca código promocional: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 5;
		panel_Normal.add(lblNewLabel_1, gbc_lblNewLabel_1);

		codigo = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 8;
		gbc_textField.gridy = 5;
		panel_Normal.add(codigo, gbc_textField);
		codigo.setColumns(20);

		Component verticalStrut_2 = Box.createVerticalStrut(100);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 7;
		gbc_verticalStrut_2.gridy = 6;
		panel_Normal.add(verticalStrut_2, gbc_verticalStrut_2);

		botonPremium = new JButton("SUSCRIBETE");
		botonPremium.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridwidth = 4;
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 7;
		panel_Normal.add(botonPremium, gbc_btnNewButton);
		
		// TODO esto es solo un boton que pasa de un frame a otro, no importante
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "panel_Premium");
			}
		});
		GridBagConstraints gbc_btnNewButton2 = new GridBagConstraints();
		gbc_btnNewButton2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton2.gridx = 5;
		gbc_btnNewButton2.gridy = 8;
		panel_Normal.add(btnNewButton, gbc_btnNewButton2);

		JPanel panel_Premium = new JPanel();
		frame.getContentPane().add(panel_Premium, "panel_Premium");
		GridBagLayout gbl_panel_Premium = new GridBagLayout();
		panel_Premium.setLayout(gbl_panel_Premium);
		
		Component verticalStrut_3 = Box.createVerticalStrut(60);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_3.gridx = 8;
		gbc_verticalStrut_3.gridy = 1;
		panel_Premium.add(verticalStrut_3, gbc_verticalStrut_3);
		
		JLabel lblNewLabel_2 = new JLabel("Suscrito a Spotifoo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 8;
		gbc_lblNewLabel_2.gridy = 2;
		panel_Premium.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		Component verticalStrut_1_1 = Box.createVerticalStrut(40);
		GridBagConstraints gbc_verticalStrut_1_1 = new GridBagConstraints();
		gbc_verticalStrut_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1_1.gridx = 8;
		gbc_verticalStrut_1_1.gridy = 3;
		panel_Premium.add(verticalStrut_1_1, gbc_verticalStrut_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cuota mensual de X€");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1_1.gridx = 8;
		gbc_lblNewLabel_1_1.gridy = 4;
		panel_Premium.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		Component verticalStrut_2_1 = Box.createVerticalStrut(100);
		GridBagConstraints gbc_verticalStrut_2_1 = new GridBagConstraints();
		gbc_verticalStrut_2_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2_1.gridx = 8;
		gbc_verticalStrut_2_1.gridy = 5;
		panel_Premium.add(verticalStrut_2_1, gbc_verticalStrut_2_1);
		
		JButton btnDarDeBaja = new JButton("DAR DE BAJA");
		btnDarDeBaja.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnDarDeBaja = new GridBagConstraints();
		gbc_btnDarDeBaja.gridx = 8;
		gbc_btnDarDeBaja.gridy = 6;
		panel_Premium.add(btnDarDeBaja, gbc_btnDarDeBaja);

		// Manejadores
		botonPremium.addActionListener(this);
		btnDarDeBaja.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO
		if (e.getSource() == botonPremium) {
				Descuento d = Controlador.getUnicaInstancia().aplicarDescuento(codigo.getText());
				Controlador.getUnicaInstancia().Premium(d.Precio());

				switch (d.tipoDescuento()) {
				case "Ninguno":
					JOptionPane.showMessageDialog(null, "                    Suscripción de " + d.Precio() + "€.",
							"GRACIAS POR SUSCRIBIRTE", JOptionPane.PLAIN_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(null,
							"                    Suscripción de " + d.Precio() + "€.\n"
									+ "          Descuento aplicado: " + d.tipoDescuento(),
							"GRACIAS POR SUSCRIBIRTE", JOptionPane.PLAIN_MESSAGE);
					break;
				}
		}
		// TODO
		if (e.getSource() == botonPremium) {
			
		}

	}

	// TODO
	public boolean activar() {
		boolean premium = Controlador.getUnicaInstancia().getUsuarioActual().isPremium();
		if (premium) {
			((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "panel_Premium");
			frame.setVisible(true);
		}
		else {
			((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "panel_Normal");
			frame.setVisible(true);
		}
		return !premium;
		
	}		
}
