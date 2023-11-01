package umu.tds.modelo.musica;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import umu.tds.modelo.Controlador;

import static java.util.stream.Collectors.*;

public enum CargadorCanciones {
	INSTANCE;

	private String carpetaCanciones = "/umu/tds/modelo/musica/canciones"; // carpeta con canciones en resources

	public boolean cargarCanciones() throws Exception {
		URL resourceURL = getClass().getResource(carpetaCanciones);
		Path path = Paths.get(resourceURL.toURI());

		if (hayCanciones(path)) {
			crearObjetosCancion(path);
			return true;
		} else
			return false;
	}

	private boolean hayCanciones(Path path) {
		try {
			return Files.walk(path).anyMatch(f -> !Files.isDirectory(f));
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
			return false; // Manejo de errores
		}
	}

	@SuppressWarnings("unused")
	private void printCanciones(Path path) {
		try {
			List<Path> dirs = Files.list(path).collect(toList());
			for (Path dir : dirs) {
				System.out.println("Categoria: " + dir.toFile().getName());
				for (Path file : Files.list(dir).collect(toList())) {
					System.out.println("Disco: " + file.toFile().getName());
				}
			}
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}

	private void crearObjetosCancion(Path path) {
		try {
			List<Path> dirs = Files.list(path).collect(toList());
			for (Path dir : dirs) {
				String categoria = dir.toFile().getName();
				for (Path file : Files.list(dir).collect(toList())) {
					String nombreFichero = file.toFile().getName();
					String rutaFichero = categoria + "/" + nombreFichero;
					String[] partesNombre = nombreFichero.split("-");
					String interprete = partesNombre[0];
					String titulo = partesNombre[1].substring(0, partesNombre[1].length() - 4);

					Controlador.getUnicaInstancia().registrarCancion(titulo, rutaFichero, categoria, interprete);
				}
			}
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}
}
