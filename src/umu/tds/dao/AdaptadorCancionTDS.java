package umu.tds.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import beans.Entidad;
import beans.Propiedad;
import umu.tds.modelo.musica.Cancion;

//Usa un pool para evitar problemas doble referencia con ventas
public class AdaptadorCancionTDS implements IAdaptadorCancionDAO {
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorCancionTDS unicaInstancia = null;

	public static AdaptadorCancionTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorCancionTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorCancionTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	/* cuando se registra un cliente se le asigna un identificador �nico */
	public void registrarCancion(Cancion cancion) {
		
	}

	public void borrarCancion(Cancion cancion) {
		
	}

	public Cancion recuperarCancion(int codigo) {
		return null;
	}

	public List<Cancion> recuperarTodosCanciones() {
		return null;
	}

	public void modificarCancion(Cancion cancion) {
		
	}
}
