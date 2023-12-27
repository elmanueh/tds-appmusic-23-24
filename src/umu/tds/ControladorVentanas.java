package umu.tds;

import javax.swing.UIManager;

import umu.tds.vista.inicio.PlantillaInicio;
import umu.tds.vista.main.MenuPremium;
import umu.tds.vista.main.PlantillaMain;

/**
 * Clase Controlador de Ventanas
 */
public enum ControladorVentanas {
	INSTANCIA;

	/*
	 * ATRIBUTOS
	 */
	private PlantillaInicio plantillaInicio;
	private PlantillaMain plantillaMain;
	private MenuPremium menuPremium;

	/**
	 * Constructor de la clase ControladorVentanas
	 */
	private ControladorVentanas() {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para iniciar la ventana Inicio de Sesion.
	 */
	public void inicializarPrograma() {
		mostrarLoginView();
	}

	/**
	 * Metodo para pasar de la ventana de Inicio de Sesion a la ventana Principal del programa.
	 */
	public void logInSatisfactorio() {
		plantillaInicio.dispose();
		mostrarMainView();
	}

	/**
	 * Metodo para pasar de la ventana Principal a la ventana de Inicio de Sesion.
	 */
	public void logOutSatisfactorio() {
		plantillaMain.dispose();
		mostrarLoginView();
	}

	/**
	 * Metodo para iniciar la ventana del Menu Premium.
	 */
	public void iniciarModoPremium() {
		mostrarPremiumView();
	}

	// METODOS PRIVADOS
	
	/**
	 * Metodo para mostrar la ventana de Inicio de Sesion.
	 */
	private void mostrarLoginView() {
		plantillaInicio = new PlantillaInicio();
		plantillaInicio.setVisible(true);
	}

	/**
	 * Metodo para mostrar la ventana Principal del programa.
	 */
	private void mostrarMainView() {
		plantillaMain = new PlantillaMain();
		plantillaMain.setVisible(true);
	}

	/**
	 * Metodo para mostrar la ventana del Menu Premium.
	 */
	private void mostrarPremiumView() {
		menuPremium = new MenuPremium();
		menuPremium.setVisible(true);
	}

	/**
	 * Metodo para comunicar el estado de subscripcion de un Usuario.
	 * @param estadoPremium
	 */
	public void usuarioPremium(boolean estadoPremium) {
		plantillaMain.usuarioPremium(estadoPremium);
	}

	/**
	 * Metodo para reiniciar la configuracion de la ventana Principal.
	 */
	public void reiniciarPlantillaMain() {
		plantillaMain.cargarVentana();
	}

}
