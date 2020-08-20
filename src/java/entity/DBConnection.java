/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author abdul
 */
public class DBConnection {
    public Connection conn;
    String url ="jdbc:derby://localhost:1527/addressbook";
    String user= "APP";
    String pass =  "APP";
    
    public Connection connect(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            System.out.println("Bağlantı başarılı");
            conn = DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            System.out.println("Bağlantıda sıkıntı var");
        }
        return conn;
    }
     
    
}


