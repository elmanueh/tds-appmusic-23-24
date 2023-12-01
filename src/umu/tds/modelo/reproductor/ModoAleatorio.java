package umu.tds.modelo.reproductor;

import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public class ModoAleatorio implements ModoReproduccion {
	
	private static final int MAX_ALEATORIO = 20;
	
	@Override
	public Cancion siguienteCancion(PlayList playlistActual, String cancionActual) {
		int random = (int) (Math.random() * MAX_ALEATORIO) + 1;
		Cancion cancionSiguiente = null;
		for (int i = 0; i < random; i++) {
			cancionSiguiente = playlistActual.getSiguienteCancion(cancionActual);
			cancionActual = cancionSiguiente.getTitulo();
		}
		return cancionSiguiente;
	}

	@Override
	public Cancion anteriorCancion(PlayList playlistActual, String cancionActual) {
		int random = (int) (Math.random() * MAX_ALEATORIO) + 1;
		Cancion cancionAnterior = null;
		for (int i = 0; i < random; i++) {
			cancionAnterior = playlistActual.getAnteriorCancion(cancionActual);
			cancionActual = cancionAnterior.getTitulo();
		}
		return cancionAnterior;
	}

}
