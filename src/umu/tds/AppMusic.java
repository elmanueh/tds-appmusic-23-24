package umu.tds;

import umu.tds.componente.Cancion;
import umu.tds.componente.Canciones;
import umu.tds.componente.MapperCancionesXMLtoJava;
import umu.tds.modelo.ControladorVentanas;

public class AppMusic {

	public static void main(String[] args) {
		//ControladorVentanas.getUnicaInstancia().inicializarPrograma();

		Canciones canciones = MapperCancionesXMLtoJava.cargarCanciones("xml/canciones.xml");

		for (Cancion cancion : canciones.getCancion()) {
			System.out.println("Titulo: " + cancion.getTitulo());
			System.out.println(" Interprete : " + cancion.getInterprete());
			System.out.println(" Estilo : " + cancion.getEstilo());
			System.out.println(" URL : " + cancion.getURL());
			System.out.println("***** ***** *****");
		}
	}

}
