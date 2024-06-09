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

    public PeliculaDTO agregaPelicula(PeliculaDTO peliculaDTO) throws NegocioException, PersistenciaException;

    public void actualizarPelicula(PeliculaDTO peliculaDTO) throws NegocioException, PersistenciaException;

    public void eliminarPelicula(int idPelicula) throws NegocioException, PersistenciaException;

    public PeliculaDTO buscarClientePorId(int idCliente) throws NegocioException, PersistenciaException;

    public List<PeliculaDTO> buscarClientes(int limite, int pagina) throws NegocioException;
}
