/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasql;

import Conexion.ConexionSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MEDAC
 */
public class PruebaSQL {

        public static void main(String args[]) throws SQLException, ClassNotFoundException {
            
            ConexionSQL conexion =  new ConexionSQL();
            conexion.conectar();
          
            String consulta= "SELECT ID,USERNAME,PASSWORD,NOMBRE FROM usuarios";  
            ResultSet rs = conexion.ejecutarSelect(consulta);
            
            while (rs.next()) {
                    String id = rs.getString("ID");
                    String usr = rs.getString("USERNAME");
                    String psw = rs.getString("PASSWORD");
                    String nombre = rs.getString("NOMBRE");
                    System.out.println("userid : " + id);
                    System.out.println("usr : " + usr);
                    System.out.println("psw : " + psw);
                    System.out.println("nombre : " + nombre);
                }
            
            
            
           
            //System.out.println(conexion.getConnection());
            
        }
}
