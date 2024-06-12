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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FuncionDAO implements IFuncionDAO{

    IConexionBD conexionBD;

    public FuncionDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

  @Override
public List<Funcion> listaFuncionporDiaSucursalPelicula(String dia, int idSala, int idPelicula) throws PersistenciaException {
    List<Funcion> funciones = new ArrayList<>();

    try (Connection conn = conexionBD.crearConexion();
         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Funciones f " +
                 "WHERE f.dia =? AND f.sala_id =? AND f.pelicula_id =?")) {
       
        pstmt.setString(1, dia);
        pstmt.setInt(2, idSala);
        pstmt.setInt(3, idPelicula);

        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Funcion funcion = new Funcion();
                funcion.setId(rs.getInt("funcion_id"));
                funcion.setPrecio(rs.getDouble("precio"));
                funcion.setDia(rs.getString("dia"));
                funcion.setHora(rs.getTimestamp("hora"));
                funcion.setHoraFinal(rs.getTimestamp("hora_final"));
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
}
