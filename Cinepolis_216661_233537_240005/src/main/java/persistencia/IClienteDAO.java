/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Cliente;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IClienteDAO {
    public Cliente agregar(Cliente cliente) throws PersistenciaException;

    public void actualizarCliente(Cliente cliente) throws PersistenciaException;

    public void eliminarCliente(int idCliente) throws PersistenciaException;
    
    public List<Cliente> buscarCliente(int limit, int offset) throws PersistenciaException;

    public Cliente buscarClientePorId(int idCliente) throws PersistenciaException;
    
    public Cliente buscarClientePorCorreo(String correo) throws PersistenciaException;
}
