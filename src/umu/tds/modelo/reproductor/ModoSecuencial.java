package umu.tds.modelo.reproductor;

import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public class ModoSecuencial implements IModoReproduccion {

	@Override
	public Cancion siguienteCancion(PlayList playlistActual, String cancionActual) {
		if (playlistActual == null)
			return null;
		Cancion cancionSiguiente = playlistActual.getSiguienteCancion(cancionActual);
		return cancionSiguiente;
	}

	@Override
	public Cancion anteriorCancion(PlayList playlistActual, String cancionActual) {
		if (playlistActual == null)
			return null;
		Cancion cancionAnterior = playlistActual.getAnteriorCancion(cancionActual);
		return cancionAnterior;
	}

}
