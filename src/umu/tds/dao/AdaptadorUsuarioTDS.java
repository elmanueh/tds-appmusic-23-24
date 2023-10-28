package umu.tds.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import beans.Entidad;
import beans.Propiedad;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.*;

//Usa un pool para evitar problemas doble referencia con ventas
public class AdaptadorUsuarioTDS implements IAdaptadorUsuarioDAO {
	private static ServicioPersistencia servPersistencia;
	
	private SimpleDateFormat dateFormat;
	private static AdaptadorUsuarioTDS unicaInstancia = null;

	public static AdaptadorUsuarioTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorUsuarioTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorUsuarioTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}

	/* cuando se registra un cliente se le asigna un identificador �nico */
	public void registrarUsuario(Usuario usuario) {
		Entidad eUsuario = null;

		// Si la entidad esta registrada no la registra de nuevo
		try {
			eUsuario = servPersistencia.recuperarEntidad(usuario.getCode());
		} catch (NullPointerException e) {}
		if (eUsuario != null) return;
		
		// registrar primero los atributos que son objetos
		AdaptadorPlayListTDS adaptadorPL = AdaptadorPlayListTDS.getUnicaInstancia();
		for (PlayList pl : usuario.getListaPlayList())
			adaptadorPL.registrarPlayList(pl);
		
		AdaptadorCancionTDS adaptadorCanciones = AdaptadorCancionTDS.getUnicaInstancia();
		for (Cancion ca : usuario.getListaCancionesRecientes())
			adaptadorCanciones.registrarCancion(ca);

		// crear entidad Usuario
		eUsuario = new Entidad();
		eUsuario.setNombre("usuario");
		eUsuario.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("email", usuario.getEmail()), 
							  new Propiedad("nombre", usuario.getNombre()),
							  new Propiedad("contraseña", usuario.getContraseña()),
							  new Propiedad("fecha", dateFormat.format(usuario.getFecha())),
							  new Propiedad("esCompleta", String.valueOf(usuario.isPremium()))
							  //new Propiedad("listaPlayList", obtenerCodigosPlayLists(usuario.getListaPlayList())),
							  //new Propiedad("listaCancionesRecientes", obtenerCodigosCanciones(usuario.getListaCancionesRecientes())),
							  )));

		// registrar entidad Usuario
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		usuario.setCode(eUsuario.getId());
	}

	public void borrarUsuario(Usuario usuario) {
		// No se comprueban restricciones de integridad con Venta
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
				prop.setValor(usuario.getFecha().toString());
			}
			servPersistencia.modificarPropiedad(prop);
		}

	}

	public Usuario recuperarUsuario(int codigo) {

		// Si la entidad est� en el pool la devuelve directamente
		if (PoolDAO.getUnicaInstancia().contiene(codigo))
			return (Usuario) PoolDAO.getUnicaInstancia().getObjeto(codigo);

		// si no, la recupera de la base de datos
		Entidad eCliente;
		HashSet<PlayList> listaPlayList = new HashSet<PlayList>();
		LinkedHashSet<Cancion> listaCancionesRecientes = new LinkedHashSet<Cancion>();
		String nombre;
		String email;
		LocalDate fecha;
		String contraseña;

		// recuperar entidad
		eCliente = servPersistencia.recuperarEntidad(codigo);

		// recuperar propiedades que no son objetos
		nombre = servPersistencia.recuperarPropiedadEntidad(eCliente, "nombre");
		email = servPersistencia.recuperarPropiedadEntidad(eCliente, "email");
		//fecha = LocalDate.parse(servPersistencia.recuperarPropiedadEntidad(eCliente, "fecha"));
		contraseña = servPersistencia.recuperarPropiedadEntidad(eCliente, "email");		
		
		Usuario usuario = new Usuario(nombre, email, null, contraseña);
		usuario.setCode(codigo);

		// IMPORTANTE:a�adir el cliente al pool antes de llamar a otros
		// adaptadores
		PoolDAO.getUnicaInstancia().addObjeto(codigo, usuario);

		// recuperar propiedades que son objetos llamando a adaptadores
		listaPlayList = obtenerPlayListDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eCliente, "ventas"));

		for (PlayList pl : listaPlayList)
		usuario.addPlayList(pl);

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
	private String obtenerCodigosPlayList(List<PlayList> listaPL) {
		String aux = "";
		for (PlayList pl : listaPL) {
			aux += pl.getCodigo() + " ";
		}
		return aux.trim();
	}

	private HashSet<PlayList> obtenerPlayListDesdeCodigos(String playlists) {

		HashSet<PlayList> listaVentas = new HashSet<PlayList>();
		/*StringTokenizer strTok = new StringTokenizer(playlists, " ");*/
		/*AdaptadorPlayListTDS adaptadorPL = AdaptadorPlayListTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			listaVentas.add(adaptadorPL.recuperarPlayList(Integer.valueOf((String) strTok.nextElement())));
		}*/
		return listaVentas;
	}
	
	//HABRIA QUE CREAR LO MISMO PARA CANCIONES
}
