package umu.tds.modelo.musica;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cancion {
	//ATRIBUTOS
	private String titulo;
	private String rutaFichero;
	private int numReproducciones;
	private List<String> interprete;
	private String estiloMusical;
	
	//GETTERS AND SETTERS
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getRutaFichero() {
		return rutaFichero;
	}

	public void setRutaFichero(String rutaFichero) {
		this.rutaFichero = rutaFichero;
	}

	public int getNumReproducciones() {
		return numReproducciones;
	}

	public void setNumReproducciones(int numReproducciones) {
		this.numReproducciones = numReproducciones;
	}

	public List<String> getInterprete() {
		return interprete;
	}

	public void setInterprete(List<String> interprete) {
		this.interprete = interprete;
	}

	public String getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(String estiloMusical) {
		this.estiloMusical = estiloMusical;
	}

	//CONSTRUCTOR
	public Cancion(String titulo, String rutaFichero, String estiloMusical, String ...interpretes) {
		this.titulo = titulo;
		this.rutaFichero = rutaFichero;
		this.numReproducciones = 0;
		Collections.addAll(interprete,interpretes);
		this.estiloMusical = estiloMusical;
	}
	
	//METODOS
	public boolean contieneEstilo(String e) {
		return this.estiloMusical.equals(e);
	}
	
	public boolean contieneInterprete(String i) {
		return this.interprete.contains(i);
	}
	
	public void addReproducciones() {
		numReproducciones++;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estiloMusical, interprete, numReproducciones, rutaFichero, titulo);
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
		return Objects.equals(estiloMusical, other.estiloMusical) && Objects.equals(interprete, other.interprete)
				&& numReproducciones == other.numReproducciones && Objects.equals(rutaFichero, other.rutaFichero)
				&& Objects.equals(titulo, other.titulo);
	}
	
	
	
	
}
