package WarmupAndRecoveryPatterns;

import javax.swing.*;

public class WarmupAndRecoveryCommandPattern {
    public JPanel mainPanel;
    private JButton logWorkoutButton;
    private JButton startWarmUpButton;

    public WarmupAndRecoveryCommandPattern() {
        // Initialize mainPanel if not initialized by a GUI designer
        mainPanel = new JPanel();

        // Add buttons to the panel
        logWorkoutButton = new JButton("Log Workout");
        startWarmUpButton = new JButton("Start WarmUp");
        mainPanel.add(logWorkoutButton);
        mainPanel.add(startWarmUpButton);

        // Initialize the services and commands
        ProgressTracker tracker = new ProgressTracker();
        WarmUpService warmUpService = new WarmUpService();

        Command logWorkoutCommand = new LogWorkoutCommand(tracker);
        Command startWarmUpCommand = new StartWarmUpCommand(warmUpService);

        logWorkoutButton.addActionListener(e -> logWorkoutCommand.execute());
        startWarmUpButton.addActionListener(e -> startWarmUpCommand.execute());
    }

    // 👇 ADD THIS METHOD RIGHT HERE (empty if not manually creating components)
    private void createUIComponents() {
        // You can leave this empty unless you're creating custom components manually
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Command Pattern Demo");
            frame.setContentPane(new WarmupAndRecoveryCommandPattern().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
