package View;

import Controller.LoginController;
import Controller.TrackProgressController;
import Controller.TicketController;
import Model.DB.DBError;
import Model.Login.User;
import Model.Login.Role;
import View.Login.LoginView;
import View.ShareProgress.ShareProgressUI.ShareProgressWizardPattern;
import View.Support.TicketListView;
import View.WarmupAndRecovery.ViewWarmUpOptions;
import View.WarmupAndRecovery.AssignWorkoutView;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {
    private final User currentUser;

    public MainMenuView(User user) {
        this.currentUser = user;

        setTitle("Main Menu");
        setSize(400, 500); // Slightly taller to fit extra button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10)); // Up to 6 rows

        // 1) Share Progress
        JButton shareProgressButton = new JButton("Share Progress");
        shareProgressButton.addActionListener(e -> new ShareProgressWizardPattern().setVisible(true));

        // 2) Track Progress
        JButton trackProgressButton = new JButton("Track Progress");
        trackProgressButton.addActionListener(e -> {
            try {
                new TrackProgressController(currentUser);
            } catch (DBError ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }
            dispose();
        });

        // 3) Support
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

        // 4) Warmup and Recovery
        JButton warmupRecoveryButton = new JButton("Warmup and Recovery");
        warmupRecoveryButton.addActionListener(e -> new ViewWarmUpOptions().setVisible(true));

        // 5) Logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose();
            new LoginView(new LoginController());
        });

        // 🔥 6) Trainer Only: Assign Workout
        JButton assignWorkoutButton = new JButton("Assign Workout");
        assignWorkoutButton.addActionListener(e -> new AssignWorkoutView().setVisible(true));

        // 🔥 Add common buttons
        add(shareProgressButton);
        add(trackProgressButton);
        add(supportButton);
        add(warmupRecoveryButton);
        add(logoutButton);

        // 🔥 Only show Assign Workout if user is a Trainer
        if (currentUser.checkUserRole(Role.TRAINER)) {
            add(assignWorkoutButton);
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
