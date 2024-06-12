/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.CompraDTO;

/**
 *
 * @author Chris
 */
public interface ICompraNegocio {
    public void realizarCompra (CompraDTO compra) throws NegocioException;
}
