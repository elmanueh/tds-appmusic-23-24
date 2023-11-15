package umu.tds.modelo.musica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorCancionDAO;

public class CatalogoCanciones {

	/*
	 * ATRIBUTOS
	 */
	private static CatalogoCanciones INSTANCIA;

	private HashMap<String, Cancion> canciones;
	private FactoriaDAO dao;
	private IAdaptadorCancionDAO adaptadorCancion;

	/*
	 * CONSTRUCTOR
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

	/*
	 * GETTERS AND SETTERS
	 */
	public static CatalogoCanciones getUnicaInstancia() {
		if (INSTANCIA == null)
			INSTANCIA = new CatalogoCanciones();
		return INSTANCIA;
	}

	public LinkedList<Cancion> getCanciones() {
		return new LinkedList<Cancion>(canciones.values());
	}

	public Cancion getCancion(String titulo) {
		return canciones.get(titulo);
	}

	/*
	 * METODOS
	 */
	public void addCancion(Cancion c) {
		canciones.put(c.getTitulo(), c);
	}

	public void removeCancion(Cancion c) {
		canciones.remove(c.getTitulo());
	}

	private void cargarCatalogo() throws DAOException {
		List<Cancion> cancionesBD = adaptadorCancion.recuperarTodasCanciones();
		for (Cancion cancion : cancionesBD)
			canciones.put(cancion.getTitulo(), cancion);
	}

}
