package umu.tds.modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorPlayListDAO;
import umu.tds.dao.IAdaptadorCancionDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.CatalogoCanciones;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.CatalogoUsuarios;
import umu.tds.modelo.usuario.Usuario;

public class Controlador {

	/*
	 * ATRIBUTOS
	 */
	private static Controlador INSTANCIA;

	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorPlayListDAO adaptadorPlayList;
	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;

	private Usuario usuarioActual;
	private PlayList plActual;

	/*
	 * CONSTRUCTOR
	 */
	private Controlador() {
		inicializarAdaptadores();
		inicializarCatalogos();
	}

	/*
	 * METODOS DE CONSULTA Y ESTABLECIMIENTO
	 */
	private void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
		adaptadorCancion = factoria.getCancionDAO();
		// adaptadorPlayList = factoria.getPlaylistDAO();
	}

	private void inicializarCatalogos() {
		catalogoUsuarios = CatalogoUsuarios.getUnicaInstancia();
		// catalogoCanciones = CatalogoCanciones.getUnicaInstancia();
	}

	public static Controlador getUnicaInstancia() {
		if (INSTANCIA == null)
			INSTANCIA = new Controlador();
		return INSTANCIA;
	}

	public boolean esUsuarioRegistrado(String login) {
		return CatalogoUsuarios.getUnicaInstancia().getUsuario(login) != null;
	}

	public void registrarUsuario(String nombre, String email, Date fecha, String contraseña) {
		Usuario usuario = new Usuario(nombre, email, fecha, contraseña);
		adaptadorUsuario.registrarUsuario(usuario);
		catalogoUsuarios.addUsuario(usuario);
	}

	public void registrarCancion(String titulo, String rutaFichero, String estiloMusical, String... interpretes) {
		Cancion cancion = new Cancion(titulo, rutaFichero, estiloMusical, interpretes);
		adaptadorCancion.registrarCancion(cancion);
		catalogoCanciones.addCancion(cancion);
	}

	public void crearPlayList(String s) {
		// plActual = new PlayList(s);
	}

	public void anadirCancionAPlayList(Cancion c) {
		// plActual.addCancion(c);
	}

	public void registrarPlayList(String s) {

	}

	public boolean existeUsuario(String nombre_email) {
		return catalogoUsuarios.getUsuario(nombre_email) != null;
	}

	public List<Cancion> getCanciones() {
		return catalogoCanciones.getCanciones();
	}

	public List<Usuario> getUsuarios() {
		return catalogoUsuarios.getUsuarios();
	}

	public Boolean login(String usuarioAux, String contraseñaAux) {
		Usuario usuario = CatalogoUsuarios.getUnicaInstancia().getUsuario(usuarioAux);
		if (usuario != null && usuario.getContraseña().equals(contraseñaAux)) {
			this.usuarioActual = usuario;
			return true;
		}
		return false;
	}

	public Usuario getUsuario(String usuario) {
		return catalogoUsuarios.getUsuario(usuario);
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
	
	public LinkedList<Cancion> getCancionesFiltradas(String titulo, String interprete, String estilo){
		LinkedList<Cancion> canciones = new LinkedList<Cancion>();
		catalogoCanciones.getCanciones().stream()
			.filter(c -> c.getTitulo().contains(titulo))
			.filter(c -> c.getInterprete().contains(interprete))
			.filter(c -> c.getEstiloMusical().equals(estilo))
			.forEach(canciones::add);
		return canciones;
	}

}
