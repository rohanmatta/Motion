package ShareProgressUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShareProgressWizardPattern {
    private JPanel outerPanel;
    private JLabel stepLabel;
    private JButton backButton;
    private JButton nextButton;

    private int currentStep = 1;

    public ShareProgressWizardPattern() {
        updateStep();

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
                if (currentStep < 3) { // Assuming 3 steps in the wizard
                    currentStep++;
                    updateStep();
                }
            }
        });
    }

    private void updateStep() {
        switch (currentStep) {
            case 1:
                stepLabel.setText("Step 1: Enter post content");
                break;
            case 2:
                stepLabel.setText("Step 2: Add hashtags and captions");
                break;
            case 3:
                stepLabel.setText("Step 3: Review and confirm post");
                break;
        }
        backButton.setEnabled(currentStep > 1);
        nextButton.setEnabled(currentStep < 3);
    }

    public JPanel getOuterPanel() {
        return outerPanel;
    }
}