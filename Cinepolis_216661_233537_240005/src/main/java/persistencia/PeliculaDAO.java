/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Pelicula;
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
    public Pelicula agregar(Pelicula pelicula) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Peliculas (titulo, sinopsis, pais, link_Trailer,duracion,cartel,clasificacion) VALUES (?,?,?,?,?,?,?);";
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
            pS.setBytes(6, pelicula.getCartel());
            pS.setString(7, pelicula.getClasificacion());

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
            return pelicula;
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
        String sentenciaSQL = "UPDATE Peliculas SET titulo = ?, sinopsis = ?, pais = ?, link_Trailer = ?,duracion = ?,cartel = ?,clasificacion = ?;";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            pS.setString(1, pelicula.getTitulo());
            pS.setString(2, pelicula.getSinopsis());
            pS.setString(3, pelicula.getPais());
            pS.setString(4, pelicula.getLink_trailer());
            pS.setInt(5, pelicula.getDuracion());
            pS.setBytes(6, pelicula.getCartel());
            pS.setString(7, pelicula.getClasificacion());

            pS.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar la pelicula: " + e.getMessage());
        }
    }

    @Override
    public void eliminarPelicula(int idCliente) throws PersistenciaException {
        String sentenciaSQL = "DELETE FROM Peliculas WHERE pelicula_id = ?;";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            pS.setInt(1, idCliente);
            int filasAfectadas = pS.executeUpdate();

            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se encontró la pelicula con ID: " + idCliente);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar la pelicula: " + e.getMessage());
        }
    }

    @Override
    public List<Pelicula> buscarPelicula(int limit, int offset) throws PersistenciaException {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM Peliculas LIMIT ? OFFSET ?";
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
                    pelicula.setCartel(rs.getBytes("cartel"));
                    pelicula.setClasificacion(rs.getString("clasificacion"));
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
        String sentenciaSQL = "SELECT * FROM Peliculas WHERE pelicula_id = ?;";
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
                pelicula.setCartel(res.getBytes("cartel"));
                pelicula.setClasificacion(res.getString("clasificacion"));
                return pelicula;
            } else {
                throw new PersistenciaException("No se encontró la pelicula con ID: " + idPelicula);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la pelicula por ID: " + e.getMessage());
        }
    }

}
