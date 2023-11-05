package umu.tds.modelo.descuento;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import umu.tds.modelo.usuario.Usuario;

public interface Descuento {

	double Precio();
	
	boolean isAplicable(Usuario u);
	
	String tipoDescuento();
	
	static Set<Descuento> descuentos(String codigo){
		Set<Descuento> descuentos = new HashSet<Descuento>();
		Collections.addAll(descuentos, new DescuentoFijo(codigo), new DescuentoJovenes(), new DescuentoNulo());

		return descuentos;
	}

}
