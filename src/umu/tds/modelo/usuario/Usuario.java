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
	private String nombre;
	private String email;
	private LocalDate fecha;
	private String contraseña;
	private Collection<PlayList> listaPlayList;
	private Collection<Cancion> listaCancionesRecientes;
	
	private boolean premium;
	private Descuento descuento; //ns como se hace
	
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
		return listaPlayList;
	}

	public Collection<Cancion> getListaCancionesRecientes() {
		return listaCancionesRecientes;
	}

	public boolean isPremium() {
		return premium;
	}
	
	public void setPremium() {
		this.premium = true;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	//CONSTRUCTOR
	public Usuario(String nombre, String email, LocalDate fecha, String contraseña) {
		this.nombre = nombre;
		this.email = email;
		this.fecha = fecha;
		this.contraseña = contraseña;
		this.descuento = new Descuento();
		
		this.listaPlayList = new HashSet<PlayList>();
		this.listaCancionesRecientes = new LinkedHashSet<Cancion>();
		
		this.premium = false;
	}

	//METODOS
	public void addPlayList(PlayList p) {
		listaPlayList.add(p);
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

	@Override
	public int hashCode() {
		return Objects.hash(contraseña, descuento, email, fecha, listaCancionesRecientes, listaPlayList, nombre,
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
		return Objects.equals(contraseña, other.contraseña) && Objects.equals(descuento, other.descuento)
				&& Objects.equals(email, other.email) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(listaCancionesRecientes, other.listaCancionesRecientes)
				&& Objects.equals(listaPlayList, other.listaPlayList) && Objects.equals(nombre, other.nombre)
				&& premium == other.premium;
	}
}