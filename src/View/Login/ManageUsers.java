package View.Login;

import Controller.UserController;
import Model.Login.Role;
import Model.Login.User;
import View.MainMenuView;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ManageUsers extends JFrame {
    private JPanel panel1;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton searchButton;
    private JButton updateUserButton;
    private JTextField emailField;
    private JButton backButton;
    private JPanel rolePanel;
    private JButton createUserButton;
    private JButton deleteUserButton;
    private Map<Role, JCheckBox> roleCheckBoxMap = new HashMap<>();
    private UserController userController;

    public ManageUsers(UserController userController) {
        this.userController = userController;
        this.add(panel1);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        addRoles();
        addActionListeners();
        this.setVisible(true);
    }

    private void addRoles() {
        rolePanel.setLayout(new GridLayout(3, Role.values().length / 3 + 1));
        for (Role r : Role.values()) {
            JCheckBox checkBox = new JCheckBox(r.toString());
            roleCheckBoxMap.put(r, checkBox);
            rolePanel.add(checkBox);
        }
    }

    private void addActionListeners() {
        searchButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            System.out.println(username);
            User u = userController.lookupUser(username);
            if (u != null) {
                emailField.setText(u.getUserEmail());
                passwordField.setText("");
                for (Role r : Role.values()) {
                    JCheckBox checkBox = roleCheckBoxMap.get(r);
                    checkBox.setSelected(u.checkUserRole(r));
                }
                this.setTitle("Editing User: " + u.getUserName() + " (" + u.getUserID() + ")");
            }
        });
        updateUserButton.addActionListener(e -> {
            User u = new User();
            u.setUserEmail(emailField.getText());
            u.setUserPassword(passwordField.getText());
            for (Role r : Role.values()) {
                JCheckBox checkBox = roleCheckBoxMap.get(r);
                if (checkBox.isSelected()) {
                    u.addUserRole(r);
                }
            }
            u.setUserName(usernameField.getText());
            u.setUserID(userController.getSelectedUser().getUserID());
            userController.updateUser(u);
        });
        backButton.addActionListener((e) -> {
            this.dispose();
            new MainMenuView(userController.getActiveUser());
        });
        createUserButton.addActionListener(e -> {
            User u = new User();
            u.setUserName(usernameField.getText());
            u.setUserPassword(passwordField.getText());
            for (Role r : Role.values()) {
                JCheckBox checkBox = roleCheckBoxMap.get(r);
                if (checkBox.isSelected()) {
                    u.addUserRole(r);
                }
            }
            if (userController.createAndManageUser(u)) {
                this.setTitle("Editing User: " + u.getUserName() + " (" + u.getUserID() + ")");
            }
        });
        deleteUserButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(ManageUsers.this, "Are you sure you would like to delete user: " + userController.getSelectedUser().getUserName() + " (" + userController.getSelectedUser().getUserID() + ")", "Delete User", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (userController.deleteUser()) {
                    JOptionPane.showMessageDialog(ManageUsers.this, "Deleted User");
                }
            }
        });
    }
}
