package View.Login;

/**
 * Represents the view for user login, containing username and password.
 */
public class LoginView {

    private String username;
    private String password;

    /**
     * Constructs a new {@code LoginView} instance with the specified username and password.
     *
     * @param username The username for the login view.
     * @param password The password for the login view.
     */
    public LoginView(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieves the username associated with this login view.
     *
     * @return The username for the login view.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for this login view.
     *
     * @param username The new username to be assigned.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password associated with this login view.
     *
     * @return The password for the login view.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for this login view.
     *
     * @param password The new password to be assigned.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
