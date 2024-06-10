/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Ciudad;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICiudadDAO {
       public List<Ciudad> listaCiudades(String pais) throws PersistenciaException;
 
}
