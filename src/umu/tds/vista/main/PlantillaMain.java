package umu.tds.vista.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import umu.tds.AppMusic;
import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.PlayList;
import umu.tds.vista.inicio.PlantillaInicio;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PlantillaMain extends JFrame implements ActionListener {

	private CardLayout cardLayout;
	GridBagLayout gridBagLayout;
	private JTable table;

	private void inicializar() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PlantillaInicio.class.getResource("/umu/tds/vista/imagenes/icono.png")));

		gridBagLayout = new GridBagLayout();
		getContentPane().setLayout(gridBagLayout);

		setTitle("Spotifoo");
		setSize(937, 586);
		setMinimumSize(getSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public PlantillaMain() {

		inicializar();

		VentanaBuscar ventanaBuscar = new VentanaBuscar();
		VentanaGestionPlaylist ventanaGestionPlaylist = new VentanaGestionPlaylist();
		VentanaRecientes ventanaRecientes = new VentanaRecientes();
		VentanaMasReproducidas ventanaMasReproducidas = new VentanaMasReproducidas();
		VentanaGenerarPDF ventanaGenerarPDF = new VentanaGenerarPDF();
		VentanaMisPlaylist ventanaMisPlaylist = new VentanaMisPlaylist();

		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };

		JPanel p_iconoTitulo = new JPanel();
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

		JPanel p_cabezera = new JPanel();
		GridBagConstraints gbc_p_cabezera = new GridBagConstraints();
		gbc_p_cabezera.insets = new Insets(0, 0, 5, 5);
		gbc_p_cabezera.fill = GridBagConstraints.BOTH;
		gbc_p_cabezera.gridx = 1;
		gbc_p_cabezera.gridy = 0;
		getContentPane().add(p_cabezera, gbc_p_cabezera);
		p_cabezera.setLayout(new BorderLayout(0, 0));

		JPanel p_cabezera_izq = new JPanel();
		FlowLayout fl_p_cabezera_izq = (FlowLayout) p_cabezera_izq.getLayout();
		fl_p_cabezera_izq.setAlignment(FlowLayout.LEFT);
		p_cabezera.add(p_cabezera_izq, BorderLayout.CENTER);

		String usuario = Controlador.getUnicaInstancia().getUsuarioActual().getNombre();
		JLabel mensajeBienvenida = new JLabel("Bienvenido, " + "usuario");
		p_cabezera_izq.add(mensajeBienvenida);

		JPanel p_cabezera_der = new JPanel();
		p_cabezera.add(p_cabezera_der, BorderLayout.EAST);

		JPanel p_menuBotonesPremium = new JPanel();
		JButton botonPremium = new JButton("Premium");
		botonPremium.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonPremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_menuBotonesPremium.setVisible(true);
			}
		});
		p_cabezera_der.add(botonPremium);

		JButton botonLogOut = new JButton("Cerrar Sesión");
		botonLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppMusic.logOutSatisfactorio();
			}
		});
		p_cabezera_der.add(botonLogOut);

		JPanel p_menuBotones = new JPanel();
		GridBagConstraints gbc_p_menuBotones = new GridBagConstraints();
		gbc_p_menuBotones.insets = new Insets(0, 0, 0, 5);
		gbc_p_menuBotones.fill = GridBagConstraints.BOTH;
		gbc_p_menuBotones.gridx = 0;
		gbc_p_menuBotones.gridy = 1;
		getContentPane().add(p_menuBotones, gbc_p_menuBotones);
		GridBagLayout gbl_p_menuBotones = new GridBagLayout();
		gbl_p_menuBotones.columnWidths = new int[] { 20, 0, 0, 0 };
		gbl_p_menuBotones.rowHeights = new int[] { 40, 40, 40, 0, 40, 0, 0 };
		gbl_p_menuBotones.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_p_menuBotones.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		p_menuBotones.setLayout(gbl_p_menuBotones);

		JPanel p_cardLayout = new JPanel();
		JPanel p_listas = new JPanel();
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonBuscar.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/lupa.png")));
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_listas.setVisible(false);
				p_cardLayout.setVisible(true);
				CardLayout card = (CardLayout) p_cardLayout.getLayout();
				card.show(p_cardLayout, "ventanaBuscar");
				ventanaBuscar.esconderPanel();
			}
		});
		botonBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonBuscar = new GridBagConstraints();
		gbc_botonBuscar.fill = GridBagConstraints.BOTH;
		gbc_botonBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_botonBuscar.gridx = 1;
		gbc_botonBuscar.gridy = 0;
		p_menuBotones.add(botonBuscar, gbc_botonBuscar);

		JButton botonGestionPlaylist = new JButton("Gestión Playlist");
		botonGestionPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_listas.setVisible(false);
				p_cardLayout.setVisible(true);
				CardLayout card = (CardLayout) p_cardLayout.getLayout();
				card.show(p_cardLayout, "ventanaGestionPlaylist");
			}
		});
		botonGestionPlaylist.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonGestionPlaylist.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/mas.png")));
		botonGestionPlaylist.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonGestionPlaylist = new GridBagConstraints();
		gbc_botonGestionPlaylist.insets = new Insets(0, 0, 5, 5);
		gbc_botonGestionPlaylist.fill = GridBagConstraints.BOTH;
		gbc_botonGestionPlaylist.gridx = 1;
		gbc_botonGestionPlaylist.gridy = 1;
		p_menuBotones.add(botonGestionPlaylist, gbc_botonGestionPlaylist);

		JButton botonRecientes = new JButton("Recientes");
		botonRecientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_listas.setVisible(false);
				p_cardLayout.setVisible(true);
				CardLayout card = (CardLayout) p_cardLayout.getLayout();
				card.show(p_cardLayout, "ventanaRecientes");
			}
		});
		botonRecientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonRecientes.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/reloj.png")));
		botonRecientes.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonRecientes = new GridBagConstraints();
		gbc_botonRecientes.insets = new Insets(0, 0, 5, 5);
		gbc_botonRecientes.fill = GridBagConstraints.BOTH;
		gbc_botonRecientes.gridx = 1;
		gbc_botonRecientes.gridy = 2;
		p_menuBotones.add(botonRecientes, gbc_botonRecientes);

		p_menuBotonesPremium.setVisible(false);
		GridBagConstraints gbc_p_menuBotonesPremium = new GridBagConstraints();
		gbc_p_menuBotonesPremium.gridwidth = 3;
		gbc_p_menuBotonesPremium.insets = new Insets(0, 0, 5, 5);
		gbc_p_menuBotonesPremium.fill = GridBagConstraints.BOTH;
		gbc_p_menuBotonesPremium.gridx = 0;
		gbc_p_menuBotonesPremium.gridy = 3;
		p_menuBotones.add(p_menuBotonesPremium, gbc_p_menuBotonesPremium);
		GridBagLayout gbl_p_menuBotonesPremium = new GridBagLayout();
		gbl_p_menuBotonesPremium.columnWidths = new int[] { 20, 0, 0 };
		gbl_p_menuBotonesPremium.rowHeights = new int[] { 40, 40, 0 };
		gbl_p_menuBotonesPremium.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_p_menuBotonesPremium.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		p_menuBotonesPremium.setLayout(gbl_p_menuBotonesPremium);

		JButton botonMasReproducidas = new JButton("Más Reproducidas");
		botonMasReproducidas
				.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/lupa.png")));
		botonMasReproducidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_listas.setVisible(false);
				p_cardLayout.setVisible(true);
				CardLayout card = (CardLayout) p_cardLayout.getLayout();
				card.show(p_cardLayout, "ventanaMasReproducidas");
			}
		});
		botonMasReproducidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonMasReproducidas.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonMasReproducidas = new GridBagConstraints();
		gbc_botonMasReproducidas.fill = GridBagConstraints.BOTH;
		gbc_botonMasReproducidas.insets = new Insets(0, 0, 5, 0);
		gbc_botonMasReproducidas.gridx = 1;
		gbc_botonMasReproducidas.gridy = 0;
		p_menuBotonesPremium.add(botonMasReproducidas, gbc_botonMasReproducidas);

		JButton botonGenerarPDF = new JButton("Generar PDF");
		botonGenerarPDF.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/lupa.png")));
		botonGenerarPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_listas.setVisible(false);
				p_cardLayout.setVisible(true);
				CardLayout card = (CardLayout) p_cardLayout.getLayout();
				card.show(p_cardLayout, "ventanaGenerarPDF");
			}
		});
		botonGenerarPDF.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonGenerarPDF.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonGenerarPDF = new GridBagConstraints();
		gbc_botonGenerarPDF.fill = GridBagConstraints.BOTH;
		gbc_botonGenerarPDF.gridx = 1;
		gbc_botonGenerarPDF.gridy = 1;
		p_menuBotonesPremium.add(botonGenerarPDF, gbc_botonGenerarPDF);

		p_cardLayout.setVisible(false);
		JButton botonMisPlaylist = new JButton("Mis Playlist");
		botonMisPlaylist.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonMisPlaylist.setIcon(new ImageIcon(PlantillaMain.class.getResource("/umu/tds/vista/imagenes/altavoz.png")));
		botonMisPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_listas.setVisible(true);
				p_cardLayout.setVisible(true);
				CardLayout card = (CardLayout) p_cardLayout.getLayout();
				card.show(p_cardLayout, "ventanaMisPlaylist");
				ventanaMisPlaylist.esconderPanel();
			}
		});
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

		// TABLA PLAYLIST
		// habria que hacer algo para que se actualice el valor, aunque sea cada
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Playlist",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		p_listas.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		DefaultTableModel model = new DefaultTableModel() {
			@Override // ESTO ES PARA QUE NO SE PUEDA EDITAR EL CONTENIDO DE LA TABLA
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.setModel(model);

		model.addColumn("");
		table.setTableHeader(null);

		for (PlayList p : Controlador.getUnicaInstancia().getUsuarioActual().getListaPlayList()) {
			Object[] playlist = { p.getNombre() };
			model.addRow(playlist);
		}

		table.setBackground(Color.MAGENTA);
		// AQUI VOY A TRATAR LO DE HACER CLICK EN UNA CELDA Y QUE MUESTRE LA PLAYLIST
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();

					// Verifica si se ha hecho doble clic en una celda válida
					if (row >= 0 && column >= 0) {
						String playlist = table.getValueAt(row, column).toString();

						// Me gustaria que depende de tipo de cardlayout, llame al metodo de una ventana
						// En el caso de que queramos que la lista de playlist este en todos los sitios
						ventanaMisPlaylist.ponerPlayListEnTabla(playlist);
					}
				}
			}
		});

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

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 1;
		getContentPane().add(horizontalStrut_3, gbc_horizontalStrut_3);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
