package umu.tds.modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadoPlayListDAO;
import umu.tds.dao.IAdaptadorCancionDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.CatalogoCanciones;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.CatalogoUsuarios;
import umu.tds.modelo.usuario.Usuario;

public class Controlador {
	
	private static Controlador INSTANCIA;

	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadoPlayListDAO adaptadorPlayList;
	
	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;
	
	private PlayList plActual;
	
	private Controlador() {
		inicializarAdaptadores();
		
		inicializarCatalogos();
	}
	
	public static Controlador getUnicaInstancia() {
		if (INSTANCIA == null)
			INSTANCIA = new Controlador();
		return INSTANCIA;
	}
	
	public void registrarUsuario(String nombre, String email, Date fecha, String contraseña) {
		Usuario usuario = new Usuario(nombre, email, fecha, contraseña);
		adaptadorUsuario.registrarUsuario(usuario);
		catalogoUsuarios.addUsuario(usuario);
	}
	
	public void registrarCancion(String titulo, String rutaFichero, String estiloMusical, String ...interpretes) {
		// No se controla que el valor del string precio sea un double
		Cancion cancion = new Cancion(titulo, rutaFichero, estiloMusical, interpretes);
		adaptadorCancion.registrarCancion(cancion);

		catalogoCanciones.addCancion(cancion);
	}
	
	//ESTO NS MUCHO SI ESTAN BIEN
	public void crearPlayList(String s) {
		plActual = new PlayList(s);
	}
	
	public void anadirCancionAPlayList(Cancion c) {
		plActual.addCancion(c);
	}
	
	public void registrarPlayList(String s) {
	}
	
    private void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
		adaptadorCancion = factoria.getCancionDAO();
	}

	private void inicializarCatalogos() {
		catalogoUsuarios = CatalogoUsuarios.getUnicaInstancia();
		//catalogoCanciones = CatalogoCanciones.getUnicaInstancia();
	}
	
	public boolean existeUsuario(String email) {
		return CatalogoUsuarios.getUnicaInstancia().getUsuario(email) != null;
	}
	
	public List<Cancion> getCanciones() {
		return catalogoCanciones.getCanciones();
	}
	
	public List<Usuario> getUsuarios() {
		return catalogoUsuarios.getUsuarios();
	}
	
	public Usuario getUsuario(String usuario) {
		for (Usuario u: catalogoUsuarios.getUsuarios()) {
			if (u.getEmail().equals(usuario) || u.getNombre().equals(usuario))
				return u;
		}
		return null;	
	}

	
}
