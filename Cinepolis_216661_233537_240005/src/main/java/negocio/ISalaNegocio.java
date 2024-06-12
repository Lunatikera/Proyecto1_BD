/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.SalaDTO;
import entidades.Sala;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ISalaNegocio {
  public List<SalaDTO> listaSalasporSucursal(int idSucursal) throws NegocioException;  
}
