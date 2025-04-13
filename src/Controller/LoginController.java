package Controller;

import Model.Login.User;
import View.Login.LoginView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Controller class responsible for managing the login view.
 */
public class LoginController {

    private LoginView loginViewFrame;
    private User user;

    /**
     * Constructs a new {@code LoginController} with a default {@link LoginView} instance.
     */
    public LoginController() {
        this.loginViewFrame = new LoginView(this);
    }

    /**
     * Retrieves the current {@link LoginView} instance.
     *
     * @return The current login view frame.
     */
    public LoginView getLoginFrame() {
        return loginViewFrame;
    }

    /**
     * Sets the {@link LoginView} instance.
     *
     * @param loginViewFrame The new login view frame to be set.
     */
    public void setLoginFrame(LoginView loginViewFrame) {
        this.loginViewFrame = loginViewFrame;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean tryLogin() {
        try {
            DbController dbController = new DbController();
            Connection conn = dbController.getConn();
            System.out.println(user);
            PreparedStatement stmt = conn.prepareStatement("select * from users where users.user_name = ? and users.password = ?");
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserPassword());
            System.out.println("hello?");
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("User Found");
                user.setUserEmail(rs.getString("email"));
                user.setUserID(String.valueOf(rs.getLong("user_id")));
                user.setUserRole(rs.getLong("roles"));
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
