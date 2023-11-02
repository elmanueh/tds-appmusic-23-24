package umu.tds.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public class AdaptadorPlayListTDS implements IAdaptadorPlayListDAO {
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorPlayListTDS unicaInstancia = null;

	public static AdaptadorPlayListTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorPlayListTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorPlayListTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	/* cuando se registra un playlist se le asigna un identificador ï¿½nico */
	public void registrarPlayList(PlayList playlist) {
		Entidad ePL = null;

		// Si la entidad esta registrada no la registra de nuevo
		try {
			ePL = servPersistencia.recuperarEntidad(playlist.getCodigo());
		} catch (NullPointerException e) {}
		if (ePL != null) return;

		// registrar primero los atributos que son objetos
		AdaptadorCancionTDS adaptadorCancion = AdaptadorCancionTDS.getUnicaInstancia();
		for (Cancion c : playlist.getListaCanciones())
			adaptadorCancion.registrarCancion(c);

		// crear entidad PL
		ePL = new Entidad();
		ePL.setNombre("playlist");
		ePL.setPropiedades(new ArrayList<Propiedad>(Arrays.asList( 
				new Propiedad("nombre", playlist.getNombre()),
				new Propiedad("canciones", obtenerCodigosCanciones(playlist.getListaCanciones())))));

		// registrar entidad playlist
		ePL = servPersistencia.registrarEntidad(ePL);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		playlist.setCodigo(ePL.getId());
	}

	public void borrarPlayList(PlayList playlist) {
		// No se comprueban restricciones de integridad con Cancion
		Entidad ePL = servPersistencia.recuperarEntidad(playlist.getCodigo());

		servPersistencia.borrarEntidad(ePL);
	}

	public void modificarPlayList(PlayList playlist) {

		Entidad eCliente = servPersistencia.recuperarEntidad(playlist.getCodigo());

		for (Propiedad prop : eCliente.getPropiedades()) {
			if (prop.getNombre().equals("playlist")) {
				prop.setValor(String.valueOf(playlist.getCodigo()));
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(playlist.getNombre());
			} else if (prop.getNombre().equals("canciones")) {
				String ventas = obtenerCodigosCanciones(playlist.getListaCanciones());
				prop.setValor(ventas);
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}
	
	public PlayList recuperarPlayList(int codigo) {

		// Si la entidad estï¿½ en el pool la devuelve directamente
		if (PoolDAO.getUnicaInstancia().contiene(codigo))
			return (PlayList) PoolDAO.getUnicaInstancia().getObjeto(codigo);

		// si no, la recupera de la base de datos
		Entidad ePL;
		List<Cancion> canciones = new LinkedList<Cancion>();
		String nombre;

		// recuperar entidad
		ePL = servPersistencia.recuperarEntidad(codigo);

		// recuperar propiedades que no son objetos
		nombre = servPersistencia.recuperarPropiedadEntidad(ePL, "nombre");

		PlayList playlist = new PlayList(nombre);
		playlist.setCodigo(codigo);

		// IMPORTANTE:aï¿½adir la playlist al pool antes de llamar a otros
		// adaptadores
		PoolDAO.getUnicaInstancia().addObjeto(codigo, playlist);

		// recuperar propiedades que son objetos llamando a adaptadores
		// canciones
		canciones = obtenerCancionesDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(ePL, "canciones"));
		for (Cancion c : canciones)
			playlist.addCancion(c);
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
	
	// -------------------Funciones auxiliares-----------------------------
	private String obtenerCodigosCanciones(Collection<Cancion> listaCanciones) {
		String aux = "";
		for (Cancion c : listaCanciones) {
			aux += c.getCodigo() + " ";
		}
		return aux.trim();
	}
	
	private List<Cancion> obtenerCancionesDesdeCodigos(String canciones) {
		List<Cancion> listaCanciones = new LinkedList<Cancion>();
		StringTokenizer strTok = new StringTokenizer(canciones, " ");
		AdaptadorCancionTDS adaptadorCancion = AdaptadorCancionTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			listaCanciones.add(adaptadorCancion.recuperarCancion(Integer.valueOf((String) strTok.nextElement())));
		}
		return listaCanciones;
	}



}
