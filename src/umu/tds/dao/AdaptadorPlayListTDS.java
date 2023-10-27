package umu.tds.dao;

import beans.Entidad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.Usuario;

public class AdaptadorPlayListTDS {
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorPlayListTDS unicaInstancia = null;

	public static AdaptadorPlayListTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorPlayListTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorPlayListTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	public void registrarPlayList(PlayList pl) {
		
	}
	
	public PlayList recuperarPlayList(int codigo) {

		System.out.println("SIN IMPLEMENTAR recuperarPL");
		return null;
	}

}
