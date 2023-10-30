package umu.tds.vista.main;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaBuscar extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	public VentanaBuscar() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panelArriba = new GridBagLayout();
		gbl_panelArriba.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelArriba.rowHeights = new int[]{0, 0, 0};
		gbl_panelArriba.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelArriba.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panelArriba);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 0;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Favoritas");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 1;
		panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"estilo", "popular"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "name_16006204746500");
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_16009211174100");
		
	}
}