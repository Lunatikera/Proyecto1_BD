package negocio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import persistencia.ReporteGananciasPeliculasDAO;
import persistencia.IConexionBD;
import reportes.ReporteGananciasPeliculas;

public class GenerarReporteGananciasPeliculas {

    private ReporteGananciasPeliculasDAO reporteGananciasPeliculasDAO;

    public GenerarReporteGananciasPeliculas(IConexionBD conexionBD) {
        this.reporteGananciasPeliculasDAO = new ReporteGananciasPeliculasDAO(conexionBD);
    }

    public void crearReporte(String[] ciudades, String[] peliculas, String[] generos, String fechaInicio, String fechaFin) throws IOException, SQLException {
        List<ReporteGananciasPeliculas> reporte = reporteGananciasPeliculasDAO.obtenerGananciasPorPeliculas(ciudades, peliculas, generos, fechaInicio, fechaFin);
        reporteGananciasPeliculasDAO.crearPDF(reporte, String.join(", ", ciudades), String.join(", ", peliculas), String.join(", ", generos), fechaInicio, fechaFin);
    }
}
