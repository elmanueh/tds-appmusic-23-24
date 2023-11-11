package umu.tds.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
import umu.tds.vista.main.MenuPremium;
import umu.tds.vista.main.PlantillaMain;
import umu.tds.modelo.descuento.Descuento;

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
	private LinkedList<Cancion> cancionesSeleccionadas;
	private HashSet<Cancion> cancionesSeleccionadas;

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

	public long diasParaCumple() {
		Date fechaNacimiento = Controlador.getUnicaInstancia().getUsuarioActual().getFecha();
		Calendar fechaActual = Calendar.getInstance();

		Calendar fechaNacimientoCalendar = Calendar.getInstance();
		fechaNacimientoCalendar.setTime(fechaNacimiento);

		fechaNacimientoCalendar.set(Calendar.YEAR, fechaActual.get(Calendar.YEAR));

		if (fechaActual.after(fechaNacimientoCalendar)) {
			fechaNacimientoCalendar.add(Calendar.YEAR, 1);
		}

		long diferenciaEnMilisegundos = fechaNacimientoCalendar.getTimeInMillis() - fechaActual.getTimeInMillis();

		long diasHastaCumpleaños = diferenciaEnMilisegundos / (24 * 60 * 60 * 1000);

		return diasHastaCumpleaños;
	}

	/*
	 * CANCION
	 */
	public void registrarCancion(String titulo, String rutaFichero, String estiloMusical, String interprete) {
		Cancion cancion = new Cancion(titulo, rutaFichero, estiloMusical, interprete);
		adaptadorCancion.registrarCancion(cancion);
		catalogoCanciones.addCancion(cancion);
	}

	public boolean existePlayList(String titulo) {
		for (PlayList p : usuarioActual.getListaPlayList()) {
			if (p.getNombre().equals(titulo))
				return true;
		}
		return false;
	}

	public List<Cancion> getCanciones() {
		return catalogoCanciones.getCanciones();
	}

	public LinkedList<Cancion> getCancionesFiltradas(String titulo, String interprete, String estilo,
			boolean favorito) {
		LinkedList<Cancion> canciones = new LinkedList<Cancion>();
		if (favorito) {
			if (estilo.equals(""))
				usuarioActual.getListaPlayList().stream()
		        .flatMap(pl -> pl.getListaCanciones().stream())
		        .filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
				.filter(c -> c.getInterprete().toLowerCase().contains(interprete.toLowerCase()))
				.forEach(canciones::add);
			else
				usuarioActual.getListaPlayList().stream()
			        .flatMap(pl -> pl.getListaCanciones().stream())
			        .filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
					.filter(c -> c.getInterprete().toLowerCase().contains(interprete.toLowerCase()))
					.filter(c -> c.getEstiloMusical().equals(estilo))
					.forEach(canciones::add);
		}
		else {
		if (estilo.equals(""))
			catalogoCanciones.getCanciones().stream()
					.filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
					.filter(c -> c.getInterprete().toLowerCase().contains(interprete.toLowerCase()))
					.forEach(canciones::add);
		else
			catalogoCanciones.getCanciones().stream()
					.filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
					.filter(c -> c.getInterprete().toLowerCase().contains(interprete.toLowerCase()))
					.filter(c -> c.getEstiloMusical().equals(estilo))
					.forEach(canciones::add);
		}
		return canciones;
	}

	public LinkedList<String> getEstilos() {
		LinkedList<String> estilos = (LinkedList<String>) catalogoCanciones.getCanciones().stream()
				.map(Cancion::getEstiloMusical).distinct().sorted().collect(Collectors.toCollection(LinkedList::new));
		estilos.addFirst("");
		return estilos;
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

	public void anadirCancionesSelecAPL(String text) {
		PlayList p = usuarioActual.getPlayList(text);
		p.addAllCanciones(cancionesSeleccionadas);
		
		adaptadorPlayList.modificarPlayList(p);
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

	/*
	 * PREMIUM
	 */
	public Descuento aplicarDescuento(String codigo) {
		return usuarioActual.aplicarDescuento(codigo);
	}

	public void configuracionPremium() {
		MenuPremium.main(null);
	}

	public void configuracionPremiumConfirmado(boolean premium, double precio) {
		usuarioActual.setPremium(premium);
		PlantillaMain.modoPremium(premium);
		usuarioActual.setCuota(precio);
	}

	/*
	 * TABLA SELECCIONADOS
	 */
	public void setTablaSeleccionados(DefaultTableModel modelo) {
		cancionesSeleccionadas = new LinkedList<Cancion>();
		cancionesSeleccionadas = new HashSet<Cancion>();
		int filasTotal = modelo.getRowCount();
		

		for (int fila = 0; fila < filasTotal; fila++) {
			if ((Boolean) modelo.getValueAt(fila, 3)) {
				Cancion cancion = catalogoCanciones.getCancion((String) modelo.getValueAt(fila, 0));
				cancionesSeleccionadas.add(cancion);
			}
		}
	}

	public LinkedList<Cancion> getCancionesSeleccionadas() {
	public HashSet<Cancion> getCancionesSeleccionadas() {
		return cancionesSeleccionadas;
	}
}
