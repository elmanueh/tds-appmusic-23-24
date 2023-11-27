package umu.tds.modelo;

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
		Controlador.INSTANCIA.configuracionPremium(b, precio);
		plantillaMain.estadoPremium(b);
	}
	
	public void estadoReproductor(String estadoReproductor) {
		plantillaMain.estadoReproduciendo(estadoReproductor);
	}

	public void actualizarListaPlayList() {
		plantillaMain.actualizarListPlaylist();
	}
	
	public String getVentanaActual() {
		return plantillaMain.ventanaActual();
	}

	public void ponerCancionActual(String playlist, String cancion) {
		plantillaMain.ponerCancionActual(playlist, cancion);
		
	}

	void estadoJSlider(double duracionCancion) {
		plantillaMain.obtenerDuracionCancion(duracionCancion);
		
	}

}
