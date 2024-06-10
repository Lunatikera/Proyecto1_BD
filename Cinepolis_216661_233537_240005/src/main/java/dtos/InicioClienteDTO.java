/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Chris
 */
public class InicioClienteDTO {

    private int id;
    private String correo;
    private String contraseña;

    public InicioClienteDTO() {
    }

    public InicioClienteDTO(int id, String correo, String contraseña) {
        this.id = id;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public InicioClienteDTO(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
