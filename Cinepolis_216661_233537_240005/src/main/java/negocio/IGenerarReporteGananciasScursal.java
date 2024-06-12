/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Chris
 */
public interface IGenerarReporteGananciasScursal {

    public void generarReporte(int sucursalId, String fechaInicio, String fechaFin) throws IOException, SQLException;
}
