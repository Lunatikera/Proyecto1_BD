/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Timestamp;

/**
 *
 * @author Usuario
 */
public class Funcion {
   private int id;
   private double precio;
   private String dia;
   private Timestamp hora;
   private Timestamp horaFinal;
   private int asientosDisponibles;
   private int duracionTotalmin;
   private int idSala;
   private int idPelicula;
   private int idPrecio;

    public Funcion() {
    }

    public Funcion(int id, double precio, String dia, Timestamp hora, Timestamp horaFinal, int asientosDisponibles, int duracionTotalmin, int idSala, int idPelicula, int idPrecio) {
        this.id = id;
        this.precio = precio;
        this.dia = dia;
        this.hora = hora;
        this.horaFinal = horaFinal;
        this.asientosDisponibles = asientosDisponibles;
        this.duracionTotalmin = duracionTotalmin;
        this.idSala = idSala;
        this.idPelicula = idPelicula;
        this.idPrecio = idPrecio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public Timestamp getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Timestamp horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public int getDuracionTotalmin() {
        return duracionTotalmin;
    }

    public void setDuracionTotalmin(int duracionTotalmin) {
        this.duracionTotalmin = duracionTotalmin;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(int idPrecio) {
        this.idPrecio = idPrecio;
    }
    
   
}
