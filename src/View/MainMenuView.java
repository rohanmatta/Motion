package View;

import View.ShareProgress.ShareProgressView;
import View.Support.TicketView;
import Controller.TicketController;
import Model.Login.User;
import Model.ShareProgress.SocialMediaAccount;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {
    private final User currentUser;
    private final SocialMediaAccount currentAccount;
    private final TicketController ticketController;

    public MainMenuView(User user, SocialMediaAccount account, TicketController ticketController) {
        this.currentUser = user;
        this.currentAccount = account;
        this.ticketController = ticketController;

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
            view.displaySocialMediaPosts(currentAccount);
        });

        supportButton.addActionListener(e -> {
            TicketView ticketView = new TicketView(ticketController);
            ticketView.listTickets();  // or ticketView.viewTicket(); depending on your logic
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

    public MainMenuView(User user) {
    }
}
