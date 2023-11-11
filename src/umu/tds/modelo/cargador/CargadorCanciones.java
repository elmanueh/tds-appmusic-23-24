package umu.tds.modelo.cargador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import umu.tds.componente.Canciones;
import umu.tds.componente.MapperCancionesXMLtoJava;

public class CargadorCanciones implements Serializable {

	/*
	 * ATRIBUTOS
	 */
	private static final long serialVersionUID = 1L;

	private static CargadorCanciones INSTANCIA;
	private String archivoCanciones; // propiedad ligada
	private List<CancionesListener> cancionesListeners;

	/*
	 * CONSTRUCTOR
	 */
	private CargadorCanciones() {
		archivoCanciones = "";
		cancionesListeners = new LinkedList<>();
	}

	/*
	 * METODOS GETTERS AND SETTERS
	 */
	public static CargadorCanciones getUnicaInstancia() {
		if (INSTANCIA == null) {
			INSTANCIA = new CargadorCanciones();
		}
		return INSTANCIA;
	}

	public String getArchivoCanciones() {
		return archivoCanciones;
	}

	public void setArchivoCanciones(String archivoCanciones) {
		this.archivoCanciones = archivoCanciones;

		Canciones canciones = MapperCancionesXMLtoJava.cargarCanciones(archivoCanciones);
		CancionesEvent evento = new CancionesEvent(this, canciones);
		notificarCancionesEvent(evento);
	}

	public LinkedList<CancionesListener> getCancionesLister(CancionesListener listener) {
		return new LinkedList<CancionesListener>(cancionesListeners);
	}

	public synchronized void addCancionesListener(CancionesListener listener) {
		System.out.println("añadido un listener");
		cancionesListeners.add(listener);
	}

	public synchronized void removeCancionesListener(CancionesListener listener) {
		cancionesListeners.remove(listener);
	}

	/*
	 * METODOS
	 */
	private void notificarCancionesEvent(CancionesEvent evento) {
		ArrayList<CancionesListener> copia = null;
		synchronized (cancionesListeners) {
			copia = new ArrayList<>(cancionesListeners);
		}
		copia.stream().forEach(l -> l.enteradoNuevasCanciones(evento));
	}

}
