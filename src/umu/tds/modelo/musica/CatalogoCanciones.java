package umu.tds.modelo.musica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorCancionDAO;
import umu.tds.modelo.usuario.CatalogoUsuarios;
import umu.tds.modelo.usuario.Usuario;

public class CatalogoCanciones {
	private static final int MAX = 10;

	//ATRIBUTOS
	private Map<String,Cancion> canciones;
	private static CatalogoCanciones unicaInstancia = new CatalogoCanciones();
	
	private FactoriaDAO dao;
	private IAdaptadorCancionDAO adaptadorCancion;

	//CONSTRUCTOR
	private CatalogoCanciones() {
		try {
  			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
  			adaptadorCancion = dao.getCancionDAO();
  			this.canciones = new HashMap<String, Cancion>();
  			this.cargarCatalogo();
  		} catch (DAOException eDAO) {
  			eDAO.printStackTrace();
  		}
	}
	
	public static CatalogoCanciones getUnicaInstancia(){
		return unicaInstancia;
	}
	
	//METODOS
	public List<Cancion> getCanciones(){
		ArrayList<Cancion> lista = new ArrayList<Cancion>();
		for (Cancion c:canciones.values()) 
			lista.add(c);
		return lista;
	}
	
	public Cancion getCancion(String titulo) {
		return canciones.get(titulo); 
	}
	
	public void addCancion(Cancion c) {
		canciones.put(c.getTitulo(), c);
	}
	
	public void removeCancion(Cancion c) {
		canciones.remove(c.getTitulo());
	}

	/*public static List<Cancion> getCancionesMasReproducidas(){
		List<Cancion> topTen = (List<Cancion>) canciones.values().stream()
				.sorted((v1,v2) -> (int) v2.getNumReproducciones() - v1.getNumReproducciones())
				.limit(MAX)
				.collect(Collectors.toList());
		return topTen;
	}*/
	
	//CREO QUE HABRIA QUE HACER AQUI LO DE BUSCAR LAS CANCIONES PARA APARECER EN LAS TABLAS
	
	/*Recupera todos los clientes para trabajar con ellos en memoria*/
	private void cargarCatalogo() throws DAOException {
		 List<Cancion> cancionesBD = adaptadorCancion.recuperarTodosCanciones();
		 for (Cancion ca: cancionesBD) 
			     canciones.put(ca.getTitulo(),ca);
	}

}
