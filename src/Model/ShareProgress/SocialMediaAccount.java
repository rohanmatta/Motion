package Model.ShareProgress;

import java.util.ArrayList;
import java.util.List;

public class SocialMediaAccount {
    private String accountId;
    private String platform;
    private String username;
    private String password;
    private List<Post> posts;

    public SocialMediaAccount(String accountId, String platform, String username, String password) {
        this.accountId = accountId;
        this.platform = platform;
        this.username = username;
        this.password = password;
        this.posts = new ArrayList<>();
    }

    public void publishPost(Post post) {
        if (post != null) {
            posts.add(post);
            System.out.println("Post published on " + platform + " by " + username);
        }
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getActivitySummary() {
        return "Account " + username + " on " + platform + " has " + posts.size() + " posts.";
    }

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

}
