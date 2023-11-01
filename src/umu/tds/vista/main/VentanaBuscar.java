package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;
import umu.tds.vista.main.VentanaMisPlaylist.CenteredCheckBoxEditor;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBuscar extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtInterprete;
	private JTable table;

	public VentanaBuscar() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panelArriba = new GridBagLayout();

		panel.setLayout(gbl_panelArriba);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.anchor = GridBagConstraints.EAST;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		panel.add(horizontalStrut, gbc_horizontalStrut);

		JLabel lblNewLabel_1 = new JLabel("TITIULO: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtTitulo = new JTextField();
		txtTitulo.setText("");
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitulo.gridx = 2;
		gbc_txtTitulo.gridy = 0;
		panel.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("INTERPRETE: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtInterprete = new JTextField();
		txtInterprete.setText("");
		GridBagConstraints gbc_txtInterprete = new GridBagConstraints();
		gbc_txtInterprete.insets = new Insets(0, 0, 5, 5);
		gbc_txtInterprete.gridx = 4;
		gbc_txtInterprete.gridy = 0;
		panel.add(txtInterprete, gbc_txtInterprete);
		txtInterprete.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.anchor = GridBagConstraints.SOUTH;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 7;
		gbc_horizontalStrut_1.gridy = 0;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Favoritas");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 1;
		panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		JLabel lblNewLabel_3 = new JLabel("ESTILO: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 1;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(Controlador.getUnicaInstancia().getEstilos()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut.gridx = 4;
		gbc_verticalStrut.gridy = 2;
		panel.add(verticalStrut, gbc_verticalStrut);

		JPanel panelCard = new JPanel();
		add(panelCard, BorderLayout.CENTER);
		CardLayout cardLayout = new CardLayout();
		panelCard.setLayout(cardLayout);

		JPanel panelVacio = new JPanel();
		panelCard.add(panelVacio, "panelVacio");
		panelVacio.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelTabla = new JPanel();
		panelCard.add(panelTabla, "panelTabla");
		panelTabla.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(850, 300));
		panelTabla.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panelTabla.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 130, 0, 0 };
		panel_1.setLayout(gbl_panel_1);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 4;
		gbc_verticalStrut_1.gridy = 0;
		panel_1.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(VentanaBuscar.class.getResource("/umu/tds/vista/imagenes/atras.png")));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 1;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(VentanaBuscar.class.getResource("/umu/tds/vista/imagenes/pausa.png")));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 1;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4
				.setIcon(new ImageIcon(VentanaBuscar.class.getResource("/umu/tds/vista/imagenes/boton-de-play.png")));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 1;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaBuscar.class.getResource("/umu/tds/vista/imagenes/proximo.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_2.gridx = 4;
		gbc_horizontalStrut_2.gridy = 1;
		panel_1.add(horizontalStrut_2, gbc_horizontalStrut_2);

		JButton btnNewButton_1 = new JButton("CANCELAR");

		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 1;
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JButton("AÑADIR A PLAYLIST");

		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridx = 6;
		gbc_btnNewButton_2.gridy = 1;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Realizar la filtración de canciones
				String tituloFiltrado = txtTitulo.getText();
				String interpreteFiltrado = txtInterprete.getText();
				String estiloFiltrado = comboBox.getSelectedItem().toString();

				DefaultTableModel modeloFiltrado = new DefaultTableModel() {
					@Override
					public boolean isCellEditable(int row, int column) {
						for (int i = 0; i < 3; i++) {
							if (column == i) {
								return false;
							}
						}
						return true;
					}

					@Override
					public Class<?> getColumnClass(int columnIndex) {
						if (columnIndex == 3) {
							return Boolean.class; // Establece la columna 3 como Boolean
						}
						return super.getColumnClass(columnIndex);
					}
				};
				
				modeloFiltrado.addColumn("TITULO");
				modeloFiltrado.addColumn("ESTILO");
				modeloFiltrado.addColumn("INTERPRETE");
				modeloFiltrado.addColumn("");

				for (Cancion cancion : Controlador.getUnicaInstancia().getCancionesFiltradas(tituloFiltrado,
						interpreteFiltrado, estiloFiltrado)) {
					Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical(), cancion.getInterprete(), false };
					modeloFiltrado.addRow(fila);
				}

				table.setModel(modeloFiltrado);
				
				TableColumnModel columnModel = table.getColumnModel();

				columnModel.getColumn(0).setPreferredWidth(260);
				columnModel.getColumn(1).setPreferredWidth(260);
				columnModel.getColumn(2).setPreferredWidth(260);
				columnModel.getColumn(3).setPreferredWidth(58);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
				table.setBackground(new Color(0x0D, 0x20, 0x39));
				
				cardLayout.show(panelCard, "panelTabla");
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCard, "panelVacio");
				txtTitulo.setText("");
				txtInterprete.setText("");
				comboBox.setSelectedIndex(0);
			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getUnicaInstancia().crearPlayList("Defecto", (DefaultTableModel) table.getModel());
			}
		});

	}
}