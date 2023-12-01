package umu.tds.modelo;

import java.io.File;
import java.util.Date;
import java.util.EventObject;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorCancionDAO;
import umu.tds.dao.IAdaptadorPlayListDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.CatalogoCanciones;
import umu.tds.modelo.musica.EstiloMusical;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.reproductor.ModoAleatorio;
import umu.tds.modelo.reproductor.ModoLibre;
import umu.tds.modelo.reproductor.ModoReproduccion;
import umu.tds.modelo.reproductor.ModoSecuencial;
import umu.tds.modelo.reproductor.Reproductor;
import umu.tds.modelo.usuario.CatalogoUsuarios;
import umu.tds.modelo.usuario.Usuario;
import umu.tds.modelo.cargador.CancionesEvent;
import umu.tds.modelo.cargador.CancionesListener;
import umu.tds.modelo.cargador.CargadorCanciones;

public enum Controlador implements CancionesListener {
	INSTANCIA;

	// ATRIBUTOS
	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorPlayListDAO adaptadorPlayList;
	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;

	private Usuario usuarioActual;
	private String cancionSeleccionada, cancionReproducciendo, playlistSeleccionada, playlistReproducciendo;
	private LinkedHashSet<Cancion> cancionesSeleccionadas;
	private String estadoReproductor;
	private static final String iconoParar = "/umu/tds/vista/imagenes/pausa.png";
	private static final String iconoReproducir = "/umu/tds/vista/imagenes/tocar.png";
	
	private ModoReproduccion modoReproduccion;

	// CONSTRUCTOR
	private Controlador() {
		inicializarAdaptadores();
		inicializarCatalogos();
		CargadorCanciones.INSTANCIA.addCancionesListener(this);

		cancionesSeleccionadas = new LinkedHashSet<>();
		estadoReproductor = iconoReproducir;
		cancionReproducciendo = "None";
		playlistReproducciendo = "None";
		modoReproduccion = new ModoLibre();
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

	// =======================================
	// =============== USUARIO ===============
	// =======================================
	public Boolean login(String usuarioAux, String contraseñaAux) {
		Usuario usuario = catalogoUsuarios.getUsuario(usuarioAux);
		if (usuario != null && usuario.getContraseña().equals(contraseñaAux)) {
			usuarioActual = usuario;
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

	public boolean existeUsuario(String nombre_email) {
		return catalogoUsuarios.getUsuario(nombre_email) != null;
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void cerrarSesion() {
		cancionesSeleccionadas.clear();
		cancionSeleccionada = null;
		cancionReproducciendo = "None";
		playlistSeleccionada = null;
		playlistReproducciendo = "None";
		Reproductor.INSTANCIA.stopCancion();
		estadoReproductor = iconoReproducir;
		ControladorVentanas.INSTANCIA.logOutSatisfactorio();
	}

	// =======================================
	// =============== PLAYLIST ==============
	// =======================================
	public PlayList crearPlaylist(String playlistNombre) {
		PlayList playlist = usuarioActual.getPlayList(playlistNombre);
		if (playlist == null) {
			playlist = new PlayList(playlistNombre);
			adaptadorPlayList.registrarPlayList(playlist);
			usuarioActual.addPlayList(playlist);
		}
		playlist.addAllCanciones(cancionesSeleccionadas);
		adaptadorPlayList.modificarPlayList(playlist);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		cancionesSeleccionadas.clear();
		ControladorVentanas.INSTANCIA.reiniciarPlantillaMain();
		return playlist;
	}

	public void eliminarPlayList(String playlistNombre) {
		PlayList playlist = usuarioActual.getPlayList(playlistNombre);
		if (playlist != null) {
			usuarioActual.removePlayList(playlist);
			adaptadorPlayList.borrarPlayList(playlist);
			adaptadorUsuario.modificarUsuario(usuarioActual);
		}
		ControladorVentanas.INSTANCIA.reiniciarPlantillaMain();
	}

	public PlayList eliminarCancionDePlayList(String playlistNombre, String cancionNombre) {
		PlayList playlist = usuarioActual.getPlayList(playlistNombre);
		if (playlist == null)
			return null;
		Cancion cancion = playlist.getCancion(cancionNombre);
		playlist.removeCancion(cancion);
		adaptadorPlayList.modificarPlayList(playlist);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		return playlist;
	}

	// =======================================
	// =============== CANCION ===============
	// =======================================
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

	public LinkedList<String> getEstilos() {
		LinkedList<String> nombresEstilos = Cancion.getRegistroEstilo().stream().map(EstiloMusical::getEstilo)
				.collect(Collectors.toCollection(LinkedList::new));
		nombresEstilos.addFirst("");
		return nombresEstilos;
	}

	public LinkedList<Cancion> getCancionesFiltradas(String titulo, String interprete, String estilo,
			boolean favorito) {
		LinkedList<Cancion> canciones = new LinkedList<>();
		Stream<Cancion> cancionStream;
		if (favorito) {
			cancionStream = usuarioActual.getListaPlayList().stream().flatMap(pl -> pl.getListaCanciones().stream());
		} else {
			cancionStream = catalogoCanciones.getCanciones().stream();
		}

		canciones = cancionStream.filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
				.filter(c -> c.getInterprete().getInterprete().toLowerCase().contains(interprete.toLowerCase()))
				.filter(c -> estilo.isEmpty() || c.getEstiloMusical().getEstilo().equals(estilo))
				.collect(Collectors.toCollection(LinkedList::new));
		return canciones;
	}

	public List<Cancion> getCancionesMasReproducidas() {
		List<Cancion> listaTOP10 = catalogoCanciones.getCanciones();
		listaTOP10 = listaTOP10.stream().filter(c -> c.getNumReproducciones() > 0)
				.sorted(Comparator.comparingInt(Cancion::getNumReproducciones).reversed()).collect(Collectors.toList());
		return listaTOP10.subList(0, Math.min(10, listaTOP10.size()));
	}

	// =======================================
	// ========== GETTERS Y SETTERS ==========
	// =======================================
	public void setPlayListSeleccionada(String playlistSeleccionada) {
		this.playlistSeleccionada = playlistSeleccionada;
		cancionSeleccionada = null;
	}

	public void setCancionSeleccionada(String cancionSeleccionada) {
		this.cancionSeleccionada = cancionSeleccionada;
	}

	public String getCancionReproduciendo() {
		return cancionReproducciendo;
	}

	public String getPlaylistReproduciendo() {
		return playlistReproducciendo;
	}

	public String getEstadoReproductor() {
		return estadoReproductor;
	}

	public void configuracionPremium() {
		ControladorVentanas.INSTANCIA.iniciarModoPremium();
	}

	public void usuarioEstablecerPremium(boolean premium, double cuota) {
		usuarioActual.setPremium(premium);
		usuarioActual.setCuota(cuota);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		ControladorVentanas.INSTANCIA.usuarioPremium(premium);
	}

	public void añadirCancionSeleccionada(String cancionNombre) {
		cancionesSeleccionadas.add(catalogoCanciones.getCancion(cancionNombre));
	}

	public LinkedHashSet<Cancion> getCancionesSeleccionadas() {
		return cancionesSeleccionadas;
	}

	// =======================================
	// ============= REPRODUCTOR =============
	// =======================================
	public void reproducirCancion() {
		if (playlistSeleccionada != null && cancionSeleccionada != null) {
			playlistReproducciendo = playlistSeleccionada;
			cancionReproducciendo = cancionSeleccionada;
		}

		if (cancionReproducciendo != "None") {
			Reproductor.INSTANCIA.playCancion(catalogoCanciones.getCancion(cancionReproducciendo).getRutaFichero());
			if (Reproductor.INSTANCIA.isReproduciendo()) {
				Cancion cancion = catalogoCanciones.getCancion(cancionReproducciendo);
				cancion.addReproducciones();
				adaptadorCancion.modificarCancion(cancion);
				usuarioActual.addCancionReciente(cancion);
				adaptadorUsuario.modificarUsuario(usuarioActual);
				estadoReproductor = iconoParar;
			} else {
				estadoReproductor = iconoReproducir;
			}
		}
	}

	public boolean siguienteCancion() {
		PlayList playlistActual = usuarioActual.getPlayList(playlistReproducciendo);
		Cancion cancionSiguiente = modoReproduccion.siguienteCancion(playlistActual, cancionReproducciendo);
		if (cancionSiguiente == null) {
			Reproductor.INSTANCIA.stopCancion();
			estadoReproductor = iconoReproducir;
			return false;
		}
		setPlayListSeleccionada(playlistReproducciendo);
		setCancionSeleccionada(cancionSiguiente.getTitulo());
		reproducirCancion();
		return true;
	}

	public boolean anteriorCancion() {
		PlayList playlistActual = usuarioActual.getPlayList(playlistReproducciendo);
		Cancion cancionAnterior = modoReproduccion.anteriorCancion(playlistActual, cancionReproducciendo);
		if (cancionAnterior == null) {
			Reproductor.INSTANCIA.stopCancion();
			estadoReproductor = iconoReproducir;
			return false;
		}
		setPlayListSeleccionada(playlistReproducciendo);
		setCancionSeleccionada(cancionAnterior.getTitulo());
		reproducirCancion();
		return true;
	}

	public void volumen(int volumen) {
		Reproductor.INSTANCIA.establecerVolumen(volumen);
	}

	public int getTiempoCancion() {
		return (int) Reproductor.INSTANCIA.getDuracionCancion();
	}

	public void setModoActual(String modoReproduccion) {
		switch (modoReproduccion){
			case "secuencial":
				if (!(this.modoReproduccion instanceof ModoSecuencial)) {
					this.modoReproduccion = new ModoSecuencial();
					return;
				}
				break;
			case "aleatorio":
				if (!(this.modoReproduccion instanceof ModoAleatorio)) {
					this.modoReproduccion = new ModoAleatorio();
					return;
				}
				break;
		}
		this.modoReproduccion = new ModoLibre();
	}
	
	public String getModoReproduccion() {
		return modoReproduccion.getClass().getSimpleName();
	}
}