package umu.tds.vista.main;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import umu.tds.modelo.Controlador;
import umu.tds.modelo.musica.Cancion;
import umu.tds.modelo.musica.PlayList;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class VentanaGenerarPDF extends JPanel {

	private static final long serialVersionUID = 1L;

	public VentanaGenerarPDF() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 0;
		panel.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblGenerarPdfDe = new JLabel("GENERAR PDF DE TUS PLAYLIST");
		lblGenerarPdfDe.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblGenerarPdfDe = new GridBagConstraints();
		gbc_lblGenerarPdfDe.gridx = 0;
		gbc_lblGenerarPdfDe.gridy = 1;
		panel.add(lblGenerarPdfDe, gbc_lblGenerarPdfDe);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWeights = new double[]{0.0};
		gbl_panel_1.columnWidths = new int[]{600};
		gbl_panel_1.rowWeights = new double[]{0.0};
		gbl_panel_1.rowHeights = new int[]{300};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton = new JButton("Generar PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);

	}
	
    private void generarPDF() {
        // Crear un objeto JFileChooser
    	JFileChooser fileChooser = new JFileChooser();
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.pdf)", "pdf");
		fileChooser.setFileFilter(filter);
		
		String defaultFileName = Controlador.INSTANCIA.getNombreUsuarioActual() + ".pdf";
        File defaultFile = new File(defaultFileName);
        fileChooser.setSelectedFile(defaultFile);

        // Mostrar el diálogo de selección de archivo
        int seleccion = fileChooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File archivo = fileChooser.getSelectedFile();

            // Generar el PDF con los días de la semana
            try {
                try {
					generarPDF(archivo.getAbsolutePath());
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void generarPDF(String ruta) throws IOException, DocumentException {
    	FileOutputStream archivo = new FileOutputStream(ruta);
        Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();
		documento.add(new Paragraph("LISTADO DE PLAYLIST DEL USUARIO: " + Controlador.INSTANCIA.getNombreUsuarioActual()));
		documento.add(new Paragraph());
		for (PlayList p: Controlador.INSTANCIA.getPlayListUsuarioActual()) {
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("Playlist " + p.getNombre()));
			for (Cancion c: p.getListaCanciones()) {
				documento.add(new Paragraph("Titulo: " + c.getTitulo() + ", Interprete: " + c.getInterprete() + ", Estilo: " + c.getEstiloMusical()));
			}
		}
		documento.close();
    }
}