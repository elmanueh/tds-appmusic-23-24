package umu.tds.dao;

import java.util.List;

import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

public interface IAdaptadoPlayListDAO {

	public void registrarPlayList(PlayList playlist);
	public void borrarPlayList(PlayList playlist);
	public void modificarPlayList(PlayList playlist);
	public PlayList recuperarPlayList(int codigo);
	public List<PlayList> recuperarTodosPlayLists();
}
