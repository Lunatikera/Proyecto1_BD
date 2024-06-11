/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.PeliculaDTO;
import persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IPeliculaNegocio {

    public void agregaPelicula(PeliculaDTO peliculaDTO) throws NegocioException;

    public void actualizarPelicula(PeliculaDTO peliculaDTO) throws NegocioException;

    public void eliminarPelicula(int idPelicula) throws NegocioException;

    public PeliculaDTO buscarPeliculaPorId(int idCliente) throws NegocioException;

    public List<PeliculaDTO> buscarPaginadoPeliculas(int limite, int pagina) throws NegocioException;

    public List<PeliculaDTO> buscarPeliculaSucursal(int idSucursal, int limit, int offset) throws NegocioException;

}
