/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cinepolis;

import forms.FrmInicio;
import negocio.ClienteNegocio;
import negocio.IClienteNegocio;
import negocio.IPeliculaNegocio;
import negocio.PeliculaNegocio;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.IClienteDAO;
import persistencia.IConexionBD;
import persistencia.IPeliculaDAO;
import persistencia.PeliculaDAO;

/**
 *
 * @author Chris
 */
public class Main {

    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        IClienteDAO clientesDAO = new ClienteDAO(conexionBD);
        IPeliculaDAO peliculaDAO= new PeliculaDAO(conexionBD);
        IClienteNegocio clienteNeg = new ClienteNegocio(clientesDAO);
        IPeliculaNegocio peliculaNeg= new PeliculaNegocio(peliculaDAO);
        FrmInicio frmCrud = new FrmInicio(clienteNeg, peliculaNeg);
        frmCrud.show();

    }
}
