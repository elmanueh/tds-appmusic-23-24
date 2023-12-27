package umu.tds.modelo.musica;

import java.util.Objects;

/**
 * Clase EstiloMusical.
 */
public class EstiloMusical {
	
	/*
	 * ATRIBUTOS
	 */
	public String estilo;

	/**
	 * Constructor de la clase EstiloMusical.
	 * @param interprete Nombre del estiloMusical
	 */
	public EstiloMusical(String estilo) {
		this.estilo = estilo;
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estilo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstiloMusical other = (EstiloMusical) obj;
		return Objects.equals(estilo, other.estilo);
	}
}
