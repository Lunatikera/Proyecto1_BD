package cinepolis;

import dtos.ClienteDTO;
import dtos.PeliculaDTO;
import forms.FrmAgregarPelicula;
import forms.FrmCatalogoPeliculas;
import forms.FrmInicio;
import negocio.CiudadNegocio;
import negocio.ClienteNegocio;
import negocio.FuncionNegocio;
import negocio.ICiudadNegocio;
import negocio.IClienteNegocio;
import negocio.IFuncionNegocio;
import negocio.IPaisNegocio;
import negocio.IPeliculaNegocio;
import negocio.ISalaNegocio;
import negocio.ISucursalNegocio;
import negocio.PaisNegocio;
import negocio.PeliculaNegocio;
import negocio.SalaNegocio;
import negocio.SucursalNegocio;
import persistencia.CiudadDAO;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.FuncionDAO;
import persistencia.ICiudadDAO;
import persistencia.IClienteDAO;
import persistencia.IConexionBD;
import persistencia.IFuncionDAO;
import persistencia.IPaisDAO;
import persistencia.IPeliculaDAO;
import persistencia.ISalaDAO;
import persistencia.ISucursalDAO;
import persistencia.PaisDAO;
import persistencia.PeliculaDAO;
import persistencia.SalaDAO;
import persistencia.SucursalDAO;

public class Main {

    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        IPeliculaDAO peliDAO = new PeliculaDAO(conexionBD);
        IFuncionDAO funcionDAO= new FuncionDAO(conexionBD);
        IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
        ICiudadDAO ciudadDAO = new CiudadDAO(conexionBD);
        IPaisDAO paisDAO = new PaisDAO(conexionBD);
        ISalaDAO salaDAO=new SalaDAO(conexionBD);
        ISucursalDAO sucursalDAO= new SucursalDAO(conexionBD);
        IClienteNegocio clienteNeg = new ClienteNegocio(clienteDAO);
        IFuncionNegocio funcionNeg= new FuncionNegocio(funcionDAO);
        ICiudadNegocio ciudadNeg = new CiudadNegocio(ciudadDAO);
        ISalaNegocio salaNeg= new SalaNegocio(salaDAO);
        IPaisNegocio paisNeg = new PaisNegocio(paisDAO);
        ISucursalNegocio sucursalNeg= new SucursalNegocio(sucursalDAO);
        IPeliculaNegocio peliNeg = new PeliculaNegocio(peliDAO);

        FrmInicio a = new FrmInicio(clienteNeg, peliNeg, ciudadNeg, paisNeg, sucursalNeg, funcionNeg, salaNeg);
        a.show();

    }
}
