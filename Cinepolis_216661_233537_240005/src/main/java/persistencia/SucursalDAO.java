/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Sucursal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SucursalDAO implements ISucursalDAO {
    IConexionBD conexionBD;

    public SucursalDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
      public Sucursal buscarSucursalMasCercana(int clienteId) throws PersistenciaException {
        Sucursal sucursal = null;
        String query = "{CALL BuscarSucursalMasCercana(?)}";

        try (Connection connection = conexionBD.crearConexion();
             CallableStatement stmt = connection.prepareCall(query)) {

            // Configurar el parámetro de entrada
            stmt.setInt(1, clienteId);

            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    sucursal = new Sucursal();
                    sucursal.setId(rs.getInt("sucursal_id"));
                    sucursal.setNombre(rs.getString("nombre"));
                    sucursal.setDireccion(rs.getString("direccion"));
                }
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener la sucursal mas cercana");
        }

        return sucursal;
    }
      
      
      public List<Sucursal> obtenerSucursales() throws PersistenciaException {
        List<Sucursal> sucursales = new ArrayList<>();
        String query = "SELECT sucursal_id, nombre, direccion, ciudad_id FROM Sucursales";

        try (Connection connection = conexionBD.crearConexion();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setId(rs.getInt("sucursal_id"));
                sucursal.setNombre(rs.getString("nombre"));
                sucursal.setDireccion(rs.getString("direccion"));
                sucursal.setIdCiudad(rs.getInt("ciudad_id"));
                sucursales.add(sucursal);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener las sucursales", ex);
        }

        return sucursales;
    }
}

