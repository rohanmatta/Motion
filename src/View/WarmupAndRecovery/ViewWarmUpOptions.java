package View.WarmupAndRecovery;

import WarmupAndRecoveryPatterns.WarmUpPlan;
import WarmupAndRecoveryPatterns.WarmUpPlanFactory;

import javax.swing.*;
import java.awt.*;

public class ViewWarmUpOptions extends JFrame {

    public ViewWarmUpOptions() {
        setTitle("Warmup and Recovery Options");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel label = new JLabel("Choose a Warmup Plan", SwingConstants.CENTER);
        add(label);

        // 🔥 New button texts to match warmups
        JButton cardioButton = new JButton("Cardio Warmup");
        JButton strengthButton = new JButton("Strength Warmup");
        JButton flexibilityButton = new JButton("Flexibility Warmup");

        add(cardioButton);
        add(strengthButton);
        add(flexibilityButton);

        // 🔥 Cardio Warmup
        cardioButton.addActionListener(e -> {
            WarmUpPlan plan = WarmUpPlanFactory.createWarmUpPlan("cardio");
            if (plan != null) {
                new WarmupSessionView("cardio").setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Unable to load Cardio warmup plan.");
            }
        });

        // 🔥 Strength Warmup
        strengthButton.addActionListener(e -> {
            WarmUpPlan plan = WarmUpPlanFactory.createWarmUpPlan("strength");
            if (plan != null) {
                new WarmupSessionView("strength").setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Unable to load Strength warmup plan.");
            }
        });

        // 🔥 Flexibility Warmup
        flexibilityButton.addActionListener(e -> {
            WarmUpPlan plan = WarmUpPlanFactory.createWarmUpPlan("flexibility");
            if (plan != null) {
                new WarmupSessionView("flexibility").setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Unable to load Flexibility warmup plan.");
            }
        });
    }
}
