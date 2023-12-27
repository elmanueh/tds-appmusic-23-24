package umu.tds.modelo.reproductor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Clase que representa el Reproductor.
 */
public enum Reproductor {
	INSTANCIA;

	/*
	 * ATRIBUTOS
	 */
	private MediaPlayer mediaPlayer;
	private String binPath;
	private String tempPath;
	private String url;
	private boolean reproduciendo;
	private double volumen;

	/**
	 * Constructor de la clase Reproductor.
	 */
	private Reproductor() {
		url = "";
		mediaPlayer = null;
		binPath = Reproductor.class.getClassLoader().getResource(".").getPath();
		binPath = binPath.replaceFirst("/", "");
		tempPath = binPath.replace("/bin", "/temp");
		reproduciendo = false;
		volumen = 0.3;
	}

	/**
	 * Metodo que devuelve si se esta reproduciendo algun contenido.
	 * @return True / False
	 */
	public boolean isReproduciendo() {
		return reproduciendo;
	}

	/**
	 * Metodo para reproducir/parar una Cancion.
	 * @param urlNueva URL de la Cancion
	 */
	@SuppressWarnings("deprecation")
	public void playCancion(String urlNueva) {
		if (url.equals(urlNueva) && reproduciendo) {
			pauseCancion();
		} else if (url.equals(urlNueva) && !reproduciendo) {
			mediaPlayer.play();
			reproduciendo = true;
		} else {
			stopCancion();
			URL uri = null;
			try {
				com.sun.javafx.application.PlatformImpl.startup(() -> {
				});

				uri = new URL(urlNueva);

				System.setProperty("java.io.tmpdir", tempPath);
				Path mp3 = Files.createTempFile("now-playing", ".mp3");
				mp3.toFile().deleteOnExit();

				System.out.println(mp3.getFileName());
				try (InputStream stream = uri.openStream()) {
					Files.copy(stream, mp3, StandardCopyOption.REPLACE_EXISTING);
				}
				System.out.println("finished-copy: " + mp3.getFileName());

				Media media = new Media(mp3.toFile().toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				mediaPlayer.setVolume(volumen);
				url = urlNueva;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {}
				reproduciendo = true;
				mediaPlayer.play();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Metodo para detener una Cancion.
	 */
	public void stopCancion() {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			reproduciendo = false;
		}

		File directorio = new File(tempPath);
		String[] files = directorio.list();
		for (String archivo : files) {
			File fichero = new File(tempPath + File.separator + archivo);
			fichero.delete();
		}
		url = "";
	}

	/**
	 * Metodo para pausar una Cancion.
	 */
	public void pauseCancion() {
		if (mediaPlayer != null) {
			mediaPlayer.pause();
			reproduciendo = false;
		}
	}

	/**
	 * Metodo para establecer el volumen del Reproductor.
	 * @param v Volumen a establecer
	 */
	public void establecerVolumen(int v) {
		if (mediaPlayer != null) {
			double volumen = (double) v / 100;
			this.volumen = volumen;
			mediaPlayer.setVolume(this.volumen);
		}
	}

	/**
	 * Metodo que devuelve el tiempo en segundos de la cancion que se esta reproduciendo.
	 * @return Tiempo en segundos
	 */
	public double getDuracionCancion() {
		if (mediaPlayer == null)
			return 0;
		return mediaPlayer.getMedia().getDuration().toSeconds();
	}
}
