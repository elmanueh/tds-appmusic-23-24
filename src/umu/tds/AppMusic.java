package umu.tds;

import java.awt.EventQueue;
import javax.swing.UIManager;

import umu.tds.vista.inicio.PlantillaInicio;
import umu.tds.vista.main.PlantillaMain;

public class AppMusic {

	private static PlantillaInicio plantillaInicio;
	private static PlantillaMain plantillaMain;

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

	public static void logInSatisfactorio() {
		plantillaInicio.dispose();
		plantillaMain = new PlantillaMain();
		plantillaMain.setVisible(true);
	}

	public static void logOutSatisfactorio() {
		plantillaMain.dispose();
		plantillaInicio = new PlantillaInicio();
		plantillaInicio.setVisible(true);
	}

}
