package umu.tds.modelo.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import umu.tds.modelo.descuento.Descuento;
import umu.tds.modelo.descuento.DescuentoNulo;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public class Usuario {

	// ATRIBUTOS
	public static final double TARIFA_PREMIUM = 10;
	public static final int MAX = 5;

	private final String nombre;
	private final String email;
	private final Date fecha;
	private final String contraseña;
	private final HashSet<PlayList> listaPlayList;
	private final ArrayList<Cancion> listaCancionesRecientes;
	private boolean premium;
	private int code;
	private double cuota;

	// CONSTRUCTOR
	public Usuario(String nombre, String email, Date fecha, String contraseña) {
		this.nombre = nombre;
		this.email = email;
		this.fecha = fecha;
		this.contraseña = contraseña;
		this.code = 0;
		this.cuota = 0;

		this.listaPlayList = new HashSet<PlayList>();
		this.listaCancionesRecientes = new ArrayList<Cancion>();

		this.premium = false;
	}

	// GETTERS AND SETTERS
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
		return new HashSet<PlayList>(listaPlayList);
	}

	public LinkedHashSet<Cancion> getListaCancionesRecientes() {
		return new LinkedHashSet<Cancion>(listaCancionesRecientes);
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

	// METODOS
	public void addPlayList(PlayList p) {
		listaPlayList.add(p);
	}

	public PlayList getPlayList(String nombre) {
		for (PlayList p : listaPlayList) {
			if (p.getNombre().equals(nombre))
				return p;
		}
		return null;
	}

	public void removePlayList(PlayList p) {
		listaPlayList.remove(p);
	}

	public void addCancionReciente(Cancion cancion) {
		List<Cancion> listaRecienteActualizado = new ArrayList<Cancion>();
		listaRecienteActualizado.add(cancion);
		for (Cancion c: listaCancionesRecientes)
			listaRecienteActualizado.add(c);
		if (listaRecienteActualizado.size() > MAX) {
			listaRecienteActualizado.remove(MAX);
		}
		listaCancionesRecientes.clear();
		listaCancionesRecientes.addAll(listaRecienteActualizado);
	}

	public PlayList crearPlayList(String nombre, HashSet<Cancion> canciones) {
		PlayList playlist = new PlayList(nombre);
		playlist.addAllCanciones(canciones);
		this.addPlayList(playlist);
		return playlist;
	}

	public Descuento aplicarDescuento(String codigo) {
		return Descuento.descuentos(codigo).stream().filter(d -> d.isAplicable(this))
				.reduce((d1, d2) -> d1.Precio() < d2.Precio() ? d1 : d2).orElse(new DescuentoNulo());
	}

	@Override
	public int hashCode() {
		return Objects.hash(contraseña, email, fecha, listaCancionesRecientes, listaPlayList, nombre, premium);
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
				&& Objects.equals(fecha, other.fecha)
				&& Objects.equals(listaCancionesRecientes, other.listaCancionesRecientes)
				&& Objects.equals(listaPlayList, other.listaPlayList) && Objects.equals(nombre, other.nombre)
				&& premium == other.premium;
	}
}