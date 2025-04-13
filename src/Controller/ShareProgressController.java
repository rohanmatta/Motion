package Controller;

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
        this.wizard = new ShareProgressWizardPattern();
    }

    /**
     * Displays the ShareProgressWizardPattern.
     */
    public void showWizard() {
        wizard.setVisible(true);
    }

    /**
     * Retrieves the {@link LoginController} instance.
     *
     * @return The current {@link LoginController} instance.
     */
    public LoginController getUserLogin() {
        return userLogin;
    }

    /**
     * Sets the {@link LoginController} instance.
     *
     * @param userLogin The new {@link LoginController} instance to be set.
     */
    public void setUserLogin(LoginController userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * Retrieves the {@link ShareProgressView} instance.
     *
     * @return The current {@link ShareProgressView} instance.
     */
    public ShareProgressView getUserProgress() {
        return userProgress;
    }

    /**
     * Sets the {@link ShareProgressView} instance.
     *
     * @param userProgress The new {@link ShareProgressView} instance to be set.
     */
    public void setUserProgress(ShareProgressView userProgress) {
        this.userProgress = userProgress;
    }
}