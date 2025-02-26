package View.Support;

import Controller.TicketController;
import Model.Login.User;
import Model.Support.Message;
import Model.Support.SupportUser;
import Model.Support.Ticket;

public class TicketView {
    private TicketController controller;
    private Ticket ticket;

    public TicketView(TicketController controller) {
        this.controller = controller;
    }

    public void newTicket(String initialMessage, User user, SupportUser supportUser) {
        Ticket ticket1 = new Ticket(user, supportUser);
        ticket1.addMessage(new Message(initialMessage));
        controller.addTicket(ticket1);
        ticket = ticket1;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void closeTicket() {
        ticket = null;
    }
}
