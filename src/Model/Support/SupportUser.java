package Model.Support;

import Model.Login.User;

/**
 * Support team user
 * @author Ryan
 */
public class SupportUser extends User {
    private String password;

    /**
     * Support user constructor
     * @param username username
     * @param password password
     */
    public SupportUser(String username, String password) {
        this.setUserName(username);
        this.password = password;
    }

    /**
     * Get user password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Update user's password
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * String representation of user
     * @return String of user
     */
    @Override
    public String toString() {
        return "SupportUser{" +
                "username='" + this.getUserName() + '\'' +
                '}';
    }
}
