package View.Login;

import Controller.LoginController;
import Model.DB.DBError;
import Model.Login.User;
import View.MainMenuView;

import javax.swing.*;

public class CreateUser extends JFrame{
    private LoginController controller;
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JButton createUserButton;

    public CreateUser(LoginController loginController) {
        this.controller = loginController;
        this.add(panel1);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        addActionListeners();
        this.setVisible(true);
    }

    private void addActionListeners() {
        createUserButton.addActionListener(e -> {
            String username = textField1.getText();
            String password = String.valueOf(passwordField.getPassword());
            String email = emailField.getText();
            User user = new User();
            user.setUserEmail(email);
            user.setUserName(username);
            user.setUserPassword(password);
            try {
                if (controller.createUser(user)) {
                    JOptionPane.showMessageDialog(CreateUser.this, "User Created");
                    this.dispose();
                    new MainMenuView(controller.getUser());
                }
            } catch (DBError ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}
