package Model.Support;

import Model.Login.Role;
import Model.Login.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SupportUser extends User {
    public SupportUser(String userID, String userName, String userEmail, String userPassword) {
        super(userID, userName, userEmail, userPassword, new HashSet<>(List.of(Role.SUPPORT, Role.USER)));
    }
}
