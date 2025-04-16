package View.Login;

import Controller.LoginController;
import Controller.TicketController;
import Model.Login.User;
import View.Support.SupportTicketView;
import View.Support.TicketListView;

import javax.swing.*;
import java.util.Arrays;

public class LoginView extends JFrame {
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JPanel mainPanel;
    private LoginController controller;

    public JPasswordField getPassword() {
        return password;
    }

    public JTextField getUsername() {
        return username;
    }

    /**
     * @return login button
     */
    public JButton getLoginButton() {
        return loginButton;
    }

    public LoginView(LoginController loginController) {
        this.controller = loginController;
        this.add(mainPanel);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        addActionListeners();
        this.setVisible(true);
    }

    private void addActionListeners() {
        loginButton.addActionListener((e) -> {
            String pw = new String(password.getPassword());
            System.out.println("Login Button pressed: U: " + username.getText() + ", P: " + pw);
            User user = new User();
            user.setUserName(username.getText());
            user.setUserPassword(pw);
            controller.setUser(user);
            if (controller.tryLogin()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                System.out.println(this.controller.getUser().getUserRole());
                this.dispose();
                TicketListView newView = new TicketListView(new TicketController(this.controller.getUser()));
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed!");
            }
        });
    }
}
