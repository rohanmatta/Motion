package View.ShareProgress.ShareProgressUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShareProgressWizardPattern extends JFrame {
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
    private int selectedWorkout = 1;

    public ShareProgressWizardPattern() {
        setTitle("Share Progress Wizard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Initialize components
        mainPanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("Step 1 of 4", SwingConstants.CENTER);
        stepLabel = new JLabel("Step 1: Select a workout (1–5)", SwingConstants.CENTER);
        nextButton = new JButton("Next");
        backButton = new JButton("Back");
        progressBar = new JProgressBar(0, totalSteps);
        inputField = new JTextField(20);
        ListOfWorkouts = new JComboBox<>();

        // Fill dropdown with workouts 1–5
        for (int i = 1; i <= 5; i++) {
            ListOfWorkouts.addItem(String.valueOf(i));
        }

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
        mainPanel.add(progressBar, BorderLayout.NORTH);
        JPanel middleContainer = new JPanel(new BorderLayout());
        middleContainer.add(topPanel, BorderLayout.NORTH);
        middleContainer.add(centerPanel, BorderLayout.CENTER);

        mainPanel.add(progressBar, BorderLayout.NORTH);
        mainPanel.add(middleContainer, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(buttonPanel, BorderLayout.PAGE_END);

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
                if (currentStep < totalSteps) {
                    currentStep++;
                    updateStep();
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "You selected workout #" + selectedWorkout + ".\nPost shared!");
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
                stepLabel.setText("Step 1: Select a workout (1–5)");
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
                String selected = (String) ListOfWorkouts.getSelectedItem();
                selectedWorkout = selected != null ? Integer.parseInt(selected) : 1;
                inputField.setText("You selected workout #" + selectedWorkout);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShareProgressWizardPattern wizard = new ShareProgressWizardPattern();
            wizard.setVisible(true);
        });
    }
}
