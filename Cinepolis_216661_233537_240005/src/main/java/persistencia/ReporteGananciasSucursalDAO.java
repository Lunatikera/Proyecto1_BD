package persistencia;

import reportes.ReporteGananciasSucursal;
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

public class ReporteGananciasSucursalDAO {
    
    private IConexionBD conexionBD;
    private String RUTA_PDF = "C:\\Users\\Chris\\Desktop\\reporte_ganancias_sucursal.pdf";

    public ReporteGananciasSucursalDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public List<ReporteGananciasSucursal> obtenerReporteGananciasPorSucursal(int sucursalId, String fechaInicio, String fechaFin) throws SQLException {
        String query = "SELECT s.nombre AS sucursal, f.dia, COUNT(f.funcion_id) AS cantidad_funciones, " +
                       "SUM(c.totalCompra) AS total_ganancia_por_fecha " +
                       "FROM Compras c " +
                       "JOIN Funciones f ON c.funcion_id = f.funcion_id " +
                       "JOIN Salas s ON f.sala_id = s.sala_id " +
                       "WHERE s.sucursal_id = ? AND c.fecha_compra BETWEEN ? AND ? " +
                       "GROUP BY s.nombre, f.dia";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, sucursalId);
            stmt.setString(2, fechaInicio);
            stmt.setString(3, fechaFin);
            ResultSet rs = stmt.executeQuery();

            List<ReporteGananciasSucursal> reportes = new ArrayList<>();
            while (rs.next()) {
                String sucursal = rs.getString("sucursal");
                String dia = rs.getString("dia");
                int cantidadFunciones = rs.getInt("cantidad_funciones");
                double totalGananciaPorFecha = rs.getDouble("total_ganancia_por_fecha");

                reportes.add(new ReporteGananciasSucursal(sucursal, dia, cantidadFunciones, totalGananciaPorFecha));
            }
            return reportes;
        }
    }

    public void crearPDF(List<ReporteGananciasSucursal> reportes, String sucursal, String fechaInicio, String fechaFin) throws IOException {
        File archivo = new File(RUTA_PDF);
        archivo.getParentFile().mkdirs(); 
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(RUTA_PDF));
            document.open();
            document.add(new Paragraph("Reporte de Ganancias por Sucursal"));
            document.add(new Paragraph("Sucursal: " + sucursal));
            document.add(new Paragraph("Fecha de Inicio: " + fechaInicio));
            document.add(new Paragraph("Fecha de Fin: " + fechaFin));
            document.add(new Paragraph("\n"));

            double totalGanancias = 0;

            for (ReporteGananciasSucursal reporte : reportes) {
                document.add(new Paragraph("Sucursal: " + reporte.getSucursal()));
                document.add(new Paragraph("Fecha: " + reporte.getDia()));
                document.add(new Paragraph("Cantidad Funciones: " + reporte.getCantidadFunciones()));
                document.add(new Paragraph("Total Ganancia: $" + reporte.getTotalGananciaPorFecha()));
                document.add(new Paragraph("\n"));
                totalGanancias += reporte.getTotalGananciaPorFecha();
            }

            document.add(new Paragraph("Total de Ganancias: $" + totalGanancias));
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
