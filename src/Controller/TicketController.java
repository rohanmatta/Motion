package Controller;

import Model.DB.DBError;
import Model.Login.Role;
import Model.Login.User;
import Model.Support.Message;
import Model.Support.Status;
import Model.Support.SupportUser;
import Model.Support.Ticket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Main controller for ticketing support system
 * @author Ryan
 */
public class TicketController {
    private final List<Ticket> tickets;
    private final List<Ticket> archive;
    private Ticket activeTicket;
    private User activeUser;

    /**
     * Generic Ticket controller constructor
     * Initializes empty controller at the moment
     * Will be updated to sync with DB or File
     */
    public TicketController(User activeUser) throws DBError {
        this.tickets = new ArrayList<>();
        this.archive = new ArrayList<>();
        try {
            this.activeUser = activeUser;
            DbController dbController = new DbController();
            Connection conn = dbController.getConn();
            PreparedStatement stmt = conn.prepareStatement("select T.ticket_id, T.subject, T.status, su.user_name, su.user_id, u.user_name, u.user_id from tickets AS T left join users su on T.support_user = su.user_id left join users u on T.user = u.user_id");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket.TicketBuilder builder = new Ticket.TicketBuilder();
                SupportUser supportUser = new SupportUser();
                supportUser.setUserID(String.valueOf(rs.getLong("su.user_id")));
                supportUser.setUserName(rs.getString("su.user_name"));
                User user = new User();
                user.setUserID(rs.getString("u.user_id"));
                user.setUserName(rs.getString("u.user_name"));
                builder.setTicketId(rs.getLong("T.ticket_id")).setSupportUser(supportUser).setUser(user).setSubject(rs.getString("T.subject")).setMessages(new ArrayList<>());
                Status status = Status.valueOf(rs.getString("T.status"));
                Ticket ticket = builder.build();
                if (this.activeUser.checkUserRole(Role.ADMIN) || user.getUserID().equals(activeUser.getUserID()) || supportUser.getUserID().equals(activeUser.getUserID())) {
                    if (status == Status.ACTIVE) {
                        this.tickets.add(ticket);
                    } else if (status == Status.ARCHIVED) {
                        this.archive.add(ticket);
                    }
                    stmt = conn.prepareStatement("select u.user_id, u.user_name, m.message_content, m.message_id from messages AS m left join users u on m.user_id = u.user_id where ticket_id = ? order by sent_at");
                    stmt.setLong(1, ticket.getTicketId());
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        user = new User();
                        user.setUserID(rs.getString("u.user_id"));
                        user.setUserName(rs.getString("u.user_name"));
                        Message m = new Message(rs.getString("message_content"), user);
                        m.setId(rs.getLong("message_id"));
                        ticket.addMessage(m);
                    }
                }
            }
            System.out.println(this.activeTicket);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBError("Error getting tickets, please try again");
        }
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
        Ticket ticket = new Ticket.TicketBuilder().setSupportUser(supportUser).setUser(user).setMessages(new ArrayList<>()).build();
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

    public Ticket getActiveTicket() {
        return activeTicket;
    }

    public void setActiveTicket(Ticket activeTicket) {
        this.activeTicket = activeTicket;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public void addMessage(Message message) {
        try {
            DbController dbController = new DbController();
            Connection conn = dbController.getConn();
            CallableStatement stmt = conn.prepareCall("insert into messages (ticket_id, message_content, user_id) values(?,?,?)");
            stmt.setLong(1, activeTicket.getTicketId());
            stmt.setString(2, message.getText());
            stmt.setLong(3, Long.parseLong(message.getUser().getUserID()));
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.activeTicket.addMessage(message);
    }
}
