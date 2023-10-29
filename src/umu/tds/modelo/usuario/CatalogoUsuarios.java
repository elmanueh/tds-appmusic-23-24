package umu.tds.modelo.usuario;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;

public class CatalogoUsuarios {

	/*
	 * ATRIBUTOS
	 */
	private static CatalogoUsuarios INSTANCIA = new CatalogoUsuarios();

	private Map<LinkedList<String>, Usuario> usuarios;
	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	/*
	 * CONSTRUCTOR
	 */
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

	/*
	 * METODOS DE CONSULTA Y ESTABLECIMIENTO
	 */
	public static CatalogoUsuarios getUnicaInstancia() {
		return INSTANCIA;
	}

	public List<Usuario> getUsuarios() {
		LinkedList<Usuario> lista = new LinkedList<Usuario>(usuarios.values());
		return lista;
	}

	public Usuario getUsuario(String usuario) {
		List<LinkedList<String>> lista = usuarios.keySet().stream().filter(l -> l.contains(usuario)).toList();
		if (lista.size() != 0)
			return usuarios.get(lista.get(0));
		return null;
	}

	public void addUsuario(Usuario usuario) {
		LinkedList<String> lista = new LinkedList<>();
		lista.add(usuario.getNombre());
		lista.add(usuario.getEmail());
		usuarios.put(lista, usuario);
	}

	@SuppressWarnings("unlikely-arg-type")
	public void removeUsuario(Usuario usuario) {
		Stream<LinkedList<String>> lista = usuarios.keySet().stream().filter(l -> usuarios.get(l) == usuario);
		usuarios.remove(lista);
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
