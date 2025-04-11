package View.Support;

import Controller.TicketController;
import Model.Support.Message;

import javax.swing.*;
import java.awt.*;

public class SupportTicketView extends JFrame {
    private final TicketController controller;
    private JPanel outer;
    private JTextArea chatTextArea;
    private JButton sendButton;
    private JPanel chatPane;


    public SupportTicketView(TicketController ticketController) {
        this.controller = ticketController;
        this.add(outer);
        this.setTitle("Chat");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1000);
        addActionListeners();
        updateMessages();
        this.setVisible(true);
    }

    private void updateMessages() {
        chatPane.removeAll();
        chatPane.setLayout(new BoxLayout(chatPane, BoxLayout.Y_AXIS));
        chatPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        for (Message m : this.controller.getActiveTicket().getMessages()) {
            JLabel text = new JLabel();
            text.setText(m.getUser().getUserName() + ": " + m.getText());
            text.setAlignmentX(
                    m.getUser().getUserID().equals(this.controller.getActiveUser().getUserID()) ?
                            Component.RIGHT_ALIGNMENT :
                            Component.LEFT_ALIGNMENT );
            text.setVisible(true);
            text.setMaximumSize(new Dimension(Integer.MAX_VALUE, text.getPreferredSize().height));
            chatPane.add(text);
        }
        chatPane.revalidate();
        chatPane.repaint();
    }

    private void addActionListeners() {
        sendButton.addActionListener((e) -> {
            controller.addMessage(new Message(chatTextArea.getText(), controller.getActiveUser()));
            updateMessages();
        });
    }
}
