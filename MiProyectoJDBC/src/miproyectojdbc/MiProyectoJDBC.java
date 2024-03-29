/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miproyectojdbc;

/**
 *
 * @author jeand
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MiProyectoJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/inventario2";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            // TODO code application logic here

            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MiProyectoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIO(idUsuario,Nombre,Contraseña) VALUE('3','Abc','ABC123')");
            rs = statement.executeQuery("SELECT * FROM USUARIO");
            rs.next();
            do{
                System.out.println(rs.getInt("idUsuario")+" : "+rs.getString("Nombre"));  
            }while(rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(MiProyectoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}