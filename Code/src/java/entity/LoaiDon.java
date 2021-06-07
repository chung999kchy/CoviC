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
@Table(name = "loai_don")
@XmlRootElement
public class LoaiDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_loai_don")
    private Integer idLoaiDon;
    @Column(name = "ten_loai_don")
    private String tenLoaiDon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLoaiDon")
    private Collection<Don> donCollection;

    public LoaiDon() {
    }

    public LoaiDon(Integer idLoaiDon) {
        this.idLoaiDon = idLoaiDon;
    }

    public Integer getIdLoaiDon() {
        return idLoaiDon;
    }

    public void setIdLoaiDon(Integer idLoaiDon) {
        this.idLoaiDon = idLoaiDon;
    }

    public String getTenLoaiDon() {
        return tenLoaiDon;
    }

    public void setTenLoaiDon(String tenLoaiDon) {
        this.tenLoaiDon = tenLoaiDon;
    }

    @XmlTransient
    public Collection<Don> getDonCollection() {
        return donCollection;
    }

    public void setDonCollection(Collection<Don> donCollection) {
        this.donCollection = donCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoaiDon != null ? idLoaiDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiDon)) {
            return false;
        }
        LoaiDon other = (LoaiDon) object;
        if ((this.idLoaiDon == null && other.idLoaiDon != null) || (this.idLoaiDon != null && !this.idLoaiDon.equals(other.idLoaiDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LoaiDon[ idLoaiDon=" + idLoaiDon + " ]";
    }
    
}
