/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.PaisDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPaisNegocio {
    public List<PaisDTO> listaPaises() throws NegocioException;
}
