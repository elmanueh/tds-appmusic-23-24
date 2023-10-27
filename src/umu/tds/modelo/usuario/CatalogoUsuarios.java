package umu.tds.modelo.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;

public class CatalogoUsuarios {
	//ATRIBUTOS
	private Map<String, Usuario> usuarios;
	private static CatalogoUsuarios INSTANCIA = new CatalogoUsuarios();
	
	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	//CONSTRUCTOR
	private CatalogoUsuarios() {
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorUsuario = dao.getUsuarioDAO();
			usuarios = new HashMap<String, Usuario>();
			this.cargarCatalogo();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public static CatalogoUsuarios getUnicaInstancia(){
		return INSTANCIA;
	}
	
	//METODO
	public List<Usuario> getUsuarios(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		for (Usuario u:usuarios.values()) 
			lista.add(u);
		return lista;
	}
	
	public Usuario getUsuario(String usuario) {
		return usuarios.get(usuario); 
	}
	
	public void addUsuario(Usuario usuario) {
		usuarios.put(usuario.getEmail(), usuario);
	}
	
	public void removeUsuario (Usuario usuario) {
		usuarios.remove(usuario.getEmail());
	}
	
	/*Recupera todos los clientes para trabajar con ellos en memoria*/
	private void cargarCatalogo() throws DAOException {
		 List<Usuario> usuariosBD = adaptadorUsuario.recuperarTodosUsuarios();
		 for (Usuario us: usuariosBD) 
			     usuarios.put(us.getEmail(),us);
	}
}
