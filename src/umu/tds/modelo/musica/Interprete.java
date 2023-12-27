package umu.tds.modelo.musica;

import java.util.Objects;

/**
 * Clase Interprete.
 */
public class Interprete {
	
	/*
	 * ATRIBUTOS
	 */
	public String interprete;

	/**
	 * Constructor de la clase Interprete.
	 * @param interprete Nombre del interprete
	 */
	public Interprete(String interprete) {
		this.interprete = interprete;
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public String getInterprete() {
		return interprete;
	}

	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}

	@Override
	public int hashCode() {
		return Objects.hash(interprete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interprete other = (Interprete) obj;
		return Objects.equals(interprete, other.interprete);
	}
}
