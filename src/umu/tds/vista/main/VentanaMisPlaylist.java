package umu.tds.vista.main;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

public class VentanaMisPlaylist extends JPanel {
	private JTable table;

	public VentanaMisPlaylist() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		add(panelTitulo, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("MIS PLAYLIST");
		panelTitulo.add(lblNewLabel);
		
		JPanel panelBotones = new JPanel();
		add(panelBotones, BorderLayout.SOUTH);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelBotones.rowHeights = new int[]{0, 0};
		gbl_panelBotones.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBotones.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBotones.setLayout(gbl_panelBotones);
		
		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 0;
		panelBotones.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panelBotones.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		panelBotones.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 3;
		gbc_btnNewButton_3.gridy = 0;
		panelBotones.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 0;
		panelBotones.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JPanel panelTabla = new JPanel();
		add(panelTabla, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBorder(UIManager.getBorder("Button.border"));
		table.setFillsViewportHeight(true);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"TITULO", "INTERPRETE", "ESTILO", null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Titulo", "Interprete", "Estilo", ""
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		panelTabla.add(table);
		
	}
}