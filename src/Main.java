import Controller.DbController;
import Controller.LoginController;
import ShareProgressUI.ShareProgressWizardPattern;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // Init login controller

        new LoginController();
        //test
//
//        // Create a JFrame to host the ShareProgressWizardPattern
//        JFrame frame = new JFrame("Share Progress Wizard");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 400);
//
//        // Create an instance of ShareProgressWizardPattern
//        ShareProgressWizardPattern wizard = new ShareProgressWizardPattern();
//
//        // Add the wizard's panel to the frame
//        frame.setContentPane(wizard.getOuterPanel());
//
//        // Make the frame visible
//        frame.setVisible(true);
    }
}