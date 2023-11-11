package umu.tds;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.ControladorVentanas;

public class AppMusic {

	public static void main(String[] args) {
		// ControladorVentanas.getUnicaInstancia().inicializarPrograma();

		Controlador.getUnicaInstancia().cargarCanciones("xml/canciones.xml");
	}

}
