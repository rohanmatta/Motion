package Model.Support;

/**
 * @author Ryan
 */
public class Message {
    private String text;
    private File file;

    /**
     * Message constructor with file
     * @param text message text
     * @param file message file
     */
    public Message(String text, File file) {
        this.text = text;
        this.file = file;
    }

    /**
     * Message constructor text only
     * @param text message text
     */
    public Message(String text) {
        this.text = text;
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
        return "Message{" +
                "text='" + text + '\'' +
                ", file=" + file +
                '}';
    }
}
