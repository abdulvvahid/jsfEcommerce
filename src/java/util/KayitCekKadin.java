/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.DBConnection;
import entity.Urun;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author abdul
 */
@ManagedBean
@RequestScoped
public class KayitCekKadin {
              
    ArrayList<Urun> urunListesi = new ArrayList<>();
    
    public KayitCekKadin() {
    }
    
    public ArrayList<Urun> urunleriCek(){
        DBConnection db = new DBConnection();
        db.connect();
        if(db.conn == null){
            System.out.println("Kullanıcı eklenirken database bağlanılamadı.");
        }
        try{
            Statement st = db.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from kadin");
            urunListesi.clear();
            while (rs.next()){
                Urun u = new Urun();
                u.setUrun_id(rs.getInt("urun_id"));
                u.setUrun_name(rs.getString("urun_name"));
                u.setUrun_kategori(rs.getString("urun_kategori"));
                u.setUrun_fiyat(rs.getInt("urun_fiyat"));
                u.setUrun_adet(rs.getInt("urun_adet"));
                urunListesi.add(u);
            }
            st.close();
        }catch(SQLException e){
            
        }
        
        return urunListesi;
    }
    
}
