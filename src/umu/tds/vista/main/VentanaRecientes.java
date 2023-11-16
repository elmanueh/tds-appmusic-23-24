package umu.tds.vista.main;

import javax.swing.*;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.usuario.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VentanaRecientes extends JPanel {
	public VentanaRecientes() {
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Cancion> lista = Controlador.INSTANCIA.getCancionesRecientes();
				
				System.out.println();
				System.out.println("----------- LSITA CANCIONES RECIENTES (MAX: " + Usuario.MAX + ") -----------");
				int i=1;
		        for (Cancion c: lista) {
		            System.out.println((i) + ". " + c.getTitulo() + " - " + c.getNumReproducciones());
		        	i++;
		        }
				
			}
		});
		add(lblNewLabel);
	}

	private static final long serialVersionUID = 1L;

}