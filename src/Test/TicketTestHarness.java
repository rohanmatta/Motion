package Test;

import Controller.TicketController;
import Model.Login.User;
import Model.Support.Message;
import Model.Support.SupportUser;
import Model.Support.Ticket;
import View.Support.TicketView;

public class TicketTestHarness {
    private TicketController controller;
    private User user;
    private SupportUser supportUser;
    private TicketView ticketView;

    public TicketTestHarness() {
        controller = new TicketController();
        user = new User();
        user.setUserEmail("test@test.com");
        user.setUserName("test");
        user.setUserID("test123");
        supportUser = new SupportUser("testSupport", "test");
        ticketView = new TicketView(controller);
    }

    public static void main(String[] args) {
        System.out.println("Creating ticket test");
        TicketTestHarness harness = new TicketTestHarness();
        System.out.println("Initial list of tickets");
        harness.ticketView.listTickets();
        System.out.println("Adding new ticket");
        harness.ticketView.newTicket("Support request 1", harness.user, harness.supportUser);
        System.out.println("List of tickets after adding new ticket");
        harness.ticketView.listTickets();
        Ticket ticket = harness.ticketView.getTicket();
        System.out.println("Created ticket");
        System.out.println(ticket);
        ticket.addMessage(new Message("Support request information"));
        System.out.println("Ticket with added message");
        System.out.println(ticket.getMessages());
    }
}
