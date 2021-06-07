/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhuCachLy;
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
public class KhuCachLyDAO implements DAO<KhuCachLy> {

    private final String SQL_INSERT = "Insert into khu_cach_ly"
            + "(ten_khu_cach_ly, dia_chi_khu_cach_ly, lien_he) values " + "(?, ?, ?)";
    

    Connection conn = ConnectDB.getConnection();

    @Override
    public List<KhuCachLy> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<KhuCachLy> qq = new ArrayList<>();
            while (rs.next()) {
                KhuCachLy p = new KhuCachLy();
                p.setIdKhuCachLy(rs.getInt("id_khu_cach_ly"));
                p.setTenKhuCachLy(rs.getString("ten_khu_cach_ly"));
                p.setDiaChiKhuCachLy(rs.getString("dia_chi_khu_cach_ly"));
                p.setLienHe(rs.getString("lien_he"));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public KhuCachLy get(int id) {
        String sql = "select * from khu_cach_ly where id_khu_cach_ly= " + id;
        List<KhuCachLy> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<KhuCachLy> getAll() {
        String sql = "select * from khu_cach_ly";
        List<KhuCachLy> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(KhuCachLy t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, t.getTenKhuCachLy());
            prep.setString(2, t.getDiaChiKhuCachLy());
            prep.setString(3, t.getLienHe());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(KhuCachLy t) {
        try {
            String sql = "delete from khu_cach_ly where id_khu_cach_ly = " + t.getIdKhuCachLy();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    @Override
    public void update(KhuCachLy t, Hashtable<String, String> my_dict) {
        String sql_update = "Update khu_cach_ly set ";
        try (
                PreparedStatement prep = conn.prepareStatement(sql_update);) {
            String change = "";
            for (String key : my_dict.keySet()){
                String value = my_dict.get(key);
                try {
                    int values = Integer.parseInt(value);
                    change += key + " = "+ values+",";
                }catch(Exception e){
                    change += key + " = '"+ value+"',";
                }  
            }
            change = change.substring(0, change.length()-1);
            sql_update += change + " where id_khu_cach_ly = "+t.getIdKhuCachLy();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql_update);
        } catch (SQLException x) {
            x.printStackTrace();
        }
        
    }

}

