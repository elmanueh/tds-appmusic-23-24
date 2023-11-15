package umu.tds.modelo.cargador;

import java.util.EventObject;

import umu.tds.componente.Canciones;

public class CancionesEvent extends EventObject {

	// ATRIBUTOS
	private static final long serialVersionUID = 1L;
	private Canciones canciones;

	// CONSTRUCTOR
	public CancionesEvent(Object fuente, Canciones canciones) {
		super(fuente);
		this.canciones = canciones;
	}

	// METODOS
	public Canciones getCanciones() {
		return canciones;
	}

}
