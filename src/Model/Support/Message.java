package Model.Support;

public class Message {
    private String text;
    private File file;

    public Message(String text, File file) {
        this.text = text;
        this.file = file;
    }

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", file=" + file +
                '}';
    }
}
