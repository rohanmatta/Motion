package Controller;

import Model.DB.DBError;
import Model.Login.User;
import View.Login.LoginView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Controller class responsible for managing the login view.
 */
public class LoginController {

    private LoginView loginViewFrame;
    private User user;
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
            PreparedStatement stmt = conn.prepareStatement("select user_id, password from users where users.user_name = ?");
            stmt.setString(1, user.getUserName());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
//                System.out.println("User Found");
                String pass = rs.getString("password");
                user.setUserID(String.valueOf(rs.getLong("user_id")));
                if (passwordEncoder.matches(user.getUserPassword(), pass)) {
                    stmt = conn.prepareStatement("select email, roles from users where users.user_id = ?");
                    stmt.setString(1, user.getUserID());
                    ResultSet rs2 = stmt.executeQuery();
                    if (rs2.next()) {
                        user.setUserEmail(rs2.getString("email"));
                        user.setUserRole(rs2.getLong("roles"));
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createUser(User user) throws DBError {
        if (UserController.createUser(user) != null) {
            this.setUser(user);
            return true;
        }
        return false;
    }
}
