/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CHUNG
 */
@Entity
@Table(name = "kq_xet_nghiem")
@XmlRootElement

public class KqXetNghiem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kq_xet_nghiem")
    private Integer idKqXetNghiem;
    @Column(name = "ten_loai_xet_nghiem")
    private String tenLoaiXetNghiem;
    @Column(name = "kq_xet_nghiem")
    private String kqXetNghiem;
    @Column(name = "tg_xet_nghiem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgXetNghiem;
    @JoinColumn(name = "id_ng_cach_ly", referencedColumnName = "id_nguoi_cach_ly")
    @ManyToOne
    private NguoiCachLy ngCachLy;

    public KqXetNghiem() {
    }

    public KqXetNghiem(Integer idKqXetNghiem) {
        this.idKqXetNghiem = idKqXetNghiem;
    }

    public Integer getIdKqXetNghiem() {
        return idKqXetNghiem;
    }

    public void setIdKqXetNghiem(Integer idKqXetNghiem) {
        this.idKqXetNghiem = idKqXetNghiem;
    }

    public String getTenLoaiXetNghiem() {
        return tenLoaiXetNghiem;
    }

    public void setTenLoaiXetNghiem(String tenLoaiXetNghiem) {
        this.tenLoaiXetNghiem = tenLoaiXetNghiem;
    }

    public String getKqXetNghiem() {
        return kqXetNghiem;
    }

    public void setKqXetNghiem(String kqXetNghiem) {
        this.kqXetNghiem = kqXetNghiem;
    }

    public Date getTgXetNghiem() {
        return tgXetNghiem;
    }

    public void setTgXetNghiem(Date tgXetNghiem) {
        this.tgXetNghiem = tgXetNghiem;
    }

    public NguoiCachLy getNgCachLy() {
        return ngCachLy;
    }

    public void setNgCachLy(NguoiCachLy ngCachLy) {
        this.ngCachLy = ngCachLy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKqXetNghiem != null ? idKqXetNghiem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KqXetNghiem)) {
            return false;
        }
        KqXetNghiem other = (KqXetNghiem) object;
        if ((this.idKqXetNghiem == null && other.idKqXetNghiem != null) || (this.idKqXetNghiem != null && !this.idKqXetNghiem.equals(other.idKqXetNghiem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KqXetNghiem[ idKqXetNghiem=" + idKqXetNghiem + " ]";
    }
    
}
