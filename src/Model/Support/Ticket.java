package Model.Support;

import Model.Login.User;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private List<Message> messages;
    private User user;
    private List<SupportUser> supportUsers;

    /**
     * Ticket constructor with single support user
     * @param user user requesting support
     * @param supportUser support user
     */
    public Ticket(User user, SupportUser supportUser) {
        this.user = user;
        this.supportUsers = List.of(supportUser);
        this.messages = new ArrayList<>();
    }

    /**
     * Ticket constructor with multiple support users
     * @param user user requesting support
     * @param supportUsers support users
     */
    public Ticket(User user, List<SupportUser> supportUsers) {
        this.user = user;
        this.supportUsers = supportUsers;
        this.messages = new ArrayList<>();
    }

    /**
     * Get all messages in ticket
     * @return List of messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Add new message to conversation
     * @param message message to add
     * @return new list of all messages
     */
    public List<Message> addMessage(Message message) {
        this.messages.add(message);
        return this.messages;
    }

    /**
     * Get user requesting support
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set user requesting support
     * @param user new user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get all support staff attached to ticket
     * @return list of support users
     */
    public List<SupportUser> getSupportUsers() {
        return supportUsers;
    }

    /**
     * Update list of support users
     * @param supportUsers new list
     */
    public void setSupportUsers(List<SupportUser> supportUsers) {
        this.supportUsers = supportUsers;
    }

    /**
     * String representation of ticket
     * @return string
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "messages=" + messages +
                ", user=" + user +
                ", supportUsers=" + supportUsers +
                '}';
    }
}
