package Controller;

import Model.DB.DBError;
import Model.Login.Role;
import Model.Login.User;
import Model.Support.Message;
import Model.Support.Status;
import Model.Support.SupportUser;
import Model.Support.Ticket;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main controller for ticketing support system
 *
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
            PreparedStatement stmt = conn.prepareStatement("""
                    SELECT
                        T.ticket_id, T.subject, T.status, su.user_name, su.user_id, u.user_name, u.user_id
                    FROM
                        tickets AS T
                        LEFT JOIN users su
                            ON T.support_user = su.user_id
                        LEFT JOIN users u
                            ON T.user = u.user_id
                    """);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket.TicketBuilder builder = new Ticket.TicketBuilder();
                SupportUser supportUser = null;
                if (rs.getString("su.user_name") != null) {
                    supportUser = new SupportUser();
                    supportUser.setUserID(String.valueOf(rs.getLong("su.user_id")));
                    supportUser.setUserName(rs.getString("su.user_name"));
                }

                User user = null;
                if (rs.getString("u.user_name") != null) {
                    user = new User();
                    user.setUserID(rs.getString("u.user_id"));
                    user.setUserName(rs.getString("u.user_name"));
                }
                Status status = Status.valueOf(rs.getString("T.status"));
                builder
                        .setTicketId(rs.getLong("T.ticket_id"))
                        .setSupportUser(supportUser)
                        .setUser(user)
                        .setSubject(rs.getString("T.subject"))
                        .setStatus(status)
                        .setMessages(new ArrayList<>());
                Ticket ticket = builder.build();
                if (this.activeUser.checkUserRole(Role.ADMIN) ||
                    (this.activeUser.checkUserRole(Role.SUPPORT_USER) && supportUser == null) ||
                    (user != null && user.getUserID().equals(activeUser.getUserID())) ||
                    (supportUser != null && supportUser.getUserID().equals(activeUser.getUserID()))) {
                    if (status == Status.ACTIVE) {
                        this.tickets.add(ticket);
                    } else if (status == Status.ARCHIVED) {
                        this.archive.add(ticket);
                    }
                }
            }
            System.out.println(this.activeTicket);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBError("Error getting tickets, please try again");
        }
    }

    public void updateTicketMessages(Ticket t) throws DBError {
        DbController dbController = new DbController();
        Connection conn = dbController.getConn();
        List<Message> messages = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("""
                     SELECT
                         u.user_id,
                         u.user_name,
                         m.message_content,
                         m.message_id
                     FROM
                         messages AS m
                         LEFT JOIN users u
                             ON m.user_id = u.user_id
                     WHERE ticket_id = ?
                     ORDER BY sent_at
                    """);
            stmt.setLong(1, t.getTicketId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = null;
                if (rs.getString("u.user_id") != null) {
                    user = new User();
                    user.setUserID(rs.getString("u.user_id"));
                    user.setUserName(rs.getString("u.user_name"));
                }
                Message m = new Message(rs.getString("message_content"), user);
                m.setId(rs.getLong("message_id"));
                messages.add(m);
            }
            t.setMessages(messages);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createTicket(Ticket t, SupportUser su) throws DBError {
        DbController dbController = new DbController();
        Connection conn = dbController.getConn();
        try {
            PreparedStatement stmt = conn.prepareStatement("""
                    INSERT INTO tickets
                        (subject, user, support_user)
                    VALUES (?, ?, ?)""", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, t.getSubject());
            stmt.setLong(2, Long.parseLong(t.getUser().getUserID()));
            if (su != null) {
                stmt.setString(3, su.getUserName());
            } else {
                stmt.setNull(3, Types.NULL);
            }
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                long id = rs.getLong(1);
                activeTicket = t;
                t.setTicketId(id);
            } else {
                throw new DBError("Error creating ticket");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBError("Error creating ticket, please try again");
        }
    }

    public void archiveTicket(Ticket t) throws DBError {
        DbController dbController = new DbController();
        Connection conn = dbController.getConn();
        try {
            PreparedStatement s = conn.prepareStatement("""
                    UPDATE tickets AS t SET t.status = ? WHERE t.ticket_id = ?
                    """);
            s.setString(1, Status.ARCHIVED.toString());
            s.setLong(2, t.getTicketId());
            s.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBError("Error archiving ticket, please try again");
        }
        tickets.remove(t);
        archive.add(t);
    }

    /**
     * Getter for tickets
     *
     * @return List of all tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Adds ticket to active list
     *
     * @param ticket ticket to insert
     */
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    /**
     * Creates a new ticket for a user
     *
     * @param user        User to add to ticket
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
     *
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
     *
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
     *
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
            CallableStatement stmt = conn.prepareCall("INSERT INTO messages (ticket_id, message_content, user_id) VALUES(?,?,?)");
            stmt.setLong(1, activeTicket.getTicketId());
            stmt.setString(2, message.getText());
            stmt.setLong(3, Long.parseLong(message.getUser().getUserID()));
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.activeTicket.addMessage(message);
    }

    public void claimActive() {
        try {
            DbController dbController = new DbController();
            Connection conn = dbController.getConn();
            PreparedStatement stmt = conn.prepareStatement("""
                    UPDATE tickets
                    SET support_user = ?
                    WHERE ticket_id = ?
                    """);
            stmt.setLong(1, Long.parseLong(activeUser.getUserID()));
            stmt.setLong(2, activeTicket.getTicketId());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
