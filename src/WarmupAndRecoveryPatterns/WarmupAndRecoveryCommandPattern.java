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

    public WarmupAndRecoveryCommandPattern() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10)); // label + 2 buttons

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
            // Show real warmup in a GUI window
            new WarmupSessionView(suggestedWarmup).setVisible(true);
        } else {
            System.out.println("No matching warmup plan found.");
        }

        Command startCommand = new StartWarmUpCommand(warmUpService, suggestedWarmup);
        startCommand.execute();
    }

    private void handleLogWorkout() {
        Command logCommand = new LogWorkoutCommand(warmUpService, suggestedWarmup + " Completed");
        logCommand.execute();
    }

    private void createUIComponents() {
        // Empty unless manually creating components
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Warmup and Recovery Command Pattern Demo");
            frame.setContentPane(new WarmupAndRecoveryCommandPattern().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setVisible(true);
        });
    }
}
