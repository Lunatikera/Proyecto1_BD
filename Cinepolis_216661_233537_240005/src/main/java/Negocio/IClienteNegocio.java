/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.ClienteDTO;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IClienteNegocio {

    public ClienteDTO agregaCliente(ClienteDTO clienteDTO) throws NegocioException, PersistenciaException;

    public void actualizarCliente(ClienteDTO clienteDTO) throws NegocioException, PersistenciaException;

    public void eliminarCliente(int idCliente) throws NegocioException, PersistenciaException;

    public ClienteDTO buscarClientePorId(int idCliente) throws NegocioException, PersistenciaException;

    public List<ClienteDTO> buscarClientes(int limite, int pagina) throws NegocioException;
}
