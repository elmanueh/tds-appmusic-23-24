package umu.tds.modelo.musica;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class PlayList {
	//ATRIBUTOS
    private final String nombre;
    private final HashSet<Cancion> listaCanciones;
    private int codigo;

    //GETTERS AND SETTERS
    public String getNombre() {
		return nombre;
	}

	public HashSet<Cancion> getListaCanciones() {
		return new HashSet<Cancion>(listaCanciones);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int id) {
		this.codigo = id;
	}
    
    //CONSTRUCTOR
    public PlayList(String nombre) {
		this.nombre = nombre;
		this.listaCanciones = new HashSet<Cancion>();
		this.codigo = 0;
	}

	//METODOS
    public void addCancion(Cancion c){
    	listaCanciones.add(c);
    }
    
    public void addAllCanciones(List<Cancion> canciones) {
    	listaCanciones.addAll(canciones);
    }

    public void removeCancion(Cancion c){
    	listaCanciones.remove(c);
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
