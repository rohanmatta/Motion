package Controller;

import View.ShareProgress.LoginView;

public class LoginController {

    private LoginView loginViewFrame;

    public LoginController() {
        this.loginViewFrame = new LoginView("", "");
    }

    public LoginView getLoginFrame() {
        return loginViewFrame;
    }

    public void setLoginFrame(LoginView loginViewFrame) {
        this.loginViewFrame = loginViewFrame;
    }
}
