/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alumni202457201065;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author sitin
 */
public class koneksi {
    private static Connection mysqlconfig;
    
    public static Connection konek(){
        
        try {
            String url = "jdbc:mysql://localhost:3306/alumni2_202457201065";
            
            String user = "root";
            
            String pass = "";
            
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException sQLException) {
            
            System.err.println(sQLException.getMessage());
        }
    
        return mysqlconfig;
    
    }  
}
