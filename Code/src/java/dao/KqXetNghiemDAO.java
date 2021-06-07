/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KqXetNghiem;
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
public class KqXetNghiemDAO implements DAO<KqXetNghiem> {

    private final String SQL_INSERT = "Insert into kq_xet_nghiem"
            + "(id_ng_cach_ly, ten_loai_xet_nghiem, kq_xet_nghiem, tg_xet_nghiem) values " + "(?, ?, ?, ?)";
    private final String SQL_UPDATE = "update kq_xet_nghiem set id_ng_cach_ly = ?, "+
            " ten_loai_xet_nghiem = ?, kq_xet_nghiem = ?, tg_xet_nghiem = ? "+
            "where id_kq_xet_nghiem = ?";
    
    Connection conn = ConnectDB.getConnection();
    NguoiCachLyDAO ngCachLyDAO = new NguoiCachLyDAO();
    
    @Override
    public List<KqXetNghiem> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<KqXetNghiem> qq = new ArrayList<>();
            while (rs.next()) {
                KqXetNghiem p = new KqXetNghiem();
                p.setIdKqXetNghiem(rs.getInt("id_kq_xet_nghiem"));
                p.setTenLoaiXetNghiem(rs.getString("ten_loai_xet_nghiem"));
                p.setKqXetNghiem(rs.getString("kq_xet_nghiem"));
                p.setTgXetNghiem(rs.getTimestamp("tg_xet_nghiem"));
                int idNgCachLy = rs.getInt("id_ng_cach_ly");
                p.setNgCachLy(ngCachLyDAO.get(idNgCachLy));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public KqXetNghiem get(int id) {
        String sql = "select * from kq_xet_nghiem where id_kq_xet_nghiem= " + id;
        List<KqXetNghiem> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }
    
    public List<KqXetNghiem> findByIdNgCachLy(int id) {
        String sql = "select * from kq_xet_nghiem where id_ng_cach_ly = " + id;
        List<KqXetNghiem> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public List<KqXetNghiem> getAll() {
        String sql = "select * from kq_xet_nghiem";
        List<KqXetNghiem> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(KqXetNghiem t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setInt(1, t.getNgCachLy().getIdNguoiCachLy());
            prep.setString(2, t.getTenLoaiXetNghiem());
            prep.setString(3, t.getKqXetNghiem());
            prep.setTimestamp(4, (java.sql.Timestamp) t.getTgXetNghiem());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(KqXetNghiem t) {
        try {
            String sql = "delete from kq_xet_nghiem where id_kq_xet_nghiem = "+t.getIdKqXetNghiem();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    @Override
    public void update(KqXetNghiem t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
