package umu.tds.vista.main;

import javax.swing.JFrame;

import java.awt.CardLayout;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.ControladorVentanas;
import umu.tds.modelo.descuento.Descuento;
import umu.tds.vista.inicio.PlantillaInicio;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;

public class MenuPremium extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	/*
	 * ATRIBUTOS
	 */
	private JTextField codigo;
	private JButton botonPremium;
	private JButton botonDarDeBaja;

	/*
	 * METODOS
	 */

	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PlantillaInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		setTitle("Spotifoo Premium");
		setSize(500, 300);
		setMinimumSize(getSize());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new CardLayout(0, 0));
	}

	public MenuPremium() {

		initialize();

		JPanel panel_Normal = new JPanel();
		getContentPane().add(panel_Normal, "panel_Normal");
		GridBagLayout gbl_panel_Normal = new GridBagLayout();
		gbl_panel_Normal.columnWeights = new double[] { 0.0, 0.0 };
		gbl_panel_Normal.columnWidths = new int[] { 0, 150 };
		gbl_panel_Normal.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_Normal.rowHeights = new int[] { 0, 20, 0, 30, 35 };
		panel_Normal.setLayout(gbl_panel_Normal);

		JLabel lblNewLabel = new JLabel("Suscríbete a Spotifoo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_Normal.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Introduzca código promocional: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_Normal.add(lblNewLabel_1, gbc_lblNewLabel_1);

		codigo = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panel_Normal.add(codigo, gbc_textField);
		codigo.setColumns(20);

		botonPremium = new JButton("SUSCRIBETE");
		botonPremium.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		panel_Normal.add(botonPremium, gbc_btnNewButton);

		JPanel panel_Premium = new JPanel();
		getContentPane().add(panel_Premium, "panel_Premium");
		GridBagLayout gbl_panel_Premium = new GridBagLayout();
		gbl_panel_Premium.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_Premium.rowHeights = new int[] { 0, 20, 0, 20, 35 };
		panel_Premium.setLayout(gbl_panel_Premium);

		JLabel lblNewLabel_2 = new JLabel("Suscrito a Spotifoo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_Premium.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Cuota mensual de " + Controlador.INSTANCIA.getCuotaUsuarioActual() + "€");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		panel_Premium.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		botonDarDeBaja = new JButton("DAR DE BAJA");
		botonDarDeBaja.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnDarDeBaja = new GridBagConstraints();
		gbc_btnDarDeBaja.fill = GridBagConstraints.VERTICAL;
		gbc_btnDarDeBaja.gridx = 0;
		gbc_btnDarDeBaja.gridy = 4;
		panel_Premium.add(botonDarDeBaja, gbc_btnDarDeBaja);

		boolean premium = Controlador.INSTANCIA.isUsuarioActualPremium();
		if (premium) {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panel_Premium");
		} else {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panel_Normal");
		}
		setVisible(true);

		/*
		 * Manejadores
		 */
		botonPremium.addActionListener(this);
		botonDarDeBaja.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonPremium) {
			Descuento d = Controlador.INSTANCIA.aplicarDescuento(codigo.getText());

			String mensaje;
			switch (d.tipoDescuento()) {
			case "Ninguno":
				mensaje = "                    Suscripción de " + d.Precio() + "€.";
				break;
			default:
				mensaje = "                    Suscripción de " + d.Precio() + "€.\n" + "          Descuento aplicado: "
						+ d.tipoDescuento();
				break;
			}

			JOptionPane.showMessageDialog(null, mensaje, "GRACIAS POR SUSCRIBIRTE", JOptionPane.PLAIN_MESSAGE);
			ControladorVentanas.INSTANCIA.quitarPremium(true, d.Precio());
			dispose();
		}

		if (e.getSource() == botonDarDeBaja) {
			JOptionPane.showMessageDialog(null,
					"Te esperamos de vuelta pronto\n\nPuedes disfrutar de nuestros códigos promocionales",
					"HASTA PRONTO !!!", JOptionPane.PLAIN_MESSAGE);
			ControladorVentanas.INSTANCIA.quitarPremium(false, 0);
			dispose();
		}

	}
}
