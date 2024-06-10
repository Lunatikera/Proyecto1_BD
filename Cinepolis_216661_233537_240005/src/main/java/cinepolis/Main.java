/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cinepolis;

import forms.FrmCatalogoClientes;
import forms.FrmInicio;
import negocio.ClienteNegocio;
import negocio.IClienteNegocio;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.IClienteDAO;

/**
 *
 * @author Chris
 */
public class Main {

    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        IClienteDAO clientesDAO = new ClienteDAO(conexionBD);

        IClienteNegocio clienteNeg = new ClienteNegocio(clientesDAO);

        FrmInicio frmCrud = new FrmInicio(clienteNeg);
        frmCrud.show();

    }
}
