/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Sala;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ISalaDAO {
    public List<Sala> listaSalasporSucursal(int idSucursal) throws PersistenciaException;
    
    public Sala obtenerSalaPorID(int idSala) throws PersistenciaException;
}
