/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import static DATOS.Conexion.close;
import static DATOS.Conexion.getConnection;
import DOMINIO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexg
 */
public class EWalletDAO {

    private static final String SQL_CREAR_CARTERA = "INSERT INTO ewallet (Saldo,Puntos,DNI) VALUES(0,0,?)";
    private static final String SQL_Visualizar_Puntos = "SELECT Puntos FROM ewallet WHERE DNI LIKE ?";
    private static final String SQL_Visualizar_Saldo = "SELECT Saldo FROM ewallet WHERE DNI LIKE ?";
    private static final String SQL_RECARGAR = "UPDATE ewallet SET Saldo = (Saldo+?) WHERE DNI = ?;";
    
    public int CrearCartera(EWallet cartera) {
        Connection conn = null;
        PreparedStatement stmt = null;  
        int registros = 0;
        String a;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        boolean res = false;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_CREAR_CARTERA);
            stmt.setString(1, cartera.getDNI());

             a = cartera.getDNI();
            String verificar = "SELECT DNI FROM ewallet WHERE DNI = " + a;
                        try {
                stmt2 = conn.prepareStatement(verificar);
                rs = stmt2.executeQuery();
            } catch (SQLException ex) {
                res = true;
            }
            if (res == true) {
                try {
                    registros = stmt.executeUpdate();

                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public String VisualizarPuntos(EWallet cartera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros;
        String a=null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_Visualizar_Puntos);
            stmt.setString(1, cartera.getDNI());
            rs = stmt.executeQuery();
            while(rs.next()){
                registros=rs.getInt(1);
                a=Integer.toString(registros)+"p";
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return a;
    }
    
    public String VisualizarSaldo(EWallet cartera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros;
        String a=null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_Visualizar_Saldo);
            stmt.setString(1, cartera.getDNI());
            rs = stmt.executeQuery();
            while(rs.next()){
                registros=rs.getInt(1);
                a=Integer.toString(registros)+"€";
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return a;
    }
    
    public int recargar(EWallet cartera){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        int ERROR3 =30;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_RECARGAR);
            stmt.setInt(1, cartera.getSaldo());
            stmt.setString(2, cartera.getDNI());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
