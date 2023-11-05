package umu.tds.vista.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import javax.swing.JPanel;
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
		frame.getContentPane().add(panel_Normal, "name_599332666228800");
		GridBagLayout gbl_panel_Normal = new GridBagLayout();
		gbl_panel_Normal.columnWidths = new int[] { 0, 0, 0, 0, 0, 218, 0, 247, 0 };
		gbl_panel_Normal.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 40, 0, 0 };
		gbl_panel_Normal.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_Normal.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_Normal.setLayout(gbl_panel_Normal);

		Component verticalStrut = Box.createVerticalStrut(60);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 7;
		gbc_verticalStrut.gridy = 1;
		panel_Normal.add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel = new JLabel("Suscribete a Spotifoo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 2;
		panel_Normal.add(lblNewLabel, gbc_lblNewLabel);

		Component verticalStrut_1 = Box.createVerticalStrut(40);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 7;
		gbc_verticalStrut_1.gridy = 3;
		panel_Normal.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel_1 = new JLabel("Introduzca código promocional: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 5;
		panel_Normal.add(lblNewLabel_1, gbc_lblNewLabel_1);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 6;
		gbc_horizontalStrut.gridy = 5;
		panel_Normal.add(horizontalStrut, gbc_horizontalStrut);

		codigo = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 5;
		panel_Normal.add(codigo, gbc_textField);
		codigo.setColumns(20);

		Component verticalStrut_2 = Box.createVerticalStrut(100);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 6;
		gbc_verticalStrut_2.gridy = 6;
		panel_Normal.add(verticalStrut_2, gbc_verticalStrut_2);

		botonPremium = new JButton("SUSCRIBETE");
		botonPremium.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 7;
		panel_Normal.add(botonPremium, gbc_btnNewButton);

		JPanel panel_Premium = new JPanel();
		frame.getContentPane().add(panel_Premium, "name_599335326783900");

		// Manejadores
		botonPremium.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonPremium) {
				// PROBAR LUEGO SI FUNCIONA
				Descuento d = Controlador.getUnicaInstancia().aplicarDescuento(codigo.getText());

				switch (d.tipoDescuento()) {
				case "Ninguno":
					JOptionPane.showMessageDialog(null, "                    Suscripción de " + d.Precio() + "€.",
							"GRACIAS POR SUSCRIBIRTE A SPOTIFOO", JOptionPane.PLAIN_MESSAGE);
				default:
					JOptionPane.showMessageDialog(null,
							"                    Suscripción de " + d.Precio() + "€.\n"
									+ "          Descuento aplicado: " + d.tipoDescuento(),
							"GRACIAS POR SUSCRIBIRTE A SPOTIFOO", JOptionPane.PLAIN_MESSAGE);
				}
		}

	}

}
