package umu.tds.modelo.descuento;

import java.util.HashSet;
import java.util.Set;

import umu.tds.modelo.usuario.Usuario;

public class Descuento {

	public double Precio() {
		return 0;
	}
	
	public boolean isAplicable(Usuario u) {
        return true;
    }
	
	public static Set<Descuento> descuentos(){
		Set<Descuento> descuentos = new HashSet<Descuento>();
		descuentos.add(new Descuento());
		descuentos.add(new DescuentoFijo());
		descuentos.add(new DescuentoJovenes());
		return descuentos;
	}

}
