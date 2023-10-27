package umu.tds.modelo.descuento;

import umu.tds.modelo.usuario.Usuario;

public class DescuentoFijo extends Descuento{

	@Override
	public double Precio() {
		return Usuario.TARIFA_PREMIUM*0.5;
	}
	
	@Override
	public boolean isAplicable(Usuario u) {
        return true;
    }
}