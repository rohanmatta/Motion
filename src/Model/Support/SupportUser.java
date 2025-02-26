package Model.Support;

/**
 * @author Ryan
 */
public class SupportUser {
    private String username;
    private String password;

    /**
     * Support user constructor
     * @param username username
     * @param password password
     */
    public SupportUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Get selected username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Update username
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
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
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
