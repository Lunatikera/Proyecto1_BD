/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.ClienteDTO;
import entidades.Cliente;
import persistencia.IClienteDAO;
import persistencia.PersistenciaException;
import utilerias.Utilidades;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris
 */
public class ClienteNegocio implements IClienteNegocio {
    
    private IClienteDAO clienteDAO;
    
    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    @Override
    public ClienteDTO agregaCliente(ClienteDTO clienteDTO) throws NegocioException, PersistenciaException {
        Cliente cliente = new Cliente(clienteDTO.getId(),
                clienteDTO.getNombre(),
                clienteDTO.getCorreo(),
                clienteDTO.getFechaNacimiento(),
                clienteDTO.getUbicacion(),
                clienteDTO.getIdCiudad());
        Cliente clientNuevo = clienteDAO.agregar(cliente);
        
        ClienteDTO clienteNuevoDTO = convertirADTO(clientNuevo);
        
        return clienteNuevoDTO;
    }
    
    @Override
    public void actualizarCliente(ClienteDTO clienteDTO) throws NegocioException, PersistenciaException {
        try {
            Cliente cliente = new Cliente(clienteDTO.getId(),
                    clienteDTO.getNombre(),
                    clienteDTO.getCorreo(),
                    clienteDTO.getFechaNacimiento(),
                    clienteDTO.getUbicacion(),
                    clienteDTO.getIdCiudad());
            
            clienteDAO.actualizarCliente(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el cliente: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminarCliente(int idCliente) throws NegocioException, PersistenciaException {
        try {
            clienteDAO.eliminarCliente(idCliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar el cliente: " + e.getMessage());
        }
    }
    
    @Override
    public ClienteDTO buscarClientePorId(int idCliente) throws NegocioException, PersistenciaException {
        try {
            Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
            return convertirADTO(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar el alumno por ID: " + e.getMessage());
        }
    }
    
    @Override
    public List<ClienteDTO> buscarClientes(int limite, int pagina) throws NegocioException {
        try {
            this.esNumeroNegativo(limite);
            this.esNumeroNegativo(pagina);
            
            int offset = this.obtenerOFFSETMySQL(limite, pagina);
            
            List<Cliente> listaCliente = this.clienteDAO.buscarCliente(limite, offset);
            
            if (listaCliente == null) {
                throw new NegocioException("No existen clientes registrados");
            }
            return this.convertirClientesDTO(listaCliente);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException(e.getMessage());
        }
    }
    
    private ClienteDTO convertirADTO(Cliente cliente) throws NegocioException {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setCorreo(cliente.getCorreo());
        dto.setFechaNacimiento(cliente.getFechaNacimiento());
        dto.setUbicacion(cliente.getUbicacion());
        dto.setIdCiudad(cliente.getIdCiudad());
        
        return dto;
        
    }
    
    private List<ClienteDTO> convertirClientesDTO(List<Cliente> clientes) throws NegocioException {
        if (clientes == null) {
            throw new NegocioException("No se pudieron obtener la lista de los clientes registrados");
        }
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (Cliente cliente : clientes) {
            ClienteDTO dto = new ClienteDTO();
            dto.setId(cliente.getId());
            dto.setNombre(cliente.getNombre());
            dto.setCorreo(cliente.getCorreo());
            dto.setFechaNacimiento(cliente.getFechaNacimiento());
            dto.setUbicacion(cliente.getUbicacion());
            dto.setIdCiudad(cliente.getIdCiudad());
            clientesDTO.add(dto);
        }
        return clientesDTO;
    }
    
    private void esNumeroNegativo(int numero) throws NegocioException {
        if (numero < 0) {
            throw new NegocioException("El numero ingresado es negativo bro");
        }
    }
    
    private int obtenerOFFSETMySQL(int limite, int pagina) throws NegocioException {
        int offset = new Utilidades().RegresarOFFSETMySQL(limite, pagina);
        this.esNumeroNegativo(offset);
        return offset;
    }
    
}
