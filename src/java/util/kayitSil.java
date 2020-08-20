/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import entity.Urun;
import entity.DBConnection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author abdul
 */
@Named(value = "kayitSil")
@Dependent
public class kayitSil {

    /**
     * Creates a new instance of kayitSil
     */
    public kayitSil() {
    }
    
    public void delete(Urun u){
        DBConnection db = new DBConnection();
        db.connect();
        
        try{
            Statement st = db.conn.createStatement();
            st.executeUpdate("delete from erkek where urun_id="+u.getUrun_id());
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
