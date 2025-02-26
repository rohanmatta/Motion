package View.ShareProgress;

import Model.Login.User;
import Model.ShareProgress.Workout;
import Model.ShareProgress.SocialMediaAccount;
import Model.ShareProgress.Post;

public class ShareProgressView {

    public void displayUserProgress(User user) {
        System.out.println("=== User Progress ===");
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getUserEmail());
        if (user.getWorkoutData() != null && !user.getWorkoutData().isEmpty()) {
            for (Workout workout : user.getWorkoutData()) {
                System.out.println(workout.toString());
            }
        } else {
            System.out.println("No workout data available.");
        }
        System.out.println("=====================");
    }

    public void displaySocialMediaPosts(SocialMediaAccount account) {
        System.out.println("=== Social Media Posts ===");
        System.out.println(account.getActivitySummary());
        if (account.getPosts() != null && !account.getPosts().isEmpty()) {
            for (Post post : account.getPosts()) {
                System.out.println(post.getSummary());
            }
        } else {
            System.out.println("No posts available.");
        }
        System.out.println("==========================");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayUserInfo(User user) {
        System.out.println("=== User Information ===");
        System.out.println("User ID: " + user.getUserID());
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getUserEmail());
        System.out.println("========================");
    }
}
