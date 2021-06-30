/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.NguoiCachLy;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author CHUNG
 */
public class TaiKhoanDAO implements DAO<TaiKhoan> {

    private final String SQL_INSERT = "Insert into tai_khoan "
            + "(id_loai_tai_khoan, ten_dang_nhap, password, ten_nguoi_dung,"
            + " so_dien_thoai, avatar, id_khu_cach_ly) values " + "(?,?,?,?,?,?,?)";

    Connection conn = ConnectDB.getConnection();
    NguoiCachLyDAO nguoiCachLyDAO = new NguoiCachLyDAO();
    LoaiTaiKhoanDAO loaiTaiKhoanDAO = new LoaiTaiKhoanDAO();
    KhuCachLyDAO khuCachLyDAO = new KhuCachLyDAO();

    @Override
    public List<TaiKhoan> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<TaiKhoan> qq = new ArrayList<>();
            while (rs.next()) {
                TaiKhoan p = new TaiKhoan();
                p.setIdTaiKhoan(rs.getInt("id_tai_khoan"));
                p.setAvatar(rs.getString("avatar"));
                p.setTenNguoiDung(rs.getString("ten_nguoi_dung"));
                p.setSoDienThoai(rs.getInt("so_dien_thoai"));
                p.setTenDangNhap(rs.getString("ten_dang_nhap"));
                p.setPassword(rs.getString("password"));
                int idNgCachLy = rs.getInt("id_ng_cach_ly");
                p.setNgCachLy(nguoiCachLyDAO.get(idNgCachLy));
                int idLoaiTaiKhoan = rs.getInt("id_loai_tai_khoan");
                p.setLoaiTaiKhoan(loaiTaiKhoanDAO.get(idLoaiTaiKhoan));
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
    public TaiKhoan get(int id) {
        String sql = "select * from tai_khoan where id_tai_khoan= " + id;
        List<TaiKhoan> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<TaiKhoan> getAll() {
        String sql = "select * from tai_khoan";
        List<TaiKhoan> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public TaiKhoan find(String tenDN, String pass) {
        String sql = "select * from tai_khoan where ten_dang_nhap = '" + tenDN + "' and password = '" + pass + "';";
        List<TaiKhoan> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    public TaiKhoan find(String tenDN) {
        String sql = "select * from tai_khoan where ten_dang_nhap = '" + tenDN + "';";
        List<TaiKhoan> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public void create(TaiKhoan t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setInt(1, t.getLoaiTaiKhoan().getIdLoaiTaiKhoan());
            prep.setString(2, t.getTenDangNhap());
            prep.setString(3, t.getPassword());
            prep.setString(4, t.getTenNguoiDung());
            prep.setInt(5, t.getSoDienThoai());
            prep.setString(6, t.getAvatar());
            if(t.getKhuCachLy() != null) prep.setInt(7, t.getKhuCachLy().getIdKhuCachLy());
            else prep.setNull(7, java.sql.Types.INTEGER);
            System.out.println("alo:"+prep);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TaiKhoan t, Hashtable<String, String> my_dict) {
        String sql_update = "Update tai_khoan set ";
        if (!my_dict.isEmpty()) {
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
                sql_update += change + " where id_tai_khoan = " + t.getIdTaiKhoan();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql_update);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }

    }

    @Override
    public void delete(TaiKhoan t) {
        try {
            String sql = "delete from tai_khoan where id_tai_khoan = " + t.getIdTaiKhoan();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    public List<TaiKhoan> getList(int offset, int noOfRecords, int idKhuCachLy) {
        String sql = "select SQL_CALC_FOUND_ROWS * from tai_khoan where id_khu_cach_ly =" + idKhuCachLy + " limit " + offset + ", " + noOfRecords;
        List<TaiKhoan> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public int getNoOfRecord(int idKhuCachLy) throws SQLException {
        String sql = "select count(*) as soluong from tai_khoan where id_khu_cach_ly = " + idKhuCachLy;
        Statement sttm = conn.createStatement();
        ResultSet rs = sttm.executeQuery(sql);
        rs.next();

        return rs.getInt("soluong");
    }
}
