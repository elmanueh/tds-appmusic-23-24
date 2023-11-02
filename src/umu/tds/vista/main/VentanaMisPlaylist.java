package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;

public class VentanaMisPlaylist extends JPanel {
	private JTable table;


	public VentanaMisPlaylist() {
		setLayout(new CardLayout(0, 0));
		
		JPanel panelDefecto = new JPanel();
		add(panelDefecto, "panelDefecto");
		
		JLabel lblNewLabel = new JLabel("VACIO");
		panelDefecto.add(lblNewLabel);
		
		JPanel panelTabla = new JPanel();
		add(panelTabla, "panelTabla");
		panelTabla.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(850, 370));
		panelTabla.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panelBotones = new JPanel();
		panelTabla.add(panelBotones);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		panelBotones.setLayout(gbl_panelBotones);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 0;
		panelBotones.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaMisPlaylist.class.getResource("/umu/tds/vista/imagenes/atras.png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panelBotones.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 1;
		panelBotones.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VentanaMisPlaylist.class.getResource("/umu/tds/vista/imagenes/pausa.png")));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		panelBotones.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 1;
		panelBotones.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(VentanaMisPlaylist.class.getResource("/umu/tds/vista/imagenes/boton-de-play.png")));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 1;
		panelBotones.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_2.gridx = 5;
		gbc_horizontalStrut_2.gridy = 1;
		panelBotones.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(VentanaMisPlaylist.class.getResource("/umu/tds/vista/imagenes/proximo.png")));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.gridx = 6;
		gbc_lblNewLabel_4.gridy = 1;
		panelBotones.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
	}

	public void ponerPlayListEnTabla(String playlist) {
		PlayList p = Controlador.getUnicaInstancia().getPlayList(playlist);
		
		DefaultTableModel modeloFiltrado = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		modeloFiltrado.addColumn("TITULO");
		modeloFiltrado.addColumn("ESTILO");
		modeloFiltrado.addColumn("INTERPRETE");
		
		for (Cancion cancion : p.getListaCanciones()) {
			Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical(), cancion.getInterprete()};
			modeloFiltrado.addRow(fila);
		}

		table.setModel(modeloFiltrado);
		
		((CardLayout) getLayout()).show(this, "panelTabla");
	}
}