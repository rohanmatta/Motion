package Controller;

import Model.DB.DBError;
import Model.Login.User;
import View.Login.ManageUsers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.*;
import java.sql.*;

public class UserController {
    private final ManageUsers manageUsersView;
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final User activeUser;
    private User selectedUser;

    public UserController(User activeUser) {
        this.activeUser = activeUser;
        this.manageUsersView = new ManageUsers(this);
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public User lookupUser(String userName) {
        try {
            DbController dbController = new DbController();
            Connection conn = dbController.getConn();
            PreparedStatement s = conn.prepareStatement("""
                    SELECT
                        user_id, email, roles
                    FROM users
                    WHERE user_name = ?
                    """);
            s.setString(1, userName);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserEmail(rs.getString("email"));
                u.setUserName(userName);
                u.setUserRole(rs.getLong("roles"));
                u.setUserID(rs.getString("user_id"));
                this.selectedUser = u;
                return u;
            } else {
                JOptionPane.showMessageDialog(manageUsersView, "User not found");
                return null;
            }
        } catch (DBError e) {
            JOptionPane.showMessageDialog(manageUsersView, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(manageUsersView, "Error fetching user, please try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void updateUser(User u) {
        try {
            DbController dbController = new DbController();
            Connection conn = dbController.getConn();
            PreparedStatement s;
            if (u.getUserPassword().isEmpty()) {
                s = conn.prepareStatement("""
                        
                            UPDATE users
                        SET
                            user_name = ?,
                            email = ?,
                            roles = ?
                        WHERE user_id = ?
                        """);
                s.setString(4, u.getUserID());
            } else {
                s = conn.prepareStatement("""
                        UPDATE users
                        SET
                            user_name = ?,
                            email = ?,
                            roles = ?,
                            password = ?
                        WHERE user_id = ?
                        """);
                s.setString(4, passwordEncoder.encode(u.getUserPassword()));
                s.setString(5, u.getUserID());
            }
            s.setString(1, u.getUserName());
            s.setString(2, u.getUserEmail());
            s.setLong(3, u.getUserRole());
            s.executeUpdate();
        } catch (DBError e) {
            JOptionPane.showMessageDialog(manageUsersView, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(manageUsersView, "Error updating user, please try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean deleteUser() {
        DbController dbController = null;
        try {
            dbController = new DbController();
            Connection conn = dbController.getConn();
            PreparedStatement s = conn.prepareStatement("""
                    DELETE FROM users WHERE user_id = ?
                    """);
            s.setString(1, selectedUser.getUserID());
            s.executeUpdate();
            this.selectedUser = null;
            return true;
        } catch (DBError | SQLException e) {
            JOptionPane.showMessageDialog(manageUsersView, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean createAndManageUser(User user) {
        try {
            User u = UserController.createUser(user);
            if (u != null) {
                this.selectedUser = u;
                return true;
            }
            return false;
        } catch (DBError e) {
            JOptionPane.showMessageDialog(manageUsersView, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static User createUser(User user) throws DBError {
        try {
            DbController dbController = new DbController();
            Connection conn = dbController.getConn();
            System.out.println(user);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (user_name, email, password, roles) VALUES (?, ?, ?, ?)");
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserEmail());
            stmt.setString(3, passwordEncoder.encode(user.getUserPassword()));
            stmt.setLong(4, user.getUserRole());
            boolean rs = stmt.execute();

            stmt = conn.prepareStatement("SELECT user_id FROM users WHERE users.user_name = ?");
            stmt.setString(1, user.getUserName());
            ResultSet rs2 = stmt.executeQuery();
            if (rs2.next()) {
                user.setUserID(String.valueOf(rs2.getLong("user_id")));
                return user;
            }
            return null;
        } catch (Exception e) {
            if (e instanceof SQLIntegrityConstraintViolationException ex) {
                if (ex.getMessage().contains("users.unique_email")) {
                    throw new DBError("Email already in use");
                } else if (ex.getMessage().contains("users.unique_username")) {
                    throw new DBError("Username already in use");
                }
            }
            e.printStackTrace();
            return null;
        }
    }
}
