/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.FuncionDTO;
import entidades.Funcion;
import java.util.ArrayList;
import java.util.List;
import persistencia.IFuncionDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class FuncionNegocio implements IFuncionNegocio {

    private IFuncionDAO funcionDAO;

    public FuncionNegocio(IFuncionDAO funcionDAO) {
        this.funcionDAO = funcionDAO;
    }

    @Override
    public List<FuncionDTO> listaFuncionporDiaSucursalPelicula(String dia, int idSala, int idPelicula) throws NegocioException {
        try {
            List<Funcion> funciones = funcionDAO.listaFuncionporDiaSucursalPelicula(dia, idSala, idPelicula);
            List<FuncionDTO> funcionDTOs = new ArrayList<>();

            for (Funcion funcion : funciones) {
                FuncionDTO funcionDTO = new FuncionDTO();
                funcionDTO.setId(funcion.getId());
                funcionDTO.setDia(funcion.getDia());
                funcionDTO.setHora(funcion.getHora());
                funcionDTO.setHoraFinal(funcion.getHoraFinal());
                funcionDTO.setIdSala(funcion.getIdSala());
                funcionDTO.setIdPelicula(funcion.getIdPelicula());

                funcionDTOs.add(funcionDTO);
            }

            return funcionDTOs;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de funciones", e);
        }
    }
}
