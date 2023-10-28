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
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.Usuario;

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
	
	public void registrarCancion(Cancion cancion) {
		//FALTA TRATAR LA LISTA DE INTERPRETES
		Entidad eCancion = null;
		eCancion = servPersistencia.recuperarEntidad(cancion.getCodigo());
		if (eCancion != null) return;
		
		//crear entidad cancion
		eCancion = new Entidad();
		eCancion.setNombre("cancion");
		eCancion.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(
				new Propiedad("titulo", cancion.getTitulo()),
				new Propiedad("rutaFichero", cancion.getRutaFichero()),
				new Propiedad("numeroRep", String.valueOf(cancion.getNumReproducciones())),
				new Propiedad("estiloMusical", cancion.getEstiloMusical())
				//new Propiedad("interprete", cancion.getInterprete().toString()))		
				)));
		
		// registrar entidad producto
		eCancion = servPersistencia.registrarEntidad(eCancion);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		cancion.setCodigo(eCancion.getId());
	}

	public Cancion recuperarCancion(int codigo) {	
		//FALTA TRATAR LA LISTA DE INTERPRETES
		Entidad eCancion;
		int numRep;
		String titulo;
		String rutaFichero;
		String estiloMusical;
		//List<String> interpretes = new LinkedList<String>();
		
		// si no, la recupera de la base de datos
		// recuperar entidad
		eCancion = servPersistencia.recuperarEntidad(codigo);
		
		// recuperar propiedades que no son objetos
		titulo = servPersistencia.recuperarPropiedadEntidad(eCancion, "titulo");
		rutaFichero = servPersistencia.recuperarPropiedadEntidad(eCancion, "rutaFichero");
		estiloMusical = servPersistencia.recuperarPropiedadEntidad(eCancion, "estiloMusical");
		numRep = Integer.valueOf(servPersistencia.recuperarPropiedadEntidad(eCancion, "numRep"));
		
		Cancion cancion = new Cancion(titulo, rutaFichero, estiloMusical);
		cancion.setCodigo(codigo);
		cancion.setNumReproducciones(numRep);

		return cancion;
	}

	public List<Cancion> recuperarTodosCanciones() {
		List<Entidad> eCanciones = servPersistencia.recuperarEntidades("cancion");
		List<Cancion> canciones = new LinkedList<Cancion>();

		for (Entidad eCancion : eCanciones) {
			canciones.add(recuperarCancion(eCancion.getId()));
		}
		return canciones;
	}
}
