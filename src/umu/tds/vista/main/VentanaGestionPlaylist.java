package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import umu.tds.Controlador;
import umu.tds.ControladorVentanas;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashSet;
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
	private JPanel panelBuscar;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JButton botonCrear;
	private JButton botonEliminar;
	private Component verticalStrut_1;

	// METODOS
	public void cargarVentana(String playlistNombre) {
		if (playlistNombre != null) {
			if (Controlador.INSTANCIA.getCancionesSeleccionadas().size() > 0) {
				Object[] opciones = { "Sí", "No" };
				int respuesta = JOptionPane.showOptionDialog(null,
						"¿Quieres añadir las canciones seleccionadas a la playlist " + playlistNombre + "?"
								+ "\n Después podrás editar la playlist ",
						"Editar Playlist", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones,
						opciones[0]);
				if (respuesta == JOptionPane.YES_OPTION) {
					Controlador.INSTANCIA.crearPlaylist(playlistNombre);
					ControladorVentanas.INSTANCIA.reiniciarPlantillaMain();
				}
			}
			txtTitulo.setText(playlistNombre);
		} else {
			txtTitulo.setText("");
		}
		configuracionTabla(playlistNombre);
	}

	public void configuracionTabla(String playlistNombre) {
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

		PlayList playlist = Controlador.INSTANCIA.getUsuarioActual().getPlayList(playlistNombre);
		LinkedHashSet<Cancion> listaCanciones;
		if (playlist == null) {
			listaCanciones = Controlador.INSTANCIA.getCancionesSeleccionadas();
		} else {
			listaCanciones = (LinkedHashSet<Cancion>) playlist.getListaCanciones();
		}

		for (Cancion cancion : listaCanciones) {
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

	// CONSTRUCTOR
	public VentanaGestionPlaylist() {
		setLayout(new BorderLayout(0, 0));

		panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(null, "Gestionar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelBuscar, BorderLayout.NORTH);
		GridBagLayout gbl_panelBuscar = new GridBagLayout();
		gbl_panelBuscar.columnWidths = new int[] { 0, 0, 20, 0 };
		gbl_panelBuscar.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
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
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 0;
		panelBuscar.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(20);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
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
		botonCrear.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_botonCrear = new GridBagConstraints();
		gbc_botonCrear.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCrear.insets = new Insets(0, 0, 0, 5);
		gbc_botonCrear.gridx = 0;
		gbc_botonCrear.gridy = 0;
		panel_1.add(botonCrear, gbc_botonCrear);

		botonEliminar = new JButton("Eliminar");
		botonEliminar.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_botonEliminar = new GridBagConstraints();
		gbc_botonEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonEliminar.gridx = 1;
		gbc_botonEliminar.gridy = 0;
		panel_1.add(botonEliminar, gbc_botonEliminar);

		botonEliminarCancion = new JButton("Eliminar de la Playlist");
		GridBagConstraints gbc_botonEliminarCancion = new GridBagConstraints();
		gbc_botonEliminarCancion.fill = GridBagConstraints.VERTICAL;
		gbc_botonEliminarCancion.gridheight = 2;
		gbc_botonEliminarCancion.insets = new Insets(0, 0, 5, 0);
		gbc_botonEliminarCancion.gridx = 3;
		gbc_botonEliminarCancion.gridy = 0;
		panelBuscar.add(botonEliminarCancion, gbc_botonEliminarCancion);
		botonEliminarCancion.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonEliminarCancion.addActionListener(this);

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
		configuracionTabla(null);
		/*
		 * MANEJADORES BOTONES
		 */
		botonCrear.addActionListener(this);
		botonEliminar.addActionListener(this);

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
					ControladorVentanas.INSTANCIA.reiniciarPlantillaMain();
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
				ControladorVentanas.INSTANCIA.reiniciarPlantillaMain();
				DefaultTableModel modelo = (DefaultTableModel) tablaCanciones.getModel();
				modelo.setRowCount(0);
				txtTitulo.setText("");
			}
		}

		if (e.getSource() == botonEliminarCancion) {
			PlayList playlist = null;
			Object[] opciones = { "Sí", "No" };
			int respuesta = JOptionPane.showOptionDialog(null,
					"¿Quieres eliminar canciones de la playlist " + txtTitulo.getText() + "?",
					"Eliminar canciones de playList", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					opciones, opciones[0]);
			if (respuesta == JOptionPane.YES_OPTION) {
				DefaultTableModel modelo = (DefaultTableModel) tablaCanciones.getModel();
				for (int fila = 0; fila < modelo.getRowCount(); fila++) {
					if ((Boolean) modelo.getValueAt(fila, 3)) {
						playlist = Controlador.INSTANCIA.eliminarCancionDePlayList(txtTitulo.getText(),
								(String) modelo.getValueAt(fila, 0));
					}
				}
				JOptionPane.showMessageDialog(null,
						"Canciones de la playlist " + txtTitulo.getText() + " se han eliminado.",
						"Canciones eliminadas correctamente", JOptionPane.CANCEL_OPTION);
				if (playlist != null)
					configuracionTabla(playlist.getNombre());
			}
		}
	}

}