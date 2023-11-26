package umu.tds.modelo.musica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cancion {

	// ATRIBUTOS
	private String titulo;
	private String rutaFichero;
	private EstiloMusical estiloMusical;
	private Interprete interprete;
	private int numReproducciones;
	private int codigo;

	// CONSTRUCTOR
	public Cancion(String titulo, String rutaFichero, String estiloMusical, String interprete) {
		this.titulo = titulo;
		this.rutaFichero = rutaFichero;
		this.interprete = obtenerOCrearInterprete(interprete);
		this.estiloMusical = obtenerOCrearEstilo(estiloMusical);
		this.numReproducciones = 0;
		this.codigo = 0;
	}

	private static List<Interprete> registroInterpretes = new ArrayList<>();
	private static List<EstiloMusical> registroEstilo = new ArrayList<>();

	// GETTERS AND SETTERS
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

	// METODOS
	public void addReproducciones() {
		numReproducciones++;
	}
	
	private Interprete obtenerOCrearInterprete(String inter) {
		for (Interprete i: registroInterpretes) {
			if (i.getInterprete().equals(inter))
				return i;
		}
		
		Interprete interprete = new Interprete(inter);
		registroInterpretes.add(interprete);
		return interprete;
	}
	
	private EstiloMusical obtenerOCrearEstilo(String estilo) {
		for (EstiloMusical e: registroEstilo) {
			if (e.getEstilo().equals(estilo))
				return e;
		}
		
		EstiloMusical estiloMusical = new EstiloMusical(estilo);
		registroEstilo.add(estiloMusical);
		return estiloMusical;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, estiloMusical, interprete, numReproducciones, rutaFichero, titulo);
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
				&& Objects.equals(interprete, other.interprete) && numReproducciones == other.numReproducciones
				&& Objects.equals(rutaFichero, other.rutaFichero) && Objects.equals(titulo, other.titulo);
	}
}
