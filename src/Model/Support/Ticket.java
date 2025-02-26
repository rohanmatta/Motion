package Model.Support;

import Model.Login.User;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private List<Message> messages;
    private User user;
    private List<SupportUser> supportUsers;

    public Ticket(User user, SupportUser supportUser) {
        this.user = user;
        this.supportUsers = List.of(supportUser);
        this.messages = new ArrayList<>();
    }

    public Ticket(User user, List<SupportUser> supportUser) {
        this.user = user;
        this.supportUsers = supportUser;
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

    public List<SupportUser> getSupportUsers() {
        return supportUsers;
    }

    public void setSupportUsers(List<SupportUser> supportUsers) {
        this.supportUsers = supportUsers;
    }
}
