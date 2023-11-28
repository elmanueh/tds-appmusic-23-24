package umu.tds.modelo;

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

public enum Reproductor {
	INSTANCIA;

	// ATRIBUTOS
	private MediaPlayer mediaPlayer;
	private String binPath;
	private String tempPath;
	private String url;
	private boolean reproduciendo;
	private double volumen;

	// CONSTRUCTOR
	private Reproductor() {
		url = "";
		mediaPlayer = null;
		binPath = Reproductor.class.getClassLoader().getResource(".").getPath();
		binPath = binPath.replaceFirst("/", "");
		tempPath = binPath.replace("/bin", "/temp");
		reproduciendo = false;
		volumen = 0.3;
	}

	// METODOS
	public boolean isReproduciendo() {
		return reproduciendo;
	}

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
				reproduciendo = true;
				mediaPlayer.play();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

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

	public void pauseCancion() {
		if (mediaPlayer != null) {
			mediaPlayer.pause();
			reproduciendo = false;
		}
	}

	public void establecerVolumen(int v) {
		if (mediaPlayer != null) {
			double volumen = (double) v / 100;
			this.volumen = volumen;
			mediaPlayer.setVolume(this.volumen);
		}
	}

	public double getDuracionCancion() {
		if (mediaPlayer == null)
			return 1;
		System.out.println((int) mediaPlayer.getMedia().getDuration().toSeconds());
		return mediaPlayer.getMedia().getDuration().toSeconds();
	}
}
