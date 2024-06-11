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

        try ( Connection connection = conexionBD.crearConexion();  CallableStatement stmt = connection.prepareCall(query)) {

            // Configurar el parámetro de entrada
            stmt.setInt(1, clienteId);

            // Ejecutar la consulta
            try ( ResultSet rs = stmt.executeQuery()) {
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

        try ( Connection connection = conexionBD.crearConexion();  PreparedStatement stmt = connection.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {

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

    public List<Sucursal> listaSucursalesporCiudad(int idCiudad) throws PersistenciaException {
        List<Sucursal> sucursales = new ArrayList<>();

        // Consulta SQL para obtener las sucursales de una ciudad
        String sentenciaSQL = "SELECT sucursal_id, nombre, direccion, ubicacion, ciudad_id "
                + "FROM Sucursales "
                + "WHERE ciudad_id = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            // Establecer el parámetro del ID de ciudad en la consulta preparada
            pS.setInt(1, idCiudad);

            // Ejecutar la consulta
            try ( ResultSet resultSet = pS.executeQuery()) {
                // Iterar sobre los resultados y mapearlos a objetos Sucursal
                while (resultSet.next()) {
                    int sucursalId = resultSet.getInt("sucursal_id");
                    String nombre = resultSet.getString("nombre");
                    String direccion = resultSet.getString("direccion");
                    String ubicacion = resultSet.getString("ubicacion");
                    // Crear un objeto Sucursal y agregarlo a la lista
                    Sucursal sucursal = new Sucursal(sucursalId, nombre, direccion, ubicacion, idCiudad);
                    sucursales.add(sucursal);
                }

            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la lista de sucursales", e);
        }
        return sucursales;

    }

    @Override
    public Sucursal obtenerSucursalporNombre(String nombre) throws PersistenciaException {
       Sucursal sucursal = null;

        // Consulta SQL para obtener la sucursal por nombre
        String sentenciaSQL = "SELECT sucursal_id, nombre, direccion, ubicacion, ciudad_id "
                + "FROM Sucursales "
                + "WHERE nombre = ?";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            // Establecer el parámetro del nombre en la consulta preparada
            pS.setString(1, nombre);

            // Ejecutar la consulta
            try (ResultSet resultSet = pS.executeQuery()) {
                // Si se encuentra una sucursal, mapearla a un objeto Sucursal
                if (resultSet.next()) {
                    int sucursalId = resultSet.getInt("sucursal_id");
                    String direccion = resultSet.getString("direccion");
                    String ubicacion = resultSet.getString("ubicacion");
                    int ciudadId = resultSet.getInt("ciudad_id");
                    sucursal = new Sucursal(sucursalId, nombre, direccion, ubicacion, ciudadId);
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la sucursal por nombre", e);
        }

        return sucursal;
    }
}