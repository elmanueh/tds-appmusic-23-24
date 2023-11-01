package umu.tds.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import beans.Entidad;
import beans.Propiedad;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.*;

/**
 * Usa un pool para evitar problemas doble referencia con ventas
 */
public class AdaptadorUsuarioTDS implements IAdaptadorUsuarioDAO {
	/*
	 * ATRIBUTOS
	 */
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorUsuarioTDS unicaInstancia = null;

	private SimpleDateFormat dateFormat;

	/*
	 * CONSTRUCTOR
	 */
	private AdaptadorUsuarioTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}

	/*
	 * METODOS DE CONSULTA Y ESTABLECIMIENTO
	 */
	public static AdaptadorUsuarioTDS getUnicaInstancia() {
		if (unicaInstancia == null)
			unicaInstancia = new AdaptadorUsuarioTDS();
		return unicaInstancia;
	}

	/**
	 * Cuando se registra un cliente se le asigna un identificador único
	 */
	public void registrarUsuario(Usuario usuario) {
		Entidad eUsuario = null;

		try {
			eUsuario = servPersistencia.recuperarEntidad(usuario.getCode());
		} catch (NullPointerException e) {
		}
		if (eUsuario != null)
			return;

		AdaptadorPlayListTDS adaptadorPL = AdaptadorPlayListTDS.getUnicaInstancia();
		for (PlayList pl : usuario.getListaPlayList())
			adaptadorPL.registrarPlayList(pl);

		AdaptadorCancionTDS adaptadorCanciones = AdaptadorCancionTDS.getUnicaInstancia();
		for (Cancion ca : usuario.getListaCancionesRecientes())
			adaptadorCanciones.registrarCancion(ca);

		eUsuario = new Entidad();
		eUsuario.setNombre("usuario");
		eUsuario.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("email", usuario.getEmail()),
				new Propiedad("nombre", usuario.getNombre()), new Propiedad("contraseña", usuario.getContraseña()),
				new Propiedad("fecha", dateFormat.format(usuario.getFecha())),
				new Propiedad("listaPlayList", obtenerCodigosPlayLists(usuario.getListaPlayList())),
				new Propiedad("listaCancionesRecientes", obtenerCodigosCanciones(usuario.getListaCancionesRecientes())),
				new Propiedad("esPremium", String.valueOf(usuario.isPremium())))));

		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		usuario.setCode(eUsuario.getId());
	}

	public void borrarUsuario(Usuario usuario) {
		Entidad eUsuario = servPersistencia.recuperarEntidad(usuario.getCode());
		servPersistencia.borrarEntidad(eUsuario);
	}

	public void modificarUsuario(Usuario usuario) {
		Entidad eUsuario = servPersistencia.recuperarEntidad(usuario.getCode());

		for (Propiedad prop : eUsuario.getPropiedades()) {
			if (prop.getNombre().equals("codigo")) {
				prop.setValor(String.valueOf(usuario.getCode()));
			} else if (prop.getNombre().equals("email")) {
				prop.setValor(usuario.getEmail());
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(usuario.getNombre());
			} else if (prop.getNombre().equals("contraseña")) {
				prop.setValor(usuario.getContraseña());
			} else if (prop.getNombre().equals("fecha")) {
				prop.setValor(dateFormat.format(usuario.getFecha()));
			} else if (prop.getNombre().equals("listaPlayList")) {
				String ventas = obtenerCodigosPlayLists(usuario.getListaPlayList());
				prop.setValor(ventas);
			} else if (prop.getNombre().equals("listaCancionesRecientes")) {
				String ventas = obtenerCodigosCanciones(usuario.getListaCancionesRecientes());
				prop.setValor(ventas);
			} else if (prop.getNombre().equals("esPremium")) {
				prop.setValor(String.valueOf(usuario.isPremium()));
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}

	public Usuario recuperarUsuario(int codigo) {
		if (PoolDAO.getUnicaInstancia().contiene(codigo))
			return (Usuario) PoolDAO.getUnicaInstancia().getObjeto(codigo);

		Entidad eUsuario;
		HashSet<PlayList> listaPlayList = new HashSet<PlayList>();
		LinkedList<Cancion> cancionesRecientes = new LinkedList<Cancion>();
		String nombre;
		String email;
		Date fecha = null;
		String contraseña;
		Boolean premium;

		eUsuario = servPersistencia.recuperarEntidad(codigo);

		nombre = servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre");
		email = servPersistencia.recuperarPropiedadEntidad(eUsuario, "email");
		try {
			fecha = dateFormat.parse(servPersistencia.recuperarPropiedadEntidad(eUsuario, "fecha"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		contraseña = servPersistencia.recuperarPropiedadEntidad(eUsuario, "email");
		premium = Boolean.valueOf(servPersistencia.recuperarPropiedadEntidad(eUsuario, "esPremium"));

		Usuario usuario = new Usuario(nombre, email, fecha, contraseña);
		usuario.setCode(codigo);
		//ESTO SE DEBERIA HACER SOLO CON EL SET Y PASANDO COMO PARAMETRO premium
		if (premium)
			usuario.setPremium();
		
		PoolDAO.getUnicaInstancia().addObjeto(codigo, usuario);

		// recuperar propiedades que son objetos llamando a adaptadores
		
		listaPlayList = obtenerPlayListDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eUsuario, "listaPlayList")); 
		for (PlayList pl : listaPlayList)
		usuario.addPlayList(pl);
		
		cancionesRecientes = obtenerCancionesDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eUsuario, "listaCancionesRecientes")); 
		for (Cancion c : cancionesRecientes) 
			usuario.addCancionReciente(c);

		return usuario;
	}

	public List<Usuario> recuperarTodosUsuarios() {

		List<Entidad> eUsuarios = servPersistencia.recuperarEntidades("usuario");
		List<Usuario> clientes = new LinkedList<Usuario>();

		for (Entidad eUsuario : eUsuarios) {
			clientes.add(recuperarUsuario(eUsuario.getId()));
		}
		return clientes;
	}

	// -------------------Funciones auxiliares-----------------------------
	private String obtenerCodigosPlayLists(Collection<PlayList> collection) {
		String aux = "";
		for (PlayList pl : collection) {
			aux += pl.getCodigo() + " ";
		}
		return aux.trim();
	}

	private HashSet<PlayList> obtenerPlayListDesdeCodigos(String playlists) {
		HashSet<PlayList> listaVentas = new HashSet<PlayList>();
		StringTokenizer strTok = new StringTokenizer(playlists, " ");
		AdaptadorPlayListTDS adaptadorPL = AdaptadorPlayListTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			listaVentas.add(adaptadorPL.recuperarPlayList(Integer.valueOf((String) strTok.nextElement())));
		}
		return listaVentas;
	}

	private String obtenerCodigosCanciones(Collection<Cancion> collection) {
		String aux = "";
		for (Cancion c : collection) {
			aux += c.getCodigo() + " ";
		}
		return aux.trim();
	}

	private LinkedList<Cancion> obtenerCancionesDesdeCodigos(String recuperarPropiedadEntidad) {
		LinkedList<Cancion> cancionesRecientes = new LinkedList<Cancion>();
		StringTokenizer strTok = new StringTokenizer(recuperarPropiedadEntidad, " ");
		AdaptadorCancionTDS adaptadorCancion = AdaptadorCancionTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			cancionesRecientes.add(adaptadorCancion.recuperarCancion(Integer.valueOf((String) strTok.nextElement())));
		}
		return cancionesRecientes;
	}
}
