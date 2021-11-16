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
public class Producto {
    private int Precio;
    private int PuntosP;
    private int Stock;
    private int ID_Producto;
    private String Nombre;
    private int PrecioPuntos;

    public Producto() {
        
    }

    public Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public Producto(int Stock, int ID_Producto) {
        this.Stock = Stock;
        this.ID_Producto = ID_Producto;
    }

    public Producto(int Precio, int PuntosP, int Stock, String Nombre,int PrecioPuntos) {
        this.Precio = Precio;
        this.PuntosP = PuntosP;
        this.Stock = Stock;
        this.Nombre = Nombre;
        this.PrecioPuntos=PrecioPuntos;
    }

    public Producto(int Precio, int PuntosP, int Stock, int ID_Producto, String Nombre,int PrecioPuntos) {
        this.Precio = Precio;
        this.PuntosP = PuntosP;
        this.Stock = Stock;
        this.ID_Producto = ID_Producto;
        this.Nombre = Nombre;
        this.PrecioPuntos=PrecioPuntos;
    }

    public Producto(int Precio, int PuntosP, int ID_Producto) {
        this.Precio = Precio;
        this.PuntosP = PuntosP;
        this.ID_Producto = ID_Producto;
    }
    
    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getPuntosP() {
        return PuntosP;
    }

    public void setPuntosP(int PuntosP) {
        this.PuntosP = PuntosP;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getPrecioPuntos() {
        return PrecioPuntos;
    }

    public void setPrecioPuntos(int PrecioPuntos) {
        this.PrecioPuntos = PrecioPuntos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    @Override
    public String toString() {
        return "ID="+ ID_Producto + "  ||  " + Nombre + "  ||  " + Precio + "€" + "  ||   -" + PrecioPuntos + "p" + "  ||   +" + PuntosP + "puntos";
    }
    
}
