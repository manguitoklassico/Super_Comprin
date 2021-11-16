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
import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author alexg
 */
public class ClientesDAO {

    private static final String SQL_REGISTRARSE= "INSERT INTO clientes (Nombre,Apellidos,DNI,`E-Mail`,FechaDeNacimiento,Contraseña) VALUES(?,?,?,?,?,?)";
    private static final String SQL_INICIAR_SESION = "SELECT DNI, Contraseña FROM clientes WHERE DNI=? AND Contraseña=?";

    public int Registrarse(Clientes Cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        int registros = 0;
        String a;
        int ERROR1 = 10;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_REGISTRARSE);
            stmt.setString(1, Cliente.getNombre());
            stmt.setString(2, Cliente.getApellidos());
            stmt.setString(3, Cliente.getDNI());
            stmt.setString(4, Cliente.getEmail());
            stmt.setDate(5, (Date) Cliente.getFechaDeNacimiento());
            stmt.setString(6, Cliente.getContraseña());

            a = Cliente.getDNI();
            String verificar = "SELECT DNI FROM clientes WHERE DNI = '" + a + "'";
            
                stmt2 = conn.prepareStatement(verificar);
                rs = stmt2.executeQuery();

                if (rs.next()==false){
                    registros = stmt.executeUpdate();
                }
        } catch (SQLException ex) {
             return ERROR1;
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

    public int IniciarSesion(Clientes Cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String a;
        String c;
        int registros = 0;
        int b = 1;
        int ERROR4 = 40;
        try {
            conn = getConnection();   
            a = Cliente.getDNI();
            c = Cliente.getContraseña();
            String verificar = "SELECT DNI, Contraseña FROM clientes WHERE (DNI= '" + a + "') AND (Contraseña= '" + c + "')";
            
                stmt = conn.prepareStatement(verificar);
                rs = stmt.executeQuery();
                if (rs.next()==false){
                    return ERROR4;
                }
        } catch (SQLException ex) {
            //ex.printStackTrace(System.out);
            return ERROR4;
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
