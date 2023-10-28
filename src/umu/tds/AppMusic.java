package umu.tds;

import java.awt.EventQueue;

import javax.swing.UIManager;

import umu.tds.vista.inicio.PlantillaInicio;

public class AppMusic {
	
	private static PlantillaInicio plantillaInicio;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
					plantillaInicio = new PlantillaInicio();
					plantillaInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ocultarPlantillaLogin() {
		plantillaInicio.setVisible(false);
	}

}
