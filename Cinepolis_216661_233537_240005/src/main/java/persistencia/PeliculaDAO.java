/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Pelicula;
import enums.Clasificaciones;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris
 */
public class PeliculaDAO implements IPeliculaDAO {

    IConexionBD conexionBD;

    public PeliculaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregar(Pelicula pelicula) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO peliculas (titulo, sinopsis, pais, link_Trailer, duracion, cartel, clasificacion) VALUES (?,?,?,?,?,?,?);";
        Connection conexion = null;
        PreparedStatement pS = null;
        ResultSet res = null;

        try {
            conexion = this.conexionBD.crearConexion();
            conexion.setAutoCommit(false);
            pS = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);

            pS.setString(1, pelicula.getTitulo());
            pS.setString(2, pelicula.getSinopsis());
            pS.setString(3, pelicula.getPais());
            pS.setString(4, pelicula.getLink_trailer());
            pS.setInt(5, pelicula.getDuracion());
            pS.setString(6, pelicula.getCartel());
            pS.setString(7, pelicula.getClasificacion().name());

            pS.executeUpdate();

            res = pS.getGeneratedKeys();

            int idGenerado = -1;
            if (res.next()) {
                idGenerado = res.getInt(1);
                pelicula.setId(idGenerado);
            } else {
                throw new PersistenciaException("No se pudo obtener el ID generado.");
            }
            conexion.commit();
        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                    throw new PersistenciaException("Error al realizar el rollback: " + ex.getMessage());
                }
            }
            throw new PersistenciaException("No se pudo guardar la pelicula: " + e.getMessage());
        }
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) throws PersistenciaException {
        String sentenciaSQL = "UPDATE peliculas SET titulo = ?, sinopsis = ?, pais = ?, link_Trailer = ?,duracion = ?,cartel = ?,clasificacion = ? WHERE pelicula_id=? ;";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            pS.setString(1, pelicula.getTitulo());
            pS.setString(2, pelicula.getSinopsis());
            pS.setString(3, pelicula.getPais());
            pS.setString(4, pelicula.getLink_trailer());
            pS.setInt(5, pelicula.getDuracion());
            pS.setString(6, pelicula.getCartel());
            pS.setString(7, pelicula.getClasificacion().name());
            pS.setInt(8, pelicula.getId());

            pS.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar la pelicula: " + e.getMessage());
        }
    }

    @Override
    public void eliminarPelicula(int idPelicula) throws PersistenciaException {

        String sql = "{ CALL EliminarPeliculaConFuncionesYCompras(?) }";
        try (Connection conexion = this.conexionBD.crearConexion(); CallableStatement cs = conexion.prepareCall(sql)) {
            cs.setInt(1, idPelicula);
            cs.execute();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar la película y sus funciones: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Pelicula> buscarPelicula(int limit, int offset) throws PersistenciaException {
        List<Pelicula> peliculas = new ArrayList<>();

        String sql = "SELECT * FROM peliculas LIMIT ? OFFSET ?";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, limit);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula();
                    pelicula.setId(rs.getInt("pelicula_id"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setSinopsis(rs.getString("sinopsis"));
                    pelicula.setPais(rs.getString("pais"));
                    pelicula.setLink_trailer(rs.getString("link_Trailer"));
                    pelicula.setDuracion(rs.getInt("duracion"));
                    pelicula.setCartel(rs.getString("cartel"));
                    pelicula.setClasificacion(Clasificaciones.valueOf(rs.getString("clasificacion")));
                    peliculas.add(pelicula);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar las peliculas: " + e.getMessage());
        }
        return peliculas;
    }

    @Override
    public Pelicula buscarPeliculaPorId(int idPelicula) throws PersistenciaException {

        String sentenciaSQL = "SELECT * FROM peliculas WHERE pelicula_id = ?;";
        ResultSet res = null;

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sentenciaSQL)) {

            ps.setInt(1, idPelicula);

            res = ps.executeQuery();

            if (res.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setId(res.getInt("pelicula_id"));
                pelicula.setTitulo(res.getString("titulo"));
                pelicula.setSinopsis(res.getString("sinopsis"));
                pelicula.setPais(res.getString("pais"));
                pelicula.setLink_trailer(res.getString("link_Trailer"));
                pelicula.setDuracion(res.getInt("duracion"));
                pelicula.setCartel(res.getString("cartel"));
                pelicula.setClasificacion(Clasificaciones.valueOf(res.getString("clasificacion")));
                return pelicula;
            } else {
                throw new PersistenciaException("No se encontró la pelicula con ID: " + idPelicula);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la pelicula por ID: " + e.getMessage());
        }
    }

    public List<Pelicula> buscarPeliculaSucursal(int idSucursal, int limit, int offset) throws PersistenciaException {
        List<Pelicula> peliculas = new ArrayList<>();

        // Consulta SQL para obtener películas para una sucursal específica con límite y desplazamiento
        String sentenciaSQL = "SELECT p.pelicula_id, p.titulo, p.sinopsis, p.pais, p.link_Trailer, p.duracion, p.cartel, p.clasificacion "
                + "FROM pelicula_sucursal s "
                + "INNER JOIN peliculas p ON s.pelicula_id = p.pelicula_id "
                + "WHERE s.sucursal_id = ? "
                + "LIMIT ? OFFSET ?";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            // Establecer los parámetros en la consulta preparada
            pS.setInt(1, idSucursal);
            pS.setInt(2, limit);
            pS.setInt(3, offset);

            // Ejecutar la consulta
            try (ResultSet resultSet = pS.executeQuery()) {
                // Iterar sobre los resultados y mapearlos a objetos Pelicula
                while (resultSet.next()) {
                    int peliculaId = resultSet.getInt("pelicula_id");
                    String titulo = resultSet.getString("titulo");
                    String sinopsis = resultSet.getString("sinopsis");
                    String pais = resultSet.getString("pais");
                    String linkTrailer = resultSet.getString("link_Trailer");
                    int duracion = resultSet.getInt("duracion");
                    String cartel = resultSet.getString("cartel");
                    Clasificaciones clasificacion = Clasificaciones.valueOf(resultSet.getString("clasificacion"));

                    // Crear un objeto Pelicula y agregarlo a la lista
                    Pelicula pelicula = new Pelicula(peliculaId, titulo, sinopsis, pais, linkTrailer, duracion, cartel, clasificacion);
                    peliculas.add(pelicula);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar películas para la sucursal", e);
        }

        return peliculas;
    }
}
