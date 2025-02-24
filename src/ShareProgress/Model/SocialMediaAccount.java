package ShareProgress.Model;

import java.util.List;

public class SocialMediaAccount {

    private String accountId;
    private String platform;
    private String username;
    private String password;
    private List<Post> posts;

    public SocialMediaAccount(String accountId, String platform, String username, String password, List<Post> posts) {
        this.accountId = accountId;
        this.platform = platform;
        this.username = username;
        this.password = password;
        this.posts = posts;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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
