package Controller;

import Model.Login.User;
import Model.Support.Message;
import Model.Support.SupportUser;
import Model.Support.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketController {
    private List<Ticket> tickets;
    private List<Ticket> archive;

    public TicketController() {
        this.tickets = new ArrayList<>();
        this.archive = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Ticket createTicket(User user, SupportUser supportUser) {
        Ticket ticket = new Ticket(user, supportUser);
        addTicket(ticket);
        return ticket;
    }

    public Ticket getTicket(User user) {
        for (Ticket ticket : tickets) {
            if (ticket.getUser().equals(user)) {
                return ticket;
            }
        }
        return null;
    }

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
}
