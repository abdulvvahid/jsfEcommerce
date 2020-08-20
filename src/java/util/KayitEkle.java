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
public class KayitEkle {

    private int urun_id,urun_fiyat,urun_adet;
    private String urun_name,urun_kategori;
    private Boolean urun_gorunme;

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public int getUrun_fiyat() {
        return urun_fiyat;
    }

    public void setUrun_fiyat(int urun_fiyat) {
        this.urun_fiyat = urun_fiyat;
    }

    public int getUrun_adet() {
        return urun_adet;
    }

    public void setUrun_adet(int urun_adet) {
        this.urun_adet = urun_adet;
    }

    public String getUrun_name() {
        return urun_name;
    }

    public void setUrun_name(String urun_name) {
        this.urun_name = urun_name;
    }

    public String getUrun_kategori() {
        return urun_kategori;
    }

    public void setUrun_kategori(String urun_kategori) {
        this.urun_kategori = urun_kategori;
    }

    public Boolean getUrun_gorunme() {
        return urun_gorunme;
    }

    public void setUrun_gorunme(Boolean urun_gorunme) {
        this.urun_gorunme = urun_gorunme;
    }
    
    private int i;
    private String urun_tablo;

    public String getUrun_tablo() {
        return urun_tablo;
    }

    public void setUrun_tablo(String urun_tablo) {
        this.urun_tablo = urun_tablo;
    }
    
    
    /**
     * Creates a new instance of KayitOl
     */
    public KayitEkle() {
    }
    
    public String veriTabaninaGonder(){
        DBConnection db = new DBConnection();
        db.connect();
        if(db.conn == null){
            System.out.println("Kullanıcı eklenirken database bağlanılamadı.");
        }
        if(null != urun_tablo)switch (urun_tablo) {
            case "erkek":
                try{
                    PreparedStatement st = db.conn.prepareStatement("insert into erkek(urun_name,urun_kategori,urun_fiyat,urun_adet) values(?,?,?,?)");                    
                    st.setString(1, urun_name);
                    st.setString(2, urun_kategori);
                    st.setInt(3, urun_fiyat);
                    st.setInt(4, urun_adet);
                    i = st.executeUpdate();
                }catch(SQLException e){
                    throw new FacesException(e);
                }   break;
            case "kadin":
                try{
                    PreparedStatement st = db.conn.prepareStatement("insert into kadin(urun_name,urun_kategori,urun_fiyat,urun_adet) values(?,?,?,?)");
                    st.setString(1, urun_name);
                    st.setString(2, urun_kategori);
                    st.setInt(3, urun_fiyat);
                    st.setInt(4, urun_adet);
                    i = st.executeUpdate();
                }catch(SQLException e){
                    throw new FacesException(e);
                }   break;
            case "aksesuar":
                try{
                    PreparedStatement st = db.conn.prepareStatement("insert into aksesuar(urun_name,urun_kategori,urun_fiyat,urun_adet) values(?,?,?,?)");
                    st.setString(1, urun_name);
                    st.setString(2, urun_kategori);
                    st.setInt(3, urun_fiyat);
                    st.setInt(4, urun_adet);
                    i = st.executeUpdate();
                }catch(SQLException e){
                    throw new FacesException(e);
                }   break;
            default:
                break;
        }
        if(i>0){
            System.out.println("Kayıt Basarılı");
            return "/secret/secret?faces-redirect=true";
        }else{
            System.out.println("Kayıt işlemi başarısız");
            return "/secret/urunEkle?faces-redirect=true";
        }
    }
    
}
