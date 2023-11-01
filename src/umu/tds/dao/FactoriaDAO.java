package umu.tds.dao;

/**
 * Define una factoria abstracta que devuelve todos los DAO de la aplicacion
 */
public abstract class FactoriaDAO {
	/*
	 * ATRIBUTOS
	 */
	private static FactoriaDAO unicaInstancia;
	public static final String DAO_TDS = "umu.tds.dao.TDSFactoriaDAO";

	/*
	 * Constructor
	 */
	protected FactoriaDAO() {
	}

	/**
	 * Crea un tipo de factoria DAO. Solo existe el tipo TDSFactoriaDAO
	 */
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

	/**
	 * Devuelve la instancia de la FactoriaDAO
	 */
	public static FactoriaDAO getInstancia() throws DAOException {
		if (unicaInstancia == null)
			return getInstancia(FactoriaDAO.DAO_TDS);
		else
			return unicaInstancia;
	}

	/*
	 * Metodos factoria que devuelven adaptadores que implementen estos interfaces
	 */
	public abstract IAdaptadorCancionDAO getCancionDAO();

	public abstract IAdaptadorUsuarioDAO getUsuarioDAO();

	public abstract IAdaptadorPlayListDAO getPlaylistDAO();
}
