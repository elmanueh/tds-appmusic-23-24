package umu.tds.modelo.usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

import umu.tds.modelo.descuento.Descuento;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public class Usuario {
	public static final double TARIFA_PREMIUM = 10;
	private static final int MAX = 5;
	//ATRIBUTOS
	private final String nombre;
	private final String email;
	private final LocalDate fecha;
	private final String contraseña;
	private final Collection<PlayList> listaPlayList;
	private final Collection<Cancion> listaCancionesRecientes;
	private int code;
	private boolean premium;
	
	//GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getContraseña() {
		return contraseña;
	}

	public Collection<PlayList> getListaPlayList() {
		return new HashSet<PlayList>(listaPlayList);
	}

	public Collection<Cancion> getListaCancionesRecientes() {
		return new LinkedHashSet<Cancion>(listaCancionesRecientes);
	}

	public boolean isPremium() {
		return premium;
	}
	
	public void setPremium(boolean b) {
		this.premium = b;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	

	//CONSTRUCTOR
	public Usuario(String nombre, String email, LocalDate fecha, String contraseña) {
		this.nombre = nombre;
		this.email = email;
		this.fecha = fecha;
		this.contraseña = contraseña;
		this.code = 0;
		
		this.listaPlayList = new HashSet<PlayList>();
		this.listaCancionesRecientes = new LinkedHashSet<Cancion>();
		
		this.premium = false;
	}

	//METODOS
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
	
	public void addCancionReciente(Cancion c) {
		List<Cancion> listaRecienteActualizado = new ArrayList<Cancion>();
		listaRecienteActualizado.add(c);
		listaRecienteActualizado.addAll(listaCancionesRecientes);
		if (listaRecienteActualizado.size()>MAX) {
			listaRecienteActualizado.remove(MAX);
		}
		listaCancionesRecientes.clear();
		listaCancionesRecientes.addAll(listaRecienteActualizado);
	}
	
	public PlayList crearPlayList(String nombre, List<Cancion> canciones) {
		PlayList pl = new PlayList(nombre);
		for (Cancion c : canciones) {
			pl.addCancion(c);
		}
		
		listaPlayList.add(pl);
		return pl;
	}
	//FALTA TERMINARLO
	/*public Descuento hacerDescuento() {
		return Descuento.descuentos().stream()
				.filter(d -> d.isAplicable(this))
	}*/

	@Override
	public int hashCode() {
		return Objects.hash(contraseña, email, fecha, listaCancionesRecientes, listaPlayList, nombre,
				premium);
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
		return Objects.equals(contraseña, other.contraseña)
				&& Objects.equals(email, other.email) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(listaCancionesRecientes, other.listaCancionesRecientes)
				&& Objects.equals(listaPlayList, other.listaPlayList) && Objects.equals(nombre, other.nombre)
				&& premium == other.premium;
	}
}