package umu.tds.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import umu.tds.modelo.musica.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestPlaylist {

	private static PlayList p1, p2;
	
	@BeforeClass
	public static void configurar(){
		p1 = new PlayList("Playlist 1");
		p2 = new PlayList("Playlist 3");

		Cancion c1 = new Cancion("Con la luna llena", "xx", "Melendi", "Pop");

		p1.addCancion(c1);
		p2.addCancion(c1);
	}
	
	@Test //Comprobar nombre playlist
	public void test1() {
		assertSame("Prueba1: ", p1.getNombre() , "Playlist 1");
	}

	@Test
    // Comprobar si dos playlists son iguales
    public void test2() {
        assertNotEquals("Prueba2: Verificar igualdad de playlists", p1, p2);
    }

	@Test
    // Verificar que una Playlist no contiene una canción específica
    public void test3() {
        Cancion cancionNoExistente = new Cancion("Cancion Inexistente", "xx", "Artista Desconocido", "Desconocido");
        assertFalse("Prueba3: Verificar que la Playlist 1 no contiene una canción específica",
                p1.getListaCanciones().contains(cancionNoExistente));
    }

	@Test
    // Verificar que la eliminación de una canción de la Playlist 2 funciona correctamente
    public void test4() {
        Cancion cancionAEliminar = new LinkedList<>(p1.getListaCanciones()).get(0); // Obtener la primera canción en la Playlist 2

        assertTrue("Prueba4: La Playlist 1 contiene la canción antes de la eliminación", p1.getListaCanciones().contains(cancionAEliminar));

        p1.removeCancion(cancionAEliminar);

        assertFalse("Prueba5: La Playlist 1 no contiene la canción después de la eliminación",
                p1.getListaCanciones().contains(cancionAEliminar));
    }

	 @Test
    // Verificar que obtener una canción inexistente devuelve null
    public void test5() {
        // Asegurarse de que la Playlist 1 no contiene la canción que estamos buscando
        String nombreCancionNoExistente = "Cancion Inexistente";
        assertNull("Prueba6: Obtener una canción inexistente devuelve null", p1.getCancion(nombreCancionNoExistente));
    }
}
