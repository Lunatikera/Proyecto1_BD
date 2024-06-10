/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.CiudadDTO;
import dtos.PaisDTO;
import entidades.Ciudad;
import entidades.Pais;
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

    @Override
    public List<CiudadDTO> listaCiudades(String pais) throws NegocioException {
        try {
            List<CiudadDTO> listaCiudadDTO = new ArrayList<>();
            List<Ciudad> listaCiudades = ciudadDAO.listaCiudades(pais);

            for (Ciudad ciudad : listaCiudades) {
                listaCiudadDTO.add(convertirACiudadDTO(ciudad));

            }
            return listaCiudadDTO;

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de países desde la capa de negocio", e);
        }
    }

    private CiudadDTO convertirACiudadDTO(Ciudad ciudad) {
        return new CiudadDTO(ciudad.getId(), ciudad.getNombre());
    }
}
