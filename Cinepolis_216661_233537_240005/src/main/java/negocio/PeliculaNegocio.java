/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.PeliculaDTO;
import entidades.Pelicula;
import enums.Clasificaciones;
import persistencia.IPeliculaDAO;
import persistencia.PersistenciaException;
import utilerias.Utilidades;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris
 */
public class PeliculaNegocio implements IPeliculaNegocio {

    private IPeliculaDAO peliculaDAO;

    public PeliculaNegocio(IPeliculaDAO peliculaDAO) {
        this.peliculaDAO = peliculaDAO;
    }

    @Override
    public void agregaPelicula(PeliculaDTO peliculaDTO) throws NegocioException {
        try {
            Pelicula pelicula = new Pelicula(peliculaDTO.getId(),
                    peliculaDTO.getTitulo(),
                    peliculaDTO.getSinopsis(),
                    peliculaDTO.getPais(),
                    peliculaDTO.getLink_trailer(),
                    peliculaDTO.getDuracion(),
                    peliculaDTO.getCartel(),
                    Clasificaciones.valueOf(peliculaDTO.getClasificacion()));

            peliculaDAO.agregar(pelicula);

        } catch (IllegalArgumentException e) {
            throw new NegocioException("Error: '" + peliculaDTO.getClasificacion() + "' No es una clasificacion Correcta");
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al agregar la película: " + ex.getMessage());
        }
    }

    @Override
    public void actualizarPelicula(PeliculaDTO peliculaDTO) throws NegocioException {
        try {
            Pelicula pelicula = new Pelicula(peliculaDTO.getId(),
                    peliculaDTO.getTitulo(),
                    peliculaDTO.getSinopsis(),
                    peliculaDTO.getPais(),
                    peliculaDTO.getLink_trailer(),
                    peliculaDTO.getDuracion(),
                    peliculaDTO.getCartel(),
                    Clasificaciones.valueOf(peliculaDTO.getClasificacion()));

            peliculaDAO.actualizarPelicula(pelicula);
        } catch (IllegalArgumentException e) {
            throw new NegocioException("Error: '" + peliculaDTO.getClasificacion() + "' No es una clasificacion Correcta");
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar la pelicula: " + e.getMessage());
        }
    }

    @Override
    public void eliminarPelicula(int idPelicula) throws NegocioException {
        try {
            peliculaDAO.eliminarPelicula(idPelicula);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la pelicula: " + e.getMessage());
        }
    }

    @Override
    public PeliculaDTO buscarPeliculaPorId(int idPelicula) throws NegocioException {
        try {
            Pelicula pelicula = peliculaDAO.buscarPeliculaPorId(idPelicula);
            return convertirADTO(pelicula);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la pelicula por ID: " + e.getMessage());
        }
    }

    @Override
    public List<PeliculaDTO> buscarPaginadoPeliculas(int limite, int pagina) throws NegocioException {
        try {
            this.esNumeroNegativo(limite);
            this.esNumeroNegativo(pagina);

            int offset = this.obtenerOFFSETMySQL(limite, pagina);

            List<Pelicula> listaPelicula = this.peliculaDAO.buscarPelicula(limite, offset);

            if (listaPelicula == null && pagina == 1) {
                throw new NegocioException("No existen peliculas registrados");
            }

            return this.convertirPeliculasDTO(listaPelicula);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException(e.getMessage());
        }
    }
    
     public List<PeliculaDTO> buscarPeliculaSucursal(int idSucursal, int limit, int offset) throws NegocioException {
        try {
            // Llamar al método del DAO para buscar películas para la sucursal
            List<Pelicula> peliculas = peliculaDAO.buscarPeliculaSucursal(idSucursal, limit, offset);
            List<PeliculaDTO> peliculasDTO = new ArrayList<>();

            // Convertir las películas obtenidas a objetos PeliculaDTO
            for (Pelicula pelicula : peliculas) {
                PeliculaDTO peliculaDTO = convertirADTO(pelicula);
                peliculasDTO.add(peliculaDTO);
            }

            return peliculasDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en la capa de negocio al buscar películas para la sucursal", e);
        }
    }

    private PeliculaDTO convertirADTO(Pelicula pelicula) throws NegocioException {
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(pelicula.getId());
        dto.setTitulo(pelicula.getTitulo());
        dto.setSinopsis(pelicula.getSinopsis());
        dto.setPais(pelicula.getPais());
        dto.setLink_trailer(pelicula.getLink_trailer());
        dto.setDuracion(pelicula.getDuracion());
        dto.setCartel(pelicula.getCartel());
        dto.setClasificacion(pelicula.getClasificacion().name());

        return dto;

    }

    private List<PeliculaDTO> convertirPeliculasDTO(List<Pelicula> peliculas) throws NegocioException {
        if (peliculas == null) {
            throw new NegocioException("No se pudieron obtener la lista de las peliculas registradas");
        }
        List<PeliculaDTO> peliculasDTO = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            PeliculaDTO dto = new PeliculaDTO();
            dto.setId(pelicula.getId());
            dto.setTitulo(pelicula.getTitulo());
            dto.setSinopsis(pelicula.getSinopsis());
            dto.setPais(pelicula.getPais());
            dto.setLink_trailer(pelicula.getLink_trailer());
            dto.setDuracion(pelicula.getDuracion());
            dto.setCartel(pelicula.getCartel());
            dto.setClasificacion(pelicula.getClasificacion().name());
            peliculasDTO.add(dto);
        }
        return peliculasDTO;
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
