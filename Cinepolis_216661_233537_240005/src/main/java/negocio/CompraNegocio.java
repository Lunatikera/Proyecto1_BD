/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.CompraDTO;
import entidades.Compra;
import persistencia.ICompraDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Chris
 */
public class CompraNegocio {

    private ICompraDAO compraDAO;

    public CompraNegocio(ICompraDAO compraDAO) {
        this.compraDAO = compraDAO;
    }

    public void realizarCompra(CompraDTO compra) throws NegocioException {
        Compra compra1 = new Compra(compra.getFechaCompra(),
                compra.getCantidadBoletos(),
                compra.getClienteId(), compra.getFuncionId());
        try {
            compraDAO.insertarCompra(compra1);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al realizar la compra: " + e.getMessage(), e);
        }
    }

}
