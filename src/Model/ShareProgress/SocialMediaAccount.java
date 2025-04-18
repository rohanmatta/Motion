package Model.ShareProgress;

import Interface.PostComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a social media account where users can publish posts.
 */
public class SocialMediaAccount implements PostComponent {
    private String accountId;
    private String platform;
    private String username;
    private String password;
    private List<Post> posts;
    private List<PostComponent> components;

    /**
     * Constructs a new {@code SocialMediaAccount} instance.
     *
     * @param accountId The unique identifier of the social media account.
     * @param platform  The platform where the account is registered.
     * @param username  The username associated with the account.
     * @param password  The password for account authentication.
     */
    public SocialMediaAccount(String accountId, String platform, String username, String password, List<Post> posts, List<PostComponent> components) {
        this.accountId = accountId;
        this.platform = platform;
        this.username = username;
        this.password = password;
        this.posts = posts;
        this.components = components;
    }

    /**
     * Publishes a new post to the account.
     *
     * @param post The {@link Post} object to be published.
     */
    public void publishPost(Post post) {
        if (post != null) {
            posts.add(post);
            System.out.println("Post published on " + platform + " by " + username);
        }
    }

    /**
     * Retrieves the list of posts published by this account.
     *
     * @return A list of {@link Post} objects.
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Generates a summary of the account's activity.
     *
     * @return A formatted string describing the number of posts.
     */
    public String getActivitySummary() {
        return "Account " + username + " on " + platform + " has " + posts.size() + " posts.";
    }

    /**
     * Returns a string representation of the social media account.
     *
     * @return A formatted string containing account details.
     */
    @Override
    public String toString() {
        return "SocialMediaAccount{" +
                "accountId='" + accountId + '\'' +
                ", platform='" + platform + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", posts=" + posts +
                '}';
    }

    // Implemented composite design pattern

    public void addComponent(PostComponent component) {
        components.add(component);
    }

    public void removeComponent(PostComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Account: " + username + " on " + platform);
        for (PostComponent component : components) {
            component.display();
        }
    }

}
