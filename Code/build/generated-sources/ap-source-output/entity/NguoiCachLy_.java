package entity;

import entity.KhuCachLy;
import entity.KqXetNghiem;
import entity.Phong;
import entity.TaiKhoan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-18T23:26:09")
@StaticMetamodel(NguoiCachLy.class)
public class NguoiCachLy_ { 

    public static volatile SingularAttribute<NguoiCachLy, Integer> soDienThoai;
    public static volatile CollectionAttribute<NguoiCachLy, KqXetNghiem> kqXetNghiemCollection;
    public static volatile SingularAttribute<NguoiCachLy, Integer> idNguoiCachLy;
    public static volatile SingularAttribute<NguoiCachLy, String> mucDoNghiNhiem;
    public static volatile SingularAttribute<NguoiCachLy, String> cmt;
    public static volatile SingularAttribute<NguoiCachLy, String> gioiTinh;
    public static volatile SingularAttribute<NguoiCachLy, Date> tgVaoCachLy;
    public static volatile SingularAttribute<NguoiCachLy, Phong> phong;
    public static volatile SingularAttribute<NguoiCachLy, Integer> tuoi;
    public static volatile SingularAttribute<NguoiCachLy, KhuCachLy> khuCachLy;
    public static volatile SingularAttribute<NguoiCachLy, String> quocTich;
    public static volatile SingularAttribute<NguoiCachLy, String> diaChi;
    public static volatile SingularAttribute<NguoiCachLy, Date> tgRaCachLy;
    public static volatile CollectionAttribute<NguoiCachLy, TaiKhoan> taiKhoanCollection;
    public static volatile SingularAttribute<NguoiCachLy, String> tenNguoiCachLy;

}