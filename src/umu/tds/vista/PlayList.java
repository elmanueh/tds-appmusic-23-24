package umu.tds.vista;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class PlayList {
    private String nombre;
    private Collection<Cancion> lista;

    public PlayList(String nombre_){
        nombre = nombre_;
        lista = new HashSet<Cancion>();
    }

    public void addCancion(Cancion c){
        lista.add(c);
    }

    public void removeCancion(Cancion c){
        lista.remove(c);
    }

    public Collection<Cancion> getCanciones(){
        return new HashSet<Cancion>(lista);
    }
}
