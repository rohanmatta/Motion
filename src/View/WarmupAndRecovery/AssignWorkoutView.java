package View.WarmupAndRecovery;

import Model.Login.User;

import javax.swing.*;
import java.awt.*;

public class AssignWorkoutView extends JFrame {

    private final User clientUser;

    public AssignWorkoutView(User clientUser) {
        this.clientUser = clientUser;

        setTitle("Assign Workout to " + clientUser.getUserName());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel workoutNameLabel = new JLabel("Workout Name:");
        JTextField workoutNameField = new JTextField();

        JLabel workoutStepsLabel = new JLabel("Workout Steps (comma-separated):");
        JTextField workoutStepsField = new JTextField();

        JButton assignButton = new JButton("Assign Workout");

        add(workoutNameLabel);
        add(workoutNameField);
        add(workoutStepsLabel);
        add(workoutStepsField);
        add(new JLabel()); // spacing
        add(assignButton);

        assignButton.addActionListener(e -> {
            String workoutName = workoutNameField.getText();
            String steps = workoutStepsField.getText();

            if (workoutName.isEmpty() || steps.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.");
            } else {
                // 🔥 Mocking DB insert (replace with real insert later)
                System.out.println("Assigned " + workoutName + " to user " +
                        clientUser.getUserID() + " with steps: " + steps);
                JOptionPane.showMessageDialog(this, "Workout assigned successfully!");
                dispose();
            }
        });

        setVisible(true);
    }
}
