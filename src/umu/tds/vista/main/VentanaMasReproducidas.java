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
import java.awt.Component;

public class VentanaMasReproducidas extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	
	public VentanaMasReproducidas() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(35);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 0;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel lblNewLabel = new JLabel("LISTA MAS REPRODUCIDAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(35);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 2;
		panel.add(verticalStrut, gbc_verticalStrut);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		configuracionTabla();
		
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_2);
	}

	public void configuracionTabla() {
		table.setAutoscrolls(false);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoCreateRowSorter(true);
		
		table.setModel(Controlador.INSTANCIA.ponerTablaTop10());
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unchecked")
				TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) table
						.getRowSorter();
				sorter.sort();
			}
		});
		
		SwingUtilities.invokeLater(() -> {
			int anchoTabla = table.getWidth();
			int numColumnas = table.getColumnCount();
			int anchoUltColumna = (int) (anchoTabla * 0.05);
			for (int i = 0; i < numColumnas; i++) {
				table.getColumnModel().getColumn(i).setResizable(false);
				table.getColumnModel().getColumn(i).setPreferredWidth(anchoUltColumna);
			}
		});
		
		table.setBackground(new Color(0x0D, 0x20, 0x39));
	}
}