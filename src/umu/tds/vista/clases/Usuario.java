package umu.tds.vista.clases;

import java.util.Collection;
import java.util.HashSet;

public class Usuario {
	private String nombre;
	//private String email;
	//private String fecha;
	//private String contraseña;
	private Collection<PlayList> listaPL;
	private PlayList listaR;
	
	private boolean premium;
	private Collection<Cancion> listaC;
	private Descuento descuento;

	public Usuario(String nombre_, boolean premium_, Descuento d_) {
		nombre = nombre_;
		premium = false;
		listaPL = new HashSet<PlayList>();
		listaC = new HashSet<Cancion>();
		descuento = d_;
	}

	public void realizarPago() {
		premium = true;
	}

	public void addPlayList(PlayList p) {
		listaPL.add(p);
	}

}