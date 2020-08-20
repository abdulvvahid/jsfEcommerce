/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.DBConnection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entity.Urun;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 *
 * @author abdul
 */
@ManagedBean
@RequestScoped
public class KayitGuncelleme {
    
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
    
    
    private String GuncellemeMesaji;

    public String getGuncellemeMesaji() {
        return GuncellemeMesaji;
    }

    public void setGuncellemeMesaji(String GuncellemeMesaji) {
        this.GuncellemeMesaji = GuncellemeMesaji;
    }
    
    
    
    public void gorunurluguDegistir(Urun u){
        u.setGorunurluk(true);
    }
    
    public void kaydiGuncelle(Urun u){
        u.setGorunurluk(false);
        DBConnection db = new DBConnection();
        db.connect();
        try{
            PreparedStatement ps=db.conn.prepareStatement("update erkek set urun_name=?,urun_kategori=?,urun_fiyat=?,urun_adet=? where urun_id=?");
            ps.setString(1, u.getUrun_name());
            ps.setString(2, u.getUrun_kategori());
            ps.setInt(3, u.getUrun_fiyat());
            ps.setInt(4, u.getUrun_adet());
            ps.setInt(5, u.getUrun_id());
            System.out.println(ps);
            ps.executeUpdate();        
        }catch(SQLException e){
            System.out.println("Hata Meydana geldi."+e);
        }
        
        System.out.println(GuncellemeMesaji);
        
    }
    
    
    
}
