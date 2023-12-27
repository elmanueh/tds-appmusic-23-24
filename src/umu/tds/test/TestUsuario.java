package umu.tds.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import umu.tds.modelo.descuento.IDescuento;
import umu.tds.modelo.descuento.DescuentoCodigo;
import umu.tds.modelo.descuento.DescuentoNulo;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.Usuario;

public class TestUsuario {
	private static Usuario usuario;
    private static PlayList playlist1, playlist2;
    private static Cancion cancion1, cancion2;

    @BeforeClass
    public static void configurar() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento = sdf.parse("01-01-1990");
        usuario = new Usuario("Usuario1", "usuario1@gmail.com", fechaNacimiento, "contrasena");

        playlist1 = new PlayList("Playlist1");
        playlist2 = new PlayList("Playlist2");

        cancion1 = new Cancion("Cancion1", "xx", "Artista1", "Género1");
        cancion2 = new Cancion("Cancion2", "yy", "Artista2", "Género2");
    }

    @Test  //Comprobar se crea una playlist en usuario
    public void test1() {
        usuario.crearPlayList("NuevaPlaylist");
        assertTrue(usuario.existePlayList("NuevaPlaylist"));
    }

    @Test // Verificar que la eliminación y la inserción de playlists en usuario funciona correctamente
    public void test2() {
        usuario.añadirPlayList(playlist1);
        usuario.añadirPlayList(playlist2);

        assertTrue(usuario.existePlayList("Playlist1"));
        assertTrue(usuario.existePlayList("Playlist2"));

        usuario.eliminarPlayList(playlist1.getNombre());
        assertFalse(usuario.existePlayList("Playlist1"));
        assertTrue(usuario.existePlayList("Playlist2"));
    }

    @Test  // Comprobar que Canciones Recientes de un usuario funciona correctamente
    public void test3() {
        usuario.addCancionReciente(cancion1);
        usuario.addCancionReciente(cancion2);

        PlayList recientes = usuario.getPlaylistRecientes();

        assertTrue(recientes.getListaCanciones().contains(cancion1));
        assertTrue(recientes.getListaCanciones().contains(cancion2));
    }

    @Test  //Comprobar la aplicación de descuentos funciona correctamente
    public void test4() {
        IDescuento descuento = usuario.aplicarDescuento("");
        assertTrue(descuento instanceof DescuentoNulo);

        descuento = usuario.aplicarDescuento("SANTIAGO");

        assertTrue(descuento instanceof DescuentoCodigo);
    }
}
