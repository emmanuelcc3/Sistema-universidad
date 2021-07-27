/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//Librerías requeridas para la conexión con la base de datos.

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    private static Conexion conexion;
    //private static final String DBURL="jdbc:mysql://localhost:3306/ugeneral";
    private static final String DBURL="jdbc:mysql://localhost:3306/ugeneral?serverTimezone=UTC";
    private static Connection conn=null;
    
    //Método constructor que entabla la conexión con la base de datos de MYSQL
    private Conexion (){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn= DriverManager.getConnection(DBURL,"ugeneral_user","Prueba123_");
            
        }catch (ClassNotFoundException | SQLException | NoSuchMethodException | SecurityException |
                InstantiationException | IllegalAccessException | IllegalArgumentException |
                InvocationTargetException ex){
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    //Método GET que retorna la conexión disponible con la bd 
    public static synchronized Connection getConexion (){
        
        if (conexion==null){
            
            conexion= new Conexion();
            
        }
        return conn;
    }
    
    
}
