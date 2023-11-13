package umu.tds.modelo;

import javax.swing.UIManager;

import umu.tds.vista.inicio.PlantillaInicio;
import umu.tds.vista.main.MenuPremium;
import umu.tds.vista.main.PlantillaMain;

public class ControladorVentanas {

	/*
	 * ATRIBUTOS
	 */
	private static ControladorVentanas INSTANCIA;

	private PlantillaInicio plantillaInicio;
	private PlantillaMain plantillaMain;
	private MenuPremium menuPremium;

	/*
	 * CONSTRUCTOR
	 */
	private ControladorVentanas() {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public static ControladorVentanas getUnicaInstancia() {
		if (INSTANCIA == null) {
			INSTANCIA = new ControladorVentanas();
		}
		return INSTANCIA;
	}

	/*
	 * METODOS
	 */
	public void inicializarPrograma() {
		mostrarLoginView();
	}

	public void logInSatisfactorio() {
		plantillaInicio.dispose();
		mostrarMainView();
	}

	public void logOutSatisfactorio() {
		plantillaMain.dispose();
		mostrarLoginView();
	}

	public void iniciarPremium() {
		mostrarPremiumView();
	}

	/*
	 * METODOS PRIVADOS
	 */
	private void mostrarLoginView() {
		plantillaInicio = new PlantillaInicio();
		plantillaInicio.setVisible(true);
	}

	private void mostrarMainView() {
		plantillaMain = new PlantillaMain();
		plantillaMain.setVisible(true);
	}

	private void mostrarPremiumView() {
		menuPremium = new MenuPremium();
		menuPremium.setVisible(true);
	}

	public void quitarPremium(boolean b, double precio) {
		menuPremium.setVisible(false);
		Controlador.getUnicaInstancia().configuracionPremium(b, precio);
		plantillaMain.modoPremium(b);
	}

}
