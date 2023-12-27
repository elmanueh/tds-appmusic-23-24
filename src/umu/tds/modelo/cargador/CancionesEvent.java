package umu.tds.modelo.cargador;

import java.util.EventObject;

import umu.tds.componente.Canciones;

/**
 * Clase que representa el Evento sobre Canciones Nuevas
 */
public class CancionesEvent extends EventObject {

	/*
	 * ATRIBUTOS
	 */
	private static final long serialVersionUID = 1L;
	private Canciones canciones;

	/**
	 * Constructor de un evento Canciones.
	 * @param fuente Objeto que se desea comprobar
	 * @param canciones Canciones obtenidas
	 */
	public CancionesEvent(Object fuente, Canciones canciones) {
		super(fuente);
		this.canciones = canciones;
	}

	public Canciones getCanciones() {
		return canciones;
	}

}
