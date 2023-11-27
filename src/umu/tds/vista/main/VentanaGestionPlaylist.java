package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
import java.util.Set;
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
	public void ponerPlayListEnTabla(Set<Cancion> set) {
		panelTabla.setVisible(true);

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

		modeloFiltrado.addColumn("TITULO");
		modeloFiltrado.addColumn("ESTILO");
		modeloFiltrado.addColumn("INTERPRETE");
		modeloFiltrado.addColumn("");

		for (Cancion cancion : set) {
			Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical().getEstilo(),
					cancion.getInterprete().getInterprete(), false };
			modeloFiltrado.addRow(fila);
		}

		ajustarTamañoTabla();

		tablaCanciones.setModel(modeloFiltrado);
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

	public void vaciarCampos() {
		txtTitulo.setText("");
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

		ajustarTamañoTabla();
	}

	private void ajustarTamañoTabla() {
		SwingUtilities.invokeLater(() -> {
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
		});
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
		tablaCanciones.setAutoscrolls(false);
		tablaCanciones.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(tablaCanciones);
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		tablaCanciones.setBackground(new Color(0x0D, 0x20, 0x39));
		tablaCanciones.getTableHeader().setReorderingAllowed(false);

		tablaCanciones.setAutoCreateRowSorter(true);

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
					tablaCanciones.setModel(Controlador.INSTANCIA.crearPlaylist(txtTitulo.getText()));
					ajustarTamañoTabla();
				}
			}
		}

		if (e.getSource() == botonEliminar) {
			Object[] opciones = { "Sí", "No" };
			int respuesta = JOptionPane.showOptionDialog(null,
					"¿Quieres eliminar la playlist " + txtTitulo.getText() + "?", "Eliminar de playList",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
			if (respuesta == JOptionPane.YES_OPTION) {
				TableModel modelo = Controlador.INSTANCIA.eliminarPlayList(txtTitulo.getText(),
						tablaCanciones.getModel());
				if (modelo != null) {
					txtTitulo.setText("");
					tablaCanciones.setModel(modelo);
					JOptionPane.showMessageDialog(null, "La playlist " + txtTitulo.getText() + " se ha eliminado.",
							"Exito borrar playlist", JOptionPane.CANCEL_OPTION);
				} else {
					JOptionPane.showMessageDialog(null,
							"La playlist " + txtTitulo.getText() + " no existe.\n No puede ser borrada.",
							"Error borrar playlist", JOptionPane.CANCEL_OPTION);
				}
			}
		}

		if (e.getSource() == botonEliminarCancion) {
			Object[] opciones = { "Sí", "No" };
			int respuesta = JOptionPane.showOptionDialog(null,
					"¿Quieres eliminar canciones de la playlist " + txtTitulo.getText() + "?",
					"Eliminar canciones de playList", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					opciones, opciones[0]);
			if (respuesta == JOptionPane.YES_OPTION) {
				boolean b = Controlador.INSTANCIA.eliminarCancionDePlayList(txtTitulo.getText(),
						(DefaultTableModel) tablaCanciones.getModel());
				if (b) {
					JOptionPane.showMessageDialog(null,
							"Canciones de la playlist " + txtTitulo.getText() + " se han eliminado.",
							"Error borrar cancion", JOptionPane.CANCEL_OPTION);
					tablaCanciones.setModel(Controlador.INSTANCIA.ponerTablaPlaylist(txtTitulo.getText(), false));
				} else {
					JOptionPane.showMessageDialog(null,
							"La playlist " + txtTitulo.getText() + " no existe.\n No puede eliminar canciones.",
							"Error borrar cancion", JOptionPane.CANCEL_OPTION);
				}
			}
		}
	}

}