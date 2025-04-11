package View.Support;

import Controller.LoginController;
import Controller.TicketController;
import Model.Support.Message;

import javax.swing.*;

public class SupportTicketView extends JFrame {
    private final TicketController controller;
    private JPanel outer;
    private JScrollPane chatPane;
    private JTextArea chatTextArea;
    private JButton sendButton;


    public SupportTicketView(TicketController ticketController) {
        this.controller = ticketController;
        this.add(outer);
        this.setTitle("Chat");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        addActionListeners();
        this.setVisible(true);
    }


    private void addActionListeners() {
        sendButton.addActionListener((e) -> {
            controller.getActiveTicket().addMessage(new Message(chatTextArea.getText(), controller.getActiveUser()));
        });
    }
}
