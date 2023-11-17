package umu.tds.dao;

public abstract class FactoriaDAO {

	// ATRIBUTOS
	private static FactoriaDAO unicaInstancia;
	public static final String DAO_TDS = "umu.tds.dao.TDSFactoriaDAO";

	// CONSTRUCTOR
	public FactoriaDAO() {
	}

	// METODOS
	@SuppressWarnings("deprecation")
	public static FactoriaDAO getInstancia(String tipo) throws DAOException {
		if (unicaInstancia == null)
			try {
				unicaInstancia = (FactoriaDAO) Class.forName(tipo).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("ERROR AL CREAR");
			}
		return unicaInstancia;
	}

	public static FactoriaDAO getInstancia() throws DAOException {
		if (unicaInstancia == null)
			return getInstancia(FactoriaDAO.DAO_TDS);
		else
			return unicaInstancia;
	}

	// METODOS FACTORIA
	public abstract IAdaptadorCancionDAO getCancionDAO();

	public abstract IAdaptadorUsuarioDAO getUsuarioDAO();

	public abstract IAdaptadorPlayListDAO getPlaylistDAO();
}
