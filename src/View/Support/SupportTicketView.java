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
    private JButton backButton;


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
//        chatPane.setMaximumSize(new Dimension(this.getWidth()-5, Integer.MAX_VALUE));
        for (Message m : this.controller.getActiveTicket().getMessages()) {
            JPanel wrapper = new JPanel(
                    new FlowLayout(m.getUser().getUserID().equals(this.controller.getActiveUser().getUserID()) ?
                            FlowLayout.RIGHT :
                            FlowLayout.LEFT )
            );
            wrapper.setAlignmentX(Component.LEFT_ALIGNMENT);
            wrapper.setAlignmentY(Component.TOP_ALIGNMENT);
            wrapper.setOpaque(false);

            JLabel text = new JLabel();
            text.setText(m.getUser().getUserName() + ": " + m.getText());
            text.setVisible(true);

            wrapper.add(text);

            Dimension preferredSize = wrapper.getPreferredSize();
            wrapper.setMaximumSize(new Dimension(this.getWidth()-5, preferredSize.height));

            chatPane.add(wrapper);
        }
        chatPane.revalidate();
        chatPane.repaint();
    }

    private void addActionListeners() {
        sendButton.addActionListener((e) -> {
            controller.addMessage(new Message(chatTextArea.getText(), controller.getActiveUser()));
            updateMessages();
        });
        backButton.addActionListener((e) -> {
            this.dispose();
            new TicketListView(this.controller);
        });
    }
}
