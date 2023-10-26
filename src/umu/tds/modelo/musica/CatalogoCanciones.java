package umu.tds.modelo.musica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CatalogoCanciones {
	private static final int MAX = 10;

	//ATRIBUTOS
	private static Map<String,Cancion> canciones;
	
	//GETTERS AND SETTERS
	public Map<String, Cancion> getCanciones() {
		return canciones;
	}

	//CONSTRUCTOR
	public CatalogoCanciones() {
		this.canciones = new HashMap<String, Cancion>();
	}

	//METODOS
	public Cancion getCancion(String titulo) {
		return canciones.get(titulo); 
	}
	
	public static void addCancion(Cancion c) {
		canciones.put(c.getTitulo(), c);
	}
	
	public void removeCancion(Cancion c) {
		canciones.remove(c.getTitulo());
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
