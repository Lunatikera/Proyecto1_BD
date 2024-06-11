package cinepolis;

import dtos.ClienteDTO;
import dtos.PeliculaDTO;
import forms.FrmAgregarPelicula;
import forms.FrmCatalogoPeliculas;
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

public class Main {

    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        IPeliculaDAO peliDAO = new PeliculaDAO(conexionBD);
        IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
        ICiudadDAO ciudadDAO = new CiudadDAO(conexionBD);
        IPaisDAO paisDAO = new PaisDAO(conexionBD);
        IClienteNegocio clienteNeg = new ClienteNegocio(clienteDAO);
        ICiudadNegocio ciudadNeg = new CiudadNegocio(ciudadDAO);
        IPaisNegocio paisNeg = new PaisNegocio(paisDAO);

        IPeliculaNegocio peliNeg = new PeliculaNegocio(peliDAO);
        ClienteDTO cliente = new ClienteDTO();
        PeliculaDTO pelicula = new PeliculaDTO();

        FrmInicio a = new FrmInicio(clienteNeg, peliNeg, ciudadNeg, paisNeg);
        a.show();

    }
}
