/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Chris
 */
public class CompraDAO implements ICompraDAO{

    IConexionBD conexionBD;

    public CompraDAO(IConexionBD conexionBD)  {
        this.conexionBD = conexionBD;
    }

    @Override
    public void insertarCompra(Compra compra) throws PersistenciaException {
        String sql = "INSERT INTO Compras (fecha_compra, cantidad_Boletos, cliente_id, funcion_id) VALUES (?, ?, ?, ?)";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(compra.getFechaCompra().getTime()));
            ps.setInt(2, compra.getCantidadBoletos());
            ps.setInt(3, compra.getClienteId());
            ps.setInt(4, compra.getFuncionId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al insertar la compra: " + e.getMessage(), e);
        }
    }
}
