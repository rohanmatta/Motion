package Model.WarmupAndRecovery;

import Model.Login.Role;
import Model.Login.User;

import java.util.HashSet;
import java.util.List;

public class Admin extends User {
    public Admin(String userID, String userName, String userEmail, String userPassword) {
        super(userID, userName, userEmail, userPassword, new HashSet<>(List.of(Role.USER, Role.ADMIN)));
    }
}
