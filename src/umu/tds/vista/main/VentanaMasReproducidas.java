package umu.tds.vista.main;

import java.util.List;

import javax.swing.*;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.usuario.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMasReproducidas extends JPanel {

	private static final long serialVersionUID = 1L;

	public VentanaMasReproducidas() {

		JLabel lblNewLabel = new JLabel("ventanaMasReproducidas");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Cancion> lista = Controlador.getUnicaInstancia().getCancionesMasReproducidas();

				System.out.println();
				System.out.println("----------- LSITA CANCIONES TOP10 -----------");
		        for (int i = 0; i < lista.size(); i++) {
		            System.out.println((i + 1) + ". " + lista.get(i).getTitulo() + " - " + lista.get(i).getNumReproducciones());
		        }
			}
		});
		add(lblNewLabel);
	}
}