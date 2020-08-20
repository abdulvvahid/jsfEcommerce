/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author abdul
 */
public class Urun {
    private int urun_id;
    private String urun_name;
    private String urun_kategori;
    private int urun_fiyat;
    private boolean gorunurluk;
    private int urun_adet;

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
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

    public int getUrun_fiyat() {
        return urun_fiyat;
    }

    public void setUrun_fiyat(int urun_fiyat) {
        this.urun_fiyat = urun_fiyat;
    }
    
    public boolean isGorunurluk() {
        return gorunurluk;
    }
  
    public void setGorunurluk(boolean gorunurluk) {
 
        this.gorunurluk = gorunurluk;
    }

    public int getUrun_adet() {
        return urun_adet;
    }

    public void setUrun_adet(int urun_adet) {
        this.urun_adet = urun_adet;
    }

    public Urun(int urun_id, String urun_name, String urun_kategori, int urun_fiyat, boolean gorunurluk, int urun_adet) {
        this.urun_id = urun_id;
        this.urun_name = urun_name;
        this.urun_kategori = urun_kategori;
        this.urun_fiyat = urun_fiyat;
        this.gorunurluk = gorunurluk;
        this.urun_adet = urun_adet;
    }
    
    
    
    public Urun(int urun_id, String urun_name, String urun_kategori, int urun_fiyat, int urun_adet) {
        this.urun_id = urun_id;
        this.urun_name = urun_name;
        this.urun_kategori = urun_kategori;
        this.urun_fiyat = urun_fiyat;
        this.urun_adet = urun_adet;
    }

    
    
    
    public Urun() {
    }

    

    
}
