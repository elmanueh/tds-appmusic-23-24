package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

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

public class VentanaGestionPlaylist extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	private JTextField txtTitulo;
	private JTable tablaCanciones;
	private JButton botonEliminarCancion;
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
	private JPanel panel_1;
	private JButton botonCrear;
	private JButton botonEliminar;
	private Component verticalStrut_1;

	// METODOS

	public void reiniciar() {
		configuracionTabla();
		txtTitulo.setText("");
	}

	public void configuracionTabla() {
		panelBotonera.setVisible(true);
		panelTabla.setVisible(true);
		tablaCanciones.getTableHeader().setReorderingAllowed(false);

		DefaultTableModel modelo = new DefaultTableModel() {
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

		modelo.addColumn("Título");
		modelo.addColumn("Estilo");
		modelo.addColumn("Intérprete");
		modelo.addColumn("");

		for (Cancion cancion : Controlador.INSTANCIA.getCancionesSeleccionadas()) {
			Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical().getEstilo(),
					cancion.getInterprete().getInterprete(), false };
			modelo.addRow(fila);
		}

		tablaCanciones.setModel(modelo);
		tablaCanciones.setBackground(new Color(0x0D, 0x20, 0x39));

		TableColumnModel columnModel = tablaCanciones.getColumnModel();
		for (int columnIndex = 0; columnIndex < columnModel.getColumnCount(); columnIndex++) {
			int anchoMaximo = 0;

			for (int rowIndex = 0; rowIndex < tablaCanciones.getRowCount(); rowIndex++) {
				TableCellRenderer cellRenderer = tablaCanciones.getCellRenderer(rowIndex, columnIndex);
				Object valorCelda = tablaCanciones.getValueAt(rowIndex, columnIndex);
				Component componenteCelda = cellRenderer.getTableCellRendererComponent(tablaCanciones, valorCelda,
						false, false, rowIndex, columnIndex);
				anchoMaximo = Math.max(anchoMaximo, componenteCelda.getPreferredSize().width);

			}
			columnModel.getColumn(columnIndex).setPreferredWidth(anchoMaximo);
			columnModel.getColumn(columnIndex).setResizable(false);
		}
	}

	public void ponerPlayListEnTabla(String playlist) {
		Object[] opciones = { "Sí", "No" };
		int respuesta = JOptionPane.showOptionDialog(null,
				"¿Quieres añadir las canciones seleccionadas a la playlist " + playlist + "?"
						+ "\n Después podrás editar la playlist ",
				"Editar Playlist", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones,
				opciones[0]);
		if (respuesta == JOptionPane.YES_OPTION) {
			txtTitulo.setText(playlist);
			tablaCanciones.setModel(Controlador.INSTANCIA.ponerTablaPlaylist(playlist, true));
		} else if (respuesta == JOptionPane.NO_OPTION) {
			txtTitulo.setText(playlist);
			tablaCanciones.setModel(Controlador.INSTANCIA.ponerTablaPlaylist(playlist, false));
		}

	}

	// CONSTRUCTOR
	public VentanaGestionPlaylist() {
		setLayout(new BorderLayout(0, 0));

		panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(null, "Gestionar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelBuscar, BorderLayout.NORTH);
		GridBagLayout gbl_panelBuscar = new GridBagLayout();
		gbl_panelBuscar.columnWeights = new double[] { 0.0, 0.0 };
		panelBuscar.setLayout(gbl_panelBuscar);

		lblNewLabel_1 = new JLabel("Título:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panelBuscar.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtTitulo = new JTextField();
		txtTitulo.setText("");
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 0;
		panelBuscar.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(20);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panelBuscar.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		botonCrear = new JButton("Crear");
		GridBagConstraints gbc_botonCrear = new GridBagConstraints();
		gbc_botonCrear.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCrear.insets = new Insets(0, 0, 0, 5);
		gbc_botonCrear.gridx = 0;
		gbc_botonCrear.gridy = 0;
		panel_1.add(botonCrear, gbc_botonCrear);

		botonEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_botonEliminar = new GridBagConstraints();
		gbc_botonEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonEliminar.gridx = 1;
		gbc_botonEliminar.gridy = 0;
		panel_1.add(botonEliminar, gbc_botonEliminar);

		verticalStrut_1 = Box.createVerticalStrut(8);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 2;
		panelBuscar.add(verticalStrut_1, gbc_verticalStrut_1);

		panelTabla = new JPanel();
		panelTabla.setVisible(true);
		add(panelTabla, BorderLayout.CENTER);
		panelTabla.setLayout(new BorderLayout(0, 0));

		tablaCanciones = new JTable();
		scrollPane = new JScrollPane(tablaCanciones);
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		tablaCanciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String titulo = (String) ((DefaultTableModel) tablaCanciones.getModel())
						.getValueAt(tablaCanciones.getSelectedRow(), 0);
				Controlador.INSTANCIA.setCancionSeleccionada(titulo);
			}
		});

		Component verticalStrut = Box.createVerticalStrut(10);
		panelTabla.add(verticalStrut, BorderLayout.NORTH);

		panelBotonera = new JPanel();
		panelBotonera.setVisible(true);
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

		Component horizontalStrut_7 = Box.createHorizontalStrut(10);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_7.gridx = 2;
		gbc_horizontalStrut_7.gridy = 0;
		panel.add(horizontalStrut_7, gbc_horizontalStrut_7);

		botonEliminarCancion = new JButton("Eliminar de la Playlist");
		botonEliminarCancion.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_botonEliminarCancion = new GridBagConstraints();
		gbc_botonEliminarCancion.fill = GridBagConstraints.BOTH;
		gbc_botonEliminarCancion.gridx = 3;
		gbc_botonEliminarCancion.gridy = 0;
		panel.add(botonEliminarCancion, gbc_botonEliminarCancion);

		Component verticalStrut_2 = Box.createVerticalStrut(40);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 2;
		panelMultimedia.add(verticalStrut_2, gbc_verticalStrut_2);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panelBotonera.add(verticalStrut_3, BorderLayout.NORTH);
		configuracionTabla();
		/*
		 * MANEJADORES BOTONES
		 */
		botonCrear.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonEliminarCancion.addActionListener(this);

		botonPlay.addActionListener(this);
		botonPause.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botonCrear) {
			if (!txtTitulo.getText().equals("")) {
				Object[] opciones = { "Sí", "No" };
				int respuesta = JOptionPane.showOptionDialog(null,
						"¿Quieres crear la playlist " + txtTitulo.getText() + "?", "Eleccion de playList",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
				if (respuesta == JOptionPane.YES_OPTION) {
					DefaultTableModel modelo = (DefaultTableModel) tablaCanciones.getModel();
					modelo.setRowCount(0);
					for (Cancion cancion : Controlador.INSTANCIA.crearPlaylist(txtTitulo.getText())
							.getListaCanciones()) {
						Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical().getEstilo(),
								cancion.getInterprete().getInterprete(), false };
						modelo.addRow(fila);
					}
				}
			}
		}

		if (e.getSource() == botonEliminar) {
			Object[] opciones = { "Sí", "No" };
			int respuesta = JOptionPane.showOptionDialog(null,
					"¿Quieres eliminar la playlist " + txtTitulo.getText() + "?", "Eliminar de playList",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
			if (respuesta == JOptionPane.YES_OPTION) {
				Controlador.INSTANCIA.eliminarPlayList(txtTitulo.getText());
				DefaultTableModel modelo = (DefaultTableModel) tablaCanciones.getModel();
				modelo.setRowCount(0);
				txtTitulo.setText("");
			}
		}

		if (e.getSource() == botonEliminarCancion) {
			Object[] opciones = { "Sí", "No" };
			int respuesta = JOptionPane.showOptionDialog(null,
					"¿Quieres eliminar canciones de la playlist " + txtTitulo.getText() + "?",
					"Eliminar canciones de playList", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					opciones, opciones[0]);
			if (respuesta == JOptionPane.YES_OPTION) {
				boolean b = Controlador.INSTANCIA.eliminarCancionDePlayList(txtTitulo.getText(), // TODO
						(DefaultTableModel) tablaCanciones.getModel());
				if (b) {
					JOptionPane.showMessageDialog(null,
							"Canciones de la playlist " + txtTitulo.getText() + " se han eliminado.",
							"Error borrar cancion", JOptionPane.CANCEL_OPTION);
					tablaCanciones.setModel(Controlador.INSTANCIA.ponerTablaPlaylist(txtTitulo.getText(), false)); // TODO
				} else {
					JOptionPane.showMessageDialog(null,
							"La playlist " + txtTitulo.getText() + " no existe.\n No puede eliminar canciones.",
							"Error borrar cancion", JOptionPane.CANCEL_OPTION);
				}
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

}