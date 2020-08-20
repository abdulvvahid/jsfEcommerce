/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.DBConnection;
import entity.User;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author abdul
 */
@Named
@SessionScoped
public class LoginController implements Serializable{
    
    private User user;

    public String login(){
        
        int i=0;
        DBConnection db = new DBConnection();
        db.connect();
        if(db.conn == null){
            System.out.println("Kullanıcı eklenirken database bağlanılamadı.");
        }
        try{
        Statement stmt = db.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select user_id,user_pass from users");
            while (rs.next()){
                if((this.user.getUsername() == null ? rs.getString(1) == null : this.user.getUsername().equals(rs.getString(1))) && (this.user.getPassword() == null ? rs.getString(2) == null : this.user.getPassword().equals(rs.getString(2)))){
                   i=1;
                }
                
            }
        }catch(SQLException e){
            
        }
        if(i == 1 ){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user",this.user);
            return "/secret/secret?faces-redirect=true"; 
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Kullanıcı veya Şifre"));
            return "/login";
        }     
    }    
        
   
    
    public User getUser() {
        if( this.user == null)
            this.user = new User();
        return user;
    }

    /**
     * Creates a new instance of LoginController
     */
    public void setUser(User user) {
        this.user = user;
    }

    public LoginController() {
    }
    
}
