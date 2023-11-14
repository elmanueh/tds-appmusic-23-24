package umu.tds.dao;

import java.util.List;
import umu.tds.modelo.usuario.*;

public interface IAdaptadorUsuarioDAO {

	public void registrarUsuario(Usuario usuario);

	public void modificarUsuario(Usuario usuario);

	public Usuario recuperarUsuario(int codigo);

	public List<Usuario> recuperarTodosUsuarios();
}
