/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import static DATOS.Conexion.close;
import static DATOS.Conexion.getConnection;
import DOMINIO.EWallet;
import DOMINIO.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author alexg
 */
public class ProductoDAO {
    private static final String Mostrar_Prodcutos = "select Nombre_Producto , ID_Producto , Precio , PrecioPuntos, PuntosDevueltos FROM producto WHERE Stock>0;";
    private static final String Mostrar_Prodcutos2 = "select Nombre_Producto , ID_Producto , Precio , PrecioPuntos, PuntosDevueltos FROM producto";
    
    private static final String SQL_PRODUCTO = "UPDATE producto SET Stock = (Stock-?) WHERE ID_Producto =?";
    private static final String SQL_ALTERAR_EWALLET = "UPDATE ewallet SET Saldo = (Saldo-(?*?)) , Puntos =(Puntos+(?*?)) WHERE DNI = ?";
    private static final String COGER_PRECIO = "select Precio, PuntosDevueltos FROM producto WHERE ID_Producto = ?;";
    private static final String SQL_Visualizar_Saldo = "SELECT Saldo FROM ewallet WHERE DNI LIKE ?";
    
    private static final String SQL_Visualizar_Puntos = "SELECT Puntos FROM ewallet WHERE DNI LIKE ?";
    private static final String COGER_PRECIO_PUNTOS = "select PrecioPuntos, PuntosDevueltos FROM producto WHERE ID_Producto = ?";
    private static final String SQL_ALTERAR_EWALLET_2 = "UPDATE ewallet SET Puntos = (Puntos-(?*?)), Puntos = (Puntos+(?*?)) WHERE DNI = ?";
    
    
    private static final String SQL_PRODUCTO2 = "UPDATE producto SET Stock = (Stock+?) WHERE ID_Producto =?";
    private static final String SQL_ALTERAR_EWALLET_3 = "UPDATE ewallet SET Saldo = (Saldo+(?*?)), Puntos =(Puntos-(?*?)) WHERE DNI = ?";
    private static final String COGER_PRECIO2 = "select Precio, PuntosDevueltos FROM producto WHERE ID_Producto = ?";
    
    private static final String COGER_PRECIO_PUNTOS_2 = "select PrecioPuntos, PuntosDevueltos FROM producto WHERE ID_Producto = ?";
    private static final String SQL_ALTERAR_EWALLET_4 = "UPDATE ewallet SET Puntos = (Puntos+(?*?)), Puntos = (Puntos-(?*?)) WHERE DNI = ?";
    
    private Connection conexionTransaccional;
    
        public Vector<Producto> ListaProductos(){
        Vector <Producto> producto = new Vector <Producto>();
        Producto p = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(Mostrar_Prodcutos);
            rs = stmt.executeQuery();
            while(rs.next()){
                p = new Producto();              
                    p.setNombre(rs.getString(1));
                    p.setID_Producto(rs.getInt(2));
                    p.setPrecio(rs.getInt(3));
                    p.setPrecioPuntos(rs.getInt(4));
                    p.setPuntosP(rs.getInt(5));
                producto.add(p);
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
        return producto;  
    }
        
        public Vector<Producto> ListaProductos2(){
        Vector <Producto> producto = new Vector <Producto>();
        Producto p = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(Mostrar_Prodcutos2);
            rs = stmt.executeQuery();
            while(rs.next()){
                p = new Producto();              
                    p.setNombre(rs.getString(1));
                    p.setID_Producto(rs.getInt(2));
                    p.setPrecio(rs.getInt(3));
                    p.setPrecioPuntos(rs.getInt(4));
                    p.setPuntosP(rs.getInt(5));
                producto.add(p);
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
        return producto;  
    }
        
    public int Comprobar(Producto producto){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int a3=0;
        try{
        conn = getConnection();
        int a=producto.getID_Producto();    
        String RecibeStock = "SELECT Stock From producto WHERE ID_Producto="+a;
            stm = conn.prepareStatement(RecibeStock);
            //stm.setInt(1,producto.getID_Producto());
            rs = stm.executeQuery();
            if(rs.next()){ 
                a3=rs.getInt(1)+1;
            }
            if(producto.getStock()>=a3){
                return 60;
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        {
            try {
                close(stm);
                close(conn);
            
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return 0; 
    }
        
    public int Comprar (Producto producto, EWallet ewallet) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        Producto p = null;
        int a1=0;
        int a2=0;
        int b;
        int c;
        int a3=0;
        int a4=0;
        int Trans_completada=0;
        int ERROR6= 60;
        int ERROR7= 70;

        
        conn = this.conexionTransaccional != null ? 
        this.conexionTransaccional : Conexion.getConnection();
        
        try{
            conn = getConnection();
            conn.setAutoCommit(false);
            
            String RecibeStock = "SELECT Stock From producto WHERE ID_Producto=?";
            stm = conn.prepareStatement(RecibeStock);
            stm.setInt(1,producto.getID_Producto());
            rs = stm.executeQuery();
            while(rs.next()){ 
                a3=rs.getInt(1);
            }
            
            if(a3>=producto.getStock()){        
                stmt = conn.prepareStatement(SQL_PRODUCTO);
                stmt.setInt(1,producto.getStock());
                stmt.setInt(2,producto.getID_Producto());
                b = stmt.executeUpdate();    
            }else{
                conn.rollback();
                return ERROR6;
            }
            
            stmt2 = conn.prepareStatement(COGER_PRECIO);
            stmt2.setInt(1,producto.getID_Producto());
            rs2 = stmt2.executeQuery();
            while(rs2.next()){ 
                a1=rs2.getInt(1);
                a2=rs2.getInt(2);
            }
            
            stmt = conn.prepareStatement(SQL_Visualizar_Saldo);
            stmt.setString(1, ewallet.getDNI());
            rs = stmt.executeQuery();
            while(rs.next()){
                a4=rs.getInt(1);
            }
            int precioapagar = (a1*producto.getStock());
            
            if(precioapagar<=a4){
                stmt3 = conn.prepareStatement(SQL_ALTERAR_EWALLET);
                stmt3.setInt(1, a1);
                stmt3.setInt(2,producto.getStock()); 
                stmt3.setInt(3, a2);
                stmt3.setInt(4,producto.getStock()); 
                stmt3.setString(5,ewallet.getDNI());
                c = stmt3.executeUpdate();
            }else{
                conn.rollback();
                return ERROR7;
            }
            
            conn.commit();
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
            conn.rollback();
            
        }   finally {
            try {
                close(stm);
                close(stmt); 
                close(stmt2);
                if (this.conexionTransaccional == null) {
                close(conn);
            }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return Trans_completada;  
    }
    
    public int ComprarConPuntos (Producto producto, EWallet ewallet) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        Producto p = null;
        int a1=0;
        int a2=0;
        int b;
        int c;
        int a3 =0;
        int a4 =0;
        int ERROR6 = 60;
        int ERROR8 = 80;
        conn = this.conexionTransaccional != null ? 
        this.conexionTransaccional : Conexion.getConnection();
        
        try{
            conn = getConnection();
            conn.setAutoCommit(false);
            
            String RecibeStock = "SELECT Stock From producto WHERE ID_Producto=?";
            stm = conn.prepareStatement(RecibeStock);
            stm.setInt(1,producto.getID_Producto());
            rs = stm.executeQuery();
            while(rs.next()){ 
                a3=rs.getInt(1);
            }
            if(a3>=producto.getStock()){ 
                stmt = conn.prepareStatement(SQL_PRODUCTO);
                stmt.setInt(1,producto.getStock());
                stmt.setInt(2,producto.getID_Producto());
                b = stmt.executeUpdate();    
            }else{
                conn.rollback();
                return ERROR6;
            }
            stmt2 = conn.prepareStatement(COGER_PRECIO_PUNTOS);
            stmt2.setInt(1,producto.getID_Producto());
            rs2 = stmt2.executeQuery();
            while(rs2.next()){ 
                a1=rs2.getInt(1);
                a2=rs2.getInt(2);
            }
            
            stmt = conn.prepareStatement(SQL_Visualizar_Puntos);
            stmt.setString(1, ewallet.getDNI());
            rs = stmt.executeQuery();
            while(rs.next()){
                a4=rs.getInt(1);
            }
            int puntosapagar = (a1*producto.getStock());
            
            if(puntosapagar<=a4){
                stmt3 = conn.prepareStatement(SQL_ALTERAR_EWALLET_2);
                stmt3.setInt(1, a1);
                stmt3.setInt(2,producto.getStock());    
                stmt3.setInt(3, a2);
                stmt3.setInt(4,producto.getStock());
                stmt3.setString(5,ewallet.getDNI());
                c = stmt3.executeUpdate();
            }else{
                conn.rollback();
                return ERROR8; 
            }
            conn.commit();
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
            conn.rollback();
        }   finally {
            try {
                close(stmt);                
                if (this.conexionTransaccional == null) {
                close(conn);
            }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return 1;  
    }
    
     public int Devolver (Producto producto, EWallet ewallet) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        Producto p = null;
        int a1=0;
        int a2=0;
        int a3=0;
        int b;
        int c;
        int ERROR8 = 80;
        conn = this.conexionTransaccional != null ? 
        this.conexionTransaccional : Conexion.getConnection();
        
        try{
            conn = getConnection();
            conn.setAutoCommit(false);
            
            stmt = conn.prepareStatement(SQL_PRODUCTO2);
            stmt.setInt(1,producto.getStock());
            stmt.setInt(2,producto.getID_Producto());
            b = stmt.executeUpdate();    
            
            stmt2 = conn.prepareStatement(COGER_PRECIO2);
            stmt2.setInt(1,producto.getID_Producto());
            rs2 = stmt2.executeQuery();
            while(rs2.next()){ 
                a1=rs2.getInt(1);
                a2=rs2.getInt(2);
            }
            
            stmt = conn.prepareStatement(SQL_Visualizar_Puntos);
            stmt.setString(1, ewallet.getDNI());
            rs = stmt.executeQuery();
            while(rs.next()){
                a3=rs.getInt(1);
            }
            int puntosrestantes = (a3-(a2*producto.getStock()));
            
            if(puntosrestantes>=5){
                stmt3 = conn.prepareStatement(SQL_ALTERAR_EWALLET_3);
                stmt3.setInt(1, a1);
                stmt3.setInt(2,producto.getStock()); 
                stmt3.setInt(3, a2);
                stmt3.setInt(4,producto.getStock()); 
                stmt3.setString(5,ewallet.getDNI());
                c = stmt3.executeUpdate();
            }else{
                conn.rollback();
                return ERROR8;
            }
            conn.commit();
            
        }catch(SQLException ex){
            conn.rollback();
            
        }   finally {
            try {
                close(stmt);                
                if (this.conexionTransaccional == null) {
                close(conn);
            }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return 1;  
    }
     
        public int DevolverEnPuntos (Producto producto, EWallet ewallet) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        Producto p = null;
        int a1=0;
        int a2=0;
        int a3=0;
        int b;
        int c;
        int ERROR8 = 80;
        conn = this.conexionTransaccional != null ? 
        this.conexionTransaccional : Conexion.getConnection();
        
        try{
            conn = getConnection();
            conn.setAutoCommit(false);
            
            stmt = conn.prepareStatement(SQL_PRODUCTO2);
            stmt.setInt(1,producto.getStock());
            stmt.setInt(2,producto.getID_Producto());
            b = stmt.executeUpdate();    
            
            stmt2 = conn.prepareStatement(COGER_PRECIO_PUNTOS_2);
            stmt2.setInt(1,producto.getID_Producto());
            rs2 = stmt2.executeQuery();
            while(rs2.next()){ 
                a1=rs2.getInt(1);
                a2=rs2.getInt(2);
            }
            stmt = conn.prepareStatement(SQL_Visualizar_Puntos);
            stmt.setString(1, ewallet.getDNI());
            rs = stmt.executeQuery();
            while(rs.next()){
                a3=rs.getInt(1);
            }
            int puntosrestantes = (a3-(a2*producto.getStock()));
            
            if(puntosrestantes>=5){
                stmt3 = conn.prepareStatement(SQL_ALTERAR_EWALLET_4);
                stmt3.setInt(1, a1);
                stmt3.setInt(2,producto.getStock());    
                stmt3.setInt(3, a2);
                stmt3.setInt(4,producto.getStock());
                stmt3.setString(5,ewallet.getDNI());
                c = stmt3.executeUpdate();
            }else{
                conn.rollback();
                return ERROR8;
            }
            conn.commit();
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
            conn.rollback();
            return 0;
            
        }   finally {
            try {
                close(stmt);                
                if (this.conexionTransaccional == null) {
                close(conn);
            }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return 1;  
    }
}
