/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author CHUNG
 */

public class KhuCachLy {
    private int idKhuCachLy;
    private String tenKhuCachLy;
    private String diaChiKhuCachLy;
    private String lienHe;

    public KhuCachLy() {
    }

    
    public int getIdKhuCachLy() {
        return idKhuCachLy;
    }

    public void setIdKhuCachLy(int idKhuCachLy) {
        this.idKhuCachLy = idKhuCachLy;
    }

    public String getTenKhuCachLy() {
        return tenKhuCachLy;
    }

    public void setTenKhuCachLy(String tenKhuCachLy) {
        this.tenKhuCachLy = tenKhuCachLy;
    }

    public String getDiaChiKhuCachLy() {
        return diaChiKhuCachLy;
    }

    public void setDiaChiKhuCachLy(String diaChiKhuCachLy) {
        this.diaChiKhuCachLy = diaChiKhuCachLy;
    }

    public String getLienHe() {
        return lienHe;
    }

    public void setLienHe(String lienHe) {
        this.lienHe = lienHe;
    }

    public KhuCachLy(int idKhuCachLy, String tenKhuCachLy, String diaChiKhuCachLy, String lienHe) {
        this.idKhuCachLy = idKhuCachLy;
        this.tenKhuCachLy = tenKhuCachLy;
        this.diaChiKhuCachLy = diaChiKhuCachLy;
        this.lienHe = lienHe;
    }
    
    
}
