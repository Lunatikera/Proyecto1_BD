/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.io.IOException;
import java.sql.SQLException;
import persistencia.GenerarTicketDAO;
import persistencia.IConexionBD;

/**
 *
 * @author jesus
 */
public class GenerarTicket {
   
    private GenerarTicketDAO generarTicketDAO;

    public GenerarTicket(IConexionBD conexionBD) {
        this.generarTicketDAO = new GenerarTicketDAO(conexionBD);
    }

    public void crearTicket(int compraId) throws IOException, SQLException {
        String contenido = generarTicketDAO.obtenerDatosCompra(compraId);
        generarTicketDAO.crearPDF(contenido);
    }
    
}
