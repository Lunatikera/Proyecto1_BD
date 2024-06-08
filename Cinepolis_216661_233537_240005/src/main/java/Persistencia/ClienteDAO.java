/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris
 */
public class ClienteDAO implements IClienteDAO {

    IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cliente agregar(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO cliente (nombre, correo, fechaNacimiento, ubicacion) VALUES (?,?,?,?);";
        Connection conexion = null;
        PreparedStatement pS = null;
        ResultSet res = null;

        try {
            conexion = this.conexionBD.crearConexion();
            conexion.setAutoCommit(false);
            pS = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);

            pS.setString(1, cliente.getNombre());
            pS.setString(2, cliente.getCorreo());
            pS.setDate(3, cliente.getFechaNacimiento());
            pS.setDouble(4, cliente.getUbicacion());

            pS.executeUpdate();

            res = pS.getGeneratedKeys();

            int idGenerado = -1;
            if (res.next()) {
                idGenerado = res.getInt(1);
                cliente.setId(idGenerado);
            } else {
                throw new PersistenciaException("No se pudo obtener el ID generado.");
            }
            conexion.commit();
            return cliente;
        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                    throw new PersistenciaException("Error al realizar el rollback: " + ex.getMessage());
                }
            }
            throw new PersistenciaException("No se pudo guardar el cliente: " + e.getMessage());
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = "UPDATE cliente SET nombre = ?, correo = ?, fechaNacimiento = ?, ubicacion = ?;";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            pS.setString(1, cliente.getNombre());
            pS.setString(2, cliente.getCorreo());
            pS.setDate(3, cliente.getFechaNacimiento());
            pS.setDouble(4, cliente.getUbicacion());

            pS.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    @Override
    public void eliminarCliente(int idCliente) throws PersistenciaException {
        String sentenciaSQL = "DELETE FROM cliente WHERE cliente_id = ?;";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            pS.setInt(1, idCliente);
            int filasAfectadas = pS.executeUpdate();

            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se encontró el cliente con ID: " + idCliente);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar el cliente: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> buscarCliente(int limit, int offset) throws PersistenciaException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente LIMIT ? OFFSET ?";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, limit);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("cliente_id"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setCorreo(rs.getString("correo"));
                    cliente.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    cliente.setUbicacion(rs.getDouble("ubicacion"));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar los clientes." + e.getMessage());
        }
        return clientes;
    }

    @Override
    public Cliente buscarClientePorId(int idCliente) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM cliente WHERE cliente_id = ?;";
        ResultSet res = null;

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sentenciaSQL)) {

            ps.setInt(1, idCliente);

            res = ps.executeQuery();

            if (res.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("cliente_id"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setFechaNacimiento(res.getDate("fechaNacimiento"));
                cliente.setUbicacion(res.getDouble("ubicacion"));
                return cliente;
            } else {
                throw new PersistenciaException("No se encontró el cliente con ID: " + idCliente);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar el cliente por ID: " + e.getMessage());
        }
    }

}
