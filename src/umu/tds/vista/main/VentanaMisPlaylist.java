package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class VentanaMisPlaylist extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel panelTabla;
	private JTable tablaCanciones;
	private JScrollPane scrollPane;
	private JPanel panelBotones;
	private JButton botonShuffle;
	private JButton botonPrevious;
	private JButton botonPlay;
	private JButton botonPause;
	private JButton botonNext;
	private Component verticalStrut;
	private Component verticalStrut_1;

	public VentanaMisPlaylist() {
		setLayout(new BorderLayout(0, 0));

		panelTabla = new JPanel();
		panelTabla.setVisible(false);
		add(panelTabla, BorderLayout.CENTER);
		panelTabla.setLayout(new BorderLayout(0, 0));

		tablaCanciones = new JTable();
		tablaCanciones.setAutoscrolls(false);
		tablaCanciones.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(tablaCanciones);
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		panelBotones = new JPanel();
		panelBotones.setVisible(false);
		add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new BorderLayout(0, 0));

		JPanel panelMultimedia = new JPanel();
		panelBotones.add(panelMultimedia, BorderLayout.CENTER);
		GridBagLayout gbl_panelMultimedia = new GridBagLayout();
		gbl_panelMultimedia.columnWidths = new int[] { 0, -12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelMultimedia.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelMultimedia.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panelMultimedia.rowWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panelMultimedia.setLayout(gbl_panelMultimedia);

		Component horizontalStrut_8 = Box.createHorizontalStrut(50);
		GridBagConstraints gbc_horizontalStrut_8 = new GridBagConstraints();
		gbc_horizontalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_8.gridx = 0;
		gbc_horizontalStrut_8.gridy = 1;
		panelMultimedia.add(horizontalStrut_8, gbc_horizontalStrut_8);

		botonShuffle = new JButton("");
		botonShuffle.setIcon(new ImageIcon(VentanaBuscar.class.getResource("/umu/tds/vista/imagenes/barajar.png")));
		botonShuffle.setBorderPainted(false);
		GridBagConstraints gbc_botonShuffle = new GridBagConstraints();
		gbc_botonShuffle.insets = new Insets(0, 0, 5, 5);
		gbc_botonShuffle.gridx = 2;
		gbc_botonShuffle.gridy = 1;
		panelMultimedia.add(botonShuffle, gbc_botonShuffle);

		Component horizontalStrut_3 = Box.createHorizontalStrut(10);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 3;
		gbc_horizontalStrut_3.gridy = 1;
		panelMultimedia.add(horizontalStrut_3, gbc_horizontalStrut_3);

		botonPrevious = new JButton("");
		botonPrevious.setIcon(new ImageIcon(VentanaBuscar.class.getResource("/umu/tds/vista/imagenes/paso-atras.png")));
		botonPrevious.setBorderPainted(false);
		GridBagConstraints gbc_botonPrevious = new GridBagConstraints();
		gbc_botonPrevious.insets = new Insets(0, 0, 5, 5);
		gbc_botonPrevious.gridx = 4;
		gbc_botonPrevious.gridy = 1;
		panelMultimedia.add(botonPrevious, gbc_botonPrevious);

		Component horizontalStrut_4 = Box.createHorizontalStrut(10);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 5;
		gbc_horizontalStrut_4.gridy = 1;
		panelMultimedia.add(horizontalStrut_4, gbc_horizontalStrut_4);

		botonPlay = new JButton("");
		botonPlay.setIcon(new ImageIcon(VentanaBuscar.class.getResource("/umu/tds/vista/imagenes/tocar.png")));
		botonPlay.setBorderPainted(false);
		GridBagConstraints gbc_botonPlay = new GridBagConstraints();
		gbc_botonPlay.insets = new Insets(0, 0, 5, 5);
		gbc_botonPlay.gridx = 6;
		gbc_botonPlay.gridy = 1;
		panelMultimedia.add(botonPlay, gbc_botonPlay);

		botonPause = new JButton("");
		botonPause.setVisible(false);
		botonPause.setIcon(new ImageIcon(VentanaBuscar.class.getResource("/umu/tds/vista/imagenes/pausa.png")));
		botonPause.setBorderPainted(false);
		GridBagConstraints gbc_botonPause = new GridBagConstraints();
		gbc_botonPause.insets = new Insets(0, 0, 5, 5);
		gbc_botonPause.gridx = 7;
		gbc_botonPause.gridy = 1;
		panelMultimedia.add(botonPause, gbc_botonPause);

		Component horizontalStrut_6 = Box.createHorizontalStrut(10);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 8;
		gbc_horizontalStrut_6.gridy = 1;
		panelMultimedia.add(horizontalStrut_6, gbc_horizontalStrut_6);

		botonNext = new JButton("");
		botonNext.setIcon(
				new ImageIcon(VentanaBuscar.class.getResource("/umu/tds/vista/imagenes/un-paso-adelante.png")));
		botonNext.setBorderPainted(false);
		GridBagConstraints gbc_botonNext = new GridBagConstraints();
		gbc_botonNext.insets = new Insets(0, 0, 5, 5);
		gbc_botonNext.gridx = 9;
		gbc_botonNext.gridy = 1;
		panelMultimedia.add(botonNext, gbc_botonNext);

		verticalStrut_1 = Box.createVerticalStrut(40);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		panelMultimedia.add(verticalStrut_1, gbc_verticalStrut_1);

		verticalStrut = Box.createVerticalStrut(40);
		panelBotones.add(verticalStrut, BorderLayout.NORTH);

		/*
		 * MANEJADORES BOTONES
		 */
		botonPlay.addActionListener(this);
		botonPause.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonPlay) {
			botonPlay.setVisible(false);
			botonPause.setVisible(true);
		}

		if (e.getSource() == botonPause) {
			botonPause.setVisible(false);
			botonPlay.setVisible(true);
		}
	}

	public void ponerPlayListEnTabla(String playlist) {
		panelBotones.setVisible(true);
		panelTabla.setVisible(true);

		if (botonPause.isVisible()) {
			botonPause.setVisible(false);
			botonPlay.setVisible(true);
		}

		DefaultTableModel modeloFiltrado = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modeloFiltrado.addColumn("TITULO");
		modeloFiltrado.addColumn("ESTILO");
		modeloFiltrado.addColumn("INTERPRETE");

		for (Cancion cancion : Controlador.INSTANCIA.getListaCancionesPlayList(playlist)) {
			Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical(), cancion.getInterprete() };
			modeloFiltrado.addRow(fila);
		}

		int anchoTabla = tablaCanciones.getWidth();
		int numColumnas = tablaCanciones.getColumnCount();
		int anchoUltColumna = (int) (anchoTabla * 0.05);
		for (int i = 0; i < numColumnas; i++) {
			tablaCanciones.getColumnModel().getColumn(i).setResizable(false);
			tablaCanciones.getColumnModel().getColumn(i).setPreferredWidth(anchoUltColumna);
		}

		tablaCanciones.setModel(modeloFiltrado);
		tablaCanciones.setBackground(new Color(0x0D, 0x20, 0x39));
		tablaCanciones.getTableHeader().setReorderingAllowed(false);

		tablaCanciones.setAutoCreateRowSorter(true);

		tablaCanciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String titulo = (String) ((DefaultTableModel) tablaCanciones.getModel())
						.getValueAt(tablaCanciones.getSelectedRow(), 0);
				Controlador.INSTANCIA.setCancionActual(titulo);
				
				@SuppressWarnings("unchecked")
				TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tablaCanciones
						.getRowSorter();
				sorter.sort();
			}
		});
	}

	public void esconderPanel() {
		panelBotones.setVisible(false);
		panelTabla.setVisible(false);
	}
}