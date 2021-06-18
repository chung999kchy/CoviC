package entity;

import entity.KhuCachLy;
import entity.LoaiDon;
import entity.TaiKhoan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-18T23:26:09")
@StaticMetamodel(Don.class)
public class Don_ { 

    public static volatile SingularAttribute<Don, Integer> idNguoiXacNhan;
    public static volatile SingularAttribute<Don, Date> tgXacNhan;
    public static volatile SingularAttribute<Don, String> kqXacNhan;
    public static volatile SingularAttribute<Don, LoaiDon> loaiDon;
    public static volatile SingularAttribute<Don, TaiKhoan> nguoiTao;
    public static volatile SingularAttribute<Don, String> noiDung;
    public static volatile SingularAttribute<Don, Date> tgTao;
    public static volatile SingularAttribute<Don, Integer> idDon;
    public static volatile SingularAttribute<Don, KhuCachLy> khuCachLy;

}