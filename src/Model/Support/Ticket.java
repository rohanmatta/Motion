package Model.Support;

import Controller.DbController;
import Model.Login.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Support ticket
 * @author Ryan
 */
public class Ticket {
    private long ticketId;
    private List<Message> messages;
    private User user;
    private SupportUser supportUser;

    /**
     * Ticket constructor
     */
    private Ticket() {
    }

    public static class TicketBuilder {
        private long ticketId;
        private List<Message> messages = new ArrayList<>();
        private User user;
        private SupportUser supportUser;

        public TicketBuilder setTicketId(long ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public TicketBuilder addMessage(Message message) {
            this.messages.add(message);
            return this;
        }

        public TicketBuilder setMessages(List<Message> messages) {
            this.messages = new ArrayList<>(messages);
            return this;
        }

        public TicketBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public TicketBuilder setSupportUser(SupportUser supportUser) {
            this.supportUser = supportUser;
            return this;
        }

        public Ticket build() {
            Ticket ticket = new Ticket();
            ticket.messages = this.messages;
            ticket.user = this.user;
            ticket.supportUser = this.supportUser;
            ticket.ticketId = this.ticketId;
            return ticket;
        }
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
    public SupportUser getSupportUser() {
        return supportUser;
    }

    /**
     * Update list of support users
     * @param supportUser new list
     */
    public void setSupportUser(SupportUser supportUser) {
        this.supportUser = supportUser;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
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
                ", supportUser=" + supportUser +
                ", id=" + ticketId +
                '}';
    }
}
