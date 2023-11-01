package umu.tds;

import umu.tds.modelo.Controlador;

public class MeterCanciones {
	public static void main(String[] args) {
		Controlador.getUnicaInstancia().registrarCancion("HIMNO DE ESPAÑA", "SI", "POPULAR", "JULIAN");
		Controlador.getUnicaInstancia().registrarCancion("HIMNO DE FRANCIA", "SI", "POPULAR", "MANUEL");
		AppMusic.main(args);
	}
}
