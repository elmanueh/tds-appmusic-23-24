package umu.tds.modelo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorCancionDAO;
import umu.tds.dao.IAdaptadorPlayListDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.CatalogoCanciones;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.CatalogoUsuarios;
import umu.tds.modelo.usuario.Usuario;
import umu.tds.vista.main.PlantillaMain;
import umu.tds.modelo.cargador.CancionesEvent;
import umu.tds.modelo.cargador.CancionesListener;
import umu.tds.modelo.cargador.CargadorCanciones;
import umu.tds.modelo.descuento.Descuento;

public enum Controlador implements CancionesListener {
	INSTANCIA;

	// ATRIBUTOS
	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorPlayListDAO adaptadorPlayList;
	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;

	private Usuario usuarioActual;
	private String cancionActual;
	private String playlistActual;
	private HashSet<Cancion> cancionesSeleccionadas;

	private static final String iconoParar = "/umu/tds/vista/imagenes/pausa.png";
	private static final String iconoReproducir = "/umu/tds/vista/imagenes/tocar.png";

	// CONSTRUCTOR
	private Controlador() {
		inicializarAdaptadores();
		inicializarCatalogos();
		CargadorCanciones.INSTANCIA.addCancionesListener(this);
	}

	// METODOS
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
		catalogoUsuarios = CatalogoUsuarios.INSTANCIA;
		catalogoCanciones = CatalogoCanciones.INSTANCIA;
	}

	// USUARIO
	public Boolean login(String usuarioAux, String contraseñaAux) {
		Usuario usuario = getUsuario(usuarioAux);
		if (usuario != null && usuario.getContraseña().equals(contraseñaAux)) {
			this.usuarioActual = usuario;
			ControladorVentanas.INSTANCIA.logInSatisfactorio();
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

	public String getNombreUsuarioActual() {
		return usuarioActual.getNombre();
	}

	public boolean isUsuarioActualPremium() {
		return usuarioActual.isPremium();
	}

	public Set<PlayList> getPlayListUsuarioActual() {
		return usuarioActual.getListaPlayList();
	}

	public double getCuotaUsuarioActual() {
		return usuarioActual.getCuota();
	}

	public boolean existeUsuario(String nombre_email) {
		return getUsuario(nombre_email) != null;
	}

	public boolean isCumpleañosUsuario() {
		Date fechaNacimiento = usuarioActual.getFecha();
		Date fechaActual = new Date();
		SimpleDateFormat formatoDiaMes = new SimpleDateFormat("dd-MM");

		if (formatoDiaMes.format(fechaActual).equals(formatoDiaMes.format(fechaNacimiento)))
			return true;
		return false;
	}

	public String getIconoUsuario() {
		if (usuarioActual.isPremium())
			return new String("/umu/tds/vista/imagenes/corona-de-usuario.png");
		return new String("/umu/tds/vista/imagenes/usuario.png");
	}

	// CANCION
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
				usuarioActual.getListaPlayList().stream().flatMap(pl -> pl.getListaCanciones().stream())
						.filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
						.filter(c -> c.getInterprete().toLowerCase().contains(interprete.toLowerCase()))
						.forEach(canciones::add);
			else
				usuarioActual.getListaPlayList().stream().flatMap(pl -> pl.getListaCanciones().stream())
						.filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
						.filter(c -> c.getInterprete().toLowerCase().contains(interprete.toLowerCase()))
						.filter(c -> c.getEstiloMusical().equals(estilo)).forEach(canciones::add);
		} else {
			if (estilo.equals(""))
				catalogoCanciones.getCanciones().stream()
						.filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
						.filter(c -> c.getInterprete().toLowerCase().contains(interprete.toLowerCase()))
						.forEach(canciones::add);
			else
				catalogoCanciones.getCanciones().stream()
						.filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
						.filter(c -> c.getInterprete().toLowerCase().contains(interprete.toLowerCase()))
						.filter(c -> c.getEstiloMusical().equals(estilo)).forEach(canciones::add);
		}
		return canciones;
	}

	public LinkedList<String> getEstilos() {
		LinkedList<String> estilos = (LinkedList<String>) catalogoCanciones.getCanciones().stream()
				.map(Cancion::getEstiloMusical).distinct().sorted().collect(Collectors.toCollection(LinkedList::new));
		estilos.addFirst("");
		return estilos;
	}

	// PLAYLIST
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

	public Set<Cancion> getListaCancionesPlayList(String text) {
		return getPlayList(text).getListaCanciones();
	}

	public List<Cancion> getCancionesMasReproducidas() {
		List<Cancion> listaTOP10 = catalogoCanciones.getCanciones();

		Comparator<Cancion> comparadorReproducciones = Comparator.comparingInt(Cancion::getNumReproducciones);

		Collections.sort(listaTOP10, comparadorReproducciones.reversed());

		// Obtener las 10 canciones más reproducidas
		return listaTOP10.subList(0, Math.min(10, listaTOP10.size()));
	}

	public ArrayList<Cancion> getCancionesRecientes() {
		return usuarioActual.getListaCancionesRecientes();

	}

	public void crearPlayList(String text) {
		PlayList p = new PlayList(text);
		p.addAllCanciones(cancionesSeleccionadas);

		adaptadorPlayList.registrarPlayList(p);
		usuarioActual.addPlayList(p);
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	public void anadirCancionesSelecAPL(String text) {
		PlayList p = usuarioActual.getPlayList(text);
		for (Cancion c : cancionesSeleccionadas)
			if (!p.consultarCancion(c.getTitulo()))
				p.addCancion(c);

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

	public boolean eliminarPlayList(String text) {
		PlayList p = usuarioActual.getPlayList(text);
		if (p == null)
			return false;
		usuarioActual.removePlayList(p);
		adaptadorPlayList.borrarPlayList(p);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		return true;
	}

	public boolean eliminarCancionDePlayList(String text, DefaultTableModel modelo) {
		PlayList p = usuarioActual.getPlayList(text);
		if (p == null)
			return false;
		usuarioActual.removePlayList(p);

		int filasTotal = modelo.getRowCount();

		for (int fila = 0; fila < filasTotal; fila++) {
			if ((Boolean) modelo.getValueAt(fila, 3)) {
				Cancion cancion = p.getCancion((String) modelo.getValueAt(fila, 0));
				p.removeCancion(cancion);
			}
		}

		usuarioActual.addPlayList(p);

		adaptadorPlayList.modificarPlayList(p);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		return true;
	}

	// PREMIUM
	public Descuento aplicarDescuento(String codigo) {
		return usuarioActual.aplicarDescuento(codigo);
	}

	public void configuracionPremium(boolean premium, double precio) {
		usuarioActual.setPremium(premium);
		usuarioActual.setCuota(precio);

		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	/*
	 * TABLA SELECCIONADOS
	 */
	public void setTablaSeleccionados(DefaultTableModel modelo) {
		cancionesSeleccionadas = new HashSet<Cancion>();
		int filasTotal = modelo.getRowCount();

		for (int fila = 0; fila < filasTotal; fila++) {
			if ((Boolean) modelo.getValueAt(fila, 3)) {
				Cancion cancion = catalogoCanciones.getCancion((String) modelo.getValueAt(fila, 0));
				cancionesSeleccionadas.add(cancion);
			}
		}
	}

	public HashSet<Cancion> getCancionesSeleccionadas() {
		return cancionesSeleccionadas;
	}

	public DefaultTableModel getTablaPlaylist() {
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modeloTabla.addColumn("");
		for (PlayList p : getPlayListUsuarioActual()) {
			Object[] playlist = { p.getNombre() };
			modeloTabla.addRow(playlist);
		}
		return modeloTabla;
	}

	// CARGADOR DE CANCIONES
	public void cargarCanciones() {
		String path = System.getProperty("user.dir") + File.separator + "xml";
		File inicio = new File(path);
		JFileChooser fileChooser = new JFileChooser(inicio);

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.xml)", "xml");
		fileChooser.setFileFilter(filter);

		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			CargadorCanciones.INSTANCIA.setArchivoCanciones(selectedFile.getAbsolutePath());
		}

	}

	@Override
	public void enteradoNuevasCanciones(EventObject e) {
		CancionesEvent evento = (CancionesEvent) e;
		System.out.println("ME HAN LLEGADO NUEVAS CANCIONES");

		for (umu.tds.componente.Cancion c : evento.getCanciones().getCancion()) {
			Cancion cancion = new Cancion(c.getTitulo(), c.getURL(), c.getEstilo(), c.getInterprete());
			adaptadorCancion.registrarCancion(cancion);
			catalogoCanciones.addCancion(cancion);
		}
	}

	/*
	 * REPRODUCIR CANCIONES
	 */
	public void reproducirCancion() {
		if (cancionActual != null) {
			Cancion cancion = catalogoCanciones.getCancion(cancionActual);
			cancion.addReproducciones();
			adaptadorCancion.modificarCancion(cancion);
			usuarioActual.addCancionReciente(cancion);
			adaptadorUsuario.modificarUsuario(usuarioActual);

			Reproductor.INSTANCIA.playCancion(catalogoCanciones.getCancion(cancionActual).getRutaFichero());
			if (Reproductor.INSTANCIA.isReproduciendo())
				ControladorVentanas.INSTANCIA.estadoReproductor(iconoParar);
			else
				ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
		}
	}

	public void siguienteCancion() {
		PlayList plActual = usuarioActual.getPlayList(playlistActual);
		if (plActual == null) {
			Reproductor.INSTANCIA.stopCancion();
			ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
		} else {
			int posicion = plActual.getPosicionCancionEnPlaylist(cancionActual);
			posicion++;
			Cancion cancion = plActual.getCancionEnPosicion(posicion);
			if (cancion == null) {
				Reproductor.INSTANCIA.stopCancion();
				ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
			} else {
				setCancionActual(cancion.getTitulo());
				reproducirCancion();
			}
		}
	}

	public void anteriorCancion() {
		PlayList plActual = usuarioActual.getPlayList(playlistActual);
		if (plActual == null) {
			Reproductor.INSTANCIA.stopCancion();
			ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
		} else {
			int posicion = plActual.getPosicionCancionEnPlaylist(cancionActual);
			posicion--;
			Cancion cancion = plActual.getCancionEnPosicion(posicion);
			if (cancion == null) {
				Reproductor.INSTANCIA.stopCancion();
				ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
			} else {
				setCancionActual(cancion.getTitulo());
				reproducirCancion();
			}
		}
	}

	public void setCancionActual(String cancionActual) {
		this.cancionActual = cancionActual;
	}

	public void setPlayListActual(String playlistActual) {
		this.playlistActual = playlistActual;
	}

	public void volumen(int volumen) {
		Reproductor.INSTANCIA.establecerVolumen(volumen);
	}

	public TableModel ponerTablaCancionesRecientes() {
		DefaultTableModel modelo = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modelo.addColumn("Título");
		modelo.addColumn("Estilo");
		modelo.addColumn("Interprete");
		modelo.addColumn("Número Reproducciones");
	
		for (Cancion cancion : usuarioActual.getListaCancionesRecientes()) {
			Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical(), cancion.getInterprete(), cancion.getNumReproducciones() };
			modelo.addRow(fila);
		}
		return modelo;
	}

	public TableModel ponerTablaTop10() {
		DefaultTableModel modelo = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modelo.addColumn("Título");
		modelo.addColumn("Estilo");
		modelo.addColumn("Interprete");
		modelo.addColumn("Número Reproducciones");
		
		for (Cancion cancion : getCancionesMasReproducidas()) {
			Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical(), cancion.getInterprete(), cancion.getNumReproducciones() };
			modelo.addRow(fila);
		}
		return modelo;
	}
}
