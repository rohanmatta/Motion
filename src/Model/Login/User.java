package Model.Login;

import java.util.List;

/**
 * Model class representing a user in the system.
 */
public class User {

    private String userID;
    private String userName;
    private String userEmail;
    private String userPassword;
    private long userRole = Role.USER.getValue();

    /**
     * Retrieves the user ID.
     *
     * @return The unique identifier of the user.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the user ID.
     *
     * @param userID The unique identifier to be assigned to the user.
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the user's name.
     *
     * @return The name of the user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user's name.
     *
     * @param userName The name to be assigned to the user.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retrieves the user's email address.
     *
     * @return The email address of the user.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the user's email address.
     *
     * @param userEmail The email address to be assigned to the user.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getUserRole() {
        return userRole;
    }

    public void setUserRole(long userRole) {
        this.userRole = userRole;
    }

    public void addUserRole(Role role) {
        this.userRole = this.userRole + role.getValue();
    }

    public void removeUserRole(Role role) {
        this.userRole = this.userRole - role.getValue();
    }

    public boolean checkUserRole(Role role) {
        return (this.userRole & role.getValue()) == role.getValue() || (this.userRole & Role.ADMIN.getValue()) == role.getValue();
    }

    /**
     * Returns a string representation of the user object.
     *
     * @return A formatted string containing user details.
     */
    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
