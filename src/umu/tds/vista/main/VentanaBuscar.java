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

	// ATRIBUTOS
	private JTextField txtTitulo;
	private JTextField txtInterprete;
	private JTable tablaCanciones;
	private JButton botonBuscar;
	private JPanel panelTabla;
	private JPanel panelBotonera;
	private JPanel panelBuscar;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JCheckBox CheckBoxFavoritos;
	private JComboBox<String> comboBoxEstilo;
	private JButton botonCancelar;
	private JButton botonAñadirPlaylist;

	// METODOS
	public void esconderPanel() {
		panelTabla.setVisible(false);
		panelBotonera.setVisible(false);

		txtTitulo.setText("");
		txtInterprete.setText("");
		comboBoxEstilo.setSelectedIndex(0);
	}

	public void guardarSeleecionados() {
		Controlador.INSTANCIA.setTablaSeleccionados((DefaultTableModel) tablaCanciones.getModel());
	}

	public void actualizarEstilos() {
		for (String s : Controlador.INSTANCIA.getEstilos())
			comboBoxEstilo.addItem(s);
	}

	// CONSTRUCTOR
	public VentanaBuscar() {
		setLayout(new BorderLayout(0, 0));

		panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(UIManager.getBorder("Button.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

		comboBoxEstilo = new JComboBox<>();
		actualizarEstilos();

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
		GridBagLayout gbl_panelBotonera = new GridBagLayout();
		gbl_panelBotonera.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panelBotonera.columnWidths = new int[] { 0, 10, 0 };
		gbl_panelBotonera.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panelBotonera.rowHeights = new int[] { 10, 40, 8 };
		panelBotonera.setLayout(gbl_panelBotonera);

		botonAñadirPlaylist = new JButton("Añadir a PlayList");
		botonAñadirPlaylist.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_botonAñadirPlaylist = new GridBagConstraints();
		gbc_botonAñadirPlaylist.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadirPlaylist.fill = GridBagConstraints.BOTH;
		gbc_botonAñadirPlaylist.gridx = 0;
		gbc_botonAñadirPlaylist.gridy = 1;
		panelBotonera.add(botonAñadirPlaylist, gbc_botonAñadirPlaylist);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_botonCancelar = new GridBagConstraints();
		gbc_botonCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_botonCancelar.fill = GridBagConstraints.BOTH;
		gbc_botonCancelar.gridx = 2;
		gbc_botonCancelar.gridy = 1;
		panelBotonera.add(botonCancelar, gbc_botonCancelar);

		/*
		 * MANEJADORES BOTONES
		 */
		botonBuscar.addActionListener(this);
		botonCancelar.addActionListener(this);
		botonAñadirPlaylist.addActionListener(this);
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

			for (Cancion cancion : Controlador.INSTANCIA.getCancionesFiltradas(tituloFiltrado, interpreteFiltrado,
					estiloFiltrado, favorito)) {
				Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical(), cancion.getInterprete(), false };
				modeloFiltrado.addRow(fila);
			}
			tablaCanciones.setModel(modeloFiltrado);

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
					if (Controlador.INSTANCIA.existePlayList(playlist))
						Controlador.INSTANCIA.anadirCancionesAPlayList(playlist,
								(DefaultTableModel) tablaCanciones.getModel());
					else {
						Controlador.INSTANCIA.crearPlayList(playlist, (DefaultTableModel) tablaCanciones.getModel());
					}
				}
			} else {
				JComboBox<String> playlistComboBox = new JComboBox<>();
				playlistComboBox.setModel(new DefaultComboBoxModel<String>(Controlador.INSTANCIA.getPlayLists()));
				JOptionPane.showMessageDialog(null, playlistComboBox, "Playlists Disponibles",
						JOptionPane.INFORMATION_MESSAGE);
				if (!playlistComboBox.getSelectedItem().equals(""))
					Controlador.INSTANCIA.anadirCancionesAPlayList((String) playlistComboBox.getSelectedItem(),
							(DefaultTableModel) tablaCanciones.getModel());
			}
		}
	}
}