package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import umu.tds.modelo.Controlador;
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
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class VentanaGestionPlaylist extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JTextField txtTitulo;
	private JTable tablaCanciones;
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
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public VentanaGestionPlaylist() {
		setLayout(new BorderLayout(0, 0));

		panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(null, "Gestionar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelBuscar, BorderLayout.NORTH);
		GridBagLayout gbl_panelBuscar = new GridBagLayout();
		gbl_panelBuscar.rowWeights = new double[]{0.0, 0.0};
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
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panelBuscar.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnNewButton = new JButton("Crear");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("Eliminar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);

		panelTabla = new JPanel();
		panelTabla.setVisible(true);
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

		botonAñadirPlaylist = new JButton("Eliminar Lista");
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
		botonAñadirPlaylist.addActionListener(this);

		botonPlay.addActionListener(this);
		botonPause.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*@Override
	public void actionPerformed(ActionEvent e) {

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
	}*/
	public void ponerPlayListEnTabla(String playlist) {		
		panelBotonera.setVisible(true);
		panelTabla.setVisible(true);
		
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
	}
	public void esconderPanel() {

		txtTitulo.setText("");
	}



}