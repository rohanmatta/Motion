package View;

import Controller.TicketController;
import View.ShareProgress.ShareProgressView;
import View.Support.TicketListView;
import View.Support.TicketView;
import Model.Login.User;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {
    private final User currentUser;

    public MainMenuView(User user) {
        this.currentUser = user;

        setTitle("Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JButton shareProgressButton = new JButton("Share Progress");
        JButton supportButton = new JButton("Support");
        JButton logoutButton = new JButton("Logout");

        // Lambda replaced with expression form
        shareProgressButton.addActionListener(e -> {
            ShareProgressView view = new ShareProgressView();
            view.displayUserProgress(currentUser);
        });

        supportButton.addActionListener(e -> {
            new TicketListView(new TicketController(user));
            this.dispose();
        });

        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose();
        });

        add(shareProgressButton);
        add(supportButton);
        add(logoutButton);

        setVisible(true);
    }
}
