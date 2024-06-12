/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Funcion;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IFuncionDAO {

    public List<Funcion> listaFuncionporDiaSucursalPelicula(String dia, int idSala, int idPelicula) throws PersistenciaException;

}
