package Model.ShareProgress;

import java.util.List;

public class User {

    private String userID;
    private String userName;
    private String userEmail;
    private List<Workout> workoutData;

    public User(String userID, String userName, String userEmail, List<Workout> workoutData) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.workoutData = workoutData;
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
