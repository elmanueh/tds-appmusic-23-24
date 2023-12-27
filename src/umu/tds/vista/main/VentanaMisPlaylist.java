package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import umu.tds.Controlador;
import umu.tds.modelo.musica.Cancion;

import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

/**
 * Clase VentanaMisPlaylist
 */
public class VentanaMisPlaylist extends JPanel {

	/**
	 * ATRIBUTOS
	 */
	private static final long serialVersionUID = 1L;

	private JTable tablaCanciones;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	/**
	 * Metodo cargar VentanaMisPaylist
	 */
	public void cargarVentana(String playlistNombre) {
		scrollPane.setVisible(false);
		lblNewLabel.setVisible(false);
		configuracionTabla(playlistNombre);
	}

	/**
	 * Metodo para congiurar la tabla de playlist
	 * @param playlistNombre Nombre de la playlist
	 */
	public void configuracionTabla(String playlistNombre) {

		if (playlistNombre != null) {
			scrollPane.setVisible(true);
			lblNewLabel.setVisible(true);
			lblNewLabel.setText(playlistNombre);
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

			for (Cancion cancion : Controlador.INSTANCIA.getUsuarioActual().getPlayList(playlistNombre)
					.getListaCanciones()) {
				Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical().getEstilo(),
						cancion.getInterprete().getInterprete() };
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

	}

	/**
	 * Constructor de la clase VentanaMisPlaylist
	 */
	public VentanaMisPlaylist() {
		setLayout(new BorderLayout(0, 0));

		tablaCanciones = new JTable();
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