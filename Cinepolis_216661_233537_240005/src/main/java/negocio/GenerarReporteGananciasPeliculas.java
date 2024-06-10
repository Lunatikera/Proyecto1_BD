package negocio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import persistencia.ConexionBD;
import persistencia.ReporteGananciasPeliculasDAO;
import persistencia.ReporteGananciasPeliculas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

public class GenerarReporteGananciasPeliculas {

    private final ReporteGananciasPeliculasDAO reporteDAO;

    public GenerarReporteGananciasPeliculas() {
        this.reporteDAO = new ReporteGananciasPeliculasDAO(new ConexionBD());
    }

    public void generarReporte(String ciudad, String pelicula, String genero, String fechaInicio, String fechaFin) {
        try {
            List<ReporteGananciasPeliculas> reporte = reporteDAO.obtenerGananciasPorPeliculas(ciudad, pelicula, genero, fechaInicio, fechaFin);
            crearPDF(reporte, ciudad, pelicula, genero, fechaInicio, fechaFin);
        } catch (SQLException | FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private void crearPDF(List<ReporteGananciasPeliculas> reporte, String ciudad, String pelicula, String genero, String fechaInicio, String fechaFin) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("GananciasPorPeliculas.pdf"));
        document.open();
        
        document.add(new Paragraph("Reporte de Ganancias por Peliculas"));
        document.add(new Paragraph("Ciudad: " + ciudad));
        document.add(new Paragraph("Pelicula: " + pelicula));
        document.add(new Paragraph("Genero: " + genero));
        document.add(new Paragraph("Fecha de Inicio: " + fechaInicio));
        document.add(new Paragraph("Fecha de Fin: " + fechaFin));
        document.add(new Paragraph(" "));
        
        double totalGanancias = 0;
        
        for (ReporteGananciasPeliculas registro : reporte) {
            document.add(new Paragraph("Ciudad: " + registro.getCiudad()));
            document.add(new Paragraph("Pelicula: " + registro.getPelicula()));
            document.add(new Paragraph("Genero: " + registro.getGenero()));
            document.add(new Paragraph("Fecha: " + registro.getFecha()));
            document.add(new Paragraph("Total Ganancia por Fecha: " + registro.getTotalGananciaPorFecha()));
            document.add(new Paragraph(" "));
            
            totalGanancias += registro.getTotalGananciaPorFecha();
        }
        
        document.add(new Paragraph("Total de Ganancias: " + totalGanancias));
        
        document.close();
    }
}
