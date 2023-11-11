package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class VentanaBuscar extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JTextField txtTitulo;
	private JTextField txtInterprete;
	private JTable tablaCanciones;
	private JButton botonBuscar;
	private JButton botonCancelar;
	private JButton botonAñadirPlaylist;
	private JPanel panelTabla;
	private JPanel panelBotonera;
	private JPanel panelBuscar;
	private JLabel lblNewLabel_1;
	private JButton botonShuffle;
	private JButton botonPrevious;
	private JButton botonPlay;
	private JButton botonPause;
	private JButton botonNext;
	private JScrollPane scrollPane;
	private JCheckBox CheckBoxFavoritos;

	private JComboBox<String> comboBoxEstilo;

	public VentanaBuscar() {
		setLayout(new BorderLayout(0, 0));

		panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelBuscar, BorderLayout.NORTH);
		GridBagLayout gbl_panelBuscar = new GridBagLayout();
		gbl_panelBuscar.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panelBuscar.columnWidths = new int[] { 0, 0, 120, 0, 0, 120, 0, 100 };

		panelBuscar.setLayout(gbl_panelBuscar);

		lblNewLabel_1 = new JLabel("Título:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panelBuscar.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtTitulo = new JTextField();
		txtTitulo.setText("");
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitulo.gridx = 2;
		gbc_txtTitulo.gridy = 0;
		panelBuscar.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(10);

		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 0;
		panelBuscar.add(horizontalStrut_1, gbc_horizontalStrut_1);

		JLabel lblNewLabel_2 = new JLabel("Intérprete:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 0;
		panelBuscar.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtInterprete = new JTextField();
		txtInterprete.setText("");
		GridBagConstraints gbc_txtInterprete = new GridBagConstraints();
		gbc_txtInterprete.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInterprete.insets = new Insets(0, 0, 5, 5);
		gbc_txtInterprete.gridx = 5;
		gbc_txtInterprete.gridy = 0;
		panelBuscar.add(txtInterprete, gbc_txtInterprete);
		txtInterprete.setColumns(10);

		botonBuscar = new JButton("Buscar");
		botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));

		GridBagConstraints gbc_botonBuscar = new GridBagConstraints();
		gbc_botonBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_botonBuscar.fill = GridBagConstraints.BOTH;
		gbc_botonBuscar.gridheight = 2;
		gbc_botonBuscar.gridx = 7;
		gbc_botonBuscar.gridy = 0;
		panelBuscar.add(botonBuscar, gbc_botonBuscar);

		CheckBoxFavoritos = new JCheckBox("Favoritas");
		CheckBoxFavoritos.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 1;
		panelBuscar.add(CheckBoxFavoritos, gbc_chckbxNewCheckBox);

		JLabel lblNewLabel_3 = new JLabel("Estilo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 1;
		panelBuscar.add(lblNewLabel_3, gbc_lblNewLabel_3);

		/* TODO: Esto puede dar problemas */
		comboBoxEstilo = new JComboBox<>();
		for (String s : Controlador.getUnicaInstancia().getEstilos())
			comboBoxEstilo.addItem(s);

		GridBagConstraints gbc_comboBoxEstilo = new GridBagConstraints();
		gbc_comboBoxEstilo.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEstilo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEstilo.gridx = 5;
		gbc_comboBoxEstilo.gridy = 1;
		panelBuscar.add(comboBoxEstilo, gbc_comboBoxEstilo);

		Component horizontalStrut = Box.createHorizontalStrut(5);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 6;
		gbc_horizontalStrut.gridy = 1;
		panelBuscar.add(horizontalStrut, gbc_horizontalStrut);

		Component verticalStrut_1 = Box.createVerticalStrut(8);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 2;
		panelBuscar.add(verticalStrut_1, gbc_verticalStrut_1);

		panelTabla = new JPanel();
		panelTabla.setVisible(false);
		add(panelTabla, BorderLayout.CENTER);
		panelTabla.setLayout(new BorderLayout(0, 0));

		tablaCanciones = new JTable();
		tablaCanciones.setAutoscrolls(false);
		tablaCanciones.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(tablaCanciones);
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		Component verticalStrut = Box.createVerticalStrut(10);
		panelTabla.add(verticalStrut, BorderLayout.NORTH);

		panelBotonera = new JPanel();
		panelBotonera.setVisible(false);
		add(panelBotonera, BorderLayout.SOUTH);
		panelBotonera.setLayout(new BorderLayout(0, 0));

		JPanel panelMultimedia = new JPanel();
		panelBotonera.add(panelMultimedia, BorderLayout.CENTER);
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

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 11;
		gbc_panel.gridy = 1;
		panelMultimedia.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 100, 0, 100, 0 };
		gbl_panel.rowHeights = new int[] { 40, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_botonCancelar = new GridBagConstraints();
		gbc_botonCancelar.fill = GridBagConstraints.BOTH;
		gbc_botonCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_botonCancelar.gridx = 1;
		gbc_botonCancelar.gridy = 0;
		panel.add(botonCancelar, gbc_botonCancelar);

		Component horizontalStrut_7 = Box.createHorizontalStrut(10);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_7.gridx = 2;
		gbc_horizontalStrut_7.gridy = 0;
		panel.add(horizontalStrut_7, gbc_horizontalStrut_7);

		botonAñadirPlaylist = new JButton("Añadir a PlayList");
		botonAñadirPlaylist.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_botonAñadirPlaylist = new GridBagConstraints();
		gbc_botonAñadirPlaylist.fill = GridBagConstraints.BOTH;
		gbc_botonAñadirPlaylist.gridx = 3;
		gbc_botonAñadirPlaylist.gridy = 0;
		panel.add(botonAñadirPlaylist, gbc_botonAñadirPlaylist);

		Component verticalStrut_2 = Box.createVerticalStrut(40);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 2;
		panelMultimedia.add(verticalStrut_2, gbc_verticalStrut_2);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panelBotonera.add(verticalStrut_3, BorderLayout.NORTH);

		/*
		 * MANEJADORES BOTONES
		 */
		botonBuscar.addActionListener(this);
		botonCancelar.addActionListener(this);
		botonAñadirPlaylist.addActionListener(this);

		botonPlay.addActionListener(this);
		botonPause.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botonBuscar) {
			panelTabla.setVisible(true);
			panelBotonera.setVisible(true);

			String tituloFiltrado = txtTitulo.getText();
			String interpreteFiltrado = txtInterprete.getText();
			String estiloFiltrado = (String) comboBoxEstilo.getSelectedItem();
			boolean favorito = CheckBoxFavoritos.isSelected();

			DefaultTableModel modeloFiltrado = new DefaultTableModel() {

				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					if (column < 3)
						return false;
					return true;
				}

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					if (columnIndex == 3)
						return Boolean.class;
					return super.getColumnClass(columnIndex);
				}
			};

			modeloFiltrado.addColumn("Título");
			modeloFiltrado.addColumn("Estilo");
			modeloFiltrado.addColumn("Interprete");
			modeloFiltrado.addColumn("");

			for (Cancion cancion : Controlador.getUnicaInstancia().getCancionesFiltradas(tituloFiltrado,
					interpreteFiltrado, estiloFiltrado, favorito)) {
				Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical(), cancion.getInterprete(), false };
				modeloFiltrado.addRow(fila);
			}

			tablaCanciones.setModel(modeloFiltrado);

			int anchoTabla = tablaCanciones.getWidth();
			int numColumnas = tablaCanciones.getColumnCount();
			int anchoUltColumna = (int) (anchoTabla * 0.05);
			for (int i = 0; i < numColumnas; i++) {
				tablaCanciones.getColumnModel().getColumn(i).setResizable(false);
				if (i != numColumnas - 1)
					tablaCanciones.getColumnModel().getColumn(i)
							.setPreferredWidth((anchoTabla - anchoUltColumna) / (numColumnas - 1));

				else
					tablaCanciones.getColumnModel().getColumn(i).setPreferredWidth(anchoUltColumna);
			}

			tablaCanciones.setBackground(new Color(0x0D, 0x20, 0x39));
			tablaCanciones.getTableHeader().setReorderingAllowed(false);

			tablaCanciones.setAutoCreateRowSorter(true);

			tablaCanciones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					@SuppressWarnings("unchecked")
					TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tablaCanciones
							.getRowSorter();
					sorter.sort();
				}
			});
		}

		if (e.getSource() == botonCancelar) {
			txtTitulo.setText("");
			txtInterprete.setText("");
			comboBoxEstilo.setSelectedIndex(0);

			panelTabla.setVisible(false);
			panelBotonera.setVisible(false);
		}

		if (e.getSource() == botonAñadirPlaylist) {
			Object[] opciones = { "Sí", "No" };
			int respuesta = JOptionPane.showOptionDialog(null, "¿Quieres crear una nueva PlayList?",
					"Eleccion de playList", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones,
					opciones[0]);

			if (respuesta == JOptionPane.YES_OPTION) {
				String playlist = JOptionPane.showInputDialog(null, "Ingrese el nombre de la nueva playlist:");
				if (!(playlist == null)) {
					if (Controlador.getUnicaInstancia().existePlayList(playlist))
						Controlador.getUnicaInstancia().anadirCancionesAPlayList(playlist,
								(DefaultTableModel) tablaCanciones.getModel());
					else {
						Controlador.getUnicaInstancia().crearPlayList(playlist,
								(DefaultTableModel) tablaCanciones.getModel());
					}
				}
			} else {
				JComboBox<String> playlistComboBox = new JComboBox<>();
				playlistComboBox
						.setModel(new DefaultComboBoxModel<String>(Controlador.getUnicaInstancia().getPlayLists()));
				JOptionPane.showMessageDialog(null, playlistComboBox, "Playlists Disponibles",
						JOptionPane.INFORMATION_MESSAGE);
				if (!playlistComboBox.getSelectedItem().equals(""))
					Controlador.getUnicaInstancia().anadirCancionesAPlayList(
							(String) playlistComboBox.getSelectedItem(), (DefaultTableModel) tablaCanciones.getModel());

			}

		}

		if (e.getSource() == botonPlay) {
			botonPlay.setVisible(false);
			botonPause.setVisible(true);
		}

		if (e.getSource() == botonPause) {
			botonPause.setVisible(false);
			botonPlay.setVisible(true);
		}
	}

	public void esconderPanel() {
		panelTabla.setVisible(false);
		panelBotonera.setVisible(false);

		txtTitulo.setText("");
		txtInterprete.setText("");
		comboBoxEstilo.setSelectedIndex(0);
	}

	public void guardarSeleecionados() {
		Controlador.getUnicaInstancia().setTablaSeleccionados((DefaultTableModel) tablaCanciones.getModel());
	}
}