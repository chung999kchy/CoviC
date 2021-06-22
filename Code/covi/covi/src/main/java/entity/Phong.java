/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CHUNG
 */
@Entity
@Table(name = "phong")
@XmlRootElement

public class Phong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_phong")
    private Integer idPhong;
    @Column(name = "ten_phong")
    private String tenPhong;
    @Column(name = "so_giuong")
    private String soGiuong;
    @Column(name = "ghi_chu")
    private String ghiChu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPhong")
    private Collection<NguoiCachLy> nguoiCachLyCollection;

    private KhuCachLy khuCachLy;

    public KhuCachLy getKhuCachLy() {
        return khuCachLy;
    }

    public void setKhuCachLy(KhuCachLy khuCachLy) {
        this.khuCachLy = khuCachLy;
    }

    
    public Phong() {
    }

    public Phong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getSoGiuong() {
        return soGiuong;
    }

    public void setSoGiuong(String soGiuong) {
        this.soGiuong = soGiuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @XmlTransient
    public Collection<NguoiCachLy> getNguoiCachLyCollection() {
        return nguoiCachLyCollection;
    }

    public void setNguoiCachLyCollection(Collection<NguoiCachLy> nguoiCachLyCollection) {
        this.nguoiCachLyCollection = nguoiCachLyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhong != null ? idPhong.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phong)) {
            return false;
        }
        Phong other = (Phong) object;
        if ((this.idPhong == null && other.idPhong != null) || (this.idPhong != null && !this.idPhong.equals(other.idPhong))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Phong[ idPhong=" + idPhong + " ]";
    }
    
}
