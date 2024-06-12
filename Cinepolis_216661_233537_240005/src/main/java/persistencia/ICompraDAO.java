/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Compra;

/**
 *
 * @author Chris
 */
public interface ICompraDAO {

    public void insertarCompra(Compra compra) throws PersistenciaException;
}
