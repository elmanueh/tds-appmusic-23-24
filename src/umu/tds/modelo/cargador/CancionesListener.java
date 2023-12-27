package umu.tds.modelo.cargador;

import java.util.EventObject;

/**
 * Interfaz que representa un oyente de Canciones.
 */
public interface CancionesListener {

	/**
	 * Metodo que se ejecuta sobre un objeto para notificarle sobre el evento Canciones
	 * @param e Evento que se notifica
	 */
	public void enteradoNuevasCanciones(EventObject e);

}
