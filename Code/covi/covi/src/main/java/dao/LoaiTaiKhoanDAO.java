/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.LoaiTaiKhoan;
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
public class LoaiTaiKhoanDAO implements DAO<LoaiTaiKhoan> {

    private final String SQL_INSERT = "Insert into loai_tai_khoan"
            + "(ten_loai_tai_khoan) values " + "( ?)";

    Connection conn = ConnectDB.getConnection();

    @Override
    public List<LoaiTaiKhoan> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<LoaiTaiKhoan> qq = new ArrayList<>();
            while (rs.next()) {
                LoaiTaiKhoan p = new LoaiTaiKhoan();
                p.setIdLoaiTaiKhoan(rs.getInt("id_loai_tai_khoan"));
                p.setTenLoaiTaiKhoan(rs.getString("ten_loai_tai_khoan"));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public LoaiTaiKhoan get(int id) {
        String sql = "select * from loai_tai_khoan where id_loai_tai_khoan= " + id;
        List<LoaiTaiKhoan> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<LoaiTaiKhoan> getAll() {
        String sql = "select * from loai_tai_khoan";
        List<LoaiTaiKhoan> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(LoaiTaiKhoan t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, t.getTenLoaiTaiKhoan());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public void delete(LoaiTaiKhoan t) {
        try {
            String sql = "delete from loai_tai_khoan where id_loai_tai_khoan = "+t.getIdLoaiTaiKhoan();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    @Override
    public void update(LoaiTaiKhoan t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public LoaiTaiKhoan find(String tenLoaiTK) {
        String sql = "select * from loai_tai_khoan where ten_loai_tai_khoan= '" + tenLoaiTK + "';";
        List<LoaiTaiKhoan> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

}
