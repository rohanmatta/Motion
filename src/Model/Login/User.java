package Model.Login;

import Model.ShareProgress.Workout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private String userID;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Set<Role> roles;
    private List<Workout> workoutData;

    public User(String userID, String userName, String userEmail, String userPassword, List<Workout> workoutData) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.workoutData = workoutData;
        this.roles = new HashSet<>(List.of(Role.USER));
    }

    public User(String userID, String userName, String userEmail, String userPassword, Set<Role> roles) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.roles = roles;
        this.workoutData = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Workout> getWorkoutData() {
        return workoutData;
    }

    public void setWorkoutData(List<Workout> workoutData) {
        this.workoutData = workoutData;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) { this.roles.add(role); }

    public boolean hasAccess(Role permission) { return this.roles.contains(permission); }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", workoutData=" + workoutData +
                '}';
    }
}
