package View.Login;

import Controller.LoginController;
import Model.Login.User;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JPanel mainPanel;
    private JButton createUserButton;
    private JLabel statusLabel;
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
//            System.out.println("Login Button pressed: U: " + username.getText() + ", P: " + pw);
            User user = new User();
            user.setUserName(username.getText());
            user.setUserPassword(pw);
            controller.setUser(user);
            if (controller.tryLogin()) {
//                JOptionPane.showMessageDialog(this, "Login Successful!");
//                System.out.println(this.controller.getUser().getUserRole());
                new View.MainMenuView(this.controller.getUser());
                this.dispose();
            } else {
//                JOptionPane.showMessageDialog(this, "Login Failed!");
                statusLabel.setForeground(Color.RED);
                statusLabel.setText("Login Failed");
                password.setText("");
            }
        });

        createUserButton.addActionListener((e) -> {
           new CreateUser(this.controller);
           this.dispose();
        });
    }
}
