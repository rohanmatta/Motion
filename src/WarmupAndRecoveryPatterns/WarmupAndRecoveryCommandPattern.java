package WarmupAndRecoveryPatterns;

import View.WarmupAndRecovery.WarmupSessionView;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WarmupAndRecoveryCommandPattern {
    public JPanel mainPanel;
    private JButton logWorkoutButton;
    private JButton startWarmUpButton;
    private JLabel suggestedWarmupLabel;

    private String suggestedWarmup;
    private WarmUpService warmUpService;
    private String username; // ✅ new field

    // ✅ updated constructor to accept username
    public WarmupAndRecoveryCommandPattern(String username) {
        this.username = username;

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));

        suggestedWarmupLabel = new JLabel("", SwingConstants.CENTER);
        logWorkoutButton = new JButton("Log Workout");
        startWarmUpButton = new JButton("Start Suggested Warmup");

        mainPanel.add(suggestedWarmupLabel);
        mainPanel.add(startWarmUpButton);
        mainPanel.add(logWorkoutButton);

        warmUpService = new WarmUpService();
        suggestedWarmup = suggestWarmup();
        suggestedWarmupLabel.setText("Suggested Warmup: " + suggestedWarmup);

        startWarmUpButton.addActionListener(e -> handleStartWarmup());
        logWorkoutButton.addActionListener(e -> handleLogWorkout());
    }

    private String suggestWarmup() {
        String[] warmups = {"cardio", "strength", "flexibility"};
        Random random = new Random();
        int index = random.nextInt(warmups.length);
        return warmups[index];
    }

    private void handleStartWarmup() {
        WarmUpPlan plan = WarmUpPlanFactory.createWarmUpPlan(suggestedWarmup);

        if (plan != null) {
            new WarmupSessionView(suggestedWarmup).setVisible(true);
        } else {
            System.out.println("No matching warmup plan found.");
        }

        Command startCommand = new StartWarmUpCommand(warmUpService, suggestedWarmup, username);

        startCommand.execute();
    }

    private void handleLogWorkout() {
        Command logCommand = new LogWorkoutCommand(warmUpService, suggestedWarmup + " Completed", username);
        logCommand.execute();
    }

    private void createUIComponents() {
        // leave blank
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Warmup and Recovery Command Pattern Demo");

            // 🔥 For demo/testing, use a placeholder username
            frame.setContentPane(new WarmupAndRecoveryCommandPattern("demoUser").mainPanel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setVisible(true);
        });
    }
}
