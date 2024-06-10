/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.ClienteDTO;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IClienteNegocio {

    public void agregaCliente(ClienteDTO clienteDTO) throws NegocioException;

    public void actualizarCliente(ClienteDTO clienteDTO) throws NegocioException;

    public void eliminarCliente(int idCliente) throws NegocioException;

    public ClienteDTO iniciarSesion(String correo, String contraseña) throws NegocioException;

    public ClienteDTO buscarClientePorId(int idCliente) throws NegocioException;

    public ClienteDTO buscarClientePorCorreo(String correo) throws NegocioException;

    public List<ClienteDTO> buscarClientes(int limite, int pagina) throws NegocioException;

    public boolean existeClienteConCorreo(String correo) throws NegocioException;

}
