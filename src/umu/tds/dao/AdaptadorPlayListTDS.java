package umu.tds.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public class AdaptadorPlayListTDS implements IAdaptadorPlayListDAO {

	/*
	 * ATRIBUTOS
	 */
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorPlayListTDS unicaInstancia = null;

	/*
	 * CONSTRUCTOR
	 */
	private AdaptadorPlayListTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public static AdaptadorPlayListTDS getUnicaInstancia() {
		if (unicaInstancia == null)
			unicaInstancia = new AdaptadorPlayListTDS();
		return unicaInstancia;
	}

	/*
	 * METODOS
	 */
	public void registrarPlayList(PlayList playlist) {
		Entidad ePlayList = null;

		try {
			ePlayList = servPersistencia.recuperarEntidad(playlist.getCodigo());
		} catch (NullPointerException e) {
		}
		if (ePlayList != null)
			return;

		ePlayList = new Entidad();
		ePlayList.setNombre("playlist");
		ePlayList.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nombre", playlist.getNombre()),
				new Propiedad("canciones", obtenerCodigosCanciones(playlist)))));

		ePlayList = servPersistencia.registrarEntidad(ePlayList);
		playlist.setCodigo(ePlayList.getId());
	}

	public void borrarPlayList(PlayList playlist) {
		Entidad ePlayList = servPersistencia.recuperarEntidad(playlist.getCodigo());

		servPersistencia.borrarEntidad(ePlayList);
	}

	public void modificarPlayList(PlayList playlist) {

		Entidad ePlayList = servPersistencia.recuperarEntidad(playlist.getCodigo());

		for (Propiedad prop : ePlayList.getPropiedades()) {
			if (prop.getNombre().equals("playlist")) {
				prop.setValor(String.valueOf(playlist.getCodigo()));
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(playlist.getNombre());
			} else if (prop.getNombre().equals("canciones")) {
				String codigosCanciones = obtenerCodigosCanciones(playlist);
				prop.setValor(codigosCanciones);
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}

	public PlayList recuperarPlayList(int codigo) {

		if (PoolDAO.getUnicaInstancia().contiene(codigo))
			return (PlayList) PoolDAO.getUnicaInstancia().getObjeto(codigo);

		Entidad ePlayList;
		HashSet<Cancion> canciones = new HashSet<Cancion>();
		String nombre;

		ePlayList = servPersistencia.recuperarEntidad(codigo);
		nombre = servPersistencia.recuperarPropiedadEntidad(ePlayList, "nombre");
		PlayList playlist = new PlayList(nombre);
		playlist.setCodigo(codigo);

		PoolDAO.getUnicaInstancia().addObjeto(codigo, playlist);

		canciones = obtenerCancionesDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(ePlayList, "canciones"));
		playlist.addAllCanciones(canciones);
		return playlist;
	}

	public List<PlayList> recuperarTodosPlayLists() {
		List<Entidad> ePLs = servPersistencia.recuperarEntidades("playlist");
		List<PlayList> playlist = new LinkedList<PlayList>();
		for (Entidad ePlayList : ePLs) {
			playlist.add(recuperarPlayList(ePlayList.getId()));
		}
		return playlist;
	}

	/*
	 * METODOS AUXILIARES
	 */
	private String obtenerCodigosCanciones(PlayList playlist) {
		String codigosCanciones = "";
		for (Cancion c : playlist.getListaCanciones()) {
			codigosCanciones += c.getCodigo() + " ";
		}
		return codigosCanciones.trim();
	}

	private HashSet<Cancion> obtenerCancionesDesdeCodigos(String canciones) {
		HashSet<Cancion> listaCanciones = new HashSet<Cancion>();
		StringTokenizer strTok = new StringTokenizer(canciones, " ");

		while (strTok.hasMoreTokens()) {
			listaCanciones.add(AdaptadorCancionTDS.getUnicaInstancia()
					.recuperarCancion(Integer.valueOf((String) strTok.nextElement())));
		}
		return listaCanciones;
	}

}
