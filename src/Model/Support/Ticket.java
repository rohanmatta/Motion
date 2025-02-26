package Model.Support;

import Model.Login.User;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private List<Message> messages;
    private User user;
    private SupportUser supportUser;

    public Ticket(User user, SupportUser supportUser) {
        this.user = user;
        this.supportUser = supportUser;
        this.messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Message> addMessage(Message message) {
        this.messages.add(message);
        return this.messages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SupportUser getSupportUser() {
        return supportUser;
    }

    public void setSupportUser(SupportUser supportUser) {
        this.supportUser = supportUser;
    }
}
