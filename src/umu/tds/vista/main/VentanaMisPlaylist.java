package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class VentanaMisPlaylist extends JPanel {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	private JTable tablaCanciones;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	// CONSTRUCTOR
	public VentanaMisPlaylist() {
		setLayout(new BorderLayout(0, 0));

		tablaCanciones = new JTable();
		tablaCanciones.setAutoscrolls(false);
		tablaCanciones.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(tablaCanciones);
		add(scrollPane, BorderLayout.CENTER);

		JPanel p_titulo = new JPanel();
		add(p_titulo, BorderLayout.NORTH);
		GridBagLayout gbl_p_titulo = new GridBagLayout();
		gbl_p_titulo.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_p_titulo.rowHeights = new int[] { 15, 0, 10 };
		p_titulo.setLayout(gbl_p_titulo);

		lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		p_titulo.add(lblNewLabel, gbc_lblNewLabel);
	}

	// METODOS
	public void ponerPlayListEnTabla(String playlist) {
		scrollPane.setVisible(true);
		lblNewLabel.setVisible(true);
		lblNewLabel.setText(Controlador.INSTANCIA.getPlaylistSeleccionada());

		DefaultTableModel modeloFiltrado = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modeloFiltrado.addColumn("TITULO");
		modeloFiltrado.addColumn("ESTILO");
		modeloFiltrado.addColumn("INTERPRETE");

		for (Cancion cancion : Controlador.INSTANCIA.getListaCancionesPlayList(playlist)) {
			Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical(), cancion.getInterprete() };
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

		tablaCanciones.setAutoCreateRowSorter(true);

		tablaCanciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String titulo = (String) ((DefaultTableModel) tablaCanciones.getModel())
						.getValueAt(tablaCanciones.getSelectedRow(), 0);
				Controlador.INSTANCIA.setCancionSeleccionada(titulo);

				@SuppressWarnings("unchecked")
				TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tablaCanciones
						.getRowSorter();
				sorter.sort();
			}
		});
	}

	public void esconderPanel() {
		scrollPane.setVisible(false);
		lblNewLabel.setVisible(false);
	}
}