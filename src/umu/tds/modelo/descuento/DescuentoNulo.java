package umu.tds.modelo.descuento;

import umu.tds.modelo.usuario.Usuario;

/*
 * Clase que representa un Descuento Nulo.
 */
public class DescuentoNulo implements IDescuento {

	@Override
	public double Precio() {
		return Usuario.TARIFA_PREMIUM;
	}

	@Override
	public boolean isAplicable(Usuario usuario) {
		return true;
	}

	@Override
	public String tipoDescuento() {
		return "Ninguno";
	}

}
