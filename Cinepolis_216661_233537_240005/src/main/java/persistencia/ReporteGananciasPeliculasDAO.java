package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteGananciasPeliculasDAO {

    private final IConexionBD conexionBD;

    public ReporteGananciasPeliculasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public List<ReporteGananciasPeliculas> obtenerGananciasPorPeliculas(String ciudad, String pelicula, String genero, String fechaInicio, String fechaFin) throws SQLException {
        List<ReporteGananciasPeliculas> reporte = new ArrayList<>();
        
        String query = "SELECT c.nombre AS ciudad, p.titulo AS pelicula, g.nombre AS genero, f.dia, " +
                       "SUM(cmp.totalCompra) AS total_ganancia_por_fecha " +
                       "FROM Compras cmp " +
                       "JOIN Funciones f ON cmp.funcion_id = f.funcion_id " +
                       "JOIN Peliculas p ON f.pelicula_id = p.pelicula_id " +
                       "JOIN Generos g ON p.genero_id = g.genero_id " +
                       "JOIN Salas s ON f.sala_id = s.sala_id " +
                       "JOIN Ciudades c ON s.ciudad_id = c.ciudad_id " +
                       "WHERE c.nombre = ? AND p.titulo = ? AND g.nombre = ? AND cmp.fecha_compra BETWEEN ? AND ? " +
                       "GROUP BY c.nombre, p.titulo, g.nombre, f.dia";

        try (Connection connection = conexionBD.crearConexion();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, ciudad);
            ps.setString(2, pelicula);
            ps.setString(3, genero);
            ps.setString(4, fechaInicio);
            ps.setString(5, fechaFin);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String ciudadRes = rs.getString("ciudad");
                    String peliculaRes = rs.getString("pelicula");
                    String generoRes = rs.getString("genero");
                    String dia = rs.getString("dia");
                    double totalGananciaPorFecha = rs.getDouble("total_ganancia_por_fecha");

                    reporte.add(new ReporteGananciasPeliculas(ciudadRes, peliculaRes, generoRes, dia, totalGananciaPorFecha));
                }
            }
        }
        
        return reporte;
    }
}
