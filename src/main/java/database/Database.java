package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    protected static String URL = "jdbc:mysql://localhost:3306/qlsv123?useSSL=false";
    protected static String USERNAME = "root";
    protected static String PASSWORD = "123456";
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            return null;
        }
    }
}
