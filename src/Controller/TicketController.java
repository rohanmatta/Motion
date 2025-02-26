package Controller;

import Model.Support.Message;
import Model.Support.Ticket;

public class TicketController {
    private Ticket ticket;

    public TicketController(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void sendMessage(String message) {
        this.getTicket().addMessage(new Message(message, null));
    }
}
