package umu.tds;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;
import umu.tds.modelo.usuario.Usuario;

/**
 * Clase para crear un PDF
 */
public class CreadorPDF {

	/**
	 * Metodo para generar el PDF con las PlayList del usuario.
	 * @param usuario Usuario del que quieres obtener sus playlist
	 * @param ruta Ruta donde se creara el archivo
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void generarPDF(Usuario usuario, String ruta) throws IOException, DocumentException {
		FileOutputStream archivo = new FileOutputStream(ruta);
        Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();
		documento.add(new Paragraph("LISTADO DE PLAYLIST DEL USUARIO: " + usuario.getNombre()));
		documento.add(new Paragraph());
		for (PlayList p: usuario.getListaPlayList()) {
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("Playlist " + p.getNombre()));
			for (Cancion c: p.getListaCanciones()) {
				documento.add(new Paragraph("Titulo: " + c.getTitulo() + ", Interprete: " + c.getInterprete().getInterprete() + ", Estilo: " + c.getEstiloMusical().getEstilo()));
			}
		}
		documento.close();
	}
}
