package Controller;

import Model.Login.User;
import Model.Support.Message;
import Model.Support.SupportUser;
import Model.Support.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 */
public class TicketController {
    private final List<Ticket> tickets;
    private final List<Ticket> archive;

    /**
     * Generic Ticket controller constructor
     * Initializes empty controller at the moment
     * Will be updated to sync with DB or File
     */
    public TicketController() {
        this.tickets = new ArrayList<>();
        this.archive = new ArrayList<>();
    }

    /**
     * Getter for tickets
     * @return List of all tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Adds ticket to active list
     * @param ticket ticket to insert
     */
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    /**
     * Creates a new ticket for a user
     * @param user User to add to ticket
     * @param supportUser Support User for ticket
     * @return Created Ticket
     */
    public Ticket createTicket(User user, SupportUser supportUser) {
        Ticket ticket = new Ticket(user, supportUser);
        addTicket(ticket);
        return ticket;
    }

    /**
     * Get a user's active support ticket
     * @param user User to search for
     * @return User's active ticket or null
     */
    public Ticket getTicket(User user) {
        for (Ticket ticket : tickets) {
            if (ticket.getUser().equals(user)) {
                return ticket;
            }
        }
        return null;
    }

    /**
     * Deletes User's active ticket and archives it
     * @param user User to search for
     * @return Deleted ticket
     */
    public Ticket deleteTicket(User user) {
        for (Ticket ticket : tickets) {
            if (ticket.getUser().equals(user)) {
                tickets.remove(ticket);
                archive.add(ticket);
                return ticket;
            }
        }
        return null;
    }

    /**
     * Get all archived tickets
     * @return List of all archived tickets
     */
    public List<Ticket> getArchive() {
        return archive;
    }
}
