package umu.tds.modelo.reproductor;

import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

/**
 * Interfaz que representa un Modo de Reproduccion.
 */
public interface IModoReproduccion {

	/**
	 * Metodo para obtener la siguiente cancion.
	 * @param playlistActual playlist que se esta reproduciendo
	 * @param cancionActual cancion que se acaba de reproducir
	 * @return Cancion que tiene que reproducirse
	 */
	public Cancion siguienteCancion(PlayList playlistActual, String cancionActual);

	/**
	 * Metodo para obtener la anterior cancion.
	 * @param playlistActual playlist que se esta reproduciendo
	 * @param cancionActual cancion que se acaba de reproducir
	 * @return Cancion que tiene que reproducirse
	 */
	public Cancion anteriorCancion(PlayList playlistActual, String cancionActual);
	
	/**
	 * Metodo que obtiene el tipo de Modo de Reproduccion.
	 * @return Nombre del modo de reproduccion
	 */
	public String getModoReproduccion();
	
}
