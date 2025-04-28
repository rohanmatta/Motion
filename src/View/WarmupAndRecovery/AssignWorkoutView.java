package View.WarmupAndRecovery;

import javax.swing.*;
import java.awt.*;

public class AssignWorkoutView extends JFrame {

    public AssignWorkoutView() {
        setTitle("Assign Workout to Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel clientIdLabel = new JLabel("Client ID:");
        JTextField clientIdField = new JTextField();

        JLabel workoutNameLabel = new JLabel("Workout Name:");
        JTextField workoutNameField = new JTextField();

        JLabel workoutStepsLabel = new JLabel("Workout Steps (comma-separated):");
        JTextField workoutStepsField = new JTextField();

        JButton assignButton = new JButton("Assign Workout");

        add(clientIdLabel);
        add(clientIdField);
        add(workoutNameLabel);
        add(workoutNameField);
        add(workoutStepsLabel);
        add(workoutStepsField);
        add(new JLabel()); // empty space
        add(assignButton);

        assignButton.addActionListener(e -> {
            String clientId = clientIdField.getText();
            String workoutName = workoutNameField.getText();
            String steps = workoutStepsField.getText();

            if (clientId.isEmpty() || workoutName.isEmpty() || steps.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.");
            } else {
                // 🔥 Here you would save the workout for the client
                System.out.println("Assigned " + workoutName + " to client " + clientId + " with steps: " + steps);
                JOptionPane.showMessageDialog(this, "Workout assigned successfully!");
                dispose();
            }
        });
    }
}
