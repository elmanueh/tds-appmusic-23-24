package umu.tds.modelo.musica;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class PlayList {
	//ATRIBUTOS
    private String nombre;
    private Collection<Cancion> listaCanciones;

    //CONSTRUCTOR
    public PlayList(String nombre, HashSet<Cancion> listaCanciones) {
		this.nombre = nombre;
		this.listaCanciones = new HashSet<Cancion>(listaCanciones);
	}

    //METODOS
    public void addCancion(Cancion c){
    	listaCanciones.add(c);
    }

    public void removeCancion(Cancion c){
    	listaCanciones.remove(c);
    }

    public Collection<Cancion> getCanciones(){
        return new HashSet<Cancion>(listaCanciones);
    }
}
