package Model.ShareProgress;

import java.time.LocalDateTime;

public class Post {
    private String postId;
    private String content;
    private String platform;
    private LocalDateTime postTime;
    private String caption;

    public Post(String postId, String content, String platform, LocalDateTime postTime, String caption) {
        this.postId = postId;
        this.content = content;
        this.platform = platform;
        this.postTime = postTime;
        this.caption = caption;
    }

    public void updateContent(String newContent) {
        this.content = newContent;
    }

    public String getSummary() {
        return "Post on " + platform + " at " + postTime + ": " + caption;
    }

    @Override
    public String toString() {
        return getSummary();
    }
}
