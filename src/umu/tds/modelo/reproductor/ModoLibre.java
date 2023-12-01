package umu.tds.modelo.reproductor;

import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public class ModoLibre implements ModoReproduccion{

	@Override
	public Cancion siguienteCancion(PlayList playlistActual, String cancionActual) {
		return null;
	}

	@Override
	public Cancion anteriorCancion(PlayList playlistActual, String cancionActual) {
		return null;
	}

}
