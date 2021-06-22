/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Don;
import entity.KhuCachLy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author CHUNG
 */
public class DonDAO implements DAO<Don> {

    private String SQL_COUNT_TODAY = "SELECT count(*) as soluong FROM datn.don "
            + "WHERE month(tg_tao) = month(now()) "
            + "and year(tg_tao)=year(now()) "
            + "and day(tg_tao) = day(now()) ";
    
    private String SQL_COUNT_THIS_MONTH = "SELECT count(*) as soluong FROM datn.don "
            + "WHERE month(tg_tao) = month(now()) "
            + "and year(tg_tao)=year(now()) ";
    
    private final String SQL_INSERT = "Insert into don"
            + "(id_loai_don, id_nguoi_tao, kq_xac_nhan, noi_dung, tg_tao, tg_xac_nhan, id_khu_cach_ly) values " + "(?,?,?,?,?,?,?)";
    
    
    Connection conn = ConnectDB.getConnection();
    LoaiDonDAO loaiDonDAO = new LoaiDonDAO();
    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    KhuCachLyDAO khuCachLyDAO = new KhuCachLyDAO();
    
    @Override
    public List<Don> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Don> qq = new ArrayList<>();
            while (rs.next()) {
                Don p = new Don();
                p.setIdDon(rs.getInt("id_don"));
                int idLoaiDon = rs.getInt("id_loai_don");
                p.setLoaiDon(loaiDonDAO.get(idLoaiDon));
                int idNgTao = rs.getInt("id_nguoi_tao");
                p.setNguoiTao(taiKhoanDAO.get(idNgTao));
                p.setIdNguoiXacNhan(rs.getInt("id_nguoi_xac_nhan"));
                p.setKqXacNhan(rs.getString("kq_xac_nhan"));
                p.setNoiDung(rs.getString("noi_dung"));
                p.setTgTao(rs.getTimestamp("tg_tao"));
                p.setTgXacNhan(rs.getTimestamp("tg_xac_nhan"));
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
    public Don get(int id) {
        String sql = "select * from don where id_don= " + id;
        List<Don> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<Don> getAll() {
        String sql = "select * from don";
        List<Don> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(Don t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setInt(1, t.getLoaiDon().getIdLoaiDon());
            prep.setInt(2, t.getNguoiTao().getIdTaiKhoan());
            //prep.setInt(3, t.getIdNguoiXacNhan());
            prep.setString(3, t.getKqXacNhan());
            prep.setString(4, t.getNoiDung());
            prep.setTimestamp(5, (Timestamp) t.getTgTao());
            prep.setTimestamp(6, (Timestamp) t.getTgXacNhan());
            prep.setInt(7, t.getKhuCachLy().getIdKhuCachLy());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    @Override
    public void delete(Don t) {
        try {
            String sql = "delete from don where id_don = "+t.getIdDon();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    @Override
    public void update(Don t, Hashtable<String, String> my_dict) {
        String sql_update = "Update don set ";
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
            sql_update += change + " where id_don = "+t.getIdDon();
            Statement stmt = conn.createStatement();
            System.out.println("sql "+ sql_update);
            stmt.executeUpdate(sql_update);
        } catch (SQLException x) {
            x.printStackTrace();
        }
        
    }
    
    public List<Don> getList(int offset, int noOfRecords, int idKhuCachLy) {
        String sql = "SELECT * from don where id_khu_cach_ly ="+idKhuCachLy+" limit " + offset + ", " + noOfRecords;
        List<Don> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public int getNoOfRecord(int idKhuCachLy) {
        try {
            String sql = "select count(*) as soluong from don where id_khu_cach_ly = "+idKhuCachLy;
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            rs.next();
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }
    
    public List<Don> getListById(int idNgTao, int offset, int noOfRecords) {
        String sql = "SELECT * from don where id_nguoi_tao = "+idNgTao+" limit " + offset + ", " + noOfRecords;
        List<Don> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public int getNoOfRecordById(int idNgTao) {
        try {
            String sql = "select count(*) as soluong from don where id_nguoi_tao = "+idNgTao;
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            rs.next();
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }


    public int getCountToday(int idKhu) {
        if (idKhu != 0) SQL_COUNT_TODAY += "and id_khu_cach_ly = "+idKhu;
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
        if (idKhu != 0) SQL_COUNT_THIS_MONTH += "and id_khu_cach_ly = "+idKhu;
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(SQL_COUNT_THIS_MONTH);
            rs.next();
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }
}
