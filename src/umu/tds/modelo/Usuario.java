package umu.tds.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Usuario {
	private static final int MAX = 10;
	//ATRIBUTOS
	private String nombre;
	private String email;
	private String fecha;
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

	public String getFecha() {
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
	public Usuario(String nombre, String email, String fecha, String contraseña) {
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

}