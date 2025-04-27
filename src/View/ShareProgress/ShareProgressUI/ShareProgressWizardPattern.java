package View.ShareProgress.ShareProgressUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShareProgressWizardPattern extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel; // Step title
    private JLabel stepLabel; // Step description
    private JButton nextButton;
    private JButton backButton;
    private JProgressBar progressBar;
    private JTextField inputField;

    private int currentStep = 1;
    private final int totalSteps = 4;

    public ShareProgressWizardPattern() {
        setTitle("Share Progress Wizard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Initialize components
        mainPanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("Step 1 of 4", SwingConstants.CENTER); // Step title
        stepLabel = new JLabel("Step 1: Select post from Track Progress", SwingConstants.CENTER);
        nextButton = new JButton("Next");
        backButton = new JButton("Back");
        progressBar = new JProgressBar(0, totalSteps);
        inputField = new JTextField(20); // Ensure the text field has a size

        // Set initial progress
        progressBar.setValue(currentStep);

        // Top panel for title and step description
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(titleLabel);
        topPanel.add(stepLabel);

        // Center panel for input field
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(inputField, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);

        // Add components to main panel
        mainPanel.add(progressBar, BorderLayout.NORTH);
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(centerPanel, BorderLayout.SOUTH);
        mainPanel.add(buttonPanel, BorderLayout.PAGE_END);

        // Add action listeners
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
                    JOptionPane.showMessageDialog(mainPanel, "You have completed the wizard!");
                }
            }
        });

        // Disable back button initially
        backButton.setEnabled(false);

        // Add main panel to frame
        add(mainPanel);
    }

    private void updateStep() {
        titleLabel.setText("Step " + currentStep + " of " + totalSteps); // Update step title
        switch (currentStep) {
            case 1:
                stepLabel.setText("Step 1: Select post from Track Progress");
                inputField.setText(""); // Clear input field
                inputField.setToolTipText("Write your post content here...");
                break;
            case 2:
                stepLabel.setText("Step 2: Add captions or hashtags");
                inputField.setText(""); // Clear input field
                inputField.setToolTipText("Add captions or hashtags...");
                break;
            case 3:
                stepLabel.setText("Step 3: Review the post");
                inputField.setText(""); // Clear input field
                inputField.setToolTipText("Review your post content...");
                break;
            case 4:
                stepLabel.setText("Step 4: Confirm and share the post");
                inputField.setText(""); // Clear input field
                inputField.setToolTipText("Confirm your post details...");
                break;
        }

        // Update progress bar
        progressBar.setValue(currentStep);

        // Enable/disable buttons
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