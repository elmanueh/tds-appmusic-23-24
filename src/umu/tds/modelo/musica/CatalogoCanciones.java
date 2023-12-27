package umu.tds.modelo.musica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorCancionDAO;

/**
 * Interfaz que representa el catalogo de canciones
 */
public enum CatalogoCanciones {
	INSTANCIA;

	/**
	 * ATRIBUTOS
	 */
	private HashMap<String, Cancion> canciones;
	private FactoriaDAO dao;
	private IAdaptadorCancionDAO adaptadorCancion;

	/**
	 * Constructor de la interfaz CatalogoCanciones.
	 */
	private CatalogoCanciones() {
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorCancion = dao.getCancionDAO();
			canciones = new HashMap<String, Cancion>();
			this.cargarCatalogo();
		} catch (DAOException eDAO) {
			eDAO.printStackTrace();
		}
	}

	/**
	 * GETTERS AND SETTERS
	 */
	public List<Cancion> getCanciones() {
		return new LinkedList<Cancion>(canciones.values());
	}

	public Cancion getCancion(String titulo) {
		return canciones.get(titulo);
	}

	/**
	 * Metodo que añade una cancion al mapa de canciones
	 * @param cancion Canciona a añadir en el mapa
	 */
	public void addCancion(Cancion cancion) {
		canciones.put(cancion.getTitulo(), cancion);
	}

	/**
	 * Metodo que carga todas las canciones de la base de datos
	 */
	private void cargarCatalogo() throws DAOException {
		List<Cancion> cancionesBD = adaptadorCancion.recuperarTodasCanciones();
		for (Cancion cancion : cancionesBD)
			canciones.put(cancion.getTitulo(), cancion);
	}

}
