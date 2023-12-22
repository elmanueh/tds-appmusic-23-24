package umu.tds;

import javax.swing.UIManager;

import umu.tds.vista.inicio.PlantillaInicio;
import umu.tds.vista.main.MenuPremium;
import umu.tds.vista.main.PlantillaMain;

public enum ControladorVentanas {
	INSTANCIA;

	// ATRIBUTOS
	private PlantillaInicio plantillaInicio;
	private PlantillaMain plantillaMain;
	private MenuPremium menuPremium;

	// CONSTRUCTOR
	private ControladorVentanas() {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// METODOS
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

	public void iniciarModoPremium() {
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

	public void usuarioPremium(boolean estadoPremium) {
		plantillaMain.usuarioPremium(estadoPremium);
	}

	public void reiniciarPlantillaMain() {
		plantillaMain.cargarVentana();
	}

}
