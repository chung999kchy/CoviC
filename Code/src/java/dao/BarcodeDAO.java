/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Barcode;
import entity.NguoiCachLy;

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
public class BarcodeDAO implements DAO<Barcode> {

    private final String SQL_INSERT = "Insert into barcode"
            + "(ng_cach_ly_id, ma, time_begin, time_end, lan) values " + "(?, ?, ?, ?, ?)";
    

    Connection conn = ConnectDB.getConnection();
    NguoiCachLyDAO ngCachLyDAO = new NguoiCachLyDAO();

    @Override
    public List<Barcode> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Barcode> qq = new ArrayList<>();
            while (rs.next()) {
                Barcode p = new Barcode();
                int idNgCachLy = rs.getInt("ng_cach_ly_id");
                p.setNgCachLy(ngCachLyDAO.get(idNgCachLy));
                p.setMa(rs.getString("ma"));
                p.setTimeBegin(rs.getTimestamp("time_begin"));
                p.setTimeEnd(rs.getTimestamp("time_end"));
                p.setLan(rs.getInt("lan"));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Barcode get(int id) {
        String sql = "select * from barcode where ng_cach_ly_id= " + id;
        List<Barcode> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    public Barcode findByMa(String ma) {
        String sql = "select * from barcode where ma= '"+ma+"' and now() < time_end and now() > time_begin;";
        List<Barcode> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }
    @Override
    public List<Barcode> getAll() {
        String sql = "select * from barcode";
        List<Barcode> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(Barcode t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setInt(1, t.getNgCachLy().getIdNguoiCachLy());
            prep.setString(2, t.getMa());
            prep.setTimestamp(3, (java.sql.Timestamp)t.getTimeBegin());
            prep.setTimestamp(4, (java.sql.Timestamp)t.getTimeEnd());
            prep.setInt(5, t.getLan());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Barcode t) {
        try {
            String sql = "delete from barcode where ma = " + t.getMa();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }
    
    

    @Override
    public void update(Barcode t, Hashtable<String, String> my_dict) {
        String sql_update = "Update barcode set ";
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
            sql_update += change + " where ma = '"+t.getMa()+"'";
            System.out.println("abc: "+sql_update);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate(sql_update);
        } catch (SQLException x) {
            x.printStackTrace();
        }
        
    }
    
    public void deleteQRByTime(int idNguoi){
        try {
            String sql = "delete from barcode where ng_cach_ly_id = " + idNguoi+" and (now() > time_end or lan > 0)";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

}
