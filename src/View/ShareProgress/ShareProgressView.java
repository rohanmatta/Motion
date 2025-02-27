package View.ShareProgress;

import Model.Login.User;
import Model.ShareProgress.SocialMediaAccount;
import Model.ShareProgress.Post;

/**
 * Represents the view for sharing progress, displaying user information and social media posts.
 */
public class ShareProgressView {

    /**
     * Displays the progress of a user.
     *
     * @param user The {@code User} object containing user information.
     */
    public void displayUserProgress(User user) {
        System.out.println("=== User Progress ===");
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getUserEmail());
        System.out.println("=====================");
    }

    /**
     * Displays social media posts associated with a social media account.
     *
     * @param account The {@code SocialMediaAccount} object containing social media details.
     */
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

    /**
     * Displays a message to the user.
     *
     * @param message The message to be displayed.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays detailed user information.
     *
     * @param user The {@code User} object containing user details.
     */
    public void displayUserInfo(User user) {
        System.out.println("=== User Information ===");
        System.out.println("User ID: " + user.getUserID());
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getUserEmail());
        System.out.println("========================");
    }
}
