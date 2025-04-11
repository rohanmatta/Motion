package Controller;

import java.security.InvalidParameterException;
import java.sql.*;

public class DbController {
    private final String dbName = "ist412_001_team1";
    private final String url = "jdbc:mysql://mysql.up.ist.psu.edu:3306/"+dbName;
    private final String username = "user";
    private final String password = "pass";
    private Connection conn = null;

    public DbController() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL!");

//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
//
//            if (rs.next()) {
//                System.out.println("Test User found");
////                System.out.println(rs.getString("user_name")); // example
//            }

            this.conn = conn;

        } catch (SQLException e) {
            throw new InvalidParameterException("DB Connection invalid");
        }
    }

    public Connection getConn() {
        if (conn == null) {
            DbController dbController = new DbController();
            return dbController.getConn();
        }
        return conn;
    }
}
