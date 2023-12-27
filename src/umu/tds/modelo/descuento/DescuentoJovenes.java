package umu.tds.modelo.descuento;

import java.text.SimpleDateFormat;

import umu.tds.modelo.usuario.Usuario;

/**
 * Clase que representa un Descuento para Jovenes.
 */
public class DescuentoJovenes implements IDescuento {
	
	@Override
	public double Precio() {
		return Usuario.TARIFA_PREMIUM * 0.8;
	}

	@Override
	public boolean isAplicable(Usuario usuario) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		String anio = sdf.format(usuario.getFecha());

		return Integer.parseInt(anio) > 1999;
	}

	@Override
	public String tipoDescuento() {
		return "Descuento Joven";
	}
}
