package WarmupAndRecoveryPatterns;

import WarmupAndRecoveryPatterns.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarmupAndRecoveryCommandPattern extends JFrame {
    private JButton logWorkoutButton;
    private JButton startWarmUpButton;
    private JPanel mainPanel;

    public WarmupAndRecoveryCommandPattern() {
        ProgressTracker tracker = new ProgressTracker();
        WarmUpService warmUpService = new WarmUpService();

        Command logWorkoutCommand = new LogWorkoutCommand(tracker);
        Command startWarmUpCommand = new StartWarmUpCommand(warmUpService);

        logWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logWorkoutCommand.execute();
            }
        });

        startWarmUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startWarmUpCommand.execute();
            }
        });

        setContentPane(mainPanel);
        setTitle("Command Pattern Demo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new WarmupAndRecoveryCommandPattern();
    }
}
