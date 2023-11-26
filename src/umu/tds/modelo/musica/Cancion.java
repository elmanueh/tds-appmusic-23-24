package umu.tds.modelo.musica;

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
	public Cancion(String titulo, String rutaFichero, EstiloMusical estiloMusical, Interprete interprete) {
		this.titulo = titulo;
		this.rutaFichero = rutaFichero;
		this.interprete = interprete;
		this.estiloMusical = estiloMusical;
		this.numReproducciones = 0;
		this.codigo = 0;
	}

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
