package umu.tds.modelo.descuento;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import umu.tds.modelo.usuario.Usuario;

/**
 * Interfaz que representa un Descuento.
 */
public interface IDescuento {

	/**
	 * Metodo para obtener el precio de la subscripcion.
	 * @return Precio de la subscripcion
	 */
	public double Precio();

	/**
	 * Metodo para comprobar si un descuento se puede aplicar sobre el Usuario.
	 * @param usuario Usuario a comprobar
	 * @return True / False
	 */
	public boolean isAplicable(Usuario usuario);

	/**
	 * Metodo que obtiene el tipo de Descuento.
	 * @return Nombre del descuento
	 */
	public String tipoDescuento();

	/**
	 * Metodo que devuelve la lista de descuentos disponibles en la aplicacion.
	 * @param codigo Codigo de promocion
	 * @return lista de decuentos disponibles
	 */
	public static Set<IDescuento> descuentos(String codigo) {
		Set<IDescuento> descuentos = new HashSet<IDescuento>();
		Collections.addAll(descuentos, new DescuentoCodigo(codigo), new DescuentoJovenes());
		return descuentos;
	}

}
