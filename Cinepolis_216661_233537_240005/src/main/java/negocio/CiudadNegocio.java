/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.CiudadDTO;
import entidades.Ciudad;
import java.util.ArrayList;
import java.util.List;
import persistencia.ICiudadDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class CiudadNegocio implements ICiudadNegocio {
     private ICiudadDAO ciudadDAO;

    public CiudadNegocio(ICiudadDAO ciudadDAO) {
        this.ciudadDAO = ciudadDAO;
    }
    
    public List<CiudadDTO> listaCiudades(String pais) throws NegocioException {
        try {
            // Obtener el ID del país usando el nombre del país

            // Obtener la lista de ciudades para el país especificado
            List<Ciudad> listaCiudades = ciudadDAO.listaCiudades(pais);

            // Convertir la lista de Ciudad a CiudadDTO
            List<CiudadDTO> listaCiudadesDTO = new ArrayList<>();
            for (Ciudad ciudad : listaCiudades) {
                listaCiudadesDTO.add(convertirACiudadDTO(ciudad));
            }
            return listaCiudadesDTO;

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de ciudades desde la capa de negocio", e);
        }
    }

    // Método privado para convertir Ciudad a CiudadDTO
    private CiudadDTO convertirACiudadDTO(Ciudad ciudad) {
        return new CiudadDTO(ciudad.getId() , ciudad.getNombre());
    }

}
