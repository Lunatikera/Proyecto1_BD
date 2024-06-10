/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PaisDAO implements IPaisDAO {

    IConexionBD conexionBD;

    public PaisDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public List<Pais> listaPaises() throws PersistenciaException {
        List<Pais> paises = new ArrayList<>();

        // Consulta SQL para obtener los países
        String sentenciaSQL = "SELECT pais_id, nombre FROM Paises";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement pS = conexion.prepareStatement(sentenciaSQL);  ResultSet resultSet = pS.executeQuery()) {

            // Iterar sobre los resultados y mapearlos a objetos Pais
            while (resultSet.next()) {
                int paisId = resultSet.getInt("pais_id");
                String nombre = resultSet.getString("nombre");

                // Crear un objeto Pais y agregarlo a la lista
                Pais pais = new Pais(paisId, nombre);
                paises.add(pais);
            }

        } catch (SQLSyntaxErrorException | SQLDataException e) {
            // Manejar errores específicos de SQL, si es necesario
            throw new PersistenciaException("Error de sintaxis SQL o problema con los datos", e);
        } catch (SQLException e) {
            // Manejar errores generales de SQL
            throw new PersistenciaException("Error al obtener la lista de países", e);
        }

        return paises;
    }

}
