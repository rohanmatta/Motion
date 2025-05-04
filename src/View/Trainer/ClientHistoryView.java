package View.Trainer;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Model.UserHistoryManager;

public class ClientHistoryView extends JFrame {

    private JTextField txtUsername;
    private JTextArea txtHistory;

    public ClientHistoryView() {
        setTitle("View Client History");
        setSize(500, 400);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        txtUsername = new JTextField(20);
        JButton btnView = new JButton("View");

        topPanel.add(new JLabel("Enter Client Username:"));
        topPanel.add(txtUsername);
        topPanel.add(btnView);
        add(topPanel, BorderLayout.NORTH);

        txtHistory = new JTextArea();
        txtHistory.setEditable(false);
        add(new JScrollPane(txtHistory), BorderLayout.CENTER);

        btnView.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            List<UserHistoryManager.HistoryEntry> history = UserHistoryManager.getHistoryFor(username);
            txtHistory.setText("");

            if (history.isEmpty()) {
                txtHistory.setText("No history found for user: " + username);
            } else {
                for (UserHistoryManager.HistoryEntry entry : history) {
                    txtHistory.append(entry.toString() + "\n");
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
