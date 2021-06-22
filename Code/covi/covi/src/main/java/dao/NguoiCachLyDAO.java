/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.NguoiCachLy;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import utils.Utils;

/**
 *
 * @author CHUNG
 */
public class NguoiCachLyDAO implements DAO<NguoiCachLy> {

    private String SQL_COUNT_TODAY = "SELECT count(*) as soluong FROM datn.nguoi_cach_ly "
            + "WHERE month(tg_vao_cach_ly) = month(now()) "
            + "and year(tg_vao_cach_ly)=year(now()) "
            + "and day(tg_vao_cach_ly) = day(now()) ";

    private String SQL_COUNT_THIS_MONTH = "SELECT count(*) as soluong FROM datn.nguoi_cach_ly "
            + "WHERE month(tg_vao_cach_ly) = month(now()) "
            + "and year(tg_vao_cach_ly)=year(now()) ";

    private String SQL_COUNT_NOT_OUT = "SELECT count(*) as soluong FROM datn.nguoi_cach_ly "
            + "WHERE tg_ra_cach_ly is NULL ";

    private final String SQL_INSERT = "Insert into nguoi_cach_ly"
            + " (ten_nguoi_cach_ly, tuoi, gioi_tinh, dia_chi, cmt, so_dien_thoai, quoc_tich, muc_do_nghi_nhiem"
            + ", id_phong, tg_vao_cach_ly, id_khu_cach_ly) values " + "(?,?,?,?,?,?,?,?,?,?,?)";

    Connection conn = ConnectDB.getConnection();
    PhongDAO phongDAO = new PhongDAO();
    KhuCachLyDAO khuCachLyDAO = new KhuCachLyDAO();

    @Override
    public List<NguoiCachLy> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<NguoiCachLy> qq = new ArrayList<>();
            while (rs.next()) {
                NguoiCachLy p = new NguoiCachLy();
                p.setIdNguoiCachLy(rs.getInt("id_nguoi_cach_ly"));
                p.setTenNguoiCachLy(rs.getString("ten_nguoi_cach_ly"));
                p.setTuoi(rs.getInt("tuoi"));
                p.setGioiTinh(rs.getString("gioi_tinh"));
                p.setDiaChi(rs.getString("dia_chi"));
                p.setCmt(rs.getString("cmt"));
                p.setSoDienThoai(rs.getInt("so_dien_thoai"));
                p.setQuocTich(rs.getString("quoc_tich"));
                p.setMucDoNghiNhiem(rs.getString("muc_do_nghi_nhiem"));
                p.setTgVaoCachLy(rs.getTimestamp("tg_vao_cach_ly"));
                p.setTgRaCachLy(rs.getTimestamp("tg_ra_cach_ly"));
                int idPhong = rs.getInt("id_phong");
                p.setPhong(phongDAO.get(idPhong));
                int idKhuCachLy = rs.getInt("id_khu_cach_ly");
                p.setKhuCachLy(khuCachLyDAO.get(idKhuCachLy));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public NguoiCachLy get(int id) {
        String sql = "SELECT * from nguoi_cach_ly where id_nguoi_cach_ly= " + id;
        List<NguoiCachLy> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<NguoiCachLy> getAll() {
        String sql = "SELECT * from nguoi_cach_ly";
        List<NguoiCachLy> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void update(NguoiCachLy t, Hashtable<String, String> my_dict) {
        if (!my_dict.isEmpty()) {
            String sql_update = "Update nguoi_cach_ly set ";
            try (
                    PreparedStatement prep = conn.prepareStatement(sql_update);) {
                String change = "";
                for (String key : my_dict.keySet()) {
                    String value = my_dict.get(key);
                    try {
                        int values = Integer.parseInt(value);
                        change += key + " = " + values + ",";
                    } catch (Exception e) {
                        change += key + " = '" + value + "',";
                    }
                }
                change = change.substring(0, change.length() - 1);
                sql_update += change + " where id_nguoi_cach_ly = " + t.getIdNguoiCachLy();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql_update);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }

    }

    @Override
    public void delete(NguoiCachLy t) {
        try {
            String sql = "delete from nguoi_cach_ly where id_nguoi_cach_ly = " + t.getIdNguoiCachLy();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    public List<NguoiCachLy> getList(int offset, int noOfRecords, int idKhuCachLy) {
        String sql = "SELECT * from nguoi_cach_ly where id_khu_cach_ly =" + idKhuCachLy + " limit " + offset + ", " + noOfRecords;
        //System.out.println("sql " + sql);
        List<NguoiCachLy> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public List<NguoiCachLy> getListInPhong(int idPhong, int idKhuCachLy) {
        String sql = "SELECT * from nguoi_cach_ly where id_khu_cach_ly = " + idKhuCachLy + " and id_phong = " + idPhong;
        //System.out.println("sql " + sql);
        List<NguoiCachLy> qq = new ArrayList<>();
        qq = parse(sql);

        return qq;
    }

    public int getNoOfRecord(int idKhuCachLy) {
        try {
            String sql = "select count(*) as soluong from nguoi_cach_ly where id_khu_cach_ly = " + idKhuCachLy;
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            rs.next();
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }

    //cap nhat tg vao vien
    public void charge(NguoiCachLy t) {
        Hashtable<String, String> my_dict = new Hashtable<>();
        String tg_ra = Utils.getToday();
        my_dict.put("tg_vao_cach_ly", tg_ra);
        update(t, my_dict);
    }

    // cap nhat tg xuat vien
    public void discharge(NguoiCachLy t) {
        Hashtable<String, String> my_dict = new Hashtable<>();
        String tg_ra = Utils.getToday();
        my_dict.put("tg_ra_cach_ly", tg_ra);
        update(t, my_dict);
    }

    @Override
    public void create(NguoiCachLy t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, t.getTenNguoiCachLy());
            prep.setInt(2, t.getTuoi());
            prep.setString(3, t.getGioiTinh());
            prep.setString(4, t.getDiaChi());
            prep.setString(5, t.getCmt());
            prep.setInt(6, t.getSoDienThoai());
            prep.setString(7, t.getQuocTich());
            prep.setString(8, t.getMucDoNghiNhiem());
            prep.setInt(9, t.getPhong().getIdPhong());
            prep.setTimestamp(10, (java.sql.Timestamp) t.getTgVaoCachLy());
            prep.setInt(11, t.getKhuCachLy().getIdKhuCachLy());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<NguoiCachLy> SearchByKey(String key, int offset, int noOfRecords) {
        String sql = "SELECT * from nguoi_cach_ly where ten_nguoi_cach_ly like '%" + key + "%'";
        List<NguoiCachLy> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public int getAllNoOfRecord() {
        try {
            String sql = "select count(*) as soluong from nguoi_cach_ly";
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            rs.next();
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }

    public int getCountToday(int idKhu) {
        if (idKhu != 0) {
            SQL_COUNT_TODAY += "and id_khu_cach_ly = " + idKhu;
        }
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(SQL_COUNT_TODAY);
            rs.next();
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }

    public int getCountThisMonth(int idKhu) {
        if (idKhu != 0) {
            SQL_COUNT_THIS_MONTH += "and id_khu_cach_ly = " + idKhu;
        }
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(SQL_COUNT_THIS_MONTH);
            rs.next();
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }

    public int getCountNotOut(int idKhu) {
        if (idKhu != 0) {
            SQL_COUNT_NOT_OUT += "and id_khu_cach_ly = " + idKhu;
        }
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(SQL_COUNT_NOT_OUT);
            rs.next();
            
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }

}
