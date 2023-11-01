package umu.tds.dao;

import java.util.List;

import umu.tds.modelo.musica.Cancion;

public interface IAdaptadorCancionDAO {

	public void registrarCancion(Cancion cancion);

	public Cancion recuperarCancion(int codigo);

	public List<Cancion> recuperarTodasCanciones();
}
