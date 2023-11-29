package umu.tds.modelo.musica;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class PlayList {

	// ATRIBUTOS
	private final String nombre;
	private final LinkedHashSet<Cancion> listaCanciones;
	private int codigo;

	// CONSTRUCTOR
	public PlayList(String nombre) {
		this.nombre = nombre;
		this.listaCanciones = new LinkedHashSet<Cancion>();
		this.codigo = 0;
	}

	// GETTERS AND SETTERS
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

	// METODOS
	public void addCancion(Cancion c) {
		listaCanciones.add(c);
	}

	public void addAllCanciones(LinkedHashSet<Cancion> cancionesSeleccionadas) {
		listaCanciones.addAll(cancionesSeleccionadas);
	}

	public void removeCancion(Cancion c) {
		listaCanciones.remove(c);
	}

	public boolean consultarCancion(Cancion c) {
		return listaCanciones.contains(c);
	}

	public boolean consultarCancion(String c) {
		for (Cancion cancion : listaCanciones) {
			if (cancion.getTitulo().equals(c))
				return true;
		}
		return false;
	}
	
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
		return Objects.hash(codigo, /* listaCanciones, */ nombre);
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
		return codigo == other.codigo /* && Objects.equals(listaCanciones, other.listaCanciones) */
				&& Objects.equals(nombre, other.nombre);
	}

}
