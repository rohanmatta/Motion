package Model.Support;

import Model.Login.Role;
import Model.Login.User;

/**
 * Support team user
 * @author Ryan
 */
public class SupportUser extends User {
    public SupportUser() {
        super();
        this.addUserRole(Role.SUPPORT_USER);
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
