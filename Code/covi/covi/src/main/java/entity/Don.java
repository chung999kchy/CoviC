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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "don")
@XmlRootElement

public class Don implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_don")
    private Integer idDon;
    @Column(name = "id_nguoi_xac_nhan")
    private Integer idNguoiXacNhan;
    @Column(name = "kq_xac_nhan")
    private String kqXacNhan;
    @Basic(optional = false)
    @Column(name = "noi_dung")
    private String noiDung;
    @Basic(optional = false)
    @Column(name = "tg_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgTao;
    @Column(name = "tg_xac_nhan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgXacNhan;
    @JoinColumn(name = "id_loai_don", referencedColumnName = "id_loai_don")
    @ManyToOne(optional = false)
    private LoaiDon loaiDon;
    @JoinColumn(name = "id_nguoi_tao", referencedColumnName = "id_tai_khoan")
    @ManyToOne(optional = false)
    private TaiKhoan nguoiTao;
    
    private KhuCachLy khuCachLy;

    public KhuCachLy getKhuCachLy() {
        return khuCachLy;
    }

    public void setKhuCachLy(KhuCachLy khuCachLy) {
        this.khuCachLy = khuCachLy;
    }

    public Don() {
    }

    public Don(Integer idDon) {
        this.idDon = idDon;
    }

    public Don(Integer idDon, String noiDung, Date tgTao) {
        this.idDon = idDon;
        this.noiDung = noiDung;
        this.tgTao = tgTao;
    }

    public Integer getIdDon() {
        return idDon;
    }

    public void setIdDon(Integer idDon) {
        this.idDon = idDon;
    }

    public Integer getIdNguoiXacNhan() {
        return idNguoiXacNhan;
    }

    public void setIdNguoiXacNhan(Integer idNguoiXacNhan) {
        this.idNguoiXacNhan = idNguoiXacNhan;
    }

    public String getKqXacNhan() {
        return kqXacNhan;
    }

    public void setKqXacNhan(String kqXacNhan) {
        this.kqXacNhan = kqXacNhan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getTgTao() {
        return tgTao;
    }

    public void setTgTao(Date tgTao) {
        this.tgTao = tgTao;
    }

    public Date getTgXacNhan() {
        return tgXacNhan;
    }

    public void setTgXacNhan(Date tgXacNhan) {
        this.tgXacNhan = tgXacNhan;
    }

    public LoaiDon getLoaiDon() {
        return loaiDon;
    }

    public void setLoaiDon(LoaiDon loaiDon) {
        this.loaiDon = loaiDon;
    }

    public TaiKhoan getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(TaiKhoan nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDon != null ? idDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Don)) {
            return false;
        }
        Don other = (Don) object;
        if ((this.idDon == null && other.idDon != null) || (this.idDon != null && !this.idDon.equals(other.idDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Don[ idDon=" + idDon + " ]";
    }
    
}
