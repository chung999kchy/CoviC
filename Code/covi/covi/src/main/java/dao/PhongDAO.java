/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Phong;
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
public class PhongDAO implements DAO<Phong> {

    private final String SQL_INSERT = "Insert into phong"
            + "(ten_phong, so_giuong, ghi_chu, id_khu_cach_ly) values " + "(?, ?, ?, ?)";
    private final String SQL_UPDATE = "update phong set ten_phong = ?, so_giuong = ?, ghi_chu = ? where id_phong = ?";

    private String SQL_COUNT_INCLUDE = "SELECT sum(so_giuong) as soluong FROM datn.phong ";
    Connection conn = ConnectDB.getConnection();
    KhuCachLyDAO khuCachLyDAO = new KhuCachLyDAO();

    @Override
    public List<Phong> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Phong> qq = new ArrayList<>();
            while (rs.next()) {
                Phong p = new Phong();
                p.setIdPhong(rs.getInt("id_phong"));
                p.setTenPhong(rs.getString("ten_phong"));
                p.setSoGiuong(rs.getString("so_giuong"));
                p.setGhiChu(rs.getString("ghi_chu"));
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
    public Phong get(int id) {
        String sql = "select * from phong where id_phong= " + id;
        List<Phong> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<Phong> getAll() {
        String sql = "select * from phong";
        List<Phong> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }
    
    public List<Phong> getAllInKhu(int idKhu) {
        String sql = "select * from phong where id_khu_cach_ly = "+idKhu;
        List<Phong> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(Phong t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, t.getTenPhong());
            prep.setString(2, t.getSoGiuong());
            prep.setString(3, t.getGhiChu());
            prep.setInt(4, t.getKhuCachLy().getIdKhuCachLy());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Phong t) {
        try {
            String sql = "delete from phong where id_phong = " + t.getIdPhong();
            System.out.println();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    @Override
    public void update(Phong t, Hashtable<String, String> my_dict) {
        String sql_update = "Update phong set ";
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
                sql_update += change + " where id_phong = " + t.getIdPhong();
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(sql_update);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }

    }

    public List<Phong> getList(int offset, int noOfRecords, int idKhuCachLy) {
        String sql = "select SQL_CALC_FOUND_ROWS * from phong where id_khu_cach_ly =" + idKhuCachLy + " limit " + offset + ", " + noOfRecords;
        List<Phong> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public int getNoOfRecord(int idKhuCachLy) throws SQLException {
        String sql = "select count(*) as soluong from phong where id_khu_cach_ly = " + idKhuCachLy;
        Statement sttm = conn.createStatement();
        ResultSet rs = sttm.executeQuery(sql);
        rs.next();

        return rs.getInt("soluong");
    }

    public int getCountInclude(int idKhu) {
        if (idKhu != 0) {
            SQL_COUNT_INCLUDE += " where id_khu_cach_ly = " + idKhu;
        }
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(SQL_COUNT_INCLUDE);
            rs.next();
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }
}
