package View.WarmupAndRecovery;

import javax.swing.*;
import java.awt.*;

public class WarmupSessionView extends JFrame {

    public WarmupSessionView(String warmupType) {
        setTitle(warmupType.substring(0,1).toUpperCase() + warmupType.substring(1).toLowerCase() + " Warmup Session");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea workoutSteps = new JTextArea();
        workoutSteps.setEditable(false);

        if (warmupType.equalsIgnoreCase("cardio")) {
            workoutSteps.setText("""
                    Cardio Warmup Plan:
                    - Jog in place for 1 minute
                    - High knees for 30 seconds
                    - Jumping jacks for 1 minute
                    - Butt kicks for 30 seconds
                    """);
        } else if (warmupType.equalsIgnoreCase("strength")) {
            workoutSteps.setText("""
                    Strength Warmup Plan:
                    - Bodyweight squats: 15 reps
                    - Lunges: 10 reps each leg
                    - Arm circles: 30 seconds
                    - Pushups: 10 reps
                    """);
        } else if (warmupType.equalsIgnoreCase("flexibility")) {
            workoutSteps.setText("""
                    Flexibility Warmup Plan:
                    - Standing quad stretch: 30 sec per leg
                    - Hamstring stretch: 30 sec
                    - Shoulder rolls: 30 sec
                    - Neck stretch: 30 sec
                    """);
        } else {
            workoutSteps.setText("No warmup steps available.");
        }

        add(new JScrollPane(workoutSteps), BorderLayout.CENTER);

        JButton doneButton = new JButton("Finish Warmup");
        doneButton.addActionListener(e -> dispose()); // close the window
        add(doneButton, BorderLayout.SOUTH);
    }
}
