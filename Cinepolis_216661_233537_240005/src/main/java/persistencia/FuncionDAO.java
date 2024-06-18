/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Funcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FuncionDAO implements IFuncionDAO {

    IConexionBD conexionBD;

    public FuncionDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<Funcion> listaFuncionporDiaSucursalPelicula(String dia, int idSucursal, int idPelicula) throws PersistenciaException {
        List<Funcion> funciones = new ArrayList<>();

        try ( Connection conn = conexionBD.crearConexion();  PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Funciones f "
                + "JOIN Salas s ON f.sala_id = s.sala_id "
                + "WHERE f.dia =? AND s.sucursal_id =? AND f.pelicula_id =? "
                + "ORDER BY f.hora ASC")) {

            pstmt.setString(1, dia);
            pstmt.setInt(2, idSucursal);
            pstmt.setInt(3, idPelicula);

            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Funcion funcion = new Funcion();
                    funcion.setId(rs.getInt("funcion_id"));
                    funcion.setPrecio(rs.getDouble("precio"));
                    funcion.setDia(rs.getString("dia"));
                    funcion.setHora(rs.getTime("hora").toLocalTime());
                    funcion.setHoraFinal(rs.getTime("hora_final").toLocalTime());
                    funcion.setAsientosDisponibles(rs.getInt("asientos_Disponibles"));
                    funcion.setDuracionTotalmin(rs.getInt("duracionTotal"));
                    funcion.setIdSala(rs.getInt("sala_id"));
                    funcion.setIdPelicula(rs.getInt("pelicula_id"));
                    funcion.setIdPrecio(rs.getInt("precio_id"));
                    funciones.add(funcion);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al recuperar funciones", e);
        }

        return funciones;
    }

// Método para buscar una función por ID
    @Override
    public Funcion buscarPorIdFuncion(int id) throws PersistenciaException {
        Funcion funcion = null;

        try ( Connection conn = conexionBD.crearConexion();  PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Funciones WHERE funcion_id = ?")) {

            pstmt.setInt(1, id);

            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    funcion = new Funcion();
                    funcion.setId(rs.getInt("funcion_id"));
                    funcion.setPrecio(rs.getDouble("precio"));
                    funcion.setDia(rs.getString("dia"));
                    funcion.setHora(rs.getTime("hora").toLocalTime());
                    funcion.setHoraFinal(rs.getTime("hora_final").toLocalTime());
                    funcion.setAsientosDisponibles(rs.getInt("asientos_Disponibles"));
                    funcion.setDuracionTotalmin(rs.getInt("duracionTotal"));
                    funcion.setIdSala(rs.getInt("sala_id"));
                    funcion.setIdPelicula(rs.getInt("pelicula_id"));
                    funcion.setIdPrecio(rs.getInt("precio_id"));
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la función por ID", e);
        }

        return funcion;
    }

    // Método para eliminar una función
    @Override
    public void eliminarFuncion(Funcion funcion) throws PersistenciaException {
        try ( Connection conn = conexionBD.crearConexion()) {
            conn.setAutoCommit(false);

            try ( PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Funciones WHERE funcion_id = ?")) {
                pstmt.setInt(1, funcion.getId());

                int filasAfectadas = pstmt.executeUpdate();
                if (filasAfectadas == 1) {
                    conn.commit();
                } else {
                    conn.rollback();
                    throw new PersistenciaException("No se encontró la función para eliminar");
                }
            } catch (SQLException e) {
                conn.rollback();
                throw new PersistenciaException("Error al eliminar la función", e);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al manejar la transacción", e);
        }

    }

    // Método para agregar una nueva función
    @Override
    public void agregarFuncion(Funcion funcion) throws PersistenciaException {
        try ( Connection conn = conexionBD.crearConexion()) {
            conn.setAutoCommit(false);

            try ( PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Funciones (dia, hora, sala_id, pelicula_id) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS)) {

                Time sqlHora = Time.valueOf(funcion.getHora());
                pstmt.setString(1, funcion.getDia());
                pstmt.setTime(2, sqlHora);
                pstmt.setInt(3, funcion.getIdSala());
                pstmt.setInt(4, funcion.getIdPelicula());

                int filasAfectadas = pstmt.executeUpdate();
                if (filasAfectadas == 1) {
                    try ( ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            funcion.setId(generatedKeys.getInt(1));
                        }
                    }
                    conn.commit();
                } else {
                    conn.rollback();
                    throw new PersistenciaException("Error al agregar la función");
                }
            } catch (SQLException e) {
                conn.rollback();
                throw new PersistenciaException("Error al agregar la función", e);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al manejar la transacción", e);
        }
    }

    // Método para editar una función
    @Override
    public void editarFuncion(Funcion funcion) throws PersistenciaException {
        try ( Connection conn = conexionBD.crearConexion()) {
            conn.setAutoCommit(false);
            System.out.println(funcion);
            try ( PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE Funciones SET dia = ?, hora = ?, sala_id = ?, pelicula_id = ?"
                    + "  WHERE funcion_id = ?")) {
                Time sqlHora = Time.valueOf(funcion.getHora());
                pstmt.setString(1, funcion.getDia());
                pstmt.setTime(2, sqlHora);
                pstmt.setInt(3, funcion.getIdSala());
                pstmt.setInt(4, funcion.getIdPelicula());
                pstmt.setInt(5, funcion.getId());

                int filasAfectadas = pstmt.executeUpdate();
                if (filasAfectadas == 1) {
                    conn.commit();
                } else {
                    conn.rollback();
                    throw new PersistenciaException("No se encontró la función para editar");
                }
            } catch (SQLException e) {
                conn.rollback();
                throw new PersistenciaException("no se puedo editar la funcion", e);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al manejar la transacción", e);
        }

    }
}
