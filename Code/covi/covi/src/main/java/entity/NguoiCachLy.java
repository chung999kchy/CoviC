/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CHUNG
 */
@Entity
@Table(name = "nguoi_cach_ly")
@XmlRootElement

public class NguoiCachLy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nguoi_cach_ly")
    private Integer idNguoiCachLy;
    @Basic(optional = false)
    @Column(name = "ten_nguoi_cach_ly")
    private String tenNguoiCachLy;
    @Column(name = "tuoi")
    private Integer tuoi;
    @Column(name = "cmt")
    private String cmt;
    @Column(name = "gioi_tinh")
    private String gioiTinh;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "so_dien_thoai")
    private Integer soDienThoai;
    @Column(name = "quoc_tich")
    private String quocTich;
    @Basic(optional = false)
    @Column(name = "muc_do_nghi_nhiem")
    private String mucDoNghiNhiem;
    @Basic(optional = false)
    @Column(name = "tg_vao_cach_ly")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgVaoCachLy;
    @Column(name = "tg_ra_cach_ly")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgRaCachLy;
    @OneToMany(mappedBy = "idNgCachLy")
    private Collection<KqXetNghiem> kqXetNghiemCollection;
    @JoinColumn(name = "id_phong", referencedColumnName = "id_phong")
    @ManyToOne(optional = false)
    private Phong phong;
    @OneToMany(mappedBy = "idNgCachLy")
    private Collection<TaiKhoan> taiKhoanCollection;

    private KhuCachLy khuCachLy;
    public NguoiCachLy() {
    }

    public NguoiCachLy(Integer idNguoiCachLy) {
        this.idNguoiCachLy = idNguoiCachLy;
    }

    public NguoiCachLy(Integer idNguoiCachLy, String tenNguoiCachLy, String mucDoNghiNhiem, Date tgVaoCachLy) {
        this.idNguoiCachLy = idNguoiCachLy;
        this.tenNguoiCachLy = tenNguoiCachLy;
        this.mucDoNghiNhiem = mucDoNghiNhiem;
        this.tgVaoCachLy = tgVaoCachLy;
    }

    public Integer getIdNguoiCachLy() {
        return idNguoiCachLy;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public void setIdNguoiCachLy(Integer idNguoiCachLy) {
        this.idNguoiCachLy = idNguoiCachLy;
    }

    public String getTenNguoiCachLy() {
        return tenNguoiCachLy;
    }

    public void setTenNguoiCachLy(String tenNguoiCachLy) {
        this.tenNguoiCachLy = tenNguoiCachLy;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(Integer soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getMucDoNghiNhiem() {
        return mucDoNghiNhiem;
    }

    public void setMucDoNghiNhiem(String mucDoNghiNhiem) {
        this.mucDoNghiNhiem = mucDoNghiNhiem;
    }

    public Date getTgVaoCachLy() {
        return tgVaoCachLy;
    }

    public void setTgVaoCachLy(Date tgVaoCachLy) {
        this.tgVaoCachLy = tgVaoCachLy;
    }

    public Date getTgRaCachLy() {
        return tgRaCachLy;
    }

    public void setTgRaCachLy(Date tgRaCachLy) {
        this.tgRaCachLy = tgRaCachLy;
    }

    public KhuCachLy getKhuCachLy() {
        return khuCachLy;
    }

    public void setKhuCachLy(KhuCachLy khuCachLy) {
        this.khuCachLy = khuCachLy;
    }
    
    

    @XmlTransient
    public Collection<KqXetNghiem> getKqXetNghiemCollection() {
        return kqXetNghiemCollection;
    }

    public void setKqXetNghiemCollection(Collection<KqXetNghiem> kqXetNghiemCollection) {
        this.kqXetNghiemCollection = kqXetNghiemCollection;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
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
        hash += (idNguoiCachLy != null ? idNguoiCachLy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NguoiCachLy)) {
            return false;
        }
        NguoiCachLy other = (NguoiCachLy) object;
        if ((this.idNguoiCachLy == null && other.idNguoiCachLy != null) || (this.idNguoiCachLy != null && !this.idNguoiCachLy.equals(other.idNguoiCachLy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NguoiCachLy[ idNguoiCachLy=" + idNguoiCachLy + " ]";
    }
    
}
