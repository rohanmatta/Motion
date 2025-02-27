package Model.ShareProgress;

import java.time.LocalDateTime;

/**
 * Represents a social media post that can be shared on different platforms.
 */
public class Post {
    private String postId;
    private String content;
    private String platform;
    private LocalDateTime postTime;
    private String caption;

    /**
     * Constructs a new {@code Post} instance with the specified details.
     *
     * @param postId   The unique identifier of the post.
     * @param content  The main content of the post.
     * @param platform The platform where the post is shared.
     * @param postTime The timestamp of when the post was created.
     * @param caption  The caption associated with the post.
     */
    public Post(String postId, String content, String platform, LocalDateTime postTime, String caption) {
        this.postId = postId;
        this.content = content;
        this.platform = platform;
        this.postTime = postTime;
        this.caption = caption;
    }

    /**
     * Updates the content of the post.
     *
     * @param newContent The new content to be set for the post.
     */
    public void updateContent(String newContent) {
        this.content = newContent;
    }

    /**
     * Retrieves a brief summary of the post.
     *
     * @return A formatted string summarizing the post.
     */
    public String getSummary() {
        return "Post on " + platform + " at " + postTime + ": " + caption;
    }

    /**
     * Returns a string representation of the post.
     *
     * @return A summary of the post.
     */
    @Override
    public String toString() {
        return getSummary();
    }
}
