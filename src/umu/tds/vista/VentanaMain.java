package umu.tds.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

public class VentanaMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtHola;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMain frame = new VentanaMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMain() {
		setTitle("AppMusic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotonera = new JPanel();
		contentPane.add(panelBotonera, BorderLayout.WEST);
		GridBagLayout gbl_panelBotonera = new GridBagLayout();
		gbl_panelBotonera.columnWidths = new int[]{0, 0};
		gbl_panelBotonera.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelBotonera.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelBotonera.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelBotonera.setLayout(gbl_panelBotonera);
		
		
		JPanel panelCardLayout = new JPanel();

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) panelCardLayout.getLayout();
				card.show(panelCardLayout, "panelBuscar");
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(VentanaMain.class.getResource("/umu/tds/vista/imagenes/lupa.png")));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panelBotonera.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gestion Playlists");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) panelCardLayout.getLayout();
				card.show(panelCardLayout, "panelGestion");
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon(VentanaMain.class.getResource("/umu/tds/vista/imagenes/mas.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panelBotonera.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Recientes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) panelCardLayout.getLayout();
				card.show(panelCardLayout, "panelRecientes");
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setIcon(new ImageIcon(VentanaMain.class.getResource("/umu/tds/vista/imagenes/reloj.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panelBotonera.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Mis Playlists");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) panelCardLayout.getLayout();
				card.show(panelCardLayout, "panelPlaylists");
				
				CardLayout card2 = (CardLayout) panelCardLayout.getLayout();
				card2.show(panelCardLayout, "panelPlaylists");
			}
		});
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setIcon(new ImageIcon(VentanaMain.class.getResource("/umu/tds/vista/imagenes/altavoz.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 3;
		panelBotonera.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 4;
		panelBotonera.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new CardLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, "name_84722694107700");
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Listas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.add(panel_7, "name_84727007526100");
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		panel_7.setLayout(gbl_panel_7);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelCentro.add(panel, BorderLayout.NORTH);
		
		JLabel lblBienvenido = new JLabel("Bienvenido, ");
		panel.add(lblBienvenido);
		
		JButton btnPremium = new JButton("Premium");
		panel.add(btnPremium);
		
		JButton btnSalir = new JButton("Salir");
		panel.add(btnSalir);
		
		panelCentro.add(panelCardLayout, BorderLayout.CENTER);
		panelCardLayout.setLayout(new CardLayout(0, 0));
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(null);
		panelCardLayout.add(panelBuscar, "panelBuscar");
		panelBuscar.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBuscar.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_1.rowHeights = new int[]{20, 0, 0, 0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		txtHola = new JTextField();
		txtHola.setForeground(Color.BLACK);
		GridBagConstraints gbc_txtHola = new GridBagConstraints();
		gbc_txtHola.insets = new Insets(0, 0, 5, 5);
		gbc_txtHola.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHola.gridx = 0;
		gbc_txtHola.gridy = 1;
		panel_1.add(txtHola, gbc_txtHola);
		txtHola.setColumns(10);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("favoritas");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 2;
		panel_1.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"uno", "dos", "tres"}));
		comboBox.setToolTipText("uno\r\ndos\r\ntres");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		panel_1.add(comboBox, gbc_comboBox);
		
		JButton btnNewButton_4 = new JButton("buscar");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 3;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panelBuscar.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_5 = new JButton("Añadir lista");
		panel_2.add(btnNewButton_5, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VentanaMain.class.getResource("/umu/tds/vista/imagenes/mas.png")));
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(VentanaMain.class.getResource("/umu/tds/vista/imagenes/altavoz.png")));
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon(VentanaMain.class.getResource("/umu/tds/vista/imagenes/mas.png")));
		panel_3.add(lblNewLabel_2_3);
		
		JPanel panel_4 = new JPanel();
		panelBuscar.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("AQUI SE MOSTRARA LA TABLA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1, "name_83487100989400");
		
		JPanel panelGestion = new JPanel();
		panelCardLayout.add(panelGestion, "panelGestion");
		
		JLabel lblPanelgestion = new JLabel("PanelGestion");
		panelGestion.add(lblPanelgestion);
		
		JPanel panelRecientes = new JPanel();
		panelCardLayout.add(panelRecientes, "panelRecientes");
		
		JPanel panelPlaylists = new JPanel();
		panelCardLayout.add(panelPlaylists, "panelPlaylists");
		panelPlaylists.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panelPlaylists.add(panel_8, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("aqui va la tabla");
		panel_8.add(lblNewLabel_3);
		
		JPanel panel_9 = new JPanel();
		panelPlaylists.add(panel_9, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("aqui van los botones");
		panel_9.add(lblNewLabel_4);
	}

}
