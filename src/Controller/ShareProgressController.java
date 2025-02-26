package Controller;

import View.ShareProgress.ShareProgressView;

public class ShareProgressController {

    private LoginController userLogin;
    private ShareProgressView userProgress;

    public ShareProgressController() {
        this.userLogin = new LoginController();
        this.userProgress = new ShareProgressView();
    }

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
