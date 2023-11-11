package umu.tds.modelo.descuento;

import java.text.SimpleDateFormat;

import umu.tds.modelo.usuario.Usuario;

public class DescuentoJovenes implements Descuento {
	@Override
	public double Precio() {
		return Usuario.TARIFA_PREMIUM * 0.8;
	}

	@Override
	public boolean isAplicable(Usuario u) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		String anio = sdf.format(u.getFecha());

		return Integer.parseInt(anio) > 1999;
	}

	@Override
	public String tipoDescuento() {
		return "Descuento Joven";
	}
}
