package umu.tds.modelo.usuario;

import java.util.HashMap;
import java.util.Map;

public class CatalogoUsuarios {
	//ATRIBUTOS
	private Map<String, Usuario> usuarios;
	
	//GETTERS AND SETTERS
	public Map<String, Usuario> getUsuarios() {
		return new HashMap<String,Usuario>(usuarios);
	}

	public void setUsuarios(Map<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	} 

	//CONSTRUCTOR
	public CatalogoUsuarios() {
		usuarios = new HashMap<String,Usuario>();
	}
	
	//METODO
	public Usuario getUsuario(String usuario) {
		return usuarios.get(usuario); 
	}
	
	public void addUsuario(Usuario cli) {
		usuarios.put(cli.getNombre(), cli);
	}
	
	public void removeUsuario (Usuario cli) {
		usuarios.remove(cli.getNombre());
	}
}
