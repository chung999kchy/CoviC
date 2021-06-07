package entity;

import entity.KhuCachLy;
import entity.NguoiCachLy;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-07T23:03:36")
@StaticMetamodel(Phong.class)
public class Phong_ { 

    public static volatile SingularAttribute<Phong, String> soGiuong;
    public static volatile SingularAttribute<Phong, String> ghiChu;
    public static volatile SingularAttribute<Phong, String> tenPhong;
    public static volatile CollectionAttribute<Phong, NguoiCachLy> nguoiCachLyCollection;
    public static volatile SingularAttribute<Phong, Integer> idPhong;
    public static volatile SingularAttribute<Phong, KhuCachLy> khuCachLy;

}