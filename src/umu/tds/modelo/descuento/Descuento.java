package umu.tds.modelo.descuento;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import umu.tds.modelo.usuario.Usuario;

public interface Descuento {

	double Precio();
	
	boolean isAplicable(Usuario u);
	
	static Set<Descuento> descuentos(){
		Set<Descuento> descuentos = new HashSet<Descuento>();
		Collections.addAll(descuentos, new DescuentoNulo(), new DescuentoFijo(), new DescuentoJovenes());

		return descuentos;
	}

}
