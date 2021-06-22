/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.LoaiDon;
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
public class LoaiDonDAO implements DAO<LoaiDon> {

    private final String SQL_INSERT = "Insert into loai_don"
            + "(ten_loai_don) values " + "( ?)";

    Connection conn = ConnectDB.getConnection();

    @Override
    public List<LoaiDon> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<LoaiDon> qq = new ArrayList<>();
            while (rs.next()) {
                LoaiDon p = new LoaiDon();
                p.setIdLoaiDon(rs.getInt("id_loai_don"));
                p.setTenLoaiDon(rs.getString("ten_loai_don"));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public LoaiDon get(int id) {
        String sql = "select * from loai_don where id_loai_don= " + id;
        List<LoaiDon> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<LoaiDon> getAll() {
        String sql = "select * from loai_don";
        List<LoaiDon> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(LoaiDon t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, t.getTenLoaiDon());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(LoaiDon t) {
        try {
            String sql = "delete from loai_don where id_loai_don = "+t.getIdLoaiDon();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    @Override
    public void update(LoaiDon t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
