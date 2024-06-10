/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Ciudad;
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
public class CiudadDAO implements ICiudadDAO {

    IConexionBD conexionBD;

    public CiudadDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public List<Ciudad> listaCiudades(String pais) throws PersistenciaException {
        List<Ciudad> ciudades = new ArrayList<>();

        // Consulta SQL para obtener las ciudades de un país
        String sentenciaSQL = "SELECT C.ciudad_id, C.nombre "
                + "FROM Ciudades C "
                + "JOIN Paises P ON C.pais_id = P.pais_id "
                + "WHERE P.nombre = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            // Establecer el parámetro de país en la consulta preparada
            pS.setString(1, pais);

            // Ejecutar la consulta
            try ( ResultSet resultSet = pS.executeQuery()) {
                // Iterar sobre los resultados y mapearlos a objetos Ciudad
                while (resultSet.next()) {
                    int ciudadId = resultSet.getInt("ciudad_id");
                    String nombre = resultSet.getString("nombre");

                    // Crear un objeto Ciudad y agregarlo a la lista
                    Ciudad ciudad = new Ciudad(ciudadId, nombre);
                    ciudades.add(ciudad);
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la lista de ciudades", e);
        }

        return ciudades;
    }

    @Override
    public Ciudad obtenerCiudadporNombre(String nombre) throws PersistenciaException {
        String consultaSQL = "SELECT ciudad_id, nombre FROM Ciudades WHERE nombre = ?";
        Ciudad ciudad = null;

        try ( Connection conexion = conexionBD.crearConexion();  PreparedStatement consulta = conexion.prepareStatement(consultaSQL)) {
            consulta.setString(1, nombre);
            try ( ResultSet resultado = consulta.executeQuery()) {
                if (resultado.next()) {
                    int id = resultado.getInt("ciudad_id");
                    String nombreCiudad = resultado.getString("nombre");
                    // Aquí puedes obtener los otros campos de la ciudad si es necesario
                    ciudad = new Ciudad(id, nombreCiudad);
                }
            }

            if (ciudad == null) {
                throw new PersistenciaException("No se encontró ninguna ciudad con el nombre especificado.");
            }

            return ciudad;
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la ciudad por nombre: " + e.getMessage(), e);
        }
    }
}
