/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;



/**
 *
 * @author MEDAC
 */
public class ConexionSQL {
    
    //atributos
        private static final String driver = "com.mysql.cj.jdbc.Driver";
        private static final String ConexionURL = "jdbc:mysql://localhost:3306/prueba";
        
            String usuario;
            String password;   
            Connection conn;
            
            
           public ConexionSQL (){
             this.usuario = "root" ;
             this.password= "Medac123";
           }
           
 
    
    public void conectar() throws SQLException, ClassNotFoundException {
        
            Class.forName(driver);
            conn = DriverManager.getConnection(ConexionURL,  usuario, password);
        
    }
    
     public ResultSet ejecutarSelect( String Consulta) throws SQLException {
        Statement stmt =  conn.createStatement();
        ResultSet rset = stmt.executeQuery(Consulta);
        return rset;
    }
    
    
     
     
     
     
     public Connection getConnection() {
        return conn;
    }

}
