/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Cliente;
import java.sql.Connection;
import java.util.Date;
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
        String sentenciaSQLCliente = "INSERT INTO Clientes (nombres, apellidoPA, apellidoMA, correo, contraseña, fechaNacimiento, ubicacion, ciudad_id) VALUES (?,?,?,?,?,?,?,?);";
        String sentenciaSQLCiudad = "INSERT INTO Ciudades (nombre, pais_id) VALUES (?, ?) ON DUPLICATE KEY UPDATE ciudad_id=LAST_INSERT_ID(ciudad_id);";
        String sentenciaSQLPais = "INSERT INTO Paises (nombre) VALUES (?) ON DUPLICATE KEY UPDATE pais_id=LAST_INSERT_ID(pais_id);";
        String obtenerPaisIdSQL = "SELECT pais_id FROM Paises WHERE nombre = ?";
        String obtenerCiudadIdSQL = "SELECT ciudad_id FROM Ciudades WHERE nombre = ? AND pais_id = ?";

        Connection conexion = null;
        PreparedStatement pSCiudad = null;
        PreparedStatement pSPais = null;
        PreparedStatement pSCliente = null;
        PreparedStatement pSObtenerPaisId = null;
        PreparedStatement pSObtenerCiudadId = null;
        ResultSet res = null;

        try {
            conexion = this.conexionBD.crearConexion();
            conexion.setAutoCommit(false);
            pSObtenerPaisId = conexion.prepareStatement(obtenerPaisIdSQL);
            pSObtenerPaisId.setString(1, cliente.getPais());
            res = pSObtenerPaisId.executeQuery();
            int paisId = -1;
            if (res.next()) {
                paisId = res.getInt(1);
            } else {
                pSPais = conexion.prepareStatement(sentenciaSQLPais, Statement.RETURN_GENERATED_KEYS);
                pSPais.setString(1, cliente.getPais());
                pSPais.executeUpdate();
                res = pSPais.getGeneratedKeys();
                if (res.next()) {
                    paisId = res.getInt(1);
                } else {
                    throw new PersistenciaException("No se pudo obtener el ID del país.");
                }
            }

            pSObtenerCiudadId = conexion.prepareStatement(obtenerCiudadIdSQL);
            pSObtenerCiudadId.setString(1, cliente.getCiudad());
            pSObtenerCiudadId.setInt(2, paisId);
            res = pSObtenerCiudadId.executeQuery();
            int ciudadId = -1;
            if (res.next()) {
                ciudadId = res.getInt(1);
            } else {
                pSCiudad = conexion.prepareStatement(sentenciaSQLCiudad, Statement.RETURN_GENERATED_KEYS);
                pSCiudad.setString(1, cliente.getCiudad());
                pSCiudad.setInt(2, paisId);
                pSCiudad.executeUpdate();
                res = pSCiudad.getGeneratedKeys();
                if (res.next()) {
                    ciudadId = res.getInt(1);
                } else {
                    throw new PersistenciaException("No se pudo obtener el ID de la ciudad.");
                }
            }

            cliente.setIdCiudad(ciudadId);

            java.sql.Date sqlDate = new java.sql.Date(cliente.getFechaNacimiento().getTime());

            pSCliente = conexion.prepareStatement(sentenciaSQLCliente, Statement.RETURN_GENERATED_KEYS);
            pSCliente.setString(1, cliente.getNombre());
            pSCliente.setString(2, cliente.getApellidoPA());
            pSCliente.setString(3, cliente.getApellidoMA());
            pSCliente.setString(4, cliente.getCorreo());
            pSCliente.setString(5, cliente.getContraseña());
            pSCliente.setDate(6, sqlDate);
            pSCliente.setObject(7, cliente.getUbicacion());
            pSCliente.setInt(8, cliente.getIdCiudad());
            pSCliente.executeUpdate();

            res = pSCliente.getGeneratedKeys();
            int idGenerado = -1;
            if (res.next()) {
                idGenerado = res.getInt(1);
                cliente.setId(idGenerado);
            } else {
                throw new PersistenciaException("No se pudo obtener el ID generado.");
            }
            conexion.commit();
            conexion.close();
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

        String sentenciaSQL = "UPDATE clientes SET nombres = ?, apellidoPA = ?, apellidoMA = ?, correo = ?, contraseña = ?, fechaNacimiento = ?, ubicacion = ?, ciudad_id = ?;";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement pS = conexion.prepareStatement(sentenciaSQL)) {

            java.sql.Date sqlDate = new java.sql.Date(cliente.getFechaNacimiento().getTime());

            pS.setString(1, cliente.getNombre());
            pS.setString(2, cliente.getApellidoPA());
            pS.setString(3, cliente.getApellidoMA());
            pS.setString(4, cliente.getCorreo());
            pS.setString(5, cliente.getContraseña());
            pS.setDate(6, sqlDate);
            pS.setDouble(7, cliente.getUbicacion());
            pS.setInt(8, cliente.getIdCiudad());

            pS.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    @Override
    public void eliminarCliente(int idCliente) throws PersistenciaException {

        String sentenciaSQL = "DELETE FROM clientes WHERE cliente_id = ?;";
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

        String sql = "SELECT * FROM clientes LIMIT ? OFFSET ?";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, limit);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("cliente_id"));
                    cliente.setNombre(rs.getString("nombres"));
                    cliente.setApellidoPA(rs.getString("apellidoPA"));
                    cliente.setApellidoMA(rs.getString("apellidoMA"));
                    cliente.setCorreo(rs.getString("correo"));
                    cliente.setContraseña(rs.getString("contraseña"));
                    cliente.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    cliente.setIdCiudad(rs.getInt("ciudad_id"));
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

        String sentenciaSQL = "SELECT * FROM clientes WHERE cliente_id = ?;";
        ResultSet res = null;

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sentenciaSQL)) {

            ps.setInt(1, idCliente);

            res = ps.executeQuery();

            if (res.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("cliente_id"));
                cliente.setNombre(res.getString("nombres"));
                cliente.setApellidoPA(res.getString("apellidoPA"));
                cliente.setApellidoMA(res.getString("apellidoMA"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setContraseña(res.getString("contraseña"));
                cliente.setFechaNacimiento(res.getDate("fechaNacimiento"));
                cliente.setIdCiudad(res.getInt("ciudad_id"));
                return cliente;
            } else {
                throw new PersistenciaException("No se encontró el cliente con ID: " + idCliente);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar el cliente por ID: " + e.getMessage());
        }
    }

    @Override
    public Cliente buscarClientePorCorreo(String correo) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Clientes WHERE correo = ?;";
        ResultSet res = null;

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sentenciaSQL)) {

            ps.setString(1, correo);

            res = ps.executeQuery();

            if (res.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("cliente_id"));
                cliente.setNombre(res.getString("nombres"));
                cliente.setApellidoPA(res.getString("apellidoPA"));
                cliente.setApellidoMA(res.getString("apellidoMA"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setContraseña(res.getString("contraseña"));
                cliente.setFechaNacimiento(res.getDate("fechaNacimiento"));
                cliente.setIdCiudad(res.getInt("ciudad_id"));
                return cliente;
            } else {
                throw new PersistenciaException("No se encontró el cliente registrado con el correo: " + correo);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar el cliente por su correo: " + e.getMessage());
        }
    }

}
