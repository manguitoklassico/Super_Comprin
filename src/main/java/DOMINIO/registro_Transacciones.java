/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMINIO;

/**
 *
 * @author alexg
 */
public class registro_Transacciones {
    private int Numero_Transacion;
    private int Precio_Compra;
    private int Puntos_Obtenidos;
    private String DNI;

    public registro_Transacciones() {
    }

    public registro_Transacciones(int Numero_Transacion) {
        this.Numero_Transacion = Numero_Transacion;
    }

    public registro_Transacciones(int Precio_Compra, int Puntos_Obtenidos, String DNI) {
        this.Precio_Compra = Precio_Compra;
        this.Puntos_Obtenidos = Puntos_Obtenidos;
        this.DNI = DNI;
    }

    public registro_Transacciones(int Numero_Transacion, int Precio_Compra, int Puntos_Obtenidos, String DNI) {
        this.Numero_Transacion = Numero_Transacion;
        this.Precio_Compra = Precio_Compra;
        this.Puntos_Obtenidos = Puntos_Obtenidos;
        this.DNI = DNI;
    }

    public int getNumero_Transacion() {
        return Numero_Transacion;
    }

    public void setNumero_Transacion(int Numero_Transacion) {
        this.Numero_Transacion = Numero_Transacion;
    }

    public int getPrecio_Compra() {
        return Precio_Compra;
    }

    public void setPrecio_Compra(int Precio_Compra) {
        this.Precio_Compra = Precio_Compra;
    }

    public int getPuntos_Obtenidos() {
        return Puntos_Obtenidos;
    }

    public void setPuntos_Obtenidos(int Puntos_Obtenidos) {
        this.Puntos_Obtenidos = Puntos_Obtenidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "registro_Transacciones{" + "Numero_Transacion=" + Numero_Transacion + ", Precio_Compra=" + Precio_Compra + ", Puntos_Obtenidos=" + Puntos_Obtenidos + ", DNI=" + DNI + '}';
    }
    
}
