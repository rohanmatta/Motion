package View.Support;

import Controller.TicketController;
import Model.DB.DBError;
import Model.Login.Role;
import Model.Support.Message;
import Model.Support.Status;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SupportTicketView extends JFrame {
    private final TicketController controller;
    private JPanel outer;
    private JTextArea chatTextArea;
    private JButton sendButton;
    private JPanel chatPane;
    private JButton backButton;
    private JPanel topPanel;
    private JButton claimTicketButton;
    private JLabel chatLabel;
    private JButton closeTicketButton;
    private JPanel inputPanel;
    ScheduledExecutorService svc;


    public SupportTicketView(TicketController ticketController) {
        this.controller = ticketController;
        this.add(outer);
        this.setTitle("Support ticket: " + controller.getActiveTicket().getSubject());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1000);
        addActionListeners();

        if (!controller.getActiveUser().checkUserRole(Role.SUPPORT_USER) ||
            controller.getActiveTicket().getSupportUser() != null) {
            System.out.println("Removing claim btn");
            System.out.println(controller.getActiveTicket().getSupportUser());
            System.out.println("User has support role = " + controller.getActiveUser().checkUserRole(Role.SUPPORT_USER));
            topPanel.remove(claimTicketButton);
        }

        if (controller.getActiveTicket().getStatus().equals(Status.ARCHIVED)) {
            this.chatTextArea.setEnabled(false);
            this.sendButton.setEnabled(false);
            this.inputPanel.remove(closeTicketButton);
            this.setTitle("Support ticket: " + controller.getActiveTicket().getSubject() + " - Archived");
        } else {
            svc = Executors.newSingleThreadScheduledExecutor();
            svc.scheduleAtFixedRate(() -> {
                try {
                    fetchMessages();
                    SwingUtilities.invokeLater(this::updateMessages);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SupportTicketView.this, "Failed to fetch messages in background: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }, 0, 5, TimeUnit.SECONDS);
        }

        this.setVisible(true);
    }

    private void updateMessages() {
        chatPane.removeAll();
        chatPane.setLayout(new BoxLayout(chatPane, BoxLayout.Y_AXIS));
//        chatPane.setMaximumSize(new Dimension(this.getWidth()-5, Integer.MAX_VALUE));
        for (Message m : this.controller.getActiveTicket().getMessages()) {
            JPanel wrapper = createChatWrapper(m);
            chatPane.add(wrapper);
        }
        chatPane.revalidate();
        chatPane.repaint();
    }

    private void fetchMessages() {
        try {
            controller.updateTicketMessages(controller.getActiveTicket());
        } catch (DBError e) {

            JOptionPane.showMessageDialog(this, "Error getting ticket messages: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createChatWrapper(Message m) {
        JPanel wrapper = new JPanel(
                new FlowLayout(m.getUser().getUserID().equals(this.controller.getActiveUser().getUserID()) ?
                        FlowLayout.RIGHT :
                        FlowLayout.LEFT)
        );
        wrapper.setAlignmentX(Component.LEFT_ALIGNMENT);
        wrapper.setAlignmentY(Component.TOP_ALIGNMENT);
        wrapper.setOpaque(false);

        JLabel text = new JLabel();
        text.setText(m.getUser().getUserName() + ": " + m.getText());
        text.setVisible(true);

        wrapper.add(text);

        Dimension preferredSize = wrapper.getPreferredSize();
        wrapper.setMaximumSize(new Dimension(this.getWidth() - 5, preferredSize.height));
        return wrapper;
    }

    private void addActionListeners() {
        sendButton.addActionListener((e) -> {
            controller.addMessage(new Message(chatTextArea.getText(), controller.getActiveUser()));
            chatTextArea.setText("");
            updateMessages();
        });
        backButton.addActionListener((e) -> {
            svc.shutdownNow();
            this.dispose();
            new TicketListView(this.controller);
        });
        claimTicketButton.addActionListener((e) -> {
            controller.claimActive();
            this.topPanel.remove(claimTicketButton);
            JOptionPane.showMessageDialog(SupportTicketView.this, "Ticket Claimed", "Claim Ticket", JOptionPane.INFORMATION_MESSAGE);
        });
        closeTicketButton.addActionListener((e) -> {
            svc.shutdownNow();
            try {
                this.controller.archiveTicket(this.controller.getActiveTicket());
                JOptionPane.showMessageDialog(SupportTicketView.this, "Ticket Archived", "Archive Ticket", JOptionPane.INFORMATION_MESSAGE);
            } catch (DBError ex) {
                JOptionPane.showMessageDialog(SupportTicketView.this, "Error archiving ticket: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    class RefreshWorker extends SwingWorker<Void, Void> {
        protected Void doInBackground() {
            fetchMessages();
            return null;
        }

        protected void done() {
            updateMessages();
        }
    }
}
