package umu.tds.modelo.descuento;

import umu.tds.modelo.usuario.Usuario;

/**
 * Clase que representa un Descuento Fijo.
 */
public class DescuentoCodigo implements IDescuento {

	/*
	 * ATRIBUTOS
	 */
	private static final String CODIGO_PROMOCIONAL = "SANTIAGO";
	private String codigo;

	/**
	 * Constructor de la clase Descuento Fijo.
	 * @param codigo
	 */
	public DescuentoCodigo(String codigo) {
		super();
		this.codigo = codigo;
	}

	@Override
	public double Precio() {
		return Usuario.TARIFA_PREMIUM * 0.5;
	}

	@Override
	public boolean isAplicable(Usuario usuario) {
		if (CODIGO_PROMOCIONAL.equals(codigo))
			return true;
		return false;
	}

	@Override
	public String tipoDescuento() {
		return "Descuento codigo promocional";
	}
}