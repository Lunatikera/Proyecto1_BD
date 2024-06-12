/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Sala;
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
public class SalaDAO {
     IConexionBD conexionBD;

    public SalaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
     public List<Sala> listaSalasporSucursal(int idSucursal) throws PersistenciaException {
    List<Sala> listaSalas = new ArrayList<>();

    try (Connection conn = conexionBD.crearConexion();
         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Salas WHERE sucursal_id =?")) {
        pstmt.setInt(1, idSucursal);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setId(rs.getInt("sala_id"));
                sala.setNombre(rs.getString("nombre"));
                sala.setNumeroAsiento(rs.getInt("num_asientos"));
                sala.setDuracionLimpieza(rs.getInt("duracionLimpieza"));
                listaSalas.add(sala);
            }
        }
    } catch (SQLException e) {
        throw new PersistenciaException("Error al obtener lista de salas por sucursal", e);
    }

    return listaSalas;
}
}
