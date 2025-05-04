package Controller;

import Model.DB.DBError;
import Model.Login.Role;
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

    public LoginController() {
        this.loginViewFrame = new LoginView(this);
    }

    public LoginView getLoginFrame() {
        return loginViewFrame;
    }

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

            PreparedStatement stmt = conn.prepareStatement(
                    "select user_id, password from users where users.user_name = ?"
            );
            stmt.setString(1, user.getUserName());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String pass = rs.getString("password");
                user.setUserID(String.valueOf(rs.getLong("user_id")));

                if (passwordEncoder.matches(user.getUserPassword(), pass)) {
                    stmt = conn.prepareStatement(
                            "select email, roles from users where users.user_id = ?"
                    );
                    stmt.setString(1, user.getUserID());
                    ResultSet rs2 = stmt.executeQuery();

                    if (rs2.next()) {
                        user.setUserEmail(rs2.getString("email"));

                        // 🔒 SKIP DB role assignment
                        // user.setUserRole(rs2.getLong("roles"));

                        // 🔧 DEV ONLY: Hardcoded roles for demo
                        if (user.getUserName().equalsIgnoreCase("admin")) {
                            user.addUserRole(Role.ADMIN);
                        }

                        if (user.getUserName().equalsIgnoreCase("trainer1")) {
                            user.addUserRole(Role.TRAINER);
                            user.addUserRole(Role.USER); // optional: for Track/Share Progress
                        }

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
