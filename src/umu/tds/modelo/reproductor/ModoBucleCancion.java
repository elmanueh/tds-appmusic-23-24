package umu.tds.modelo.reproductor;

import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

/**
 * Clase que representa un Modo de Reproduccion en Bucle.
 */
public class ModoBucleCancion implements IModoReproduccion {

	@Override
	public Cancion siguienteCancion(PlayList playlistActual, String cancionActual) {
		return playlistActual.getCancion(cancionActual);
	}

	@Override
	public Cancion anteriorCancion(PlayList playlistActual, String cancionActual) {
		return playlistActual.getCancion(cancionActual);
	}

	@Override
	public String getModoReproduccion() {
		return "Modo: Bucle Cancion";
	}

}
