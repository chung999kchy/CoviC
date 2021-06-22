/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author CHUNG
 */

/**
 * Interface giao tiếp với cơ sở dữ liệu
 * @param <T> Kiểu dữ liệu
 */
public interface DAO<T> {

    List<T> parse(String sql);
    
    T get(int id);
    
    List<T> getAll();

    void create(T t);

    void update(T t, Hashtable<String, String> my_dict) ;

    void delete(T t);
}
