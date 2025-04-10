package Controller;

import View.Login.LoginViewOld;

/**
 * Controller class responsible for managing the login view.
 */
public class LoginController {

    private LoginViewOld loginViewFrame;

    /**
     * Constructs a new {@code LoginController} with a default {@link LoginViewOld} instance.
     */
    public LoginController() {
        this.loginViewFrame = new LoginViewOld("", "");
    }

    /**
     * Retrieves the current {@link LoginViewOld} instance.
     *
     * @return The current login view frame.
     */
    public LoginViewOld getLoginFrame() {
        return loginViewFrame;
    }

    /**
     * Sets the {@link LoginViewOld} instance.
     *
     * @param loginViewFrame The new login view frame to be set.
     */
    public void setLoginFrame(LoginViewOld loginViewFrame) {
        this.loginViewFrame = loginViewFrame;
    }
}
