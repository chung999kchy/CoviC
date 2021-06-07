/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.Configs;
/**
 *
 * @author CHUNG
 */
public class ConnectDB {
    private static Connection connect;
    
    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"+Configs.DB_NAME ,
                    Configs.DB_USERNAME, Configs.DB_PASSWORD);
            System.out.println("Connect databse successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connect;
    }
    
    public static void main(String[] args) {
        ConnectDB.getConnection();
    }
}
