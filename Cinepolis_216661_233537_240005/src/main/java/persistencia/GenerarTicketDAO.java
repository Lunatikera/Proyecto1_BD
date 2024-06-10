/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Document;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesus
 */
public class GenerarTicketDAO {
    
    IConexionBD conexionBD;
    String RUTA_PDF = "C:\\Users\\jesus\\OneDrive\\Escritorio\\tickets/ticket.pdf";

    public GenerarTicketDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    public String obtenerDatosCompra(int compraId) throws SQLException {
        String query = "SELECT " +
                       "c.fecha_compra, c.cantidad_Boletos, c.totalCompra, " +
                       "cl.nombres, cl.apellidoPA, cl.apellidoMA, " +
                       "f.precio, f.dia, f.hora, " +
                       "p.titulo, p.duracion, " +
                       "s.nombre AS sala_nombre " +
                       "FROM Compras c " +
                       "JOIN Clientes cl ON c.cliente_id = cl.cliente_id " +
                       "JOIN Funciones f ON c.funcion_id = f.funcion_id " +
                       "JOIN Peliculas p ON f.pelicula_id = p.pelicula_id " +
                       "JOIN Salas s ON f.sala_id = s.sala_id " +
                       "WHERE c.compra_id = ?";

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, compraId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String fechaCompra = rs.getDate("fecha_compra").toString();
                int cantidadBoletos = rs.getInt("cantidad_Boletos");
                double totalCompra = rs.getDouble("totalCompra");
                String nombresCliente = rs.getString("nombres");
                String apellidoPA = rs.getString("apellidoPA");
                String apellidoMA = rs.getString("apellidoMA");
                double precio = rs.getDouble("precio");
                String dia = rs.getString("dia");
                String hora = rs.getTime("hora").toString();
                String tituloPelicula = rs.getString("titulo");
                int duracionPelicula = rs.getInt("duracion");
                String nombreSala = rs.getString("sala_nombre");

                return "Fecha de Compra: " + fechaCompra + "\n" +
                       "Cliente: " + nombresCliente + " " + apellidoPA + " " + apellidoMA + "\n" +
                       "Cantidad de Boletos: " + cantidadBoletos + "\n" +
                       "Total Compra: $" + totalCompra + "\n" +
                       "Pelicula: " + tituloPelicula + " (" + duracionPelicula + " min)\n" +
                       "Sala: " + nombreSala + "\n" +
                       "Dia: " + dia + "\n" +
                       "Hora: " + hora + "\n" +
                       "Precio por Boleto: $" + precio;
            } else {
                throw new SQLException("No se encontró la compra con ID: " + compraId);
            }
        }
    }

     public void crearPDF(String contenido) throws IOException {
        File archivo = new File(RUTA_PDF);
        archivo.getParentFile().mkdirs(); // Crear directorios si no existen

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(RUTA_PDF));
            document.open();
            document.add(new Paragraph(contenido));
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
    
}
