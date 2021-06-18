package entity;

import entity.TaiKhoan;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-18T23:26:09")
@StaticMetamodel(LoaiTaiKhoan.class)
public class LoaiTaiKhoan_ { 

    public static volatile SingularAttribute<LoaiTaiKhoan, String> tenLoaiTaiKhoan;
    public static volatile CollectionAttribute<LoaiTaiKhoan, TaiKhoan> taiKhoanCollection;
    public static volatile SingularAttribute<LoaiTaiKhoan, Integer> idLoaiTaiKhoan;

}