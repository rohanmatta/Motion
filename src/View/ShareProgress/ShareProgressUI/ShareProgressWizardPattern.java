package View.ShareProgress.ShareProgressUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShareProgressWizardPattern extends JFrame {
    private JPanel mainPanel;
    private JLabel stepLabel;
    private JButton nextButton;
    private JButton backButton;
    private JProgressBar progressBar;

    private int currentStep = 1;
    private final int totalSteps = 4;

    public ShareProgressWizardPattern() {
        setTitle("Share Progress Wizard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Initialize components
        mainPanel = new JPanel(new BorderLayout());
        stepLabel = new JLabel("Step 1: Enter post content", SwingConstants.CENTER);
        nextButton = new JButton("Next");
        backButton = new JButton("Back");
        progressBar = new JProgressBar(0, totalSteps);

        // Set initial progress
        progressBar.setValue(currentStep);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);

        // Add components to main panel
        mainPanel.add(stepLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(progressBar, BorderLayout.NORTH);

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
        switch (currentStep) {
            case 1:
                stepLabel.setText("Step 1: Enter post content");
                break;
            case 2:
                stepLabel.setText("Step 2: Add captions or hashtags");
                break;
            case 3:
                stepLabel.setText("Step 3: Review the post");
                break;
            case 4:
                stepLabel.setText("Step 4: Confirm and share the post");
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