/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.DBConnection;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author abdul
 */
@ManagedBean
@RequestScoped
public class KayitOl {

    private String isim;
    private String sifre;
    public int i=0;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    /**
     * Creates a new instance of KayitOl
     */
    public KayitOl() {
    }
    
    public String veriTabaninaGonder(){
        DBConnection db = new DBConnection();
        db.connect();
        if(db.conn == null){
            System.out.println("Kullanıcı eklenirken database bağlanılamadı.");
        }
        try{
            PreparedStatement st = db.conn.prepareStatement("insert into users(user_id,user_pass) values(?,?)");
            st.setString(1, isim);
            st.setString(2, sifre);
            i = st.executeUpdate();
        }catch(SQLException e){
            throw new FacesException(e);
        }
        if(i>0){
            System.out.println("Kayıt Basarılı");
            return "/login?faces-redirect=true";
        }else{
            System.out.println("Kayıt işlemi başarısız");
            return "/register?faces-redirect=true";
        }
    }
    
}
