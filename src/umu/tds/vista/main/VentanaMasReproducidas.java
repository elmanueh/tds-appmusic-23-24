package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import umu.tds.modelo.Controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

public class VentanaMasReproducidas extends JPanel {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	private JTable tablaCanciones;

	// METODOS
	public void configuracionTabla() {
		tablaCanciones.setAutoscrolls(false);
		tablaCanciones.setFillsViewportHeight(true);
		tablaCanciones.getTableHeader().setReorderingAllowed(false);
		tablaCanciones.setAutoCreateRowSorter(true);

		tablaCanciones.setModel(Controlador.INSTANCIA.ponerTablaTop10());

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		tablaCanciones.getColumnModel().getColumn(tablaCanciones.getColumnCount()-1).setCellRenderer(centerRenderer);

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

		SwingUtilities.invokeLater(() -> {
			int anchoTabla = tablaCanciones.getWidth();
			int numColumnas = tablaCanciones.getColumnCount();
			int anchoUltColumna = (int) (anchoTabla * 0.05);
			for (int i = 0; i < numColumnas; i++) {
				tablaCanciones.getColumnModel().getColumn(i).setResizable(false);
				tablaCanciones.getColumnModel().getColumn(i).setPreferredWidth(anchoUltColumna);
			}
		});

		tablaCanciones.setBackground(new Color(0x0D, 0x20, 0x39));
	}

	// CONSTRUCTOR
	public VentanaMasReproducidas() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panel.rowHeights = new int[] { 15, 0, 10 };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("10 CANCIONES MÁS REPRODUCIDAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		tablaCanciones = new JTable();
		configuracionTabla();

		scrollPane.setViewportView(tablaCanciones);
	}
}