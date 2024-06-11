package cinepolis;

import java.io.IOException;
import java.sql.SQLException;
import negocio.GenerarReporteGananciasPeliculas;
import persistencia.ConexionBD;
import persistencia.IConexionBD;

public class Main {

    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        GenerarReporteGananciasPeliculas generarReporte = new GenerarReporteGananciasPeliculas(conexionBD);
        
        String[] ciudades = {"CDMX", "Ciudad2"};
        String[] peliculas = {"Origen", "Pelicula2"};
        String[] generos = {"Accion", "Comedia"};
        String fechaInicio = "2023-06-08";
        String fechaFin = "2023-06-20";

        try {
            generarReporte.crearReporte(ciudades, peliculas, generos, fechaInicio, fechaFin);
            System.out.println("Reporte generado exitosamente.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
