package negocio;


import persistencia.IConexionBD;
import reportes.ReporteGananciasSucursal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import persistencia.ReporteGananciasSucursalDAO;

public class GenerarReporteGananciasSucursal {

    private ReporteGananciasSucursalDAO reporteDAO;

    public GenerarReporteGananciasSucursal(IConexionBD conexionBD) {
        this.reporteDAO = new ReporteGananciasSucursalDAO(conexionBD);
    }

    public void generarReporte(int sucursalId, String fechaInicio, String fechaFin) throws IOException, SQLException {
        List<ReporteGananciasSucursal> reportes = reporteDAO.obtenerReporteGananciasPorSucursal(sucursalId, fechaInicio, fechaFin);
        String sucursal = reportes.isEmpty() ? "Desconocida" : reportes.get(0).getSucursal();
        reporteDAO.crearPDF(reportes, sucursal, fechaInicio, fechaFin);
    }
}
