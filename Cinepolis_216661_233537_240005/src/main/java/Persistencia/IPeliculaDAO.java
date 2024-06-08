/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Pelicula;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IPeliculaDAO {
    public Pelicula agregar(Pelicula pelicula) throws PersistenciaException;

    public void actualizarPelicula(Pelicula pelicula) throws PersistenciaException;

    public void eliminarPelicula(int idCliente) throws PersistenciaException;
    
    public List<Pelicula> buscarPelicula(int limit, int offset) throws PersistenciaException;

    public Pelicula buscarPeliculaPorId(int idPelicula) throws PersistenciaException;
}
