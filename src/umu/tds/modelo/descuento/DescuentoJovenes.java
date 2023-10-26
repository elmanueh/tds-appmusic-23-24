package umu.tds.modelo.descuento;

import umu.tds.modelo.usuario.Usuario;

public class DescuentoJovenes extends Descuento{
	@Override
	double Precio() {
		return Usuario.TARIFA_PREMIUM*0.8;
	}
	
	@Override
	public boolean isAplicable(Usuario u) {
	    return u.getFecha().getYear() < 1999;
    }
}
