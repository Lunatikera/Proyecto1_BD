/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.SucursalDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ISucursalNegocio {

    public SucursalDTO obtenerSucursalMasCercana(int idCliente) throws NegocioException;

    public List<SucursalDTO> obtenerSucursales() throws NegocioException;

    public List<SucursalDTO> listaSucursalesporCiudad(int idCiudad) throws NegocioException;
    
    public SucursalDTO obtenerSucursalporNombre(String nombre) throws NegocioException;

}
