package utils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sun on 11/15/16.
 */
public class DBConnection {
    private static DBConnection dbConnection = new DBConnection();

    private DBConnection(){}

    public static DBConnection getInstance() {
        return dbConnection;
    }

    public static Connection getDBConnection() {
        Connection conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/voucher?" + "user=root&password=root");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect with Database", "Inane warning", JOptionPane.WARNING_MESSAGE);
        }
        return conn;
    }

}
