/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.SalaDTO;
import entidades.Sala;
import java.util.ArrayList;
import java.util.List;
import persistencia.ISalaDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class SalaNegocio implements ISalaNegocio {
  private ISalaDAO salaDAO;

    public SalaNegocio( ISalaDAO salaDAO) {
        this.salaDAO = salaDAO;
    }  

    @Override
public List<SalaDTO> listaSalasporSucursal(int idSucursal) throws NegocioException {
    List<SalaDTO> listaSalasDTO = new ArrayList<>();
    try {
        List<Sala> listaSalas = salaDAO.listaSalasporSucursal(idSucursal);
        for (Sala sala : listaSalas) {
            SalaDTO salaDTO = new SalaDTO();
            salaDTO.setId(sala.getId());
            salaDTO.setNombre(sala.getNombre());
            listaSalasDTO.add(salaDTO);
        }
    } catch (PersistenciaException e) {
        throw new NegocioException("Error al obtener lista de salas por sucursal", e);
    }
    return listaSalasDTO;
}
}
