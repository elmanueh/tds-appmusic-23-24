package umu.tds;

import umu.tds.modelo.musica.Cancion;
import umu.tds.vista.Aplicacion;

public class AppMusic {
	
	public static void main(String[] args) {
		Aplicacion app = new Aplicacion();
		app.main(args);
		
		Cancion c1 = new Cancion("Himno de ESPAÑA", "---", "POP", "ANONIMO");
		Cancion c2 = new Cancion("Himno de PORTUGAL", "---", "POP", "ANONIMO");
		Cancion c3 = new Cancion("Himno de ALEMANIA", "---", "POP", "ANONIMO");
		Cancion c4 = new Cancion("Himno de FRANCIA", "---", "POP", "ANONIMO");
		Cancion c5 = new Cancion("Himno de INGLATERRA", "---", "POP", "ANONIMO");
	}
}
