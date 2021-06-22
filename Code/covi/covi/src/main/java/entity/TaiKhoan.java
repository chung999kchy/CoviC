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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tai_khoan")
@XmlRootElement

public class TaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tai_khoan")
    private Integer idTaiKhoan;
    @Basic(optional = false)
    @Column(name = "ten_dang_nhap")
    private String tenDangNhap;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "ten_nguoi_dung")
    private String tenNguoiDung;
    @Column(name = "so_dien_thoai")
    private Integer soDienThoai;
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiTao")
    private Collection<Don> donCollection;
    @JoinColumn(name = "id_loai_tai_khoan", referencedColumnName = "id_loai_tai_khoan")
    @ManyToOne(optional = false)
    private LoaiTaiKhoan loaiTaiKhoan;
    @JoinColumn(name = "id_ng_cach_ly", referencedColumnName = "id_nguoi_cach_ly")
    @ManyToOne
    private NguoiCachLy ngCachLy;
    private KhuCachLy khuCachLy;

    public TaiKhoan() {
    }

    public TaiKhoan(Integer idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public TaiKhoan(Integer idTaiKhoan, String tenDangNhap, String password, String tenNguoiDung) {
        this.idTaiKhoan = idTaiKhoan;
        this.tenDangNhap = tenDangNhap;
        this.password = password;
        this.tenNguoiDung = tenNguoiDung;
    }

    public Integer getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(Integer idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public Integer getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(Integer soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Collection<Don> getDonCollection() {
        return donCollection;
    }

    public void setDonCollection(Collection<Don> donCollection) {
        this.donCollection = donCollection;
    }

    public LoaiTaiKhoan getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(LoaiTaiKhoan loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public NguoiCachLy getNgCachLy() {
        return ngCachLy;
    }

    public void setNgCachLy(NguoiCachLy ngCachLy) {
        this.ngCachLy = ngCachLy;
    }

    public KhuCachLy getKhuCachLy() {
        return khuCachLy;
    }

    public void setKhuCachLy(KhuCachLy khuCachLy) {
        this.khuCachLy = khuCachLy;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTaiKhoan != null ? idTaiKhoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.idTaiKhoan == null && other.idTaiKhoan != null) || (this.idTaiKhoan != null && !this.idTaiKhoan.equals(other.idTaiKhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TaiKhoan[ idTaiKhoan=" + idTaiKhoan + " ]";
    }

}
