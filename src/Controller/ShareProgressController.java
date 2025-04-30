package Controller;

import Model.Login.User;
import View.ShareProgress.ShareProgressUI.ShareProgressWizardPattern;
import View.ShareProgress.ShareProgressView;

/**
 * Controller class responsible for managing the sharing of user progress.
 */
public class ShareProgressController {

    private LoginController userLogin;
    private ShareProgressView userProgress;
    private ShareProgressWizardPattern wizard;

    /**
     * Constructs a new {@code ShareProgressController} with default instances
     * of {@link LoginController}, {@link ShareProgressView}, and initializes the wizard.
     */
    public ShareProgressController() {
        this.userLogin = new LoginController();
        this.userProgress = new ShareProgressView();

        // Get the logged-in user from LoginController
        User loggedInUser = userLogin.getUser(); // ✅ make sure this returns a valid User

        this.wizard = new ShareProgressWizardPattern(loggedInUser); // ✅ pass user
    }

    /**
     * Displays the ShareProgressWizardPattern.
     */
    public void showWizard() {
        wizard.setVisible(true);
    }

    // Getters and setters (unchanged)
    public LoginController getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(LoginController userLogin) {
        this.userLogin = userLogin;
    }

    public ShareProgressView getUserProgress() {
        return userProgress;
    }

    public void setUserProgress(ShareProgressView userProgress) {
        this.userProgress = userProgress;
    }
}
