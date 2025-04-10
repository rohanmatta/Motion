package View.Login;

import Controller.LoginController;

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
            System.out.println("Login Button pressed: U: " + username.getText() + ", P: " + new String(password.getPassword()));
        });
    }
}
