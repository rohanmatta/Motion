package View;

import Controller.LoginController;
import Controller.TrackProgressController;
import Controller.TicketController;
import Model.DB.DBError;
import Model.Login.User;
import View.Login.LoginView;
import View.ShareProgress.ShareProgressView;
import View.Support.TicketListView;
import View.ShareProgress.ShareProgressUI.ShareProgressWizardPattern;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {
    private final User currentUser;

    public MainMenuView(User user) {
        this.currentUser = user;

        setTitle("Main Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));  // now 4 rows

        // 1) Share Progress
        JButton shareProgressButton = new JButton("Share Progress");
        shareProgressButton.addActionListener(e -> {
            new ShareProgressWizardPattern().setVisible(true);
        });

        // 2) Track Progress
        JButton trackProgressButton = new JButton("Track Progress");
        trackProgressButton.addActionListener(e -> {
            // Launch your Track Progress window
            try {
                new TrackProgressController(currentUser);
            } catch (DBError ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }
            dispose();
        });

        // 3) Support Tickets
        JButton supportButton = new JButton("Support");
        supportButton.addActionListener(e -> {
            try {
                new TicketListView(new TicketController(currentUser));
            } catch (DBError ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }
            dispose();
        });

        // 4) Logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose();
            new LoginView(new LoginController());
        });

        // add buttons in order
        add(shareProgressButton);
        add(trackProgressButton);
        add(supportButton);
        add(logoutButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
