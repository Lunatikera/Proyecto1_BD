/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.javato edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Chris
 */
public interface IConexionBD {

    public Connection crearConexion() throws SQLException;
}
