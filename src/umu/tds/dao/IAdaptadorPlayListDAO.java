package umu.tds.dao;

import umu.tds.modelo.musica.PlayList;

public interface IAdaptadorPlayListDAO {

	public void registrarPlayList(PlayList playlist);

	public void borrarPlayList(PlayList playlist);

	public void modificarPlayList(PlayList playlist);

	public PlayList recuperarPlayList(int codigo);
}
