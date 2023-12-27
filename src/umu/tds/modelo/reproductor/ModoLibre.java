package umu.tds.modelo.reproductor;

import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

/**
 * Clase que representa un Modo de Reproduccion Libre.
 */
public class ModoLibre implements IModoReproduccion{

	@Override
	public Cancion siguienteCancion(PlayList playlistActual, String cancionActual) {
		return null;
	}

	@Override
	public Cancion anteriorCancion(PlayList playlistActual, String cancionActual) {
		return null;
	}

	@Override
	public String getModoReproduccion() {
		return "Modo: Libre";
	}

}
