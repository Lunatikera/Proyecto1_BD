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
import java.util.logging.Level;
import java.util.logging.Logger;
import utilerias.Encriptacion;

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
    public void agregaCliente(ClienteDTO clienteDTO) throws NegocioException {
        Cliente cliente = new Cliente(clienteDTO.getId(),
                clienteDTO.getNombre(),
                clienteDTO.getApellidoPA(),
                clienteDTO.getApellidoMA(),
                clienteDTO.getCorreo(),
                clienteDTO.getContraseña(),
                clienteDTO.getFechaNacimiento(),
                clienteDTO.getUbicacion(),
                clienteDTO.getIdCiudad(),
                clienteDTO.getCiudad(),
                clienteDTO.getPais());
        try {
            String contraseñaEncriptada = Encriptacion.encriptarPassword(cliente.getContraseña());
            cliente.setContraseña(contraseñaEncriptada);
            clienteDAO.agregar(cliente);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizarCliente(ClienteDTO clienteDTO) throws NegocioException {
        try {
            Cliente cliente = new Cliente(clienteDTO.getId(),
                    clienteDTO.getNombre(),
                    clienteDTO.getApellidoPA(),
                    clienteDTO.getApellidoMA(),
                    clienteDTO.getCorreo(),
                    clienteDTO.getContraseña(),
                    clienteDTO.getFechaNacimiento(),
                    clienteDTO.getUbicacion(),
                    clienteDTO.getIdCiudad(),
                    clienteDTO.getCiudad(),
                    clienteDTO.getPais());

            clienteDAO.actualizarCliente(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    @Override
    public void eliminarCliente(int idCliente) throws NegocioException {
        try {
            clienteDAO.eliminarCliente(idCliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar el cliente: " + e.getMessage());
        }
    }

    public ClienteDTO iniciarSesion(String correo, String contraseña) throws NegocioException {
        ClienteDTO cliente = buscarClientePorCorreo(correo);
        if (cliente == null) {
            throw new NegocioException("Correo no encontrado.");
        }
        boolean contraseñaValida = Encriptacion.verificarPasswordConHash(contraseña, cliente.getContraseña());
        if (!contraseñaValida) {
            throw new NegocioException("Credenciales no válidas.");
        }
        return cliente;
    }

    @Override
    public ClienteDTO buscarClientePorId(int idCliente) throws NegocioException {
        try {
            Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
            return convertirADTO(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar el alumno por ID: " + e.getMessage());
        }
    }

    @Override
    public ClienteDTO buscarClientePorCorreo(String correo) throws NegocioException {
        try {
            Cliente cliente = clienteDAO.buscarClientePorCorreo(correo);
            return convertirADTO(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar el alumno por correo: " + e.getMessage());
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
        dto.setApellidoPA(cliente.getApellidoPA());
        dto.setApellidoMA(cliente.getApellidoMA());
        dto.setCorreo(cliente.getCorreo());
        dto.setContraseña(cliente.getContraseña());
        dto.setFechaNacimiento(cliente.getFechaNacimiento());
        dto.setUbicacion(cliente.getUbicacion());
        dto.setIdCiudad(cliente.getIdCiudad());
        dto.setCiudad(cliente.getCiudad());
        dto.setPais(cliente.getPais());

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
            dto.setApellidoPA(cliente.getApellidoPA());
            dto.setApellidoMA(cliente.getApellidoMA());
            dto.setCorreo(cliente.getCorreo());
            dto.setContraseña(cliente.getContraseña());
            dto.setFechaNacimiento(cliente.getFechaNacimiento());
            dto.setUbicacion(cliente.getUbicacion());
            dto.setIdCiudad(cliente.getIdCiudad());
            dto.setCiudad(cliente.getCiudad());
            dto.setPais(cliente.getPais());
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
    
    public boolean existeClienteConCorreo(String correo) throws NegocioException {
    try {
        return clienteDAO.existeClienteConCorreo(correo);
    } catch (PersistenciaException e) {
        throw new NegocioException("Error al verificar la existencia del cliente con correo electrónico: " + correo);
    }
}


}
