/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.SucursalDTO;
import entidades.Sucursal;
import java.util.ArrayList;
import java.util.List;
import persistencia.ISucursalDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class SucursalNegocio implements ISucursalNegocio {

    private ISucursalDAO sucursalDAO;

    public SucursalNegocio(ISucursalDAO sucursalDAO) {
        this.sucursalDAO = sucursalDAO;
    }

    @Override
    public SucursalDTO obtenerSucursalMasCercana(int idCliente) throws NegocioException {
        try {
            Sucursal sucursal = sucursalDAO.buscarSucursalMasCercana(idCliente);

            if (sucursal == null) {
                throw new NegocioException("No se encontró una sucursal cercana");
            }

            SucursalDTO sucursalDTO = new SucursalDTO();
            sucursalDTO.setId(sucursal.getId());
            sucursalDTO.setNombre(sucursal.getNombre());
            sucursalDTO.setDireccion(sucursal.getDireccion());

            return sucursalDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la sucursal más cercana", e);
        }
    }

    @Override
    public List<SucursalDTO> obtenerSucursales() throws NegocioException {
        try {
            // Llamar al DAO para obtener la lista de sucursales
            List<Sucursal> sucursales = sucursalDAO.obtenerSucursales();

            // Convertir la lista de Sucursal a una lista de SucursalDTO
            List<SucursalDTO> sucursalDTOs = new ArrayList<>();
            for (Sucursal sucursal : sucursales) {
                SucursalDTO dto = new SucursalDTO();
                dto.setId(sucursal.getId());
                dto.setNombre(sucursal.getNombre());
                dto.setDireccion(sucursal.getDireccion());
                sucursalDTOs.add(dto);
            }
            return sucursalDTOs;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener las sucursales", ex);
        }
    }

    public List<SucursalDTO> listaSucursalesporCiudad(int idCiudad) throws NegocioException {
        try {
            List<Sucursal> sucursales = sucursalDAO.listaSucursalesporCiudad(idCiudad);
            List<SucursalDTO> sucursalesDTO = new ArrayList<>();

            for (Sucursal sucursal : sucursales) {
                // Convertir Sucursal a SucursalDTO
                SucursalDTO sucursalDTO = convertirASucursalDTO(sucursal);
                sucursalesDTO.add(sucursalDTO);
            }

            return sucursalesDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en la capa de negocio al obtener la lista de sucursales", e);
        }
    }

    @Override
    public SucursalDTO obtenerSucursalporNombre(String nombre) throws NegocioException {
        try {
            // Llamar al método del DAO para obtener la sucursal por nombre
            Sucursal sucursal = sucursalDAO.obtenerSucursalporNombre(nombre);

            if (sucursal != null) {
                // Convertir la sucursal obtenida a un objeto SucursalDTO
                SucursalDTO sucursalDTO = convertirASucursalDTO(sucursal);
                return sucursalDTO;
            } else {
                // Si no se encuentra ninguna sucursal con el nombre proporcionado, lanzar una excepción
                throw new NegocioException("No se encontró ninguna sucursal con el nombre proporcionado: " + nombre);
            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en la capa de negocio al obtener la sucursal por nombre", e);
        }
    }

    private SucursalDTO convertirASucursalDTO(Sucursal sucursal) {
        // Implementa la lógica para convertir un objeto Sucursal a un objeto SucursalDTO
        // Aquí supongo que SucursalDTO tiene un constructor que toma los mismos parámetros que Sucursal
        return new SucursalDTO(sucursal.getId(), sucursal.getNombre(), sucursal.getDireccion(), sucursal.getIdCiudad());
    }
}
