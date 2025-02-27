package View.Support;

import Controller.TicketController;
import Model.Login.User;
import Model.Support.Message;
import Model.Support.SupportUser;
import Model.Support.Ticket;

/**
 * Main view for tickets
 * @author Ryan
 */
public class TicketView {
    private final TicketController controller;
    private Ticket ticket;

    /**
     * View constructor - Initializes controller
     * @param controller ticket controller
     */
    public TicketView(TicketController controller) {
        this.controller = controller;
    }

    /**
     * Creates a new ticket in view and controller
     * @param initialMessage Opening message from user
     * @param user User requesting ticket
     * @param supportUser Support user assigned to ticket
     */
    public void newTicket(String initialMessage, User user, SupportUser supportUser) {
        Ticket ticket1 = new Ticket(user, supportUser);
        ticket1.addMessage(new Message(initialMessage));
        controller.addTicket(ticket1);
        ticket = ticket1;
    }

    /**
     * Gets active ticket in view
     * @return Active ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Closes active ticket in view
     */
    public void closeTicket() {
        ticket = null;
    }

    /**
     * Views active ticket
     */
    public void viewTicket() {
        System.out.println("=====");
        System.out.println(ticket);
        System.out.println("=====");
    }
}
