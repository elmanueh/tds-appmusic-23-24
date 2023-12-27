package umu.tds.modelo.cargador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import umu.tds.componente.Canciones;
import umu.tds.componente.MapperCancionesXMLtoJava;

/**
 * Clase Cargador de Canciones.
 */
public enum CargadorCanciones implements Serializable {
	INSTANCIA;

	/*
	 * ATRIBUTOS
	 */
	private static final long serialVersionUID = 1L;
	private String archivoCanciones; // propiedad ligada
	private List<CancionesListener> cancionesListeners;

	/**
	 * Constructor de la clase Cargador de Canciones.
	 */
	private CargadorCanciones() {
		archivoCanciones = "";
		cancionesListeners = new LinkedList<>();
	}

	/**
	 * Metodo para obtener la ruta del archivo.
	 * @return
	 */
	public String getArchivoCanciones() {
		return archivoCanciones;
	}

	/**
	 * Metodo para establecer la ruta del archivo con las canciones.
	 * @param archivoCanciones Ruta del archivo
	 */
	public void setArchivoCanciones(String archivoCanciones) {
		this.archivoCanciones = archivoCanciones;

		Canciones canciones = MapperCancionesXMLtoJava.cargarCanciones(archivoCanciones);
		CancionesEvent evento = new CancionesEvent(this, canciones);
		notificarCancionesEvent(evento);
	}

	/**
	 * Metodo que devuelve una lista con los oyentes.
	 * @return Lista de oyentes
	 */
	public LinkedList<CancionesListener> getCancionesLister() {
		return new LinkedList<CancionesListener>(cancionesListeners);
	}

	/**
	 * Metodo que añade un nuevo oyente a la lista.
	 * @param listener Nuevo oyente
	 */
	public synchronized void addCancionesListener(CancionesListener listener) {
		System.out.println("añadido un listener");
		cancionesListeners.add(listener);
	}

	/**
	 * Metodo que elimina un oyente de la lista
	 * @param listener Oyente a eliminar
	 */
	public synchronized void removeCancionesListener(CancionesListener listener) {
		cancionesListeners.remove(listener);
	}

	/**
	 * Metodo para notificar a todos los oyentes de un nuevo evento.
	 * @param evento Evento a notificar
	 */
	private void notificarCancionesEvent(CancionesEvent evento) {
		ArrayList<CancionesListener> copia = null;
		synchronized (cancionesListeners) {
			copia = new ArrayList<>(cancionesListeners);
		}
		copia.stream().forEach(l -> l.enteradoNuevasCanciones(evento));
	}

}
