package umu.tds.modelo.usuario;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;

public enum CatalogoUsuarios {
	INSTANCIA;

	// ATRIBUTOS
	private Map<LinkedList<String>, Usuario> usuarios;
	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	// CONSTRUCTOR
	private CatalogoUsuarios() {
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorUsuario = dao.getUsuarioDAO();
			usuarios = new HashMap<LinkedList<String>, Usuario>();
			this.cargarCatalogo();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	// GETTERS AND SETTERS
	public List<Usuario> getUsuarios() {
		LinkedList<Usuario> lista = new LinkedList<Usuario>(usuarios.values());
		return lista;
	}

	public Usuario getUsuario(String usuario) {
		Object[] lista = usuarios.keySet().stream().filter(l -> l.contains(usuario)).toArray();
		if (lista.length != 0)
			return usuarios.get(lista[0]);
		return null;
	}

	// METODOS
	public void addUsuario(Usuario usuario) {
		LinkedList<String> lista = new LinkedList<>();
		lista.add(usuario.getNombre());
		lista.add(usuario.getEmail());
		usuarios.put(lista, usuario);
	}

	private void cargarCatalogo() throws DAOException {
		List<Usuario> usuariosBD = adaptadorUsuario.recuperarTodosUsuarios();
		for (Usuario usuario : usuariosBD) {
			LinkedList<String> lista = new LinkedList<>();
			lista.add(usuario.getNombre());
			lista.add(usuario.getEmail());
			usuarios.put(lista, usuario);
		}
	}
}
