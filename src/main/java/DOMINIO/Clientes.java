/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMINIO;

import java.util.Date;

/**
 *
 * @author alexg
 */
public class Clientes {
   private String Nombre; 
   private String Apellidos;
   private String DNI;
   private String Email;
   private Date FechaDeNacimiento;
   private String Contraseña;

    public Clientes() {
    }

    public Clientes(String DNI) {
        this.DNI = DNI;
    }

    public Clientes(String Nombre, String Apellidos, String Email, Date FechaDeNacimiento, String Contraseña) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.FechaDeNacimiento = FechaDeNacimiento;
        this.Contraseña = Contraseña;
    }

    public Clientes(String Nombre, String Apellidos, String DNI, String Email, Date FechaDeNacimiento, String Contraseña) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.DNI = DNI;
        this.Email = Email;
        this.FechaDeNacimiento = FechaDeNacimiento;
        this.Contraseña = Contraseña;
    }

    public Clientes(String DNI, String Contraseña) {
        this.DNI = DNI;
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public String getEmail() {
        return Email;
    }

    public Date getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setFechaDeNacimiento(Date FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    @Override
    public String toString() {
        return "Clientes{" + "Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", DNI=" + DNI + ", Email=" + Email + ", FechaDeNacimiento=" + FechaDeNacimiento + ", Contrase\u00f1a=" + Contraseña + '}';
    }
}
