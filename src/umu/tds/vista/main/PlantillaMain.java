package umu.tds.vista.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.ControladorVentanas;
import umu.tds.modelo.musica.PlayList;
import umu.tds.vista.inicio.PlantillaInicio;

import javax.swing.JTable;
import java.awt.Point;
import javax.swing.UIManager;

public class PlantillaMain extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private GridBagLayout gridBagLayout;
	private JTable tablaPlayList;
	private JButton botonPremium;
	private JButton botonLogOut;
	private JButton botonBuscar;
	private JButton botonGestionPlaylist;
	private JButton botonRecientes;
	private JButton botonMasReproducidas;
	private JButton botonGenerarPDF;
	private JButton botonMisPlaylist;
	private static JPanel p_menuBotonesPremium;
	private JPanel p_listas;
	private JPanel p_cardLayout;
	private JPanel p_cabezera;
	private JLabel mensajeBienvenida;

	private VentanaBuscar ventanaBuscar;
	private VentanaGestionPlaylist ventanaGestionPlaylist;
	private VentanaRecientes ventanaRecientes;
	private VentanaMasReproducidas ventanaMasReproducidas;
	private VentanaGenerarPDF ventanaGenerarPDF;
	private VentanaMisPlaylist ventanaMisPlaylist;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;

	private void inicializar() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PlantillaInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));

		gridBagLayout = new GridBagLayout();
		getContentPane().setLayout(gridBagLayout);

		setTitle("Spotifoo");
		setSize(1100, 700);
		setMinimumSize(getSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		ventanaBuscar = new VentanaBuscar();
		ventanaGestionPlaylist = new VentanaGestionPlaylist();
		ventanaRecientes = new VentanaRecientes();
		ventanaMasReproducidas = new VentanaMasReproducidas();
		ventanaGenerarPDF = new VentanaGenerarPDF();
		ventanaMisPlaylist = new VentanaMisPlaylist();
	}

	public PlantillaMain() {

		inicializar();

		gridBagLayout.columnWidths = new int[] { 0, 0, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };

		JPanel p_iconoTitulo = new JPanel();
		p_iconoTitulo.setBackground(new Color(40, 40, 40));
		FlowLayout flowLayout = (FlowLayout) p_iconoTitulo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_p_iconoTitulo = new GridBagConstraints();
		gbc_p_iconoTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_p_iconoTitulo.fill = GridBagConstraints.BOTH;
		gbc_p_iconoTitulo.gridx = 0;
		gbc_p_iconoTitulo.gridy = 0;
		getContentPane().add(p_iconoTitulo, gbc_p_iconoTitulo);

		Component horizontalStrut = Box.createHorizontalStrut(10);
		p_iconoTitulo.add(horizontalStrut);

		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		icono.setHorizontalAlignment(SwingConstants.LEFT);
		icono.setForeground(Color.WHITE);
		p_iconoTitulo.add(icono);

		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		p_iconoTitulo.add(horizontalStrut_1);

		JLabel titulo = new JLabel("Spotifoo");
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		p_iconoTitulo.add(titulo);

		Component verticalStrut = Box.createVerticalStrut(90);
		p_iconoTitulo.add(verticalStrut);
		
		lblNewLabel_1 = new JLabel("");
		if (Controlador.INSTANCIA.diasParaCumple() == 365)
			lblNewLabel_1.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/torta-cumpleanos.png")));
		p_iconoTitulo.add(lblNewLabel_1);

		p_cabezera = new JPanel();
		p_cabezera.setBackground(new Color(40, 40, 40));
		GridBagConstraints gbc_p_cabezera = new GridBagConstraints();
		gbc_p_cabezera.gridwidth = 2;
		gbc_p_cabezera.insets = new Insets(0, 0, 5, 5);
		gbc_p_cabezera.fill = GridBagConstraints.BOTH;
		gbc_p_cabezera.gridx = 1;
		gbc_p_cabezera.gridy = 0;
		getContentPane().add(p_cabezera, gbc_p_cabezera);
		p_cabezera.setLayout(new BorderLayout(0, 0));

		/* TODO: si falla quitar aqui el usuario para probar */
		String usuario = Controlador.INSTANCIA.getNombreUsuarioActual();
		mensajeBienvenida = new JLabel("Bienvenido, " + usuario);
		mensajeBienvenida.setLocation(new Point(40, 0));
		mensajeBienvenida.setHorizontalTextPosition(SwingConstants.LEFT);
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		if (Controlador.INSTANCIA.isUsuarioActualPremium())
			mensajeBienvenida.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/corona-de-usuario.png")));
		else
			mensajeBienvenida.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/usuario.png")));
			
		p_cabezera.add(mensajeBienvenida, BorderLayout.CENTER);
		
		JPanel p_cabezeraBotones = new JPanel();
		p_cabezeraBotones.setOpaque(false);
		p_cabezera.add(p_cabezeraBotones, BorderLayout.EAST);
		GridBagLayout gbl_p_cabezeraBotones = new GridBagLayout();
		gbl_p_cabezeraBotones.columnWidths = new int[] { 0, 100, 10, 100, 0 };
		gbl_p_cabezeraBotones.rowHeights = new int[] { 30 };
		p_cabezeraBotones.setLayout(gbl_p_cabezeraBotones);
		JPanel p_menuBotones = new JPanel();
		botonPremium = new JButton("Premium");
		p_menuBotonesPremium = new JPanel();

		btnNewButton = new JButton("UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        String path = System.getProperty("user.dir") + File.separator + "xml";
				File inicio = new File(path);
				JFileChooser fileChooser = new JFileChooser(inicio);

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.xml)", "xml");
				fileChooser.setFileFilter(filter);

				int result = fileChooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					Controlador.INSTANCIA.cargarCanciones(selectedFile.getAbsolutePath());
					ventanaBuscar.actualizarEstilos();
				}
			}
		});

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		p_cabezeraBotones.add(btnNewButton, gbc_btnNewButton);

		botonPremium.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonPremium.setAlignmentX(0.5f);
		GridBagConstraints gbc_botonPremium = new GridBagConstraints();
		gbc_botonPremium.fill = GridBagConstraints.BOTH;
		gbc_botonPremium.insets = new Insets(0, 0, 0, 5);
		gbc_botonPremium.gridx = 1;
		gbc_botonPremium.gridy = 0;
		p_cabezeraBotones.add(botonPremium, gbc_botonPremium);

		botonLogOut = new JButton("Cerrar Sesión");

		botonLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_botonLogOut = new GridBagConstraints();
		gbc_botonLogOut.insets = new Insets(0, 0, 0, 5);
		gbc_botonLogOut.fill = GridBagConstraints.BOTH;
		gbc_botonLogOut.gridx = 3;
		gbc_botonLogOut.gridy = 0;
		p_cabezeraBotones.add(botonLogOut, gbc_botonLogOut);

		GridBagConstraints gbc_p_menuBotones = new GridBagConstraints();
		gbc_p_menuBotones.insets = new Insets(0, 0, 0, 5);
		gbc_p_menuBotones.fill = GridBagConstraints.BOTH;
		gbc_p_menuBotones.gridx = 0;
		gbc_p_menuBotones.gridy = 1;
		getContentPane().add(p_menuBotones, gbc_p_menuBotones);
		GridBagLayout gbl_p_menuBotones = new GridBagLayout();
		gbl_p_menuBotones.columnWidths = new int[] { 20, 190, 0, 0 };
		gbl_p_menuBotones.rowHeights = new int[] { 40, 40, 40, 0, 40, 0, 0 };
		gbl_p_menuBotones.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_p_menuBotones.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		p_menuBotones.setLayout(gbl_p_menuBotones);

		p_cardLayout = new JPanel();
		p_listas = new JPanel();
		botonBuscar = new JButton(" Buscar");
		botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonBuscar.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/buscar-alt.png")));

		botonBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonBuscar = new GridBagConstraints();
		gbc_botonBuscar.fill = GridBagConstraints.BOTH;
		gbc_botonBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_botonBuscar.gridx = 1;
		gbc_botonBuscar.gridy = 0;
		p_menuBotones.add(botonBuscar, gbc_botonBuscar);

		botonGestionPlaylist = new JButton(" Gestión Playlist");

		botonGestionPlaylist.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonGestionPlaylist
				.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/agregar-carpeta.png")));
		botonGestionPlaylist.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonGestionPlaylist = new GridBagConstraints();
		gbc_botonGestionPlaylist.insets = new Insets(0, 0, 5, 5);
		gbc_botonGestionPlaylist.fill = GridBagConstraints.BOTH;
		gbc_botonGestionPlaylist.gridx = 1;
		gbc_botonGestionPlaylist.gridy = 1;
		p_menuBotones.add(botonGestionPlaylist, gbc_botonGestionPlaylist);

		botonRecientes = new JButton(" Recientes");

		botonRecientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonRecientes
				.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/tiempo-pasado.png")));
		botonRecientes.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonRecientes = new GridBagConstraints();
		gbc_botonRecientes.insets = new Insets(0, 0, 5, 5);
		gbc_botonRecientes.fill = GridBagConstraints.BOTH;
		gbc_botonRecientes.gridx = 1;
		gbc_botonRecientes.gridy = 2;
		p_menuBotones.add(botonRecientes, gbc_botonRecientes);

		p_menuBotonesPremium.setVisible(Controlador.INSTANCIA.isUsuarioActualPremium());
		GridBagConstraints gbc_p_menuBotonesPremium = new GridBagConstraints();
		gbc_p_menuBotonesPremium.gridwidth = 2;
		gbc_p_menuBotonesPremium.insets = new Insets(0, 0, 5, 5);
		gbc_p_menuBotonesPremium.fill = GridBagConstraints.BOTH;
		gbc_p_menuBotonesPremium.gridx = 0;
		gbc_p_menuBotonesPremium.gridy = 3;
		p_menuBotones.add(p_menuBotonesPremium, gbc_p_menuBotonesPremium);
		GridBagLayout gbl_p_menuBotonesPremium = new GridBagLayout();
		gbl_p_menuBotonesPremium.columnWidths = new int[] { 20, 0, 0 };
		gbl_p_menuBotonesPremium.rowHeights = new int[] { 40, 40, 0 };
		gbl_p_menuBotonesPremium.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_p_menuBotonesPremium.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		p_menuBotonesPremium.setLayout(gbl_p_menuBotonesPremium);

		botonMasReproducidas = new JButton(" Más Reproducidas");
		botonMasReproducidas.setIcon(
				new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/estrella-del-trofeo.png")));

		botonMasReproducidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonMasReproducidas.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonMasReproducidas = new GridBagConstraints();
		gbc_botonMasReproducidas.fill = GridBagConstraints.BOTH;
		gbc_botonMasReproducidas.insets = new Insets(0, 0, 5, 0);
		gbc_botonMasReproducidas.gridx = 1;
		gbc_botonMasReproducidas.gridy = 0;
		p_menuBotonesPremium.add(botonMasReproducidas, gbc_botonMasReproducidas);

		botonGenerarPDF = new JButton(" Generar PDF");
		botonGenerarPDF
				.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/archivo-pdf.png")));

		botonGenerarPDF.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonGenerarPDF.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonGenerarPDF = new GridBagConstraints();
		gbc_botonGenerarPDF.fill = GridBagConstraints.BOTH;
		gbc_botonGenerarPDF.gridx = 1;
		gbc_botonGenerarPDF.gridy = 1;
		p_menuBotonesPremium.add(botonGenerarPDF, gbc_botonGenerarPDF);

		p_cardLayout.setVisible(false);
		botonMisPlaylist = new JButton(" Mis Playlist");
		botonMisPlaylist.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonMisPlaylist.setIcon(
				new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/arbol-de-carpetas.png")));

		botonMisPlaylist.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonMisPlaylist = new GridBagConstraints();
		gbc_botonMisPlaylist.insets = new Insets(0, 0, 5, 5);
		gbc_botonMisPlaylist.fill = GridBagConstraints.BOTH;
		gbc_botonMisPlaylist.gridx = 1;
		gbc_botonMisPlaylist.gridy = 4;
		p_menuBotones.add(botonMisPlaylist, gbc_botonMisPlaylist);

		p_listas.setVisible(false);
		GridBagConstraints gbc_p_listas = new GridBagConstraints();
		gbc_p_listas.insets = new Insets(0, 0, 0, 5);
		gbc_p_listas.gridwidth = 2;
		gbc_p_listas.fill = GridBagConstraints.BOTH;
		gbc_p_listas.gridx = 0;
		gbc_p_listas.gridy = 5;
		p_menuBotones.add(p_listas, gbc_p_listas);
		p_listas.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		p_listas.add(horizontalStrut_2, BorderLayout.WEST);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		p_listas.add(verticalStrut_1, BorderLayout.NORTH);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		p_listas.add(verticalStrut_2, BorderLayout.SOUTH);

		tablaPlayList = new JTable();
		tablaPlayList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tablaPlayList.setTableHeader(null);
		JScrollPane scrollPane = new JScrollPane(tablaPlayList);
		scrollPane.setPreferredSize(new Dimension());
		scrollPane.setBorder(new TitledBorder(UIManager.getBorder("Button.border"), "Playlist", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		p_listas.add(scrollPane, BorderLayout.CENTER);

		// HASTA AQUI TABLA PLAYLIST

		GridBagConstraints gbc_p_cardLayout = new GridBagConstraints();
		gbc_p_cardLayout.insets = new Insets(0, 0, 0, 5);
		gbc_p_cardLayout.fill = GridBagConstraints.BOTH;
		gbc_p_cardLayout.gridx = 1;
		gbc_p_cardLayout.gridy = 1;
		getContentPane().add(p_cardLayout, gbc_p_cardLayout);
		p_cardLayout.setLayout(new CardLayout(0, 0));

		p_cardLayout.add(ventanaBuscar, "ventanaBuscar");
		p_cardLayout.add(ventanaGestionPlaylist, "ventanaGestionPlaylist");
		p_cardLayout.add(ventanaRecientes, "ventanaRecientes");
		p_cardLayout.add(ventanaMasReproducidas, "ventanaMasReproducidas");
		p_cardLayout.add(ventanaGenerarPDF, "ventanaGenerarPDF");
		p_cardLayout.add(ventanaMisPlaylist, "ventanaMisPlaylist");

		/*
		 * MANEJADORES
		 */
		botonPremium.addActionListener(this);
		botonLogOut.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGestionPlaylist.addActionListener(this);
		botonRecientes.addActionListener(this);
		botonMasReproducidas.addActionListener(this);
		botonGenerarPDF.addActionListener(this);
		botonMisPlaylist.addActionListener(this);

	}

	public void modoPremium(boolean premium) {
		p_menuBotonesPremium.setVisible(premium);
		if (premium) {
			mensajeBienvenida.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/corona-de-usuario.png")));
		} else {
			mensajeBienvenida.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/usuario.png")));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (ventanaBuscar.isVisible() && e.getSource() != botonPremium && e.getSource() != botonLogOut) {
			ventanaBuscar.guardarSeleecionados();
		}

		// TODO
		if (e.getSource() == botonPremium) {
			ControladorVentanas.INSTANCIA.iniciarPremium();
		}

		if (e.getSource() == botonLogOut) {
			ControladorVentanas.INSTANCIA.logOutSatisfactorio();
		}

		if (e.getSource() == botonBuscar) {
			p_listas.setVisible(false);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaBuscar");
			ventanaBuscar.esconderPanel();
		}

		if (e.getSource() == botonGestionPlaylist) {
			p_listas.setVisible(true);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaGestionPlaylist");
			ventanaGestionPlaylist.vaciarCampos();
			ventanaGestionPlaylist.ponerPlayListEnTabla(Controlador.INSTANCIA.getCancionesSeleccionadas());

			/*
			 * TABLA
			 */
			DefaultTableModel modeloTabla = new DefaultTableModel() {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			modeloTabla.addColumn("");
			for (PlayList p : Controlador.INSTANCIA.getPlayListUsuarioActual()) {
				Object[] playlist = { p.getNombre() };
				modeloTabla.addRow(playlist);
			}

			tablaPlayList.setModel(modeloTabla);
		}

		if (e.getSource() == botonRecientes) {
			p_listas.setVisible(false);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaRecientes");
		}

		if (e.getSource() == botonMasReproducidas) {
			p_listas.setVisible(false);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaMasReproducidas");
		}

		if (e.getSource() == botonGenerarPDF) {
			p_listas.setVisible(false);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaGenerarPDF");
		}

		if (e.getSource() == botonMisPlaylist) {
			p_listas.setVisible(true);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaMisPlaylist");
			ventanaMisPlaylist.esconderPanel();

			/*
			 * TABLA
			 */
			DefaultTableModel modeloTabla = new DefaultTableModel() {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			modeloTabla.addColumn("");
			for (PlayList p : Controlador.INSTANCIA.getPlayListUsuarioActual()) {
				Object[] playlist = { p.getNombre() };
				modeloTabla.addRow(playlist);
			}

			tablaPlayList.setModel(modeloTabla);

			tablaPlayList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = tablaPlayList.getSelectedRow();
					int column = tablaPlayList.getSelectedColumn();

					String playlist = tablaPlayList.getValueAt(row, column).toString();
					ventanaMisPlaylist.ponerPlayListEnTabla(playlist);
				}
			});

		}

	}

}
