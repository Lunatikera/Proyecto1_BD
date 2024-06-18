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

    // Constructor que inicializa la DAO de funciones
    public FuncionNegocio(IFuncionDAO funcionDAO) {
        this.funcionDAO = funcionDAO;
    }

    // Método para listar funciones por día, sucursal y película
    @Override
    public List<FuncionDTO> listaFuncionporDiaSucursalPelicula(String dia, int idSucursal, int idPelicula) throws NegocioException {
        try {
            List<Funcion> funciones = funcionDAO.listaFuncionporDiaSucursalPelicula(dia, idSucursal, idPelicula);
            List<FuncionDTO> funcionDTOs = new ArrayList<>();

            for (Funcion funcion : funciones) {
                funcionDTOs.add(convertirADTO(funcion));
            }

            return funcionDTOs;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de funciones", e);
        }
    }

    // Método para buscar una función por ID
    @Override
    public FuncionDTO buscarPorIdFuncion(int id) throws NegocioException {
        try {
            Funcion funcion = funcionDAO.buscarPorIdFuncion(id);
            if (funcion == null) {
                throw new NegocioException("No se encontró la función con ID: " + id);
            }
            return convertirADTO(funcion);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la función por ID", e);
        }
    }

    // Método para eliminar una función
    @Override
    public void eliminarFuncion(FuncionDTO funcionDTO) throws NegocioException {
        try {
            Funcion funcion = convertirAEntidad(funcionDTO);
            funcionDAO.eliminarFuncion(funcion);

            if (funcionDTO == null) {
                throw new NegocioException("No se pudo eliminar la función con ID: " + funcionDTO.getId());
            }

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la función", e);
        }
    }

    // Método para agregar una nueva función
    @Override
    public void agregarFuncion(FuncionDTO funcionDTO) throws NegocioException {
        try {
            Funcion funcion = convertirAEntidad(funcionDTO);
            funcionDAO.agregarFuncion(funcion);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la función", e);
        }
    }

    // Método para editar una función
    @Override
    public void editarFuncion(FuncionDTO funcionDTO) throws NegocioException {
        try {
            System.out.println("1 "+ funcionDTO);
            Funcion funcion = convertirAEntidad(funcionDTO);
            System.out.println("2"+ funcionDTO);
            funcionDAO.editarFuncion(funcion);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al editar la función", e);
        }
    }

    // Método privado para convertir de DTO a entidad
    private Funcion convertirAEntidad(FuncionDTO funcionDTO) {
        Funcion funcion = new Funcion();
        funcion.setId(funcionDTO.getId());
        funcion.setDia(funcionDTO.getDia());
        funcion.setHora(funcionDTO.getHora());
        funcion.setHoraFinal(funcionDTO.getHoraFinal());
        funcion.setIdSala(funcionDTO.getIdSala());
        funcion.setIdPelicula(funcionDTO.getIdPelicula());
        return funcion;
    }

    // Método privado para convertir de entidad a DTO
    private FuncionDTO convertirADTO(Funcion funcion) {
        FuncionDTO funcionDTO = new FuncionDTO();
        funcionDTO.setId(funcion.getId());
        funcionDTO.setDia(funcion.getDia());
        funcionDTO.setHora(funcion.getHora());
        funcionDTO.setHoraFinal(funcion.getHoraFinal());
        funcionDTO.setIdSala(funcion.getIdSala());
        funcionDTO.setIdPelicula(funcion.getIdPelicula());
        return funcionDTO;
    }
}
