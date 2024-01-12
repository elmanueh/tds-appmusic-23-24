package umu.tds;

import java.io.IOException;
import java.util.Date;
import java.util.EventObject;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

import com.itextpdf.text.DocumentException;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorCancionDAO;
import umu.tds.dao.IAdaptadorPlayListDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;
import umu.tds.github.LoginGitHub;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.CatalogoCanciones;
import umu.tds.modelo.musica.EstiloMusical;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.reproductor.ModoAleatorio;
import umu.tds.modelo.reproductor.ModoBucleCancion;
import umu.tds.modelo.reproductor.ModoLibre;
import umu.tds.modelo.reproductor.IModoReproduccion;
import umu.tds.modelo.reproductor.ModoSecuencial;
import umu.tds.modelo.reproductor.Reproductor;
import umu.tds.modelo.usuario.CatalogoUsuarios;
import umu.tds.modelo.usuario.Usuario;
import umu.tds.cargador.CancionesEvent;
import umu.tds.cargador.CancionesListener;
import umu.tds.cargador.CargadorCanciones;

public enum Controlador implements CancionesListener {
	INSTANCIA;

	/*
	 * ATRIBUTOS
	 */
	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorPlayListDAO adaptadorPlayList;
	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;

	private Usuario usuarioActual;
	private String cancionSeleccionada, cancionReproduciendo, playlistSeleccionada, playlistReproduciendo;
	private LinkedHashSet<Cancion> cancionesSeleccionadas;
	
	private IModoReproduccion modoReproduccion;

	/**
	 * Constructor de la clase Controlador.
	 */
	private Controlador() {
		inicializarAdaptadores();
		inicializarCatalogos();
		CargadorCanciones.INSTANCIA.addCancionesListener(this);

		cancionesSeleccionadas = new LinkedHashSet<>();
		cancionReproduciendo = "None";
		playlistReproduciendo = "None";
		modoReproduccion = new ModoLibre();
	}

	/**
	 * Metodo para inicializar los Adaptadores.
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

	/**
	 * Metodo para inicializar los Catalogos.
	 */
	private void inicializarCatalogos() {
		catalogoUsuarios = CatalogoUsuarios.INSTANCIA;
		catalogoCanciones = CatalogoCanciones.INSTANCIA;
	}

	// =======================================
	// =============== USUARIO ===============
	// =======================================
	
	/**
	 * Metodo para iniciar sesion en la aplicacion.
	 * @param usuarioAux Nombre de usuario
	 * @param contraseñaAux Contraseña
	 * @return True / False
	 */
	public Boolean login(String usuarioAux, String contraseñaAux) {
		Usuario usuario = catalogoUsuarios.getUsuario(usuarioAux);
		if (usuario != null && usuario.getContraseña().equals(contraseñaAux)) {
			usuarioActual = usuario;
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo para iniciar sesion con GitHub en la aplicacion.
	 * @param nombreUsuario Nombre de usuario
	 * @param githubPropertiesPath Ruta del archivo con la clave
	 * @return True / False
	 */
	public Boolean loginGitHub(String nombreUsuario, String githubPropertiesPath) {
		if (LoginGitHub.INSTANCE.verificar(nombreUsuario, githubPropertiesPath) && existeUsuario(nombreUsuario)) {
			usuarioActual = catalogoUsuarios.getUsuario(nombreUsuario);
			return true;
		}
		else
			return false;
	}

	/**
	 * Metodo para registrar un Usuario en la aplicacion.
	 * @param nombre Nombre del usuario
	 * @param email Correo del usuario
	 * @param fecha Fecha de nacimiento
	 * @param contraseña Contraseña del usuario
	 */
	public void registrarUsuario(String nombre, String email, Date fecha, String contraseña) {
		Usuario usuario = new Usuario(nombre, email, fecha, contraseña);
		this.usuarioActual = usuario;
		adaptadorUsuario.registrarUsuario(usuario);
		catalogoUsuarios.addUsuario(usuario);
	}

	/**
	 * Metodo para comprobar si un Usuario ya existe.
	 * @param nombre_email Nombre/Correo del Usuario
	 * @return True / False
	 */
	public boolean existeUsuario(String nombre_email) {
		return catalogoUsuarios.getUsuario(nombre_email) != null;
	}

	/**
	 * Metodo que devuelve el Usuario conectado actualmente.
	 * @return Usuario conectado
	 */
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	/**
	 * Metodo para establecer si el Usuario es Premium o no.
	 * @param premium Estado de la subscripcion.
	 * @param cuota Precio a pagar.
	 */
	public void usuarioEstablecerPremium(boolean premium, double cuota) {
		usuarioActual.setPremium(premium);
		usuarioActual.setCuota(cuota);
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	/**
	 * Metodo para cerrar la sesion del Usuario actual.
	 */
	public void cerrarSesion() {
		cancionesSeleccionadas.clear();
		cancionSeleccionada = null;
		cancionReproduciendo = "None";
		playlistSeleccionada = null;
		playlistReproduciendo = "None";
		Reproductor.INSTANCIA.stopCancion();
	}

	// =======================================
	// =============== PLAYLIST ==============
	// =======================================
	
	/**
	 * Metodo para crear una PlayList con canciones.
	 * @param playlistNombre Nombre de la PlayList
	 * @return PlayList creada
	 */
	public PlayList crearPlaylist(String playlistNombre) {
		PlayList playlist = usuarioActual.getPlayList(playlistNombre);
		if (playlist == null) {
			playlist = usuarioActual.crearPlayList(playlistNombre);
			adaptadorPlayList.registrarPlayList(playlist);
		}
		usuarioActual.añadirCancionesToPlayList(playlistNombre, cancionesSeleccionadas);
		adaptadorPlayList.modificarPlayList(playlist);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		cancionesSeleccionadas.clear();
		return playlist;
	}

	/**
	 * Metodo para eliminar una PlayList
	 * @param playlistNombre Nombre de la PlayList
	 */
	public void eliminarPlayList(String playlistNombre) {
		PlayList playlist = usuarioActual.getPlayList(playlistNombre);
		if (playlist != null) {
			usuarioActual.eliminarPlayList(playlistNombre);
			adaptadorPlayList.borrarPlayList(playlist);
			adaptadorUsuario.modificarUsuario(usuarioActual);
		}
	}

	/**
	 * Metodo para eliminar una Cancion de la PlayList
	 * @param playlistNombre Nombre de la PlayList
	 * @param cancionNombre Nombre de la Cancion
	 * @return PlayList modificada
	 */
	public PlayList eliminarCancionDePlayList(String playlistNombre, String cancionNombre) {
		PlayList playlist = usuarioActual.getPlayList(playlistNombre);
		if (playlist == null)
			return null;
		Cancion cancion = playlist.getCancion(cancionNombre);
		playlist.eliminarCancion(cancion);
		adaptadorPlayList.modificarPlayList(playlist);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		return playlist;
	}

	// =======================================
	// =============== CANCION ===============
	// =======================================
	
	/**
	 * Metodo para obtener nuevas canciones añadidas a traves de un evento.
	 */
	@Override
	public void enteradoNuevasCanciones(EventObject e) {
		CancionesEvent evento = (CancionesEvent) e;
		for (umu.tds.componente.Cancion c : evento.getCanciones().getCancion()) {
			Cancion cancion = new Cancion(c.getTitulo(), c.getURL(), c.getEstilo(), c.getInterprete());
			adaptadorCancion.registrarCancion(cancion);
			catalogoCanciones.addCancion(cancion);
		}
	}

	/**
	 * Metodo para cargar las canciones de un archivo XML.
	 * @param selectedFile Ruta del fichero XML
	 */
	public void cargarCanciones(String selectedFile) {
		CargadorCanciones.INSTANCIA.setArchivoCanciones(selectedFile);
	}

	/**
	 * Metodo para obtener los estilos musicales de las Canciones.
	 * @return Lista de Estilos Musicales
	 */
	public LinkedList<String> getEstilos() {
		LinkedList<String> nombresEstilos = Cancion.getRegistroEstilo().stream()
				.map(EstiloMusical::getEstilo)
				.collect(Collectors.toCollection(LinkedList::new));
		nombresEstilos.addFirst("");
		return nombresEstilos;
	}

	/**
	 * Metodo para obtener las canciones que satisfacen el filtro.
	 * @param titulo Nombre o parte del nombre de la Cancion
	 * @param interprete Nombre o parte nombre del Interprete
	 * @param estilo Nombre del estilo musical
	 * @param favorito Si queremos que se seleccionen de las que tenemos en alguna PlayList
	 * @return Lista de Canciones que satisfacen el filtro
	 */
	public LinkedList<Cancion> getCancionesFiltradas(String titulo, String interprete, String estilo, boolean favorito) {
		LinkedList<Cancion> canciones = new LinkedList<>();
		Stream<Cancion> cancionStream;
		if (favorito) {
			cancionStream = usuarioActual.getListaPlayList().stream()
					.flatMap(pl -> pl.getListaCanciones().stream());
		} else {
			cancionStream = catalogoCanciones.getCanciones().stream();
		}

		canciones = cancionStream.filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
				.filter(c -> c.getInterprete().getInterprete().toLowerCase().contains(interprete.toLowerCase()))
				.filter(c -> estilo.isEmpty() || c.getEstiloMusical().getEstilo().equals(estilo))
				.collect(Collectors.toCollection(LinkedList::new));
		return canciones;
	}

	/**
	 * Metodo que obtiene las canciones mas reproducidas entre todos los Usuarios.
	 * @return Lista de Canciones
	 */
	public List<Cancion> getCancionesMasReproducidas() {
		return catalogoCanciones.getCanciones().stream()
				.filter(c -> c.getNumReproducciones() > 0)
				.sorted(Comparator.comparingInt(Cancion::getNumReproducciones).reversed())
				.limit(10)
				.collect(Collectors.toList());
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
		return cancionReproduciendo;
	}

	public String getPlaylistReproduciendo() {
		return playlistReproduciendo;
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
	
	/*
	 * Metodo para reproducir una cancion seleccionada.
	 */
	public boolean reproducirCancion() {
		if (playlistSeleccionada != null && cancionSeleccionada != null) {
			playlistReproduciendo = playlistSeleccionada;
			cancionReproduciendo = cancionSeleccionada;
		}

		if (cancionReproduciendo != "None") {
			Reproductor.INSTANCIA.playCancion(catalogoCanciones.getCancion(cancionReproduciendo).getRutaFichero());
			if (Reproductor.INSTANCIA.isReproduciendo()) {
				Cancion cancion = catalogoCanciones.getCancion(cancionReproduciendo);
				cancion.añadirReproducciones();
				adaptadorCancion.modificarCancion(cancion);
				usuarioActual.addCancionReciente(cancion);
				adaptadorUsuario.modificarUsuario(usuarioActual);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * Metodo para obtener la siguiente cancion a reproducir.
	 * @return True / False (si existe siguiente Cancion)
	 */
	public boolean siguienteCancion() {
		PlayList playlistActual = usuarioActual.getPlayList(playlistReproduciendo);
		Cancion cancionSiguiente;
		if (playlistActual == null)
			cancionSiguiente = null;
		else
			cancionSiguiente = modoReproduccion.siguienteCancion(playlistActual, cancionReproduciendo);
		Reproductor.INSTANCIA.stopCancion();
		if (cancionSiguiente == null) {
			playlistReproduciendo = "None";
			cancionReproduciendo = "None";
			return false;
		}
		setPlayListSeleccionada(playlistReproduciendo);
		setCancionSeleccionada(cancionSiguiente.getTitulo());
		reproducirCancion();
		return true;
	}
 
	/**
	 * Metodo para obtener la anterior cancion a reproducir.
	 * @return True / False (si existe siguiente Cancion)
	 */
	public boolean anteriorCancion() {
		PlayList playlistActual = usuarioActual.getPlayList(playlistReproduciendo);
		Cancion cancionAnterior;
		if (playlistActual == null)
			cancionAnterior = null;
		else
			cancionAnterior = modoReproduccion.anteriorCancion(playlistActual, cancionReproduciendo);
		Reproductor.INSTANCIA.stopCancion();
		if (cancionAnterior == null) {
			playlistReproduciendo = "None";
			cancionReproduciendo = "None";
			return false;
		}
		setPlayListSeleccionada(playlistReproduciendo);
		setCancionSeleccionada(cancionAnterior.getTitulo());
		reproducirCancion();
		return true;
	}

	/**
	 * Metodo para establecer el volumen del Reproductor.
	 * @param volumen Volumen para establecer
	 */
	public void volumen(int volumen) {
		Reproductor.INSTANCIA.establecerVolumen(volumen);
	}

	/**
	 * Metodo para obtener la duracion total de la Cancion en segundos.
	 * @return Numero de segundos de la Cancion
	 */
	public int getTiempoCancion() {
		return (int) Reproductor.INSTANCIA.getDuracionCancion();
	}
	
	/**
	 * Metodo para establecer el modo aleatorio en el reproductor.
	 */
	public void setModoAleatorioReproduccion() {
		if (!(this.modoReproduccion instanceof ModoAleatorio)) {
			this.modoReproduccion = new ModoAleatorio();
		} else {
			this.modoReproduccion = new ModoLibre();
		}
	}
	
	/**
	 * Metodo para establecer el modo secuencial en el reproductor.
	 */
	public void setModoSecuencialReproduccion() {
		if (this.modoReproduccion instanceof ModoSecuencial) {
			this.modoReproduccion = new ModoBucleCancion();
		} else if (this.modoReproduccion instanceof ModoBucleCancion) {
			this.modoReproduccion = new ModoLibre();
		} else {
			this.modoReproduccion = new ModoSecuencial();
		}
	}
	
	/**
	 * Metodo para obtener el modo de reproduccion.
	 * @return Cadena con el modo de reproduccion
	 */
	public String getModoReproduccion() {
		return modoReproduccion.getModoReproduccion();
	}
	
	// =======================================
	// ============= GENERAR PDF =============
	// =======================================
	
	/**
	 * Metodo para generar el PDF con las PlayList del usuario.
	 * @param ruta Ruta donde se creara el archivo
	 * @throws IOException
	 * @throws DocumentException
	 */
	public void generarPDF(String ruta) throws IOException, DocumentException {
		CreadorPDF.generarPDF(usuarioActual, ruta);
	}
}