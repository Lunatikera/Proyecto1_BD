/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import persistencia.IPaisDAO;

/**
 *
 * @author Usuario
 */
public class PaisNegocio implements IPaisNegocio {
     private IPaisDAO paisDAO;

    public PaisNegocio(IPaisDAO paisDAO) {
        this.paisDAO = paisDAO;
    }

}
