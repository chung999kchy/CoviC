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
@Table(name = "loai_tai_khoan")
@XmlRootElement

public class LoaiTaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_loai_tai_khoan")
    private Integer idLoaiTaiKhoan;
    @Column(name = "ten_loai_tai_khoan")
    private String tenLoaiTaiKhoan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLoaiTaiKhoan")
    private Collection<TaiKhoan> taiKhoanCollection;

    public LoaiTaiKhoan() {
    }

    public LoaiTaiKhoan(Integer idLoaiTaiKhoan) {
        this.idLoaiTaiKhoan = idLoaiTaiKhoan;
    }

    public Integer getIdLoaiTaiKhoan() {
        return idLoaiTaiKhoan;
    }

    public void setIdLoaiTaiKhoan(Integer idLoaiTaiKhoan) {
        this.idLoaiTaiKhoan = idLoaiTaiKhoan;
    }

    public String getTenLoaiTaiKhoan() {
        return tenLoaiTaiKhoan;
    }

    public void setTenLoaiTaiKhoan(String tenLoaiTaiKhoan) {
        this.tenLoaiTaiKhoan = tenLoaiTaiKhoan;
    }

    @XmlTransient
    public Collection<TaiKhoan> getTaiKhoanCollection() {
        return taiKhoanCollection;
    }

    public void setTaiKhoanCollection(Collection<TaiKhoan> taiKhoanCollection) {
        this.taiKhoanCollection = taiKhoanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoaiTaiKhoan != null ? idLoaiTaiKhoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiTaiKhoan)) {
            return false;
        }
        LoaiTaiKhoan other = (LoaiTaiKhoan) object;
        if ((this.idLoaiTaiKhoan == null && other.idLoaiTaiKhoan != null) || (this.idLoaiTaiKhoan != null && !this.idLoaiTaiKhoan.equals(other.idLoaiTaiKhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LoaiTaiKhoan[ idLoaiTaiKhoan=" + idLoaiTaiKhoan + " ]";
    }
    
}
