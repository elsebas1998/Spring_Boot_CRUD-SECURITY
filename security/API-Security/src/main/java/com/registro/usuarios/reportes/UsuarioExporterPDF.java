package com.registro.usuarios.reportes;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioExporterPDF {

    private List<Usuario> listaUsuarios;


    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepositorio.findAll();
    }
    public UsuarioExporterPDF(List<Usuario> obtenerUsuarios) {
        super();
        this.listaUsuarios = obtenerUsuarios;
    }

    private void escribirCabeceraDelaTabla(PdfPTable tabla){
        PdfPCell celda = new PdfPCell();
        celda.setBackgroundColor(Color.RED);
        celda.setPadding(5);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Nombre", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Apellido", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Email", fuente));
        tabla.addCell(celda);
    }

    private void escribirDatosDeLaTabla(PdfPTable tabla){
        for(Usuario usuario : listaUsuarios){
            tabla.addCell(String.valueOf(usuario.getId()));
            tabla.addCell(String.valueOf(usuario.getNombre()));
            tabla.addCell(String.valueOf(usuario.getApellido()));
            tabla.addCell(String.valueOf(usuario.getEmail()));
        }
    }
    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de usuarios", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titulo);

        PdfPTable tabla = new PdfPTable(4);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] { 1f, 2.3f, 2.3f, 6f});
        tabla.setWidthPercentage(110);
        escribirCabeceraDelaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        document.add(tabla);
        document.close();
    }
}