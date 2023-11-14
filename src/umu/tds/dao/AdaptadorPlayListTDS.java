package umu.tds.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public enum AdaptadorPlayListTDS implements IAdaptadorPlayListDAO {
	INSTANCIA;

	// ATRIBUTOS
	private ServicioPersistencia servPersistencia;

	// CONSTRUCTOR
	private AdaptadorPlayListTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	// METODOS
	public void registrarPlayList(PlayList playlist) {
		Entidad ePlayList = null;
		ePlayList = servPersistencia.recuperarEntidad(playlist.getCodigo());

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
		Entidad ePlayList;
		HashSet<Cancion> canciones = new HashSet<Cancion>();
		String nombre;

		ePlayList = servPersistencia.recuperarEntidad(codigo);
		nombre = servPersistencia.recuperarPropiedadEntidad(ePlayList, "nombre");
		PlayList playlist = new PlayList(nombre);
		playlist.setCodigo(codigo);

		canciones = obtenerCancionesDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(ePlayList, "canciones"));
		playlist.addAllCanciones(canciones);
		return playlist;
	}

	// METODOS AUXILIARES
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
			listaCanciones.add(
					AdaptadorCancionTDS.INSTANCIA.recuperarCancion(Integer.valueOf((String) strTok.nextElement())));
		}
		return listaCanciones;
	}

}
