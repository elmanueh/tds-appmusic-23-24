package umu.tds.modelo;

import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.EventObject;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import umu.tds.dao.DAOException;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.IAdaptadorCancionDAO;
import umu.tds.dao.IAdaptadorPlayListDAO;
import umu.tds.dao.IAdaptadorUsuarioDAO;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.CatalogoCanciones;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.CatalogoUsuarios;
import umu.tds.modelo.usuario.Usuario;
import umu.tds.modelo.cargador.CancionesEvent;
import umu.tds.modelo.cargador.CancionesListener;
import umu.tds.modelo.cargador.CargadorCanciones;

public enum Controlador implements CancionesListener {
	INSTANCIA;

	// ATRIBUTOS
	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorPlayListDAO adaptadorPlayList;
	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;

	private Usuario usuarioActual;
	private String cancionSeleccionada, cancionReproducciendo;
	private String playlistSeleccionada, playlistReproducciendo;
	private LinkedHashSet<Cancion> cancionesSeleccionadas;
	private PlayList playlistMasReproducidas;

	private static final String iconoParar = "/umu/tds/vista/imagenes/pausa.png";
	private static final String iconoReproducir = "/umu/tds/vista/imagenes/tocar.png";

	// CONSTRUCTOR
	private Controlador() {
		inicializarAdaptadores();
		inicializarCatalogos();
		CargadorCanciones.INSTANCIA.addCancionesListener(this);
	}

	// METODOS
	private void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
		adaptadorCancion = factoria.getCancionDAO();
		adaptadorPlayList = factoria.getPlaylistDAO();
	}

	private void inicializarCatalogos() {
		catalogoUsuarios = CatalogoUsuarios.INSTANCIA;
		catalogoCanciones = CatalogoCanciones.INSTANCIA;
	}

	// USUARIO
	public Boolean login(String usuarioAux, String contraseñaAux) {
		Usuario usuario = catalogoUsuarios.getUsuario(usuarioAux);
		if (usuario != null && usuario.getContraseña().equals(contraseñaAux)) {
			this.usuarioActual = usuario;
			ControladorVentanas.INSTANCIA.logInSatisfactorio();
			return true;
		}
		return false;
	}

	public void registrarUsuario(String nombre, String email, Date fecha, String contraseña) {
		Usuario usuario = new Usuario(nombre, email, fecha, contraseña);
		this.usuarioActual = usuario;
		adaptadorUsuario.registrarUsuario(usuario);
		catalogoUsuarios.addUsuario(usuario);
	}

	public boolean existeUsuario(String nombre_email) {
		return catalogoUsuarios.getUsuario(nombre_email) != null;
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	// CANCION

	@Override
	public void enteradoNuevasCanciones(EventObject e) {
		CancionesEvent evento = (CancionesEvent) e;
		System.out.println("ME HAN LLEGADO NUEVAS CANCIONES");

		for (umu.tds.componente.Cancion c : evento.getCanciones().getCancion()) {
			Cancion cancion = new Cancion(c.getTitulo(), c.getURL(), c.getEstilo(), c.getInterprete());
			adaptadorCancion.registrarCancion(cancion);
			catalogoCanciones.addCancion(cancion);
		}
	}

	public void cargarCanciones() {
		String path = System.getProperty("user.dir") + File.separator + "xml";
		File inicio = new File(path);
		JFileChooser fileChooser = new JFileChooser(inicio);

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.xml)", "xml");
		fileChooser.setFileFilter(filter);

		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			CargadorCanciones.INSTANCIA.setArchivoCanciones(selectedFile.getAbsolutePath());
		}
	}

	public LinkedList<Cancion> getCancionesFiltradas(String titulo, String interprete, String estilo,
			boolean favorito) {
		LinkedList<Cancion> canciones = new LinkedList<>();

		Stream<Cancion> cancionStream;

		if (favorito) {
			cancionStream = usuarioActual.getListaPlayList().stream().flatMap(pl -> pl.getListaCanciones().stream());
		} else {
			cancionStream = catalogoCanciones.getCanciones().stream();
		}

		canciones = cancionStream.filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
				.filter(c -> c.getInterprete().getInterprete().toLowerCase().contains(interprete.toLowerCase()))
				.filter(c -> estilo.isEmpty() || c.getEstiloMusical().getEstilo().equals(estilo))
				.collect(Collectors.toCollection(LinkedList::new));

		return canciones;
	}

	// QUIZAS SI LA LSITA DE ESTILOS EN CANCION FUERA PUBLICA SE PODRIA LLAMAR AQUI,
	// seria mas rapido
	public LinkedList<String> getEstilos() {
		LinkedList<String> estilos = catalogoCanciones.getCanciones().stream()
				.map(cancion -> cancion.getEstiloMusical().getEstilo()).distinct().sorted()
				.collect(Collectors.toCollection(LinkedList::new));
		estilos.addFirst("");
		return estilos;
	}

	public List<Cancion> getCancionesMasReproducidas() {
		List<Cancion> listaTOP10 = catalogoCanciones.getCanciones();

		listaTOP10 = listaTOP10.stream().filter(c -> c.getNumReproducciones() > 0).collect(Collectors.toList());

		Comparator<Cancion> comparadorReproducciones = Comparator.comparingInt(Cancion::getNumReproducciones);

		Collections.sort(listaTOP10, comparadorReproducciones.reversed());

		// Obtener las 10 canciones más reproducidas
		return listaTOP10.subList(0, Math.min(10, listaTOP10.size()));
	}

	// PLAYLIST
	public String getPlaylistSeleccionada() {
		return playlistSeleccionada;
	}

	public void añadirCancionesSeleccionadasAPlaylist(String text) {
		PlayList p = usuarioActual.getPlayList(text);
		usuarioActual.removePlayList(p);
		for (Cancion c : cancionesSeleccionadas)
			if (!p.consultarCancion(c.getTitulo()))
				p.addCancion(c);

		adaptadorPlayList.modificarPlayList(p);
		usuarioActual.addPlayList(p);
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	public String[] getPlayLists() { // TODO esta en usuario pero la otra devuelve objetos Playlist
		LinkedList<String> playlist = new LinkedList<String>();
		playlist.add("");
		for (PlayList p : usuarioActual.getListaPlayList()) {
			playlist.add(p.getNombre());
		}
		String[] playlist2 = new String[playlist.size()];
		for (int i = 0; i < playlist2.length; i++) {
			playlist2[i] = playlist.get(i);
		}
		return playlist2;
	}

	// PREMIUM
	public void configuracionPremium(boolean premium, double precio) {
		usuarioActual.setPremium(premium);
		usuarioActual.setCuota(precio);

		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	/*
	 * TABLA SELECCIONADOS
	 */
	public void setTablaSeleccionados(DefaultTableModel modelo) {
		cancionesSeleccionadas = new LinkedHashSet<Cancion>();
		int filasTotal = modelo.getRowCount();

		for (int fila = 0; fila < filasTotal; fila++) {
			if ((Boolean) modelo.getValueAt(fila, 3)) {
				Cancion cancion = catalogoCanciones.getCancion((String) modelo.getValueAt(fila, 0));
				cancionesSeleccionadas.add(cancion);
			}
		}
	}

	public LinkedHashSet<Cancion> getCancionesSeleccionadas() {
		return cancionesSeleccionadas;
	}

	/*
	 * Tablita playlist
	 */

	public DefaultTableModel getTablaPlaylist() {
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modeloTabla.addColumn("");
		for (PlayList p : usuarioActual.getListaPlayList()) {
			Object[] playlist = { p.getNombre() };
			modeloTabla.addRow(playlist);
		}
		return modeloTabla;
	}

	public void reproducirCancion() {

		switch (ControladorVentanas.INSTANCIA.getVentanaActual()) {
		case "VentanaBuscar":
			break;
		case "VentanaRecientes":
			playlistSeleccionada = usuarioActual.getPlaylistRecientes().getNombre();
			break;
		case "VentanaMasReproducidas":
			playlistMasReproducidas = new PlayList("masReproducidas");
			playlistMasReproducidas.addAllCanciones(new LinkedHashSet<>(getCancionesMasReproducidas()));
			playlistSeleccionada = playlistMasReproducidas.getNombre();
			break;
		}

		if (playlistSeleccionada != null && cancionSeleccionada != null) {
			playlistReproducciendo = playlistSeleccionada;
			cancionReproducciendo = cancionSeleccionada;
		}

		if (cancionReproducciendo != null) {
			Reproductor.INSTANCIA.playCancion(catalogoCanciones.getCancion(cancionReproducciendo).getRutaFichero());
			if (Reproductor.INSTANCIA.isReproduciendo()) {
				Cancion cancion = catalogoCanciones.getCancion(cancionReproducciendo);
				cancion.addReproducciones();
				adaptadorCancion.modificarCancion(cancion);
				usuarioActual.addCancionReciente(cancion);
				adaptadorUsuario.modificarUsuario(usuarioActual);
				ControladorVentanas.INSTANCIA.estadoReproductor(iconoParar);
			} else {
				ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
			}
		}
		ControladorVentanas.INSTANCIA.ponerCancionActual(playlistReproducciendo, cancionReproducciendo);
	}

	public void siguienteCancion() {
		PlayList plActual = usuarioActual.getPlayList(playlistReproducciendo);
		switch (ControladorVentanas.INSTANCIA.getVentanaActual()) {
		case "VentanaBuscar":
			break;
		case "VentanaRecientes":
			plActual = usuarioActual.getPlaylistRecientes();
			break;
		case "VentanaMasReproducidas":
			plActual = playlistMasReproducidas;
			break;
		}

		if (plActual == null) {
			Reproductor.INSTANCIA.stopCancion();
			ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
		} else {
			int posicion = plActual.getPosicionCancionEnPlaylist(cancionReproducciendo);
			posicion++;
			Cancion cancion = plActual.getCancionEnPosicion(posicion);
			if (cancion == null) {
				Reproductor.INSTANCIA.stopCancion();
				ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
			} else {
				setPlayListSeleccionada(playlistReproducciendo);
				setCancionSeleccionada(cancion.getTitulo());
				reproducirCancion();
			}
		}
	}

	public void anteriorCancion() {
		PlayList plActual = usuarioActual.getPlayList(playlistReproducciendo);
		switch (ControladorVentanas.INSTANCIA.getVentanaActual()) {
		case "VentanaBuscar":
			break;
		case "VentanaRecientes":
			plActual = usuarioActual.getPlaylistRecientes();
			break;
		case "VentanaMasReproducidas":
			plActual = playlistMasReproducidas;
			break;
		}

		if (plActual == null) {
			Reproductor.INSTANCIA.stopCancion();
			ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
		} else {
			int posicion = plActual.getPosicionCancionEnPlaylist(cancionReproducciendo);
			posicion--;
			Cancion cancion = plActual.getCancionEnPosicion(posicion);
			if (cancion == null) {
				Reproductor.INSTANCIA.stopCancion();
				ControladorVentanas.INSTANCIA.estadoReproductor(iconoReproducir);
			} else {
				setPlayListSeleccionada(playlistReproducciendo);
				setCancionSeleccionada(cancion.getTitulo());
				reproducirCancion();
			}
		}
	}

	public void setCancionSeleccionada(String cancionSeleccionada) {
		this.cancionSeleccionada = cancionSeleccionada;
	}

	public void setPlayListSeleccionada(String playlistSeleccionada) {
		this.playlistSeleccionada = playlistSeleccionada;
		cancionSeleccionada = null;
	}

	public void volumen(int volumen) {
		Reproductor.INSTANCIA.establecerVolumen(volumen);
	}

	/*
	 * MANEJO TABLA VENTANA BUSCAR
	 */
	public TableModel getTablaFiltrado(String tituloFiltrado, String interpreteFiltrado, String estiloFiltrado,
			boolean favorito) {
		DefaultTableModel modeloFiltrado = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column < 3)
					return false;
				return true;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == 3)
					return Boolean.class;
				return super.getColumnClass(columnIndex);
			}
		};

		modeloFiltrado.addColumn("Título");
		modeloFiltrado.addColumn("Estilo");
		modeloFiltrado.addColumn("Interprete");
		modeloFiltrado.addColumn("");

		for (Cancion cancion : getCancionesFiltradas(tituloFiltrado, interpreteFiltrado, estiloFiltrado, favorito)) {
			Object[] fila = { cancion.getTitulo(), cancion.getEstiloMusical().getEstilo(),
					cancion.getInterprete().getInterprete(), false };
			modeloFiltrado.addRow(fila);
		}
		return modeloFiltrado;
	}

	public void crearPlaylist(String playlist, TableModel tableModel) {
		if (!(playlist == null) && !(playlist.equals(""))) {
			PlayList p;
			boolean existe = usuarioActual.existePlayList(playlist);
			if (existe)
				p = usuarioActual.getPlayList(playlist);
			else
				p = new PlayList(playlist);
			int filasTotal = tableModel.getRowCount();

			for (int fila = 0; fila < filasTotal; fila++) {
				if ((Boolean) tableModel.getValueAt(fila, 3)) {
					Cancion cancion = catalogoCanciones.getCancion((String) tableModel.getValueAt(fila, 0));
					p.addCancion(cancion);
				}
			}
			if (existe)
				adaptadorPlayList.modificarPlayList(p);
			else
				adaptadorPlayList.registrarPlayList(p);

			usuarioActual.addPlayList(p);
			adaptadorUsuario.modificarUsuario(usuarioActual);
		}
	}

	/*
	 * MANEJO TABLA VENTANA GESTIONAR PLAYLIST
	 */
	public TableModel ponerTablaPlaylist(String playlist, boolean b) {
		if (b)
			añadirCancionesSeleccionadasAPlaylist(playlist);
		DefaultTableModel modelo = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column < 3)
					return false;
				return true;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == 3)
					return Boolean.class;
				return super.getColumnClass(columnIndex);
			}
		};

		modelo.addColumn("TITULO");
		modelo.addColumn("ESTILO");
		modelo.addColumn("INTERPRETE");
		modelo.addColumn("");

		for (Cancion c : usuarioActual.getPlayList(playlist).getListaCanciones()) {
			Object[] fila = { c.getTitulo(), c.getEstiloMusical().getEstilo(), c.getInterprete().getInterprete(),
					false };
			modelo.addRow(fila);
		}
		return modelo;
	}

	public TableModel crearPlaylist(String playlist) {
		if (!usuarioActual.existePlayList(playlist)) { // Si no existe se crea
			PlayList p = new PlayList(playlist);
			adaptadorPlayList.registrarPlayList(p);
			usuarioActual.addPlayList(p);
		}
		// luego se llama al metodo de arriba que lo que hace es añadir a la playlist
		// las canciones
		return ponerTablaPlaylist(playlist, true);
	}

	public TableModel eliminarPlayList(String text, TableModel tableModel) {
		PlayList p = usuarioActual.getPlayList(text);
		if (p == null)
			return null;

		usuarioActual.removePlayList(p);
		adaptadorPlayList.borrarPlayList(p);
		adaptadorUsuario.modificarUsuario(usuarioActual);

		DefaultTableModel modelo = (DefaultTableModel) tableModel;
		modelo.setRowCount(0);
		return modelo;
	}

	public boolean eliminarCancionDePlayList(String text, DefaultTableModel modelo) {
		PlayList p = usuarioActual.getPlayList(text);
		if (p == null)
			return false;
		usuarioActual.removePlayList(p);

		int filasTotal = modelo.getRowCount();

		for (int fila = 0; fila < filasTotal; fila++) {
			if ((Boolean) modelo.getValueAt(fila, 3)) {
				Cancion cancion = p.getCancion((String) modelo.getValueAt(fila, 0));
				p.removeCancion(cancion);
			}
		}

		usuarioActual.addPlayList(p);

		adaptadorPlayList.modificarPlayList(p);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		return true;
	}
}