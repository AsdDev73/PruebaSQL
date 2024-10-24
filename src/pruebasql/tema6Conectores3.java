

package pruebasql;

/**
 *
 * @author Jorge Martínez
 * Este ejemplo utiliza la base de datos prueba y la tabla usuarios
 * El script con la creación de ambos está en el aula virtual
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tema6Conectores3 {
        /*
    Definimos e inicializamos constantes:
    DRIVER. Nombre del driver que vamos a utilizar. En este caso de MYSQL
    URL_CONEXION. equipo:puerto/basededatos
    
        */
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/bd_instituto";
        
        public static void main(String args[]) throws SQLException {

            final String usuario = "root";
            final String password = "Medac123";
            Connection dbConnection = null;
            Statement statement = null;
            try {
                //Registramos el driver de mysql
                Class.forName(DRIVER);
                //Clase DriverManager gestiona todos los drivers que tenemos en nuestra aplicación
                //Devuelve un objeto conexión que utilizaremos para conectarnos a la base de datos
                Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
                //Guardamos en una variable la sentencia DML
                int id = 11;
                String nombreusuario = "'aperez'";
                String clave = "'123456'";
                String nombre = "'Antonio'";
               
                String insertTableSQL = "INSERT INTO profesores (id,username,password,nombre) VALUES("
                        + id +", "+ nombreusuario +", "+clave+", "+nombre+");";
               
                
                String updateTableSQL = "UPDATE usuarios SET nombre = 'Alonso' WHERE nombre = " + nombre;
                String deleteTableSQL = "DELETE FROM usuarios WHERE id = 3";
                //Ejecutamos el método createStatement y creamos un objeto statement
                //que nos va a permitir ejecutar consultas
                statement = conn.createStatement();
                //executeUpdate(String). Ejecutamos la consulta y nos devuelve un int con el número de filas afectadas
                int res = statement.executeUpdate(insertTableSQL);
                System.out.println("Numero de registros afectados en insert: "+ res);
                int res2 = statement.executeUpdate(updateTableSQL);
                System.out.println("Numero de registros afectados en update: "+ res2);
                int res3 = statement.executeUpdate(deleteTableSQL);
                System.out.println("Numero de registros afectados en delete: "+ res3);
                //Solo necesario si autocommit no está activado a true
                //conn.commit();
                //Otra forma de insert, update, delete con PreparedStatement
                int id2 = 20;
                String nombreusuario2 = "mperez";
                String clave2 = "123456";
                String nombre2 = "Mario";
                PreparedStatement ps = conn.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?) ");
                ps.setInt(1,id2);
                ps.setString(2, nombreusuario2);
                ps.setString(3, clave2);
                ps.setString(4, nombre2);
                int resPrepared = ps.executeUpdate();
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
    }   
}

