package umu.tds.modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorCancionDAO;
import umu.tds.dao.IAdaptadorPlayListDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.CargadorCanciones;
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

	/*
	 * CONSTRUCTOR
	 */
	private Controlador() {
		inicializarAdaptadores();
		inicializarCatalogos();
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public static Controlador getUnicaInstancia() {
		if (INSTANCIA == null) {
			INSTANCIA = new Controlador();
			try {
				CargadorCanciones.INSTANCE.cargarCanciones();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return INSTANCIA;
	}

	/*
	 * METODOS
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
		adaptadorPlayList = factoria.getPlaylistDAO();
	}

	private void inicializarCatalogos() {
		catalogoUsuarios = CatalogoUsuarios.getUnicaInstancia();
		catalogoCanciones = CatalogoCanciones.getUnicaInstancia();
	}

	/*
	 * USUARIO
	 */
	public Boolean login(String usuarioAux, String contraseñaAux) {
		Usuario usuario = getUsuario(usuarioAux);
		if (usuario != null && usuario.getContraseña().equals(contraseñaAux)) {
			this.usuarioActual = usuario;
			return true;
		}
		return false;
	}

	public void registrarUsuario(String nombre, String email, Date fecha, String contraseña) {
		Usuario usuario = new Usuario(nombre, email, fecha, contraseña);
		this.usuarioActual = usuario;
		adaptadorUsuario.registrarUsuario(usuario);
		catalogoUsuarios.addUsuario(usuario);
	}

	public Usuario getUsuario(String nombre_email) {
		return catalogoUsuarios.getUsuario(nombre_email);
	}

	public List<Usuario> getUsuarios() {
		return catalogoUsuarios.getUsuarios();
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public boolean existeUsuario(String nombre_email) {
		return getUsuario(nombre_email) != null;
	}

	/*
	 * CANCION
	 */
	public void registrarCancion(String titulo, String rutaFichero, String estiloMusical, String interprete) {
		Cancion cancion = new Cancion(titulo, rutaFichero, estiloMusical, interprete);
		adaptadorCancion.registrarCancion(cancion);
		catalogoCanciones.addCancion(cancion);
	}

	public List<Cancion> getCanciones() {
		return catalogoCanciones.getCanciones();
	}

	public LinkedList<Cancion> getCancionesFiltradas(String titulo, String interprete, String estilo) {
		LinkedList<Cancion> canciones = new LinkedList<Cancion>();
		if (estilo.equals(""))
			catalogoCanciones.getCanciones().stream().filter(c -> c.getTitulo().contains(titulo))
					.filter(c -> c.getInterprete().contains(interprete)).forEach(canciones::add);
		else
			catalogoCanciones.getCanciones().stream().filter(c -> c.getTitulo().contains(titulo))
					.filter(c -> c.getInterprete().contains(interprete))
					.filter(c -> c.getEstiloMusical().equals(estilo)).forEach(canciones::add);
		return canciones;
	}

	public String[] getEstilos() {
		LinkedList<String> estilos = new LinkedList<String>();
		estilos.add("");
		for (Cancion c : catalogoCanciones.getCanciones()) {
			if (!estilos.contains(c.getEstiloMusical())) {
				estilos.add(c.getEstiloMusical());
			}
		}
		String[] estilos2 = new String[estilos.size()];
		for (int i = 0; i < estilos2.length; i++) {
			estilos2[i] = estilos.get(i);
		}
		return estilos2;
	}

	/*
	 * PLAYLIST
	 */
	public void crearPlayList(String s, DefaultTableModel modelo) {
		PlayList p = new PlayList(s);
		int filasTotal = modelo.getRowCount();

		for (int fila = 0; fila < filasTotal; fila++) {
			if ((Boolean) modelo.getValueAt(fila, 3)) {
				Cancion cancion = catalogoCanciones.getCancion((String) modelo.getValueAt(fila, 0));
				p.addCancion(cancion);
			}
		}

		adaptadorPlayList.registrarPlayList(p);
		usuarioActual.addPlayList(p);
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	public void anadirCancionesAPlayList(String s, DefaultTableModel modelo) {

		PlayList p = usuarioActual.getPlayList(s);
		int filasTotal = modelo.getRowCount();

		for (int fila = 0; fila < filasTotal; fila++) {
			if ((Boolean) modelo.getValueAt(fila, 3)) {
				Cancion cancion = catalogoCanciones.getCancion((String) modelo.getValueAt(fila, 0));
				p.addCancion(cancion);
			}
		}
		adaptadorPlayList.modificarPlayList(p);
		usuarioActual.addPlayList(p);
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	public String[] getPlayLists() {
		LinkedList<String> playlist = new LinkedList<String>();
		playlist.add("");
		for (PlayList p : usuarioActual.getListaPlayList()) {
			playlist.add(p.getNombre());
		}
		String[] playlist2 = new String[playlist.size()];
		for (int i = 0; i < playlist2.length; i++) {
			playlist2[i] = playlist.get(i);
		}
		return playlist2;
	}

	public PlayList getPlayList(String s) {
		return usuarioActual.getPlayList(s);
	}

}
