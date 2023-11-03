package umu.tds.vista.main;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.Usuario;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class VentanaMisPlaylist extends JPanel {
	private JTable table;
	private JTextField textField;

	public VentanaMisPlaylist() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelTitulo = new JPanel();
		add(panelTitulo, BorderLayout.NORTH);
		GridBagLayout gbl_panelTitulos = new GridBagLayout();
		gbl_panelTitulos.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelTitulos.rowHeights = new int[] { 0, 0, 0 };
		gbl_panelTitulos.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelTitulos.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelTitulo.setLayout(gbl_panelTitulos);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		panelTitulo.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnNewButton_5 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 1;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		panelTitulo.add(btnNewButton_5, gbc_btnNewButton_5);

		JButton btnNewButton_6 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.gridx = 1;
		gbc_btnNewButton_6.gridy = 1;
		panelTitulo.add(btnNewButton_6, gbc_btnNewButton_6);

		JPanel panelTabla = new JPanel();
		add(panelTabla, BorderLayout.CENTER);

		DefaultTableModel modeloTabla = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == 3) {
					return Boolean.class; // Establece la columna "SELECCIONAR" como Boolean
				}
				return super.getColumnClass(columnIndex);
			}
		};
		table = new JTable();

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(650, 300));
		panelTabla.add(scrollPane);

		table.setModel(modeloTabla);

		JPanel panelBotones = new JPanel();
		panelTabla.add(panelBotones);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[] { 0, 0, 0, 0, 0, 80, 135, 0, 0, 0 };
		gbl_panelBotones.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelBotones.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelBotones.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelBotones.setLayout(gbl_panelBotones);

		JButton btnNewButton_7 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.gridheight = 3;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_7.gridx = 6;
		gbc_btnNewButton_7.gridy = 0;
		panelBotones.add(btnNewButton_7, gbc_btnNewButton_7);

		JButton btnNewButton_3 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 3;
		gbc_btnNewButton_3.gridy = 1;
		panelBotones.add(btnNewButton_3, gbc_btnNewButton_3);

		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 1;
		panelBotones.add(lblNewLabel, gbc_lblNewLabel);

		Component horizontalStrut = Box.createHorizontalStrut(40);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 7;
		gbc_horizontalStrut.gridy = 1;
		panelBotones.add(horizontalStrut, gbc_horizontalStrut);

		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 8;
		gbc_lblNewLabel_1.gridy = 1;
		panelBotones.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		panelBotones.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		panelBotones.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_2 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 2;
		panelBotones.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_4 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 2;
		panelBotones.add(btnNewButton_4, gbc_btnNewButton_4);

		modeloTabla.addColumn("TITULO");
		modeloTabla.addColumn("INTERPRETE");
		modeloTabla.addColumn("ESTILO");
		modeloTabla.addColumn("SELECCIONAR");

		table.getColumnModel().getColumn(3).setCellEditor(new CenteredCheckBoxEditor());

		/*
		 * for (Cancion u: Controlador.getUnicaInstancia().getCanciones()) { Object[]
		 * usuario = {u.getTitulo(), u.getEstiloMusical(), u.getInterprete(), false};
		 * modeloTabla.addRow(usuario); }
		 */
		for (PlayList p : Controlador.getUnicaInstancia().getUsuarioActual().getListaPlayList()) {
			Object[] playlist = { p.getNombre(), p.getListaCanciones().size(), null, false };
			modeloTabla.addRow(playlist);
		}

	}

	static class CenteredCheckBoxEditor extends DefaultCellEditor {
		private JCheckBox checkBox;

		public CenteredCheckBoxEditor() {
			super(new JCheckBox());
			checkBox = (JCheckBox) getComponent();
			checkBox.setHorizontalAlignment(JCheckBox.CENTER);
		}
	}
}