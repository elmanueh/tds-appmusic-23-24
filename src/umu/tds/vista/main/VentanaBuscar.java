package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;
import umu.tds.vista.main.VentanaMisPlaylist.CenteredCheckBoxEditor;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBuscar extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtInterprete;
	private JTable table;

	public VentanaBuscar() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panelArriba = new GridBagLayout();
		
		panel.setLayout(gbl_panelArriba);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.anchor = GridBagConstraints.EAST;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		txtTitulo = new JTextField();
		txtTitulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtTitulo.getText().equals("titulo"))
					txtTitulo.setText("");
			}
		});
		txtTitulo.setText("titulo");
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 0;
		panel.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(10);
		
		txtInterprete = new JTextField();
		txtInterprete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtInterprete.getText().equals("interprete"))
					txtInterprete.setText("");
			}
		});
		txtInterprete.setText("interprete");
		GridBagConstraints gbc_txtInterprete = new GridBagConstraints();
		gbc_txtInterprete.insets = new Insets(0, 0, 5, 5);
		gbc_txtInterprete.gridx = 3;
		gbc_txtInterprete.gridy = 0;
		panel.add(txtInterprete, gbc_txtInterprete);
		txtInterprete.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.anchor = GridBagConstraints.SOUTH;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 5;
		gbc_horizontalStrut_1.gridy = 0;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Favoritas");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 1;
		panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"estilo", "POPULAR"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		JPanel panelCard = new JPanel();
		add(panelCard, BorderLayout.CENTER);
		CardLayout cardLayout = new CardLayout();
		panelCard.setLayout(cardLayout);
		
		JPanel panelVacio = new JPanel();
		panelCard.add(panelVacio, "panelVacio");
		panelVacio.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("VACIO");
		panelVacio.add(lblNewLabel);
		
		JPanel panelTabla = new JPanel();
		panelCard.add(panelTabla, "panelTabla");
		
		DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return Boolean.class; // Establece la columna "SELECCIONAR" como Boolean
                }
                return super.getColumnClass(columnIndex);
            }
        };
		panelTabla.setLayout(new BorderLayout(0, 0));
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(650, 300));
		panelTabla.add(scrollPane, BorderLayout.NORTH);
		
		table.setModel(modeloTabla);
		
		JPanel panel_1 = new JPanel();
		panelTabla.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_1 = new JButton("CANCELAR");
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
		modeloTabla.addColumn("TITULO");
        modeloTabla.addColumn("INTERPRETE");
        modeloTabla.addColumn("ESTILO");
        modeloTabla.addColumn("SELECCIONAR");
        
        table.getColumnModel().getColumn(3).setCellEditor(new CenteredCheckBoxEditor());

        for (Cancion u: Controlador.getUnicaInstancia().getCanciones()) {
        	Object[] usuario = {u.getTitulo(), u.getEstiloMusical(), u.getInterprete(), false};
        	modeloTabla.addRow(usuario);
        }
		
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Realizar la filtración de canciones
                String tituloFiltrado = txtTitulo.getText();
                String interpreteFiltrado = txtInterprete.getText();
                String estiloFiltrado = comboBox.getSelectedItem().toString();

                DefaultTableModel modeloFiltrado = new DefaultTableModel() {
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        if (columnIndex == 3) {
                            return Boolean.class; // Establece la columna "SELECCIONAR" como Boolean
                        }
                        return super.getColumnClass(columnIndex);
                    }
                };

                modeloFiltrado.addColumn("TITULO");
                modeloFiltrado.addColumn("INTERPRETE");
                modeloFiltrado.addColumn("ESTILO");
                modeloFiltrado.addColumn("SELECCIONAR");

                for (Cancion cancion : Controlador.getUnicaInstancia().getCancionesFiltradas(tituloFiltrado, interpreteFiltrado, estiloFiltrado)) {
                        Object[] fila = {cancion.getTitulo(), cancion.getEstiloMusical(), cancion.getInterprete(), false};
                        modeloFiltrado.addRow(fila);
                }

                table.setModel(modeloFiltrado);
                cardLayout.show(panelCard, "panelTabla");
            }
        });
        
    	btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCard, "panelVacio");
				txtTitulo.setText("titulo");
				txtInterprete.setText("interprete");
				comboBox.setSelectedIndex(0);
			}
		});
	}
}