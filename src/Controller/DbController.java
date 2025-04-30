package Controller;

import Model.DB.DBError;

import java.security.InvalidParameterException;
import java.sql.*;

public class DbController {
    private final String dbName = "ist412_001_team1";
    private final String url = "jdbc:mysql://0.0.0.0:3307/"+dbName;
    private final String username = "rjz5227";
    private final String password = "EsTMYK62";
    private Connection conn = null;

    public DbController() throws DBError {
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
            throw new DBError("DB Connection error, please restart the application and try again");
        }
    }

    public Connection getConn() throws DBError {
        if (conn == null) {
            DbController dbController = new DbController();
            return dbController.getConn();
        }
        return conn;
    }
}
