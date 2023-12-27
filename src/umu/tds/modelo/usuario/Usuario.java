package umu.tds.modelo.usuario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import umu.tds.modelo.descuento.IDescuento;
import umu.tds.modelo.descuento.DescuentoNulo;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

/**
 * Clase Usuario
 */
public class Usuario {

	/*
	 * ATRIBUTOS
	 */
	public static final double TARIFA_PREMIUM = 10;
	public static final int TAMAÑO_PLAYLIST_RECIENTES = 5;
	public static final String ICONO_USUARIO_PREMIUM = "/umu/tds/vista/imagenes/corona-de-usuario.png";
	public static final String ICONO_USUARIO_NORMAL = "/umu/tds/vista/imagenes/usuario.png";

	private final String nombre;
	private final String email;
	private final Date fecha;
	private final String contraseña;
	private final LinkedHashSet<PlayList> listaPlayList;
	private PlayList playlistRecientes;
	private boolean premium;
	private int code;
	private double cuota;

	/**
	 * Constructor de la clase Usuario.
	 * @param nombre Nombre del Usuario
	 * @param email Correo del Usuario
	 * @param fecha Fecha de Nacimiento del Usuario
	 * @param contraseña Contraseña del Usuario
	 */
	public Usuario(String nombre, String email, Date fecha, String contraseña) {
		this.nombre = nombre;
		this.email = email;
		this.fecha = fecha;
		this.contraseña = contraseña;
		this.code = 0;
		this.cuota = 0;

		this.listaPlayList = new LinkedHashSet<PlayList>();
		this.playlistRecientes = new PlayList("cancionesRecientes");
		this.premium = false;
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getContraseña() {
		return contraseña;
	}

	public Set<PlayList> getListaPlayList() {
		return new LinkedHashSet<PlayList>(listaPlayList);
	}

	public PlayList getPlaylistRecientes() {
		return playlistRecientes;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	/**
	 * Comprobar si es el cumpleaños del Usuario.
	 * @return Booleano
	 */
	public boolean isCumpleaños() {
		Date fechaActual = new Date();
		SimpleDateFormat formatoDiaMes = new SimpleDateFormat("dd-MM");

		if (formatoDiaMes.format(fechaActual).equals(formatoDiaMes.format(fecha)))
			return true;
		return false;
	}

	/**
	 * Extraer el icono del Usuario.
	 * @return Icono del Usuario
	 */
	public String getIconoUsuario() {
		if (this.isPremium())
			return ICONO_USUARIO_PREMIUM;
		return ICONO_USUARIO_NORMAL;
	}
	
	/**
	 * Metodo para añadir una Cancion a la lista de CancionesRecientes.
	 * @param cancion Cancion a añadir
	 */
	public void addCancionReciente(Cancion cancion) {
		LinkedList<Cancion> canciones = new LinkedList<>(playlistRecientes.getListaCanciones());
		canciones.remove(cancion);
		canciones.addFirst(cancion);
		if (canciones.size() > TAMAÑO_PLAYLIST_RECIENTES) {
			canciones.removeLast();
		}
		playlistRecientes = new PlayList("cancionesRecientes");
		playlistRecientes.añadirTodasCanciones(new LinkedHashSet<Cancion>(canciones));
	}

	/**
	 * Metodo para crear una PlayList a un Usuario.
	 * @param playlistNombre Nombre de la PlayList
	 * @return PlayList creada
	 */
	public PlayList crearPlayList(String playlistNombre) {
		PlayList playlist = new PlayList(playlistNombre);
		this.añadirPlayList(playlist);
		return playlist;
	}
	
	/**
	 * Metodo para añadir una PlayList a un Usuario.
	 * @param playlist PlayList a añadir
	 */
	public void añadirPlayList(PlayList playlist) {
		this.listaPlayList.add(playlist);
	}
	
	/**
	 * Metodo para comprobar si una PlayList existe.
	 * @param titulo Nombre de la PlayList
	 * @return True/False
	 */
	public boolean existePlayList(String titulo) {
		for (PlayList p : listaPlayList) {
			if (p.getNombre().equals(titulo))
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo que devuelve una PlayList existente.
	 * @param nombre Nombre de la PlayList
	 * @return PlayList / Null
	 */
	public PlayList getPlayList(String nombre) {
		Optional<PlayList> playlistOpcional = listaPlayList.stream().filter(playlist -> playlist.getNombre().equals(nombre)).findFirst();
		return playlistOpcional.orElse(null);
	}
	
	/**
	 * Metodo para añadir Canciones a una PlayList.
	 * @param playlistNombre Nombre de la PlayList
	 * @param listaCanciones Lista de Canciones
	 * @return PlayList modificada
	 */
	public PlayList añadirCancionesToPlayList(String playlistNombre, LinkedHashSet<Cancion> listaCanciones) {
		PlayList playlist = this.getPlayList(playlistNombre);
		playlist.añadirTodasCanciones(listaCanciones);
		return playlist;
	}
	
	/**
	 * Metodo para eliminar una PlayList
	 * @param playlistNombre Nombre de la PlayList
	 */
	public void eliminarPlayList(String playlistNombre) {
		PlayList playlist = this.getPlayList(playlistNombre);
		System.out.println(listaPlayList.contains(playlist));
		this.listaPlayList.remove(playlist);
	}

	/**
	 * Metodo para aplicar un Descuento al Usuario.
	 * @param codigo Codigo de Promoción
	 * @return Mejor Descuento a aplicar
	 */
	public IDescuento aplicarDescuento(String codigo) {
		return IDescuento.descuentos(codigo).stream()
				.filter(d -> d.isAplicable(this))
				.reduce((d1, d2) -> d1.Precio() < d2.Precio() ? d1 : d2).orElse(new DescuentoNulo());
	}

	@Override
	public int hashCode() {
		return Objects.hash(contraseña, email, fecha, playlistRecientes, listaPlayList, nombre, premium);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contraseña, other.contraseña) && Objects.equals(email, other.email)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(playlistRecientes, other.playlistRecientes)
				&& Objects.equals(listaPlayList, other.listaPlayList) && Objects.equals(nombre, other.nombre)
				&& premium == other.premium;
	}
}