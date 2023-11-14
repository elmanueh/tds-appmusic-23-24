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

@SuppressWarnings("restriction")
public class Reproductor {
	private static Reproductor INSTANCIA;

	private MediaPlayer mediaPlayer;
	private String binPath;
	private String tempPath;
	private String url="";

	public static Reproductor getUnicaInstancia() {
		if (INSTANCIA == null) {
			INSTANCIA = new Reproductor();
		}
		return INSTANCIA;
	}

	public Reproductor() {
		inicializar();
	}

	private void inicializar() {
		mediaPlayer = null;
		binPath = Reproductor.class.getClassLoader().getResource(".").getPath();
		binPath = binPath.replaceFirst("/", "");
		tempPath = binPath.replace("/bin", "/temp");

	}

	public void playCancion(String url2) {
		if (url.equals(url2)) {
			mediaPlayer.play();
		} else {
			if (mediaPlayer != null) {
				stopCancion();
			}
			URL uri = null;
			try {
				com.sun.javafx.application.PlatformImpl.startup(() -> {
				});

				uri = new URL(url2);

				System.setProperty("java.io.tmpdir", tempPath);
				Path mp3 = Files.createTempFile("now-playing", ".mp3");
				mp3.toFile().deleteOnExit(); //que los archivos terminales se borren al temrinar la app

				System.out.println(mp3.getFileName());
				try (InputStream stream = uri.openStream()) {
					Files.copy(stream, mp3, StandardCopyOption.REPLACE_EXISTING);
				}
				System.out.println("finished-copy: " + mp3.getFileName());

				Media media = new Media(mp3.toFile().toURI().toString());
				mediaPlayer = new MediaPlayer(media);

				url = url2;
				mediaPlayer.play();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void stopCancion() {
		if (mediaPlayer != null)
			mediaPlayer.stop();
		File directorio = new File(tempPath);
		String[] files = directorio.list();
		for (String archivo : files) {
			File fichero = new File(tempPath + File.separator + archivo);
			fichero.delete();
		}
		url = "";
	}

	public void pause() {
		if (mediaPlayer != null) {
			mediaPlayer.pause();
		}
	}
}
