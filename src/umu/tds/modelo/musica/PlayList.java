package umu.tds.modelo.musica;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PlayList {

	/*
	 * ATRIBUTOS
	 */
	private final String nombre;
	private final LinkedList<Cancion> listaCanciones;
	private int codigo;

	/*
	 * CONSTRUCTOR
	 */
	public PlayList(String nombre) {
		this.nombre = nombre;
		this.listaCanciones = new LinkedList<Cancion>();
		this.codigo = 0;
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public String getNombre() {
		return nombre;
	}

	public List<Cancion> getListaCanciones() {
		return new LinkedList<Cancion>(listaCanciones);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int id) {
		this.codigo = id;
	}

	/*
	 * METODOS
	 */
	public void addCancion(Cancion c) {
		listaCanciones.add(c);
	}

	public void addAllCanciones(List<Cancion> canciones) {
		listaCanciones.addAll(canciones);
	}

	public void removeCancion(Cancion c) {
		listaCanciones.remove(c);
	}

	public boolean consultarCancion(Cancion c) {
		return listaCanciones.contains(c);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, listaCanciones, nombre);
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
		return codigo == other.codigo && Objects.equals(listaCanciones, other.listaCanciones)
				&& Objects.equals(nombre, other.nombre);
	}

}
