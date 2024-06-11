/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Sucursal;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ISucursalDAO {

    public Sucursal buscarSucursalMasCercana(int clienteId) throws PersistenciaException;

    public List<Sucursal> obtenerSucursales() throws PersistenciaException;

    public List<Sucursal> listaSucursalesporCiudad(int idCiudad) throws PersistenciaException;

    public Sucursal obtenerSucursalporNombre(String nombre) throws PersistenciaException;

}
