package umu.tds.modelo.reproductor;

import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public interface IModoReproduccion {

	public Cancion siguienteCancion(PlayList playlistActual, String cancionActual);
	
	public Cancion anteriorCancion(PlayList playlistActual, String cancionActual);
	
}
