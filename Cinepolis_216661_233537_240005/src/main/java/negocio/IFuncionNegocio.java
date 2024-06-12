/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.FuncionDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IFuncionNegocio {
        public List<FuncionDTO> listaFuncionporDiaSucursalPelicula(String dia, int idSala, int idPelicula) throws NegocioException;

}
