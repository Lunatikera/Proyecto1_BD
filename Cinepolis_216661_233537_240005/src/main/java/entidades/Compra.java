/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Chris
 */
public class Compra {

    private Date fechaCompra;
    private int cantidadBoletos;
    private int clienteId;
    private int funcionId;

    public Compra() {
    }

    public Compra(Date fechaCompra, int cantidadBoletos, int clienteId, int funcionId) {
        this.fechaCompra = fechaCompra;
        this.cantidadBoletos = cantidadBoletos;
        this.clienteId = clienteId;
        this.funcionId = funcionId;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getFuncionId() {
        return funcionId;
    }

    public void setFuncionId(int funcionId) {
        this.funcionId = funcionId;
    }

}
