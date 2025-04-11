package Controller;

import java.sql.*;

public class DbController {
    private final String dbName = "rjz5227";
    private final String url = "jdbc:mysql://0.0.0.0:3306/"+dbName;
    private final String username = "testuser";
    private final String password = "testpass";
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
            e.printStackTrace();
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
