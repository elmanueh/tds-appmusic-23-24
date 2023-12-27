package umu.tds.vista.main;

import javax.swing.JFrame;

import java.awt.CardLayout;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import umu.tds.Controlador;
import umu.tds.ControladorVentanas;
import umu.tds.modelo.descuento.IDescuento;
import umu.tds.vista.inicio.PlantillaInicio;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Clase MenuPremium
 */
public class MenuPremium extends JFrame implements ActionListener {

	/**
	 * ATRIBUTOS
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textoCodigoDescuento;
	private JButton botonPremium;
	private JButton botonDarDeBaja;

	/**
	 * Metodo para inicializar MenuPremium
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

	/**
	 * Contructor de la clase MenuPremium
	 */
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

		JLabel labelTitulo = new JLabel("Suscríbete a Spotifoo");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_labelTitulo = new GridBagConstraints();
		gbc_labelTitulo.gridwidth = 2;
		gbc_labelTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_labelTitulo.gridx = 0;
		gbc_labelTitulo.gridy = 0;
		panel_Normal.add(labelTitulo, gbc_labelTitulo);

		JLabel labelTexto = new JLabel("Introduzca código promocional: ");
		GridBagConstraints gbc_labelTexto = new GridBagConstraints();
		gbc_labelTexto.anchor = GridBagConstraints.EAST;
		gbc_labelTexto.insets = new Insets(0, 0, 5, 5);
		gbc_labelTexto.gridx = 0;
		gbc_labelTexto.gridy = 2;
		panel_Normal.add(labelTexto, gbc_labelTexto);

		textoCodigoDescuento = new JTextField();
		GridBagConstraints gbc_textoCodigoDescuento = new GridBagConstraints();
		gbc_textoCodigoDescuento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoCodigoDescuento.insets = new Insets(0, 0, 5, 0);
		gbc_textoCodigoDescuento.gridx = 1;
		gbc_textoCodigoDescuento.gridy = 2;
		panel_Normal.add(textoCodigoDescuento, gbc_textoCodigoDescuento);
		textoCodigoDescuento.setColumns(20);

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

		JLabel labelTitulo2 = new JLabel("Suscrito a Spotifoo");
		labelTitulo2.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_labelTitulo2 = new GridBagConstraints();
		gbc_labelTitulo2.insets = new Insets(0, 0, 5, 0);
		gbc_labelTitulo2.gridx = 0;
		gbc_labelTitulo2.gridy = 0;
		panel_Premium.add(labelTitulo2, gbc_labelTitulo2);

		JLabel labelTexto2 = new JLabel(
				"Cuota mensual de " + Controlador.INSTANCIA.getUsuarioActual().getCuota() + "€");
		GridBagConstraints gbc_labelTexto2 = new GridBagConstraints();
		gbc_labelTexto2.insets = new Insets(0, 0, 5, 0);
		gbc_labelTexto2.gridx = 0;
		gbc_labelTexto2.gridy = 2;
		panel_Premium.add(labelTexto2, gbc_labelTexto2);

		botonDarDeBaja = new JButton("DAR DE BAJA");
		botonDarDeBaja.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnDarDeBaja = new GridBagConstraints();
		gbc_btnDarDeBaja.fill = GridBagConstraints.VERTICAL;
		gbc_btnDarDeBaja.gridx = 0;
		gbc_btnDarDeBaja.gridy = 4;
		panel_Premium.add(botonDarDeBaja, gbc_btnDarDeBaja);

		boolean premium = Controlador.INSTANCIA.getUsuarioActual().isPremium();
		if (premium) {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panel_Premium");
		} else {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panel_Normal");
		}

		// MANEJADORES
		botonPremium.addActionListener(this);
		botonDarDeBaja.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonPremium) {
			IDescuento d = Controlador.INSTANCIA.getUsuarioActual().aplicarDescuento(textoCodigoDescuento.getText());

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
			Controlador.INSTANCIA.usuarioEstablecerPremium(true, d.Precio());
			ControladorVentanas.INSTANCIA.usuarioPremium(true);
			dispose();
		}

		if (e.getSource() == botonDarDeBaja) {
			JOptionPane.showMessageDialog(null,
					"Te esperamos de vuelta pronto\n\nPuedes disfrutar de nuestros códigos promocionales",
					"HASTA PRONTO !!!", JOptionPane.PLAIN_MESSAGE);
			Controlador.INSTANCIA.usuarioEstablecerPremium(false, 0);
			ControladorVentanas.INSTANCIA.usuarioPremium(false);
			dispose();
		}

	}
}
