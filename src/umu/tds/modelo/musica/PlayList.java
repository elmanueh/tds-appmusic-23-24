package umu.tds.modelo.musica;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class PlayList {
	//ATRIBUTOS
    private final String nombre;
    private final Collection<Cancion> listaCanciones;
    private int id;

    //GETTERS AND SETTERS
    public String getNombre() {
		return nombre;
	}

	public Collection<Cancion> getListaCanciones() {
		return new HashSet<Cancion>(listaCanciones);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    //CONSTRUCTOR
    public PlayList(String nombre) {
		this.nombre = nombre;
		this.listaCanciones = new HashSet<Cancion>();
		id = 0;
	}

	//METODOS
    public void addCancion(Cancion c){
    	listaCanciones.add(c);
    }

    public void removeCancion(Cancion c){
    	listaCanciones.remove(c);
    }

    
	@Override
	public int hashCode() {
		return Objects.hash(id, listaCanciones, nombre);
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
		return id == other.id && Objects.equals(listaCanciones, other.listaCanciones)
				&& Objects.equals(nombre, other.nombre);
	}
    
    
}
