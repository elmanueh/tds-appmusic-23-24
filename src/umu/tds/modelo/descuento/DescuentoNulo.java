package umu.tds.modelo.descuento;

import umu.tds.modelo.usuario.Usuario;

public class DescuentoNulo implements Descuento {

	@Override
	public double Precio() {
		return Usuario.TARIFA_PREMIUM;
	}

	@Override
	public boolean isAplicable(Usuario u) {
		return true;
	}

	@Override
	public String tipoDescuento() {
		return "Ninguno";
	}

}
