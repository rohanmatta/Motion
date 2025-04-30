package View.ShareProgress.ShareProgressUI;

import Controller.TrackProgressController;
import Model.Login.User;
import Model.TrackProgress.WorkoutEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShareProgressWizardPattern extends JFrame {
    private final User user;
    private JPanel mainPanel;
    private JLabel titleLabel; // Step title
    private JLabel stepLabel;  // Step description
    private JButton nextButton;
    private JButton backButton;
    private JProgressBar progressBar;
    private JTextField inputField;
    private JComboBox<String> ListOfWorkouts;
    private JPanel centerPanel;

    private int currentStep = 1;
    private final int totalSteps = 4;
    private String selectedWorkoutName = "";

    public ShareProgressWizardPattern(User user) {
        this.user = user;

        setTitle("Share Progress Wizard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Initialize components
        mainPanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("Step 1 of 4", SwingConstants.CENTER);
        stepLabel = new JLabel("Step 1: Select a workout", SwingConstants.CENTER);
        nextButton = new JButton("Next");
        backButton = new JButton("Back");
        progressBar = new JProgressBar(0, totalSteps);
        inputField = new JTextField(20);
        ListOfWorkouts = new JComboBox<>();

        populateWorkoutDropdown();

        // Set initial progress
        progressBar.setValue(currentStep);

        // Top panel for title and description
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(titleLabel);
        topPanel.add(stepLabel);

        // Center panel (content changes per step)
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(ListOfWorkouts, BorderLayout.CENTER); // Start with dropdown

        // Bottom panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);

        // Add everything to main panel
        JPanel middleContainer = new JPanel(new BorderLayout());
        middleContainer.add(topPanel, BorderLayout.NORTH);
        middleContainer.add(centerPanel, BorderLayout.CENTER);

        mainPanel.add(progressBar, BorderLayout.NORTH);
        mainPanel.add(middleContainer, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Button logic
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep > 1) {
                    currentStep--;
                    updateStep();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep == 1) {
                    String selected = (String) ListOfWorkouts.getSelectedItem();
                    if (selected == null || selected.isBlank()) {
                        JOptionPane.showMessageDialog(mainPanel, "Please select a workout before continuing.");
                        return;
                    } else {
                        selectedWorkoutName = selected;
                        JOptionPane.showMessageDialog(mainPanel, "Workout \"" + selectedWorkoutName + "\" selected.");
                    }
                }

                if ((currentStep == 2 || currentStep == 3) && inputField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter text before continuing.");
                    return;
                }

                if (currentStep < totalSteps) {
                    currentStep++;
                    updateStep();
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "You selected workout: \"" + selectedWorkoutName + "\".\nPost shared!");
                }
            }
        });

        backButton.setEnabled(false);
        add(mainPanel);
    }

    private void updateStep() {
        titleLabel.setText("Step " + currentStep + " of " + totalSteps);
        centerPanel.removeAll();

        switch (currentStep) {
            case 1:
                stepLabel.setText("Step 1: Select a workout");
                centerPanel.add(ListOfWorkouts, BorderLayout.CENTER);
                break;
            case 2:
                stepLabel.setText("Step 2: Enter a caption");
                inputField.setText("");
                inputField.setEditable(true);
                centerPanel.add(inputField, BorderLayout.CENTER);
                break;
            case 3:
                stepLabel.setText("Step 3: Add more details");
                inputField.setText("");
                inputField.setEditable(true);
                centerPanel.add(inputField, BorderLayout.CENTER);
                break;
            case 4:
                stepLabel.setText("Step 4: Confirm your selection");
                inputField.setText("You selected workout: \"" + selectedWorkoutName + "\"");
                inputField.setEditable(false);
                centerPanel.add(inputField, BorderLayout.CENTER);
                break;
        }

        centerPanel.revalidate();
        centerPanel.repaint();

        progressBar.setValue(currentStep);
        backButton.setEnabled(currentStep > 1);
        nextButton.setText(currentStep < totalSteps ? "Next" : "Finish");
    }

    private void populateWorkoutDropdown() {
        try {
            TrackProgressController trackController = new TrackProgressController(user);
            List<WorkoutEntry> workouts = trackController.getSessions();
            ListOfWorkouts.removeAllItems();
            ListOfWorkouts.addItem(""); // Placeholder

            for (WorkoutEntry w : workouts) {
                ListOfWorkouts.addItem(w.getWorkoutName());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load workouts.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            User dummyUser = new User();
            dummyUser.setUserID("1"); // Set to a valid user ID in your DB
            ShareProgressWizardPattern wizard = new ShareProgressWizardPattern(dummyUser);
            wizard.setVisible(true);
        });
    }
}
