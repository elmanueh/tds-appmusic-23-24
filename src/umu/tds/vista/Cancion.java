package umu.tds.vista;

public class Cancion {
	
	private String titulo;
	private String rutaFichero;
	private int numReproducciones;
	private String interprete;
	private String estiloMusical;
	
	public Cancion(String titulo_, String ruta_, int numRep_, String interprete_, String estilo_) {
		titulo=titulo_;
		rutaFichero = ruta_;
		numReproducciones = numRep_;
		interprete = interprete_;
		estiloMusical = estilo_;
	}
}
