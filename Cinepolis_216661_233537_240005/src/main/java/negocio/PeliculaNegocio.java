/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.PeliculaDTO;
import entidades.Pelicula;
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
    public PeliculaDTO agregaPelicula(PeliculaDTO peliculaDTO) throws NegocioException, PersistenciaException {
        Pelicula pelicula = new Pelicula(peliculaDTO.getId(),
                peliculaDTO.getTitulo(),
                peliculaDTO.getSinopsis(),
                peliculaDTO.getPais(),
                peliculaDTO.getLink_trailer(),
                peliculaDTO.getDuracion(),
                peliculaDTO.getCartel(),
                peliculaDTO.getClasificacion());
        
        Pelicula peliculaNueva = peliculaDAO.agregar(pelicula);
        PeliculaDTO peliculaNuevaDTO = convertirADTO(peliculaNueva);
        
        return peliculaNuevaDTO;
    }
    
    @Override
    public void actualizarPelicula(PeliculaDTO peliculaDTO) throws NegocioException, PersistenciaException {
        try {
            Pelicula pelicula = new Pelicula(peliculaDTO.getId(),
                    peliculaDTO.getTitulo(),
                    peliculaDTO.getSinopsis(),
                    peliculaDTO.getPais(),
                    peliculaDTO.getLink_trailer(),
                    peliculaDTO.getDuracion(),
                    peliculaDTO.getCartel(),
                    peliculaDTO.getClasificacion());
            
            peliculaDAO.actualizarPelicula(pelicula);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar la pelicula: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminarPelicula(int idPelicula) throws NegocioException, PersistenciaException {
        try {
            peliculaDAO.eliminarPelicula(idPelicula);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la pelicula: " + e.getMessage());
        }
    }
    
    @Override
    public PeliculaDTO buscarClientePorId(int idCliente) throws NegocioException, PersistenciaException {
        try {
            Pelicula pelicula = peliculaDAO.buscarPeliculaPorId(idCliente);
            return convertirADTO(pelicula);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la pelicula por ID: " + e.getMessage());
        }
    }
    
    @Override
    public List<PeliculaDTO> buscarClientes(int limite, int pagina) throws NegocioException {
        try {
            this.esNumeroNegativo(limite);
            this.esNumeroNegativo(pagina);
            
            int offset = this.obtenerOFFSETMySQL(limite, pagina);
            
            List<Pelicula> listaPelicula = this.peliculaDAO.buscarPelicula(limite, offset);
            
            if (listaPelicula == null) {
                throw new NegocioException("No existen peliculas registradas");
            }
            return this.convertirPeliculasDTO(listaPelicula);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException(e.getMessage());
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
        dto.setClasificacion(pelicula.getClasificacion());
        
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
            dto.setClasificacion(pelicula.getClasificacion());
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
