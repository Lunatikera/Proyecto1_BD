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
}

