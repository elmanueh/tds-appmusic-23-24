package umu.tds.dao;

public class TDSFactoriaDAO extends FactoriaDAO {

	// CONSTRUCTOR
	public TDSFactoriaDAO() {
	}

	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		return AdaptadorUsuarioTDS.INSTANCIA;
	}

	@Override
	public IAdaptadorCancionDAO getCancionDAO() {
		return AdaptadorCancionTDS.INSTANCIA;
	}

	@Override
	public IAdaptadorPlayListDAO getPlaylistDAO() {
		return AdaptadorPlayListTDS.INSTANCIA;
	}

}
