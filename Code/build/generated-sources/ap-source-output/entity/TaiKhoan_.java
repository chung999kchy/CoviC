package entity;

import entity.Don;
import entity.KhuCachLy;
import entity.LoaiTaiKhoan;
import entity.NguoiCachLy;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-18T23:26:09")
@StaticMetamodel(TaiKhoan.class)
public class TaiKhoan_ { 

    public static volatile CollectionAttribute<TaiKhoan, Don> donCollection;
    public static volatile SingularAttribute<TaiKhoan, LoaiTaiKhoan> loaiTaiKhoan;
    public static volatile SingularAttribute<TaiKhoan, Integer> soDienThoai;
    public static volatile SingularAttribute<TaiKhoan, String> password;
    public static volatile SingularAttribute<TaiKhoan, NguoiCachLy> ngCachLy;
    public static volatile SingularAttribute<TaiKhoan, String> tenNguoiDung;
    public static volatile SingularAttribute<TaiKhoan, Integer> idTaiKhoan;
    public static volatile SingularAttribute<TaiKhoan, String> tenDangNhap;
    public static volatile SingularAttribute<TaiKhoan, String> avatar;
    public static volatile SingularAttribute<TaiKhoan, KhuCachLy> khuCachLy;

}