/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cinepolis;

import forms.FrmInicio;
import negocio.CiudadNegocio;
import negocio.ClienteNegocio;
import negocio.ICiudadNegocio;
import negocio.IClienteNegocio;
import negocio.IPaisNegocio;
import negocio.IPeliculaNegocio;
import negocio.PaisNegocio;
import negocio.PeliculaNegocio;
import persistencia.CiudadDAO;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.ICiudadDAO;
import persistencia.IClienteDAO;
import persistencia.IConexionBD;
import persistencia.IPaisDAO;
import persistencia.IPeliculaDAO;
import persistencia.PaisDAO;
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
        ICiudadDAO ciudadDAO= new CiudadDAO(conexionBD);
        IPaisDAO paisDAO= new PaisDAO(conexionBD);
        ICiudadNegocio ciudadNegocio= new CiudadNegocio(ciudadDAO);
        IPaisNegocio paisNegocio= new PaisNegocio(paisDAO);
        IClienteNegocio clienteNeg = new ClienteNegocio(clientesDAO);
        IPeliculaNegocio peliculaNeg= new PeliculaNegocio(peliculaDAO);
        FrmInicio frmCrud = new FrmInicio(clienteNeg, peliculaNeg, ciudadNegocio, paisNegocio);
        frmCrud.show();

    }
}
