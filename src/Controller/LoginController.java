package Controller;

import View.Login.LoginView;

/**
 * Controller class responsible for managing the login view.
 */
public class LoginController {

    private LoginView loginViewFrame;

    /**
     * Constructs a new {@code LoginController} with a default {@link LoginView} instance.
     */
    public LoginController() {
        this.loginViewFrame = new LoginView("", "");
    }

    /**
     * Retrieves the current {@link LoginView} instance.
     *
     * @return The current login view frame.
     */
    public LoginView getLoginFrame() {
        return loginViewFrame;
    }

    /**
     * Sets the {@link LoginView} instance.
     *
     * @param loginViewFrame The new login view frame to be set.
     */
    public void setLoginFrame(LoginView loginViewFrame) {
        this.loginViewFrame = loginViewFrame;
    }
}
