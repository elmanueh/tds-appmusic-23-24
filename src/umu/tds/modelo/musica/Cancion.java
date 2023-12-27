package umu.tds.modelo.musica;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Cancion
 */
public class Cancion {

	/*
	 * ATRIBUTOS
	 */
	private String titulo;
	private String rutaFichero;
	private EstiloMusical estiloMusical;
	private Interprete interprete;
	private int numReproducciones;
	private int codigo;
	private static List<Interprete> registroInterpretes = new LinkedList<>();
	private static List<EstiloMusical> registroEstilo = new LinkedList<>();

	/**
	 * Constructor de la clase Cancion.
	 * @param titulo Nombre de la Cancion
	 * @param rutaFichero Ruta donde se encuentra
	 * @param estiloMusical Estilo Musical
	 * @param interprete Interprete de la Cancion
	 */
	public Cancion(String titulo, String rutaFichero, String estiloMusical, String interprete) {
		this.titulo = titulo;
		this.rutaFichero = rutaFichero;
		this.interprete = obtenerOCrearInterprete(interprete);
		this.estiloMusical = obtenerOCrearEstilo(estiloMusical);
		this.numReproducciones = 0;
		this.codigo = 0;
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public String getTitulo() {
		return titulo;
	}

	public String getRutaFichero() {
		return rutaFichero;
	}

	public int getNumReproducciones() {
		return numReproducciones;
	}

	public void setNumReproducciones(int numReproducciones) {
		this.numReproducciones = numReproducciones;
	}

	public Interprete getInterprete() {
		return interprete;
	}

	public EstiloMusical getEstiloMusical() {
		return estiloMusical;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int id) {
		this.codigo = id;
	}

	public static LinkedList<EstiloMusical> getRegistroEstilo() {
		return new LinkedList<>(registroEstilo);
	}

	/**
	 * Metodo para incrementar el numero de reproducciones de una Cancion.
	 */
	public void añadirReproducciones() {
		numReproducciones++;
	}

	/**
	 * Metodo para obtener un Intreprete.
	 * @param interprete Nombre del interprete
	 * @return Interprete
	 */
	private Interprete obtenerOCrearInterprete(String interprete) {
		for (Interprete interpreteAux : registroInterpretes) {
			if (interpreteAux.getInterprete().equals(interprete))
				return interpreteAux;
		}
		Interprete interpreteAux = new Interprete(interprete);
		registroInterpretes.add(interpreteAux);
		return interpreteAux;
	}

	/**
	 * Metodo para obtener un Estilo Musical.
	 * @param estilo Nombre del estilo musical
	 * @return Estilo Musical
	 */
	private EstiloMusical obtenerOCrearEstilo(String estilo) {
		for (EstiloMusical estiloMusicalAux : registroEstilo) {
			if (estiloMusicalAux.getEstilo().equals(estilo))
				return estiloMusicalAux;
		}
		EstiloMusical estiloMusical = new EstiloMusical(estilo);
		registroEstilo.add(estiloMusical);
		return estiloMusical;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, estiloMusical, interprete, rutaFichero, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		return codigo == other.codigo && Objects.equals(estiloMusical, other.estiloMusical)
				&& Objects.equals(interprete, other.interprete) && Objects.equals(rutaFichero, other.rutaFichero)
				&& Objects.equals(titulo, other.titulo);
	}

}
