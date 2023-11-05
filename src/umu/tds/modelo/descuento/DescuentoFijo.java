package umu.tds.modelo.descuento;

import umu.tds.modelo.usuario.Usuario;

public class DescuentoFijo implements Descuento{
	public static final String CODIGO_PROMOCIONAL = "SANTIAGO";
	private String codigo;

	public DescuentoFijo(String codigo) {
		super();
		this.codigo = codigo;
	}

	@Override
	public double Precio() {
		return Usuario.TARIFA_PREMIUM*0.5;
	}
	
	@Override
	public boolean isAplicable(Usuario u) {
		if(CODIGO_PROMOCIONAL.equals(codigo))
			return true;
		return false;
    }

	@Override
	public String tipoDescuento() {
		return "Descuento codigo promocional";
	}
}