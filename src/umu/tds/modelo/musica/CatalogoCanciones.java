package umu.tds.modelo.musica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CatalogoCanciones {
	private static final int MAX = 10;

	//ATRIBUTOS
	private static Map<Integer,Cancion> canciones;
	
	//GETTERS AND SETTERS
	public Map<Integer, Cancion> getCanciones() {
		return canciones;
	}

	//CONSTRUCTOR
	public CatalogoCanciones() {
		this.canciones = new HashMap<Integer, Cancion>();
	}

	//METODOS
	public Cancion getCancion(int id) {
		return canciones.get(id); 
	}
	
	public void setCancion(Cancion c) {
		if (canciones.containsKey(c.getId()))
			addCancion(c);
	}
	
	public void addCancion(Cancion c) {
		canciones.put(c.getId(), c);
	}
	
	public void removeCancion(Cancion c) {
		canciones.remove(c.getId());
	}

	public static List<Cancion> getCancionesMasReproducidas(){
		List<Cancion> topTen = (List<Cancion>) canciones.values().stream()
				.sorted((v1,v2) -> (int) v2.getNumReproducciones() - v1.getNumReproducciones())
				.limit(MAX)
				.collect(Collectors.toList());
		return topTen;
	}
	
	//CREO QUE HABRIA QUE HACER AQUI LO DE BUSCAR LAS CANCIONES PARA APARECER EN LAS TABLAS
}
