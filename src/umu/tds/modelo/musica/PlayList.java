package umu.tds.modelo.musica;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

/**
 * Clase PlayList
 */
public class PlayList {

	/*
	 * ATRIBUTOS
	 */
	private final String nombre;
	private final LinkedHashSet<Cancion> listaCanciones;
	private int codigo;

	/**
	 * Constructor de la clase PlayList.
	 * @param nombre Nombre de la PlayList
	 */
	public PlayList(String nombre) {
		this.nombre = nombre;
		this.listaCanciones = new LinkedHashSet<Cancion>();
		this.codigo = 0;
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public String getNombre() {
		return nombre;
	}

	public Cancion getCancion(String nombre) {
		for (Cancion c : listaCanciones) {
			if (c.getTitulo().equals(nombre))
				return c;
		}
		return null;
	}

	public Set<Cancion> getListaCanciones() {
		return new LinkedHashSet<Cancion>(listaCanciones);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int id) {
		this.codigo = id;
	}

	/**
	 * Metodo para añadir una Cancion.
	 * @param c Cancion a añadir
	 */
	public void añadirCancion(Cancion c) {
		listaCanciones.add(c);
	}

	/**
	 * Metodo para añadir una lista de Canciones.
	 * @param cancionesSeleccionadas Lista de Canciones
	 */
	public void añadirTodasCanciones(LinkedHashSet<Cancion> cancionesSeleccionadas) {
		listaCanciones.addAll(cancionesSeleccionadas);
	}

	/**
	 * Metodo para eliminar una Cancion.
	 * @param c Cancion a eliminar
	 */
	public void eliminarCancion(Cancion c) {
		listaCanciones.remove(c);
	}

	/**
	 * Metodo para consultar si existe una Cancion en la PlayList.
	 * @param c Nombre de la Cancion
	 * @return True / False
	 */
	public boolean consultarCancion(String c) {
		for (Cancion cancion : listaCanciones) {
			if (cancion.getTitulo().equals(c))
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo que devuelve la siguiente cancion de la PlayList.
	 * @param cancionReproduciendo Nombre de la Cancion actual
	 * @return Cancion siguiente
	 */
	public Cancion getSiguienteCancion(String cancionReproduciendo) {
		boolean cancionSiguiente = false;
		for (Cancion cancion : listaCanciones) {
			if (cancionSiguiente)
				return cancion;	// devuelvo la siguiente
			if (cancion.getTitulo().equals(cancionReproduciendo))
				cancionSiguiente = true;
		}
		return new LinkedList<>(listaCanciones).get(0);	// devuelvo la primera de la lista
	}
	
	/**
	 * Metodo que devuelve la anterior cancion de la PlayList.
	 * @param cancionReproduciendo Nombre de la Cancion actual
	 * @return Cancion anterior
	 */
	public Cancion getAnteriorCancion(String cancionReproduciendo) {
		Cancion cancionAnterior = null;
		for (Cancion cancion : listaCanciones) {
			if (cancion.getTitulo().equals(cancionReproduciendo)) {
				if (cancionAnterior == null)
					return new LinkedList<>(listaCanciones).get(listaCanciones.size()-1);	// devuelvo la ultima de la lista
				return cancionAnterior;	// devuelvo la anterior
			}
			cancionAnterior = cancion;
		}
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayList other = (PlayList) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
