/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cinepolis;

import java.io.IOException;
import java.sql.SQLException;
import negocio.GenerarTicket;
import persistencia.ConexionBD;
import persistencia.IConexionBD;

/**
 *
 * @author Chris
 */
public class Main {

    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        GenerarTicket generarTicket = new GenerarTicket(conexionBD);
        try {
            generarTicket.crearTicket(1); 
            System.out.println("Ticket generado correctamente en la ruta fija.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
