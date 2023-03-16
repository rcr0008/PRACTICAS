package practica;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

    public static final String URL = "jdbc:mysql://localhost:3306/escuela";
    public static final String USER = "root";
    public static final String CLAVE = "Vaso124578";

    public Connection getConexion() {
         
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("CONEXION ACEPTADA");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

    

    public static void main(String[] args) {
        
      

            Conectar con = new Conectar();
            con.getConexion();

       
        }

    
}
