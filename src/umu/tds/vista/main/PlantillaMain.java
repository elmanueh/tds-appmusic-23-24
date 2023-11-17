package umu.tds.vista.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.ControladorVentanas;
import umu.tds.modelo.musica.PlayList;
import umu.tds.vista.inicio.PlantillaInicio;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.CardLayout;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;

public class PlantillaMain extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	private VentanaBuscar ventanaBuscar;
	private VentanaGestionPlaylist ventanaGestionPlaylist;
	private VentanaRecientes ventanaRecientes;
	private VentanaMasReproducidas ventanaMasReproducidas;
	private VentanaGenerarPDF ventanaGenerarPDF;
	private VentanaMisPlaylist ventanaMisPlaylist;
	private JPanel p_menuBotonesPremium;
	private JLabel mensajeBienvenida;
	private JButton btnPremium;
	private JButton btnLogOut;
	private JButton btnBuscar;
	private JButton btnGestionPlaylist;
	private JPanel p_playlist;
	private JPanel p_cardLayout;
	private JTable tablaPlayList;
	private JButton btnRecientes;
	private JButton btnMasReproducidas;
	private JButton btnGenerarPDF;
	private JButton btnMisPlaylist;
	private JButton btnUp;
	private JButton btnShuffle;
	private JButton btnPrevious;
	private JButton btnPlayPause;
	private JButton btnNext;
	private JButton btnSecuential;

	private int auxiliar;

	// METODOS
	private void inicializar() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PlantillaInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		getContentPane().setLayout(new BorderLayout(0, 0));
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

	public void estadoPremium(boolean premium) {
		p_menuBotonesPremium.setVisible(premium);
		mensajeBienvenida
				.setIcon(new ImageIcon(PlantillaMain.class.getResource(Controlador.INSTANCIA.getIconoUsuario())));
	}

	public void estadoReproduciendo(String reproduciendo) {
		btnPlayPause.setIcon(new ImageIcon(PlantillaMain.class.getResource(reproduciendo)));
	}

	// CONSTRUCTOR
	public PlantillaMain() {
		inicializar();

		JPanel p_cabezera = new JPanel();
		p_cabezera.setBackground(new Color(30, 30, 30));
		getContentPane().add(p_cabezera, BorderLayout.NORTH);
		p_cabezera.setLayout(new BorderLayout(0, 0));

		JPanel p_iconoTitulo = new JPanel();
		p_iconoTitulo.setOpaque(false);
		p_cabezera.add(p_iconoTitulo, BorderLayout.WEST);

		Component horizontalStrut = Box.createHorizontalStrut(10);
		p_iconoTitulo.add(horizontalStrut);

		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/icono.png")));
		p_iconoTitulo.add(icono);

		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		p_iconoTitulo.add(horizontalStrut_1);

		JLabel titulo = new JLabel("Spotifoo");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		p_iconoTitulo.add(titulo);

		Component verticalStrut = Box.createVerticalStrut(90);
		p_iconoTitulo.add(verticalStrut);

		JLabel cumpleaños = new JLabel("");
		cumpleaños.setVisible(false);
		cumpleaños.setIcon(
				new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/torta-cumpleanos.png")));
		p_iconoTitulo.add(cumpleaños);
		if (Controlador.INSTANCIA.isCumpleañosUsuario())
			cumpleaños.setVisible(true);

		JPanel p_cabezeraBotones = new JPanel();
		p_cabezeraBotones.setOpaque(false);
		p_cabezera.add(p_cabezeraBotones, BorderLayout.CENTER);
		p_cabezeraBotones.setLayout(new BorderLayout(0, 0));

		JPanel p_botonConfiguracion = new JPanel();
		p_botonConfiguracion.setOpaque(false);
		p_cabezeraBotones.add(p_botonConfiguracion, BorderLayout.EAST);
		GridBagLayout gbl_p_botonConfiguracion = new GridBagLayout();
		gbl_p_botonConfiguracion.rowWeights = new double[] { 0.0 };
		gbl_p_botonConfiguracion.rowHeights = new int[] { 30 };
		gbl_p_botonConfiguracion.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_p_botonConfiguracion.columnWidths = new int[] { 0, 15, 100, 15, 100, 0 };
		p_botonConfiguracion.setLayout(gbl_p_botonConfiguracion);

		btnUp = new JButton("UP");
		btnUp.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnUp = new GridBagConstraints();
		gbc_btnUp.fill = GridBagConstraints.BOTH;
		gbc_btnUp.insets = new Insets(0, 0, 0, 5);
		gbc_btnUp.gridx = 0;
		gbc_btnUp.gridy = 0;
		p_botonConfiguracion.add(btnUp, gbc_btnUp);

		btnPremium = new JButton("Premium");
		btnPremium.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnPremium = new GridBagConstraints();
		gbc_btnPremium.fill = GridBagConstraints.BOTH;
		gbc_btnPremium.insets = new Insets(0, 0, 0, 5);
		gbc_btnPremium.gridx = 2;
		gbc_btnPremium.gridy = 0;
		p_botonConfiguracion.add(btnPremium, gbc_btnPremium);

		btnLogOut = new JButton("Cerrar Sesión");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.fill = GridBagConstraints.BOTH;
		gbc_btnLogOut.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogOut.gridx = 4;
		gbc_btnLogOut.gridy = 0;
		p_botonConfiguracion.add(btnLogOut, gbc_btnLogOut);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.gridx = 5;
		gbc_horizontalStrut_2.gridy = 0;
		p_botonConfiguracion.add(horizontalStrut_2, gbc_horizontalStrut_2);

		mensajeBienvenida = new JLabel("Bienvenido, " + Controlador.INSTANCIA.getNombreUsuarioActual());
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mensajeBienvenida
				.setIcon(new ImageIcon(PlantillaMain.class.getResource(Controlador.INSTANCIA.getIconoUsuario())));

		p_cabezeraBotones.add(mensajeBienvenida, BorderLayout.CENTER);

		JPanel p_contenido = new JPanel();
		getContentPane().add(p_contenido, BorderLayout.CENTER);
		p_contenido.setLayout(new BorderLayout(0, 0));

		JPanel p_menuBotones = new JPanel();
		p_menuBotones.setBackground(new Color(40, 40, 40));
		p_contenido.add(p_menuBotones, BorderLayout.WEST);
		GridBagLayout gbl_p_menuBotones = new GridBagLayout();
		gbl_p_menuBotones.columnWidths = new int[] { 20, 190, 15, 0 };
		gbl_p_menuBotones.rowHeights = new int[] { 30, 40, 40, 40, 0, 40, 15, 250, 20, 0 };
		gbl_p_menuBotones.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_p_menuBotones.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		p_menuBotones.setLayout(gbl_p_menuBotones);

		btnBuscar = new JButton(" Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscar.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/buscar-alt.png")));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.BOTH;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 1;
		p_menuBotones.add(btnBuscar, gbc_btnBuscar);

		btnGestionPlaylist = new JButton(" Gestión Playlist");
		btnGestionPlaylist.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGestionPlaylist.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionPlaylist
				.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/agregar-carpeta.png")));
		GridBagConstraints gbc_btnGestionPlaylist = new GridBagConstraints();
		gbc_btnGestionPlaylist.fill = GridBagConstraints.BOTH;
		gbc_btnGestionPlaylist.insets = new Insets(0, 0, 5, 5);
		gbc_btnGestionPlaylist.gridx = 1;
		gbc_btnGestionPlaylist.gridy = 2;
		p_menuBotones.add(btnGestionPlaylist, gbc_btnGestionPlaylist);

		btnRecientes = new JButton(" Recientes");
		btnRecientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRecientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnRecientes
				.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/tiempo-pasado.png")));
		GridBagConstraints gbc_btnRecientes = new GridBagConstraints();
		gbc_btnRecientes.fill = GridBagConstraints.BOTH;
		gbc_btnRecientes.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecientes.gridx = 1;
		gbc_btnRecientes.gridy = 3;
		p_menuBotones.add(btnRecientes, gbc_btnRecientes);

		p_menuBotonesPremium = new JPanel();
		p_menuBotonesPremium.setOpaque(false);
		p_menuBotonesPremium.setVisible(Controlador.INSTANCIA.isUsuarioActualPremium());
		GridBagConstraints gbc_p_menuBotonesPremium = new GridBagConstraints();
		gbc_p_menuBotonesPremium.insets = new Insets(0, 0, 5, 5);
		gbc_p_menuBotonesPremium.fill = GridBagConstraints.BOTH;
		gbc_p_menuBotonesPremium.gridx = 1;
		gbc_p_menuBotonesPremium.gridy = 4;
		p_menuBotones.add(p_menuBotonesPremium, gbc_p_menuBotonesPremium);
		GridBagLayout gbl_p_menuBotonesPremium = new GridBagLayout();
		gbl_p_menuBotonesPremium.columnWidths = new int[] { 119, 0 };
		gbl_p_menuBotonesPremium.rowHeights = new int[] { 40, 40, 0 };
		gbl_p_menuBotonesPremium.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_p_menuBotonesPremium.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		p_menuBotonesPremium.setLayout(gbl_p_menuBotonesPremium);

		btnMasReproducidas = new JButton(" Más Reproducidas");
		btnMasReproducidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMasReproducidas.setHorizontalAlignment(SwingConstants.LEFT);
		btnMasReproducidas.setIcon(
				new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/estrella-del-trofeo.png")));
		GridBagConstraints gbc_btnMasReproducidas = new GridBagConstraints();
		gbc_btnMasReproducidas.fill = GridBagConstraints.BOTH;
		gbc_btnMasReproducidas.insets = new Insets(0, 0, 5, 0);
		gbc_btnMasReproducidas.gridx = 0;
		gbc_btnMasReproducidas.gridy = 0;
		p_menuBotonesPremium.add(btnMasReproducidas, gbc_btnMasReproducidas);

		btnGenerarPDF = new JButton(" Generar PDF");
		btnGenerarPDF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGenerarPDF.setHorizontalAlignment(SwingConstants.LEFT);
		btnGenerarPDF
				.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/archivo-pdf.png")));
		GridBagConstraints gbc_btnGenerarPDF = new GridBagConstraints();
		gbc_btnGenerarPDF.fill = GridBagConstraints.BOTH;
		gbc_btnGenerarPDF.gridx = 0;
		gbc_btnGenerarPDF.gridy = 1;
		p_menuBotonesPremium.add(btnGenerarPDF, gbc_btnGenerarPDF);

		btnMisPlaylist = new JButton(" Mis Playlist");
		btnMisPlaylist.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMisPlaylist.setHorizontalAlignment(SwingConstants.LEFT);
		btnMisPlaylist.setIcon(
				new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/arbol-de-carpetas.png")));
		GridBagConstraints gbc_btnMisPlaylist = new GridBagConstraints();
		gbc_btnMisPlaylist.insets = new Insets(0, 0, 5, 5);
		gbc_btnMisPlaylist.fill = GridBagConstraints.BOTH;
		gbc_btnMisPlaylist.gridx = 1;
		gbc_btnMisPlaylist.gridy = 5;
		p_menuBotones.add(btnMisPlaylist, gbc_btnMisPlaylist);

		p_playlist = new JPanel();
		p_playlist.setVisible(false);
		GridBagConstraints gbc_p_playlist = new GridBagConstraints();
		gbc_p_playlist.insets = new Insets(0, 0, 5, 5);
		gbc_p_playlist.fill = GridBagConstraints.BOTH;
		gbc_p_playlist.gridx = 1;
		gbc_p_playlist.gridy = 7;
		p_menuBotones.add(p_playlist, gbc_p_playlist);
		p_playlist.setLayout(new BorderLayout(0, 0));

		tablaPlayList = new JTable();
		tablaPlayList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tablaPlayList.setTableHeader(null);
		JScrollPane scrollPane = new JScrollPane(tablaPlayList);
		scrollPane.setPreferredSize(new Dimension());
		scrollPane.setBorder(new TitledBorder(UIManager.getBorder("Button.border"), "Playlist", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		p_playlist.add(scrollPane, BorderLayout.CENTER);

		tablaPlayList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tablaPlayList.getSelectedRow();
				int column = tablaPlayList.getSelectedColumn();

				String playlist = tablaPlayList.getValueAt(row, column).toString();
				if (auxiliar == 0)
					ventanaGestionPlaylist.ponerPlayListEnTabla(playlist);
				if (auxiliar == 1)
					ventanaMisPlaylist.ponerPlayListEnTabla(playlist);

			}
		});

		JPanel p_contenido2 = new JPanel();
		p_contenido.add(p_contenido2, BorderLayout.CENTER);
		p_contenido2.setLayout(new BorderLayout(0, 0));

		JPanel p_botonesMultimedia = new JPanel();
		p_botonesMultimedia.setBackground(new Color(40, 40, 40));
		p_contenido2.add(p_botonesMultimedia, BorderLayout.SOUTH);
		GridBagLayout gbl_p_botonesMultimedia = new GridBagLayout();
		gbl_p_botonesMultimedia.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_p_botonesMultimedia.rowHeights = new int[] { 20, 0, 10, 0, 10 };
		gbl_p_botonesMultimedia.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_p_botonesMultimedia.columnWidths = new int[] { 0, 10, 0, 10, 0, 10, 0, 10, 0, 15, 0 };
		p_botonesMultimedia.setLayout(gbl_p_botonesMultimedia);

		btnShuffle = new JButton("");
		btnShuffle.setBorderPainted(false);
		btnShuffle.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/barajar.png")));
		GridBagConstraints gbc_btnShuffle = new GridBagConstraints();
		gbc_btnShuffle.insets = new Insets(0, 0, 5, 5);
		gbc_btnShuffle.gridx = 0;
		gbc_btnShuffle.gridy = 1;
		p_botonesMultimedia.add(btnShuffle, gbc_btnShuffle);

		btnPrevious = new JButton("");
		btnPrevious.setBorderPainted(false);
		btnPrevious.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/paso-atras.png")));
		GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
		gbc_btnPrevious.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrevious.gridx = 2;
		gbc_btnPrevious.gridy = 1;
		p_botonesMultimedia.add(btnPrevious, gbc_btnPrevious);

		btnPlayPause = new JButton("");
		btnPlayPause.setBorderPainted(false);
		btnPlayPause.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/tocar.png")));
		GridBagConstraints gbc_btnPlayPause = new GridBagConstraints();
		gbc_btnPlayPause.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlayPause.gridx = 4;
		gbc_btnPlayPause.gridy = 1;
		p_botonesMultimedia.add(btnPlayPause, gbc_btnPlayPause);

		btnNext = new JButton("");
		btnNext.setBorderPainted(false);
		btnNext.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/un-paso-adelante.png")));
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 5, 5);
		gbc_btnNext.gridx = 6;
		gbc_btnNext.gridy = 1;
		p_botonesMultimedia.add(btnNext, gbc_btnNext);

		btnSecuential = new JButton("");
		btnSecuential.setBorderPainted(false);
		btnSecuential.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/barajar.png")));
		GridBagConstraints gbc_btnSecuential = new GridBagConstraints();
		gbc_btnSecuential.insets = new Insets(0, 0, 5, 5);
		gbc_btnSecuential.gridx = 8;
		gbc_btnSecuential.gridy = 1;
		p_botonesMultimedia.add(btnSecuential, gbc_btnSecuential);

		JSlider sliderCancion = new JSlider();
		GridBagConstraints gbc_sliderCancion = new GridBagConstraints();
		gbc_sliderCancion.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderCancion.gridwidth = 9;
		gbc_sliderCancion.insets = new Insets(0, 0, 5, 5);
		gbc_sliderCancion.gridx = 0;
		gbc_sliderCancion.gridy = 3;
		p_botonesMultimedia.add(sliderCancion, gbc_sliderCancion);

		JSlider sliderVolumen = new JSlider();
		sliderVolumen.setValue(25);
		sliderVolumen.setMaximum(50);
		sliderVolumen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Controlador.INSTANCIA.volumen(sliderVolumen.getValue());
			}
		});
		sliderVolumen.setPreferredSize(new Dimension(20, 50));
		sliderVolumen.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_sliderVolumen = new GridBagConstraints();
		gbc_sliderVolumen.insets = new Insets(0, 0, 5, 0);
		gbc_sliderVolumen.fill = GridBagConstraints.VERTICAL;
		gbc_sliderVolumen.gridheight = 3;
		gbc_sliderVolumen.gridx = 10;
		gbc_sliderVolumen.gridy = 1;
		p_botonesMultimedia.add(sliderVolumen, gbc_sliderVolumen);

		p_cardLayout = new JPanel();
		p_cardLayout.setVisible(false);
		p_contenido2.add(p_cardLayout, BorderLayout.CENTER);
		p_cardLayout.setLayout(new CardLayout(0, 0));

		p_cardLayout.add(ventanaBuscar, "ventanaBuscar");
		p_cardLayout.add(ventanaGestionPlaylist, "ventanaGestionPlaylist");
		p_cardLayout.add(ventanaRecientes, "ventanaRecientes");
		p_cardLayout.add(ventanaMasReproducidas, "ventanaMasReproducidas");
		p_cardLayout.add(ventanaGenerarPDF, "ventanaGenerarPDF");
		p_cardLayout.add(ventanaMisPlaylist, "ventanaMisPlaylist");

		JPanel p_bordeSuperior = new JPanel();
		p_bordeSuperior.setBackground(new Color(40, 40, 40));
		p_contenido2.add(p_bordeSuperior, BorderLayout.NORTH);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		p_bordeSuperior.add(verticalStrut_1);

		JPanel p_border = new JPanel();
		p_border.setBackground(new Color(40, 40, 40));
		p_contenido.add(p_border, BorderLayout.EAST);

		Component horizontalStrut_3 = Box.createHorizontalStrut(15);
		p_border.add(horizontalStrut_3);

		// MANEJADORES
		btnPremium.addActionListener(this);
		btnLogOut.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnGestionPlaylist.addActionListener(this);
		btnRecientes.addActionListener(this);
		btnMasReproducidas.addActionListener(this);
		btnGenerarPDF.addActionListener(this);
		btnMisPlaylist.addActionListener(this);
		btnUp.addActionListener(this);

		btnShuffle.addActionListener(this);
		btnPrevious.addActionListener(this);
		btnPlayPause.addActionListener(this);
		btnNext.addActionListener(this);
		btnSecuential.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO pensarlo de otra forma
		if (ventanaBuscar.isVisible() && e.getSource() != btnPremium && e.getSource() != btnLogOut) {
			ventanaBuscar.guardarSeleecionados();
		}

		if (e.getSource() == btnPremium) {
			ControladorVentanas.INSTANCIA.iniciarPremium();
		}

		if (e.getSource() == btnLogOut) {
			ControladorVentanas.INSTANCIA.logOutSatisfactorio();
		}

		if (e.getSource() == btnBuscar) {
			p_playlist.setVisible(false);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaBuscar");
			ventanaBuscar.esconderPanel();
		}

		if (e.getSource() == btnGestionPlaylist) {
			auxiliar = 0;
			p_playlist.setVisible(true);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaGestionPlaylist");
			ventanaGestionPlaylist.vaciarCampos();
			ventanaGestionPlaylist.ponerPlayListEnTabla(Controlador.INSTANCIA.getCancionesSeleccionadas());

			tablaPlayList.setModel(Controlador.INSTANCIA.getTablaPlaylist());
			tablaPlayList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = tablaPlayList.getSelectedRow();
					int column = tablaPlayList.getSelectedColumn();

					String playlist = tablaPlayList.getValueAt(row, column).toString();
					ventanaGestionPlaylist.ponerPlayListEnTabla(playlist);
				}
			});
		}

		if (e.getSource() == btnRecientes) {
			p_playlist.setVisible(false);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaRecientes");
			ventanaRecientes.configuracionTabla();
		}

		if (e.getSource() == btnMasReproducidas) {
			p_playlist.setVisible(false);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaMasReproducidas");
			ventanaMasReproducidas.configuracionTabla();
		}

		if (e.getSource() == btnGenerarPDF) {
			p_playlist.setVisible(false);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaGenerarPDF");
		}

		if (e.getSource() == btnMisPlaylist) {
			auxiliar = 1;
			p_playlist.setVisible(true);
			p_cardLayout.setVisible(true);
			CardLayout card = (CardLayout) p_cardLayout.getLayout();
			card.show(p_cardLayout, "ventanaMisPlaylist");
			ventanaMisPlaylist.esconderPanel();

			tablaPlayList.setModel(Controlador.INSTANCIA.getTablaPlaylist());
			tablaPlayList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = tablaPlayList.getSelectedRow();
					int column = tablaPlayList.getSelectedColumn();

					String playlist = tablaPlayList.getValueAt(row, column).toString();
					Controlador.INSTANCIA.setPlayListActual(playlist);
					ventanaMisPlaylist.ponerPlayListEnTabla(playlist);
				}
			});

		}

		if (e.getSource() == btnUp) {
			Controlador.INSTANCIA.cargarCanciones();
			ventanaBuscar.actualizarEstilos();
		}

		// MULTIMEDEA
		if (e.getSource() == btnShuffle) {

		}

		if (e.getSource() == btnPrevious) {
			Controlador.INSTANCIA.anteriorCancion();
		}

		if (e.getSource() == btnPlayPause) {
			Controlador.INSTANCIA.reproducirCancion();
		}

		if (e.getSource() == btnNext) {
			Controlador.INSTANCIA.siguienteCancion();
		}

		if (e.getSource() == btnSecuential) {

		}

	}

	public void actualizarListPlaylist() {
		DefaultTableModel modelo = (DefaultTableModel) tablaPlayList.getModel();
		modelo.setRowCount(0);

		modelo.addColumn("");
		for (PlayList p : Controlador.INSTANCIA.getPlayListUsuarioActual()) {
			Object[] playlist = { p.getNombre() };
			modelo.addRow(playlist);
		}
	}

}
