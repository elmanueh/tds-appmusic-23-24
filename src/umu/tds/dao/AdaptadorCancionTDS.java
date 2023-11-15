package umu.tds.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import beans.Entidad;
import beans.Propiedad;
import umu.tds.modelo.musica.Cancion;

public enum AdaptadorCancionTDS implements IAdaptadorCancionDAO {
	INSTANCIA;

	// ATRIBUTOS
	private ServicioPersistencia servPersistencia;

	// CONSTRUCTOR
	private AdaptadorCancionTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	// METODOS
	public void registrarCancion(Cancion cancion) {
		Entidad eCancion = null;
		eCancion = servPersistencia.recuperarEntidad(cancion.getCodigo());

		if (eCancion != null)
			return;

		eCancion = new Entidad();
		eCancion.setNombre("cancion");
		eCancion.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("titulo", cancion.getTitulo()),
				new Propiedad("rutaFichero", cancion.getRutaFichero()),
				new Propiedad("numeroRep", String.valueOf(cancion.getNumReproducciones())),
				new Propiedad("estiloMusical", cancion.getEstiloMusical()),
				new Propiedad("interprete", cancion.getInterprete()))));

		eCancion = servPersistencia.registrarEntidad(eCancion);
		cancion.setCodigo(eCancion.getId());
	}

	public Cancion recuperarCancion(int codigo) {
		Entidad eCancion;
		int numRep;
		String titulo;
		String rutaFichero;
		String estiloMusical;
		String interprete;

		eCancion = servPersistencia.recuperarEntidad(codigo);

		titulo = servPersistencia.recuperarPropiedadEntidad(eCancion, "titulo");
		rutaFichero = servPersistencia.recuperarPropiedadEntidad(eCancion, "rutaFichero");
		estiloMusical = servPersistencia.recuperarPropiedadEntidad(eCancion, "estiloMusical");
		interprete = servPersistencia.recuperarPropiedadEntidad(eCancion, "interprete");
		numRep = Integer.valueOf(servPersistencia.recuperarPropiedadEntidad(eCancion, "numeroRep"));

		Cancion cancion = new Cancion(titulo, rutaFichero, estiloMusical, interprete);
		cancion.setCodigo(codigo);
		cancion.setNumReproducciones(numRep);

		return cancion;
	}

	public List<Cancion> recuperarTodasCanciones() {
		List<Entidad> eCanciones = servPersistencia.recuperarEntidades("cancion");
		List<Cancion> canciones = new LinkedList<Cancion>();

		for (Entidad eCancion : eCanciones) {
			canciones.add(recuperarCancion(eCancion.getId()));
		}
		return canciones;
	}

	@Override
	public void modificarCancion(Cancion c) {
		// TODO Auto-generated method stub
		
	}

}
