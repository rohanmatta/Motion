package Model.Support;

import Model.Login.User;

/**
 * Support ticket messages
 * @author Ryan
 */
public class Message {
    private String text;
    private File file;
    private User user;

    /**
     * Message constructor with file
     * @param text message text
     * @param file message file
     * @param user message user
     */
    public Message(String text, File file, User user) {
        this.text = text;
        this.file = file;
        this.user = user;
    }

    /**
     * Message constructor text only
     * @param text message text
     * @param user message user
     */
    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

    /**
     * Get message text
     * @return message text
     */
    public String getText() {
        return text;
    }

    /**
     * Set message text
     * @param text message text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get message attached file
     * @return File or null
     */
    public File getFile() {
        return file;
    }

    /**
     * Set message file
     * @param file Uploaded file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Generic toString representation of message
     * @return String message
     */
    @Override
    public String toString() {
        String ret = user.getUserName() + ": " + text;
        if (file != null) {
            ret += "\nAttached File: " + file.getFileName();
        }
        return ret;
    }

    /**
     * Get message user
     * @return User or null
     */
    public User getUser() {
        return user;
    }

    /**
     * Set message user
     * @param user User or Support User that sent the message
     */
    public void setUser(User user) {
        this.user = user;
    }
}
