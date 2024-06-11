package persistencia;

import reportes.ReporteGananciasPeliculas;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteGananciasPeliculasDAO {
    
    IConexionBD conexionBD;
    String RUTA_PDF = "C:\\Users\\jesus\\OneDrive\\Escritorio\\tickets/reporte_peliculas.pdf";

    public ReporteGananciasPeliculasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public List<ReporteGananciasPeliculas> obtenerGananciasPorPeliculas(String[] ciudades, String[] peliculas, String[] generos, String fechaInicio, String fechaFin) throws SQLException {
        List<ReporteGananciasPeliculas> reporte = new ArrayList<>();
        StringBuilder query = new StringBuilder(
            "SELECT ci.nombre AS ciudad, p.titulo AS pelicula, g.nombreGenero AS genero, c.fecha_compra, SUM(c.totalCompra) AS total_ganancia_por_fecha " +
            "FROM Compras c " +
            "JOIN Funciones f ON c.funcion_id = f.funcion_id " +
            "JOIN Peliculas p ON f.pelicula_id = p.pelicula_id " +
            "JOIN Pelicula_Genero pg ON p.pelicula_id = pg.pelicula_id " +
            "JOIN Generos g ON pg.genero_id = g.genero_id " +
            "JOIN Salas s ON f.sala_id = s.sala_id " +
            "JOIN Sucursales su ON s.sucursal_id = su.sucursal_id " +
            "JOIN Ciudades ci ON su.ciudad_id = ci.ciudad_id " +
            "WHERE c.fecha_compra BETWEEN ? AND ? "
        );

        if (ciudades != null && ciudades.length > 0) {
            query.append("AND ci.nombre IN (");
            for (int i = 0; i < ciudades.length; i++) {
                query.append("?");
                if (i < ciudades.length - 1) query.append(", ");
            }
            query.append(") ");
        }

        if (peliculas != null && peliculas.length > 0) {
            query.append("AND p.titulo IN (");
            for (int i = 0; i < peliculas.length; i++) {
                query.append("?");
                if (i < peliculas.length - 1) query.append(", ");
            }
            query.append(") ");
        }

        if (generos != null && generos.length > 0) {
            query.append("AND g.nombreGenero IN (");
            for (int i = 0; i < generos.length; i++) {
                query.append("?");
                if (i < generos.length - 1) query.append(", ");
            }
            query.append(") ");
        }

        query.append("GROUP BY ci.nombre, p.titulo, g.nombreGenero, c.fecha_compra");

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {

            int paramIndex = 1;
            stmt.setString(paramIndex++, fechaInicio);
            stmt.setString(paramIndex++, fechaFin);

            if (ciudades != null && ciudades.length > 0) {
                for (String ciudad : ciudades) {
                    stmt.setString(paramIndex++, ciudad);
                }
            }

            if (peliculas != null && peliculas.length > 0) {
                for (String pelicula : peliculas) {
                    stmt.setString(paramIndex++, pelicula);
                }
            }

            if (generos != null && generos.length > 0) {
                for (String genero : generos) {
                    stmt.setString(paramIndex++, genero);
                }
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String ciudad = rs.getString("ciudad");
                String pelicula = rs.getString("pelicula");
                String genero = rs.getString("genero");
                String fechaCompra = rs.getDate("fecha_compra").toString();
                double totalGananciaPorFecha = rs.getDouble("total_ganancia_por_fecha");

                ReporteGananciasPeliculas reporteItem = new ReporteGananciasPeliculas(ciudad, pelicula, genero, fechaCompra, totalGananciaPorFecha);
                reporte.add(reporteItem);
            }
        }

        return reporte;
    }

    public void crearPDF(List<ReporteGananciasPeliculas> reporte, String ciudad, String pelicula, String genero, String fechaInicio, String fechaFin) throws IOException {
        File archivo = new File(RUTA_PDF);
        archivo.getParentFile().mkdirs(); // Crear directorios si no existen

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(RUTA_PDF));
            document.open();
            document.add(new Paragraph("Reporte de Ganancias por Películas\n"));
            document.add(new Paragraph("Filtros:\n"));
            document.add(new Paragraph("Ciudades: " + ciudad + "\n"));
            document.add(new Paragraph("Películas: " + pelicula + "\n"));
            document.add(new Paragraph("Géneros: " + genero + "\n"));
            document.add(new Paragraph("Fecha de Inicio: " + fechaInicio + "\n"));
            document.add(new Paragraph("Fecha de Fin: " + fechaFin + "\n\n"));

            double totalGanancias = 0;
            for (ReporteGananciasPeliculas item : reporte) {
                document.add(new Paragraph("Ciudad: " + item.getCiudad() + "\n"));
                document.add(new Paragraph("Pelicula: " + item.getPelicula() + "\n"));
                document.add(new Paragraph("Genero: " + item.getGenero() + "\n"));
                document.add(new Paragraph("Fecha: " + item.getFecha() + "\n"));
                document.add(new Paragraph("Total Ganancia por Fecha: $" + item.getTotalGananciaPorFecha() + "\n\n"));
                totalGanancias += item.getTotalGananciaPorFecha();
            }

            document.add(new Paragraph("Total de Ganancias: $" + totalGanancias));
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
