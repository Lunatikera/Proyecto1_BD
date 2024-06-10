
package cinepolis;

import java.io.IOException;
import java.sql.SQLException;
import negocio.GenerarReporteGananciasSucursal;
import persistencia.ConexionBD;
import persistencia.IConexionBD;

public class Main {
    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        GenerarReporteGananciasSucursal generarReporte = new GenerarReporteGananciasSucursal(conexionBD);

        int sucursalId = 1;
        String fechaInicio = "2024-06-08";
        String fechaFin = "2024-06-25";

        try {
            generarReporte.generarReporte(sucursalId, fechaInicio, fechaFin);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

