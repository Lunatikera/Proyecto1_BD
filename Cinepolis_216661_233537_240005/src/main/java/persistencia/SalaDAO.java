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
public class SalaDAO implements ISalaDAO {
     IConexionBD conexionBD;

    public SalaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
     @Override
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

    @Override
    public Sala obtenerSalaPorID(int idSala) throws PersistenciaException {
        String sql = "SELECT sala_id, nombre, num_asientos, duracionLimpieza FROM Salas WHERE sala_id = ?";
        
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idSala);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Sala sala = new Sala();
                    sala.setId(rs.getInt("sala_id"));
                    sala.setNombre(rs.getString("nombre"));
                    sala.setNumeroAsiento(rs.getInt("num_asientos"));
                    sala.setDuracionLimpieza(rs.getInt("duracionLimpieza"));
                    return sala;
                } else {
                    throw new PersistenciaException("Sala no encontrada con ID: " + idSala);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la sala por ID", e);
        }
    }
}