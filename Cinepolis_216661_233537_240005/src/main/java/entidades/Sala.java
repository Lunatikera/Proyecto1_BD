/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Usuario
 */
public class Sala {
    private int id;
    private String nombre;
    private int numeroAsiento;
    private int duracionLimpieza;
    private int iDsucursal;

    public Sala() {
    }

    public Sala(int id, String nombre, int numeroAsiento, int duracionLimpieza, int iDsucursal) {
        this.id = id;
        this.nombre = nombre;
        this.numeroAsiento = numeroAsiento;
        this.duracionLimpieza = duracionLimpieza;
        this.iDsucursal = iDsucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getDuracionLimpieza() {
        return duracionLimpieza;
    }

    public void setDuracionLimpieza(int duracionLimpieza) {
        this.duracionLimpieza = duracionLimpieza;
    }

    public int getiDsucursal() {
        return iDsucursal;
    }

    public void setiDsucursal(int iDsucursal) {
        this.iDsucursal = iDsucursal;
    }
    
    
    
}


