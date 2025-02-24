package ShareProgress.Model;

import java.time.LocalDateTime;

public class Post {

    private String postId;
    private String postContent;
    private String platform; // instagram, twitter, etc.
    private LocalDateTime postTime; // store the time the post was shared at
    private String caption; // post caption
    // maybe add hashtags later


    public Post(String postId, String postContent, String platform, LocalDateTime postTime, String caption) {
        this.postId = postId;
        this.postContent = postContent;
        this.platform = platform;
        this.postTime = postTime;
        this.caption = caption;
    }


    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postContent='" + postContent + '\'' +
                ", platform='" + platform + '\'' +
                ", postTime=" + postTime +
                ", caption='" + caption + '\'' +
                '}';
    }
}
