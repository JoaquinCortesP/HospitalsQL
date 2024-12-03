/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Joaqu
 */
public class Paciente {
    private int rut;
    private String nombre;
    private String fechaDeNacimiento;
    private String direccion;
    private int telefono;

    public Paciente() {
    }

    public Paciente(int rut, String nombre, String fechaDeNacimiento, String direccion, int telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Paciente{" + "rut=" + rut + ", nombre=" + nombre + ", fechaDeNacimiento=" + fechaDeNacimiento + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
}
