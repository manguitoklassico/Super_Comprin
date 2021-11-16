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
public class EWallet {
    private int Saldo;
    private int PuntosEW;
    private String DNI;

    public EWallet() {
    }

    public EWallet(int Saldo) {
        this.Saldo = Saldo;
    }
    
    public EWallet(String DNI) {
        this.DNI = DNI;
    }

    public EWallet(int Saldo, int Puntos) {
        this.Saldo = Saldo;
        this.PuntosEW = Puntos;
    }

    public EWallet(int Saldo, int Puntos, String DNI) {
        this.Saldo = Saldo;
        this.PuntosEW = Puntos;
        this.DNI = DNI;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public int getPuntosEW() {
        return PuntosEW;
    }

    public void setPuntosEW(int PuntosEW) {
        this.PuntosEW = PuntosEW;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public EWallet(String DNI, int Saldo) {
        this.DNI = DNI;
        this.Saldo = Saldo;
    }

    @Override
    public String toString() {
        return "EWallet{" + "Saldo=" + Saldo + ", Puntos=" + PuntosEW + ", DNI=" + DNI + '}';
    }


}
