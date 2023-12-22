package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import umu.tds.Controlador;
import umu.tds.modelo.musica.Cancion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;

public class VentanaRecientes extends JPanel {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	private JTable tablaCanciones;

	// METODOS
	public void configuracionTabla() {
		tablaCanciones.getTableHeader().setReorderingAllowed(false);

		DefaultTableModel modelo = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modelo.addColumn("Título");
		modelo.addColumn("Estilo");
		modelo.addColumn("Intérprete");
		modelo.addColumn("Reproducciones");

		for (Cancion cancion : Controlador.INSTANCIA.getUsuarioActual().getPlaylistRecientes().getListaCanciones()) {
			Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical().getEstilo(),
					cancion.getInterprete().getInterprete(), cancion.getNumReproducciones() };
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
	public VentanaRecientes() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panel.rowHeights = new int[] { 15, 0, 10 };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("5 CANCIONES RECIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		tablaCanciones = new JTable();
		JScrollPane scrollPane = new JScrollPane(tablaCanciones);
		add(scrollPane, BorderLayout.CENTER);

		configuracionTabla();
		tablaCanciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String titulo = (String) ((DefaultTableModel) tablaCanciones.getModel())
						.getValueAt(tablaCanciones.getSelectedRow(), 0);
				Controlador.INSTANCIA.setCancionSeleccionada(titulo);
			}
		});
	}
}