/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.PaisDTO;
import entidades.Pais;
import java.util.ArrayList;
import java.util.List;
import persistencia.PaisDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class PaisNegocio implements IPaisNegocio {
     private PaisDAO paisDAO;

    // Constructor para inicializar el DAO
    public PaisNegocio(PaisDAO paisDAO) {
        this.paisDAO = paisDAO;
    }

    // Método para obtener la lista de países y convertirlos a objetos PaisDTO
     @Override
    public List<PaisDTO> listaPaises() throws NegocioException {
        try {
            List<PaisDTO> listaPaisesDTO = new ArrayList<>();
            List<Pais> listaPais = paisDAO.listaPaises();

            for (Pais pais : listaPais) {
                listaPaisesDTO.add(convertirAPaisDTO(pais));
            }
            return listaPaisesDTO;

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de países desde la capa de negocio", e);
        }
    }

    // Método privado para convertir un objeto Pais a PaisDTO
    private PaisDTO convertirAPaisDTO(Pais pais) {
        return new PaisDTO(pais.getId(), pais.getNombre());
    }
}
